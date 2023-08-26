package com.business.RJB.controller;

import com.business.RJB.model.Merchants;
import com.business.RJB.model.Payment;
import com.business.RJB.model.Products;
import lombok.CustomLog;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    public ResponseEntity<Object> addMerchant(@RequestBody Merchants merchantData) {
        log.info("merchantData --- {}", merchantData);
//        Response response = adminService.addAppConfigData(appConfig);
        return ResponseEntity.accepted().body("");

    }

    @PostMapping(value = "/addProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addProduct(@RequestBody Products productData) {
        log.info("productData --- {}", productData);
//        Response response = adminService.addAppConfigData(appConfig);
        return ResponseEntity.accepted().body("");

    }

    @PostMapping(value = "/addPayment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addProduct(@RequestBody Payment paymentData) {
        log.info("paymentData --- {}", paymentData);
//        Response response = adminService.addAppConfigData(appConfig);
        return ResponseEntity.accepted().body("");

    }
}