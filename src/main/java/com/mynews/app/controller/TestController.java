//package com.mynews.app.controller;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class TestController {
//    @GetMapping("/test")
//    public String main() {
//        return "test text";
//    }
//    @PostMapping("/test/add")
//    public ClientTest2 clientAdd(@RequestBody ClientTest clientTest){
//        return ClientTest2.builder()
//                .firstName(clientTest.getFirstName())
//                .lastName(clientTest.getLastName())
//                .age(18)
//                .build();
////        ClientTest2 clientTest2 = new ClientTest2(clientTest.getFirstName(), clientTest.getLastName(), 18);
////        return clientTest2;
//    }
//
//
//
//
//}
