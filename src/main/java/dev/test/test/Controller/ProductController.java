/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.test.test.Controller;

import dev.test.test.Entity.Product;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.test.test.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author icarl
 */

@RestController
@RequestMapping("/api/v1/my-orders/products")
public class ProductController {
     @Autowired
    private ProductService productService;
    
    //Get all prodcuts
    @CrossOrigin
    @GetMapping
    public ResponseEntity<?> getAllProducts(){
        List<Product> products = productService.allProducts();
        if(products.isEmpty()){
            return new ResponseEntity<>("Not available products", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productService.allProducts(), HttpStatus.OK);
    }
    
    
}
