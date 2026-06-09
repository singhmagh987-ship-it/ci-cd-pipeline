package com.example.CICD.Demo.Service;

import com.example.CICD.Demo.DTO.ProductDTO;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    public List<ProductDTO> getAllProducts() {
        return Arrays.asList(
                new ProductDTO(1, "Widget", "Small widget for daily use", 19.99),
                new ProductDTO(2, "Gadget", "Multi-purpose gadget", 29.95),
                new ProductDTO(3, "Thingamajig", "Useful thingamajig", 14.50)
        );
    }
}
