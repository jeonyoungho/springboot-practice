package org.example.springbootpractice.api.controller;

import lombok.RequiredArgsConstructor;
import org.example.springbootpractice.api.controller.rqrs.ProductBulkCreateRq;
import org.example.springbootpractice.api.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/bulk")
    public ResponseEntity<Void> bulkCreate(@RequestBody ProductBulkCreateRq rq) {

        productService.bulkCreate(rq);

        return ResponseEntity.ok().build();
    }

}
