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

    /**
     * Fetches the Kubernetes pod name dynamically from the container environment.
     * In EKS, the HOSTNAME environment variable contains the pod name.
     * 
     * @return Pod name or "unknown" if not running in Kubernetes
     */
    public String getPodName() {
        String podName = System.getenv("HOSTNAME");
        return podName != null ? podName : "unknown";
    }

    /**
     * Fetches the Kubernetes namespace dynamically from the container environment.
     * This should be set via the Downward API in the deployment manifest.
     * 
     * @return Pod namespace or "default" if not running in Kubernetes
     */
    public String getPodNamespace() {
        String namespace = System.getenv("POD_NAMESPACE");
        return namespace != null ? namespace : "default";
    }
}
