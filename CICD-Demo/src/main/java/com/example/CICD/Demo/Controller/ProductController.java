package com.example.CICD.Demo.Contoller;

import com.example.CICD.Demo.DTO.ProductDTO;
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
    public List<ProductDTO> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/server/config")
    public Map<String, String> getServerConfig() {
        Map<String, String> config = new LinkedHashMap<>();
        config.put("podName", getEnv("POD_NAME", getEnv("HOSTNAME", "unknown")));
        config.put("containerId", getEnv("CONTAINER_ID", getContainerIdFromProc()));
        return config;
    }

    private String getEnv(String name, String fallback) {
        String value = System.getenv(name);
        return value != null && !value.isEmpty() ? value : fallback;
    }

    private String getContainerIdFromProc() {
        File file = new File("/proc/self/cgroup");
        if (!file.exists()) {
            return "unknown";
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int idx = line.lastIndexOf('/');
                if (idx >= 0 && idx + 1 < line.length()) {
                    String candidate = line.substring(idx + 1).trim();
                    if (!candidate.isEmpty()) {
                        return candidate;
                    }
                }
            }
        } catch (IOException ignored) {
        }
        return "unknown";
    }

}