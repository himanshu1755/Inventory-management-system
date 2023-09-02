package com.business.RJB.controller;

import com.business.RJB.model.Merchants;
import com.business.RJB.model.Payment;
import com.business.RJB.model.Products;
import com.business.RJB.service.MerchantService;
import com.business.RJB.service.PaymentService;
import com.business.RJB.service.ProductService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    private Gson gson;

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

    @PostMapping(value = "/addMerchant")
    public ResponseEntity<Object> addMerchant(@RequestBody String merchantData) {
        System.out.println("add merchant");
        System.out.println(merchantData);
        Merchants data = gson.fromJson(merchantData, Merchants.class);
        System.out.println(data);

        merchantService.addMerchant(data);

        return ResponseEntity.accepted().body("");

    }

    @PostMapping(value = "/addProduct")
    public ResponseEntity<Object> addProduct(@RequestBody String productData) {
        System.out.println("add product");
        Products data = gson.fromJson(productData, Products.class);
        data.setProductCode(String.valueOf(System.currentTimeMillis()));

        System.out.println(productData);
        System.out.println(data);
        productService.saveProduct(data);
        return ResponseEntity.accepted().body("SUCCESS");

    }

    @PostMapping(value = "/addPayment")
    public ResponseEntity<Object> addPayment(@RequestBody String paymentData) {
        System.out.println("add payment");
        System.out.println(paymentData);
        Payment data = gson.fromJson(paymentData, Payment.class);
        data.setMerchantId(System.currentTimeMillis());
        System.out.println(data);

        paymentService.savePayment(data);

        return ResponseEntity.accepted().body("");

    }
}