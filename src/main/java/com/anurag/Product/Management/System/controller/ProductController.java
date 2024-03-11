package com.anurag.Product.Management.System.controller;

import com.anurag.Product.Management.System.model.Product;
import com.anurag.Product.Management.System.service.ProductService;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("addProduct")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        return  new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("getAllProduct")
    public ResponseEntity<?> getAllProduct() {
        return new ResponseEntity<>(productService.getAllProduct(),HttpStatus.OK);
    }

    @GetMapping("getProductById/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id){
        return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
    }

    @DeleteMapping("deleteProduct/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable Integer id){
        return  new ResponseEntity<>(productService.deleteProduct(id),HttpStatus.OK);
    }


}
