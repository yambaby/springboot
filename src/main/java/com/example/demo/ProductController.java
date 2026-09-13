package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController // this class will handle HTTP requests and return responses
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/hi") // When someone sends a GET request to /hello, execute the method below
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/products")
    public List<Product> product(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/products/{id}") // - deletemapping is used for deleting
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProductById(id);
    }

    @PostMapping("/products")
    public void createProduct(@RequestBody Product product){
        productService.createProduct(
            product.getName(), 
            product.getQuantity(), 
            product.getUnitPrice()
        );
    }

    @PutMapping ("/products/{id}")
    public void updateProduct(@PathVariable int id, @RequestBody Product product){
        productService.updateProduct(
            id,
            product.getName(), 
            product.getQuantity(), 
            product.getUnitPrice()
        );
    }

}
