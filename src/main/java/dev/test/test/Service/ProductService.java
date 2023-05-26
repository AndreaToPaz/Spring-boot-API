/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.test.test.Service;

import dev.test.test.Entity.Product;
import dev.test.test.Repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andrea Torres
 */
@Service
public class ProductService {
 @Autowired
    private ProductRepository productRepository;
    
    //Get all orders
    public List<Product> allProducts (){
        return productRepository.findAll();
    }
   
}
