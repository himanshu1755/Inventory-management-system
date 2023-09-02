/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.business.RJB.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.netty.channel.ChannelOption;
import io.netty.channel.unix.DomainSocketAddress;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.CustomLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.embedded.netty.NettyServerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.http.server.HttpServer;

import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author ngucc
 */
@CustomLog
@Configuration
@EnableAsync
public class BeanConfiguration {

    @Autowired
    GsonBuilder gsonBuilder;

    @Value("${request.read.timeout}") //in Milliseconds
    private Long readTimeout;

    @Value("${request.connect.timeout}") //in Milliseconds
    private Long connectTimeout;


    @Bean
    public Gson gson() {
        return gsonBuilder
                .setDateFormat("yyyy-MM-dd HH:mm:ss.S")
                .excludeFieldsWithModifiers(Modifier.TRANSIENT).create();
    }

    @Bean
    public WebClient getWebClient() {
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000)
                .doOnConnected(conn -> conn
                .addHandlerLast(new ReadTimeoutHandler(readTimeout, TimeUnit.MILLISECONDS))
                .addHandlerLast(new WriteTimeoutHandler(connectTimeout, TimeUnit.MILLISECONDS)));

        ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);
        return WebClient.builder()
                .filter(logRequest())
                .clientConnector(connector)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    private ExchangeFilterFunction logRequest() {
        return (ClientRequest clientRequest, ExchangeFunction next) -> {
            log.verbose("Request: {} {}", clientRequest.method(), clientRequest.url());
            clientRequest.headers()
                    .forEach((name, values) -> values.forEach(value -> log.trace("{}={}", name, value)));
            return next.exchange(clientRequest);
        };
    }

    @Bean
    @Qualifier(value = "asyncThreadPoolTaskExecutor")
    public AsyncTaskExecutor asyncThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setThreadNamePrefix("async_thread_pool_task_executor_thread");
        executor.initialize();
        return executor;
    }

    @Bean
    @Qualifier(value = "asyncThreadPoolTaskScheduler")
    public TaskScheduler asyncThreadPoolTaskScheduler() {
        ThreadPoolTaskScheduler executor = new ThreadPoolTaskScheduler();
        executor.setPoolSize(2);
        executor.setThreadNamePrefix("async_thread_pool_task_scheduler_thread");
        executor.initialize();
        return executor;
    }

    @Bean
    public NettyReactiveWebServerFactory factory() {
        NettyReactiveWebServerFactory factory = new NettyReactiveWebServerFactory();
        factory.setServerCustomizers(Collections.singletonList(new NettyServerCustomizer() {
            @Override
            public HttpServer apply(HttpServer httpServer) {
                return httpServer.bindAddress(() -> new DomainSocketAddress("/run/cloud.sock"));
            }
        }));
        return factory;
    }

}
