package com.business.RJB.controller;

import com.business.RJB.model.Merchants;
import com.business.RJB.model.Payment;
import com.business.RJB.model.Products;
import com.business.RJB.repository.IProductRepository;
import com.business.RJB.service.MerchantService;
import com.business.RJB.service.PaymentService;
import com.business.RJB.service.ProductService;
import lombok.CustomLog;
import org.springframework.beans.factory.annotation.Autowired;
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
//@CustomLog
public class RestController {

    @Autowired
    private ProductService productService;
    @Autowired
    private MerchantService merchantService;

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/test")
    public ResponseEntity<Object> test() {

        return ResponseEntity.status(HttpStatus.OK).body("Test completed Successfully");
    }

    @GetMapping("/login")
    public String page(Model model) throws Exception {
        System.out.println("hi");
        return "index";
    }
    @GetMapping("addProduct")
    public String productPage(Model model) throws Exception {
        System.out.println("hi");
        return "../static/pages/products/product";
    }

    @GetMapping("/getProduct")
    public String productListPage(Model model) throws Exception {
        System.out.println("hi");
        return "../static/pages/products/product-list";
    }

    @GetMapping("/getMerchant")
    public String merchantListPage(Model model) throws Exception {
        System.out.println("hi");
        return "../static/pages/merchant/merchant-list";
    }

    @GetMapping("/addMerchant")
    public String addMerchant(Model model) throws Exception {
        System.out.println("hi");
        return "../static/pages/merchant/merchant";
    }
    @GetMapping("/makePayment")
    public String addPayment(Model model) throws Exception {
        System.out.println("hi");
        return "../static/pages/merchant/make-payment";
    }

    @PostMapping(value = "/addMerchant", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addMerchant(@RequestBody Merchants merchantData) {

        merchantService.addMerchant(merchantData);
//        log.info("merchantData --- {}", merchantData);
//        Response response = adminService.addAppConfigData(appConfig);
        return ResponseEntity.accepted().body("");

    }

    @PostMapping(value = "/addProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addProduct(@RequestBody Products productData) {
        System.out.println("add product");
        productService.saveProduct(productData);

//        log.info("productData --- {}", productData);
//        Response response = adminService.addAppConfigData(appConfig);
        return ResponseEntity.accepted().body("");

    }

    @PostMapping(value = "/addPayment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addPayment(@RequestBody Payment paymentData) {
        paymentService.savePayment(paymentData);
//        log.info("paymentData --- {}", paymentData);
//        Response response = adminService.addAppConfigData(appConfig);
        return ResponseEntity.accepted().body("");

    }
}