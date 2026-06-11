package com.example.CICD.Demo.DTO;

import java.util.List;

public class ProductResponseDTO {
    private String podName;
    private String podNamespace;
    private List<ProductDTO> products;

    public ProductResponseDTO(String podName, String podNamespace, List<ProductDTO> products) {
        this.podName = podName;
        this.podNamespace = podNamespace;
        this.products = products;
    }

    public String getPodName() {
        return podName;
    }

    public void setPodName(String podName) {
        this.podName = podName;
    }

    public String getPodNamespace() {
        return podNamespace;
    }

    public void setPodNamespace(String podNamespace) {
        this.podNamespace = podNamespace;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}
