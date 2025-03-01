package org.example.springbootpractice.domain;

import java.util.List;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@Slf4j
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("상품을 대량으로 저장할 수 있다.")
    void bulkCreateTest() {
        // Given
        long start = System.currentTimeMillis();

        int count = 101;
        List<Product> products = IntStream.rangeClosed(1, count)
                                          .mapToObj(i -> Product.create("Product" + i))
                                          .toList();

        // When
        List<Product> savedProducts = productRepository.saveAll(products);
        productRepository.flush();


        long end = System.currentTimeMillis();
        log.info("Elapsed time: {} ms", end - start);

        // Then
        assertThat(savedProducts).isNotNull();
        assertThat(savedProducts).hasSize(count);
        assertThat(savedProducts).allMatch(product -> product.getId() != null);
    }

}