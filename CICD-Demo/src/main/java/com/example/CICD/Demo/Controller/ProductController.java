package com.example.CICD.Demo.Contoller;

import com.example.CICD.Demo.DTO.ProductDTO;
import com.example.CICD.Demo.DTO.ProductResponseDTO;
import com.example.CICD.Demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ProductResponseDTO getProducts() {
        String podName = productService.getPodName();
        String podNamespace = productService.getPodNamespace();
        List<ProductDTO> products = productService.getAllProducts();
        
        return new ProductResponseDTO(podName, podNamespace, products);
    }

    @GetMapping("/server/config")
    public Map<String, String> getServerConfig() {
        Map<String, String> config = new LinkedHashMap<>();
        config.put("podName", productService.getPodName());
        config.put("podNamespace", productService.getPodNamespace());
        return config;
    }

}