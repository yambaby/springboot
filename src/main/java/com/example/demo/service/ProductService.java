package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service 
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(int productId){
        return productRepository.findById(productId).orElse(null);
    }

    public void deleteProductById(int productId){
        productRepository.deleteById(productId);
    }

    public void createProduct(String name, int quantity, double unitPrice){
        Product product = new Product(name, quantity, unitPrice);

        productRepository.save(product);
    }

    public void updateProduct(int productId, String name, int quantity, double unitPrice){
        Product product = productRepository.findById(productId).orElse(null);

        if (product == null){
            return;
        }
        
        product.setName(name);
        product.setQuantity(quantity);
        product.setUnitPrice(unitPrice);

        productRepository.save(product);
        
    }
}
