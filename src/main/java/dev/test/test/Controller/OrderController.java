/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.test.test.Controller;

import dev.test.test.Entity.Order;
import dev.test.test.Service.OrderService;
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

/**
 *
 * @author Andrea Torres
 * 
 */

@RestController
@RequestMapping("/api/v1/my-orders")

public class OrderController {
    @Autowired
    private OrderService orderService;
    
    //Get all orders
    @CrossOrigin
    @GetMapping
    public ResponseEntity<?> getAllOrders(){
        List<Order> orders = orderService.allOrders();
        if(orders.isEmpty()){
            return new ResponseEntity<>("Not available orders", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orderService.allOrders(), HttpStatus.OK);
    }
    
    
    //Get order by id
    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById (@PathVariable ObjectId id){
        Optional<Order> order = orderService.orderById(id);
        if(order.isPresent()){
            return new ResponseEntity<>(order.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Not available orders", 
                HttpStatus.NOT_FOUND);
    }
    
    
    //create an Order
    @CrossOrigin
    @PostMapping("/add-order")
    public ResponseEntity<?> createOrder (@RequestBody Order order){
        try{
            order.setDate("06-30-2023");
            orderService.createOrder(order);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage()
                    , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    
    //Edit order by id
    @CrossOrigin
    @PutMapping("/add-order/{id}")
    public ResponseEntity<?> updateOrderById (@PathVariable ObjectId id,@RequestBody Order updatedOrder){
        try{
            orderService.updateOrder(id, updatedOrder);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage()
                    , HttpStatus.INTERNAL_SERVER_ERROR);
        }       
    }
    
    //Delete order by id
    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderById (@PathVariable ObjectId id){
        try{
            orderService.deleteOrderById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),
                     HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }       
    
}
