package org.example.springbootpractice.api.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.springbootpractice.api.controller.rqrs.ProductBulkCreateRq;
import org.example.springbootpractice.domain.Product;
import org.example.springbootpractice.domain.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public void bulkCreate(ProductBulkCreateRq rq) {
        List<Product> products = rq.getProducts()
                                   .stream()
                                   .map(p -> Product.create(p.getName()))
                                   .toList();

        productRepository.saveAll(products);
    }
}
