package org.example.springbootpractice.api.controller.rqrs;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductBulkCreateRq {

    private List<ProductCreateRq> products;
}
