package com.example.CICD.Demo.Service;

import com.example.CICD.Demo.DTO.ProductDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ProductService Tests")
class ProductServiceTests {

    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService();
    }

    @Test
    @DisplayName("Should return all products list")
    void testGetAllProducts_ReturnsProductList() {
        // Arrange & Act
        List<ProductDTO> products = productService.getAllProducts();

        // Assert
        assertNotNull(products, "Product list should not be null");
    }

    @Test
    @DisplayName("Should return exactly 3 products")
    void testGetAllProducts_ReturnsCorrectNumberOfProducts() {
        // Arrange & Act
        List<ProductDTO> products = productService.getAllProducts();

        // Assert
        assertEquals(3, products.size(), "Should return exactly 3 products");
    }

    @Test
    @DisplayName("Should return products with correct data")
    void testGetAllProducts_ReturnsCorrectProductData() {
        // Arrange & Act
        List<ProductDTO> products = productService.getAllProducts();

        // Assert
        ProductDTO firstProduct = products.get(0);
        assertEquals(1, firstProduct.getId(), "First product ID should be 1");
        assertEquals("Widget", firstProduct.getName(), "First product name should be Widget");
        assertEquals("Small widget for daily use", firstProduct.getDescription(), "First product description should match");
        assertEquals(19.99, firstProduct.getPrice(), "First product price should be 19.99");

        ProductDTO secondProduct = products.get(1);
        assertEquals(2, secondProduct.getId(), "Second product ID should be 2");
        assertEquals("Gadget", secondProduct.getName(), "Second product name should be Gadget");
        assertEquals("Multi-purpose gadget", secondProduct.getDescription(), "Second product description should match");
        assertEquals(29.95, secondProduct.getPrice(), "Second product price should be 29.95");

        ProductDTO thirdProduct = products.get(2);
        assertEquals(3, thirdProduct.getId(), "Third product ID should be 3");
        assertEquals("Thingamajig", thirdProduct.getName(), "Third product name should be Thingamajig");
        assertEquals("Useful thingamajig", thirdProduct.getDescription(), "Third product description should match");
        assertEquals(14.50, thirdProduct.getPrice(), "Third product price should be 14.50");
    }

    @Test
    @DisplayName("Should return list with all positive prices")
    void testGetAllProducts_AllProductsHavePositivePrices() {
        // Arrange & Act
        List<ProductDTO> products = productService.getAllProducts();

        // Assert
        for (ProductDTO product : products) {
            assertTrue(product.getPrice() > 0, "Product price should be positive for: " + product.getName());
        }
    }
}
