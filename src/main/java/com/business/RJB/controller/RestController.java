package com.business.RJB.controller;

import lombok.CustomLog;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;

@CrossOrigin
@Controller
@CustomLog
public class RestController {


    @GetMapping(value = "/test")
    public ResponseEntity<Object> test() {

        return ResponseEntity.status(HttpStatus.OK).body("Test completed Successfully");
    }

    @GetMapping("/login")
    public String page(Model model) throws Exception {
        System.out.println("hi");
        return "login/index";
    }

    @PostMapping(value = "/addMerchant", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addAppConfig(@RequestBody String merchantData) {
        log.info("merchantData --- {}", merchantData);
//        Response response = adminService.addAppConfigData(appConfig);
        return ResponseEntity.accepted().body("");

    }
}