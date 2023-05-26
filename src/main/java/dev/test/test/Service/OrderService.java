/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.test.test.Service;


import dev.test.test.Entity.Order;
import dev.test.test.Repository.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andrea Torres
 * 
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
    //Get all orders
    public List<Order> allOrders (){
        return orderRepository.findAll();
    }
    //Get an Order By Id
    public Optional<Order> orderById (ObjectId id){
        return orderRepository.findById(id);
    }
    
    //Create an order
    public void createOrder(Order orderBody){
        orderRepository.insert(orderBody);
    }
    
    //Edit an Order By Id
    public Order updateOrder(ObjectId id, Order updatedOrder){
        Order existingOrder = orderRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Order not found"));
        existingOrder.setOrder_num(updatedOrder.getOrder_num());
        existingOrder.setDate(updatedOrder.getDate());
        existingOrder.setProduct_qty(updatedOrder.getProduct_qty());
        existingOrder.setFinal_price(updatedOrder.getFinal_price());
        return orderRepository.save(existingOrder);
    }
    
    // Delete an Order By Id
    public void deleteOrderById (ObjectId id){
         orderRepository.deleteById(id);
    }
   
}
