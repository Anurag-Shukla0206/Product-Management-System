package com.anurag.Product.Management.System.service;

import com.anurag.Product.Management.System.model.Product;
import com.anurag.Product.Management.System.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product){

        return productRepository.save(product);
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }


    public Product getProductById(Integer id){
        return productRepository.findById(id).get();
    }

    public String deleteProduct(Integer id){
        Product product = productRepository.findById(id).get();

        if(product != null){
            productRepository.delete(product);
            return "Product Deleted Successfully";
        }

        return "Product Not Found";

    }
}
