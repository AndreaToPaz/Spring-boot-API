/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.test.test.Entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import dev.test.test.Serializer.ObjectIdSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author Andrea Torres
 * 
 */

@Document(collection = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Order {
    
    @Id
    
    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId id;        //Order ID
    private int order_num;       //Order number
    private String date;        //Order date
    private int product_qty;     //Product quantity in the order
    private float final_price;  //Order total price 
    private int[] option;       //Order options  
    
public Order(int order_num, String date, int product_qty, float final_price, int[] option) {
        this.order_num = order_num;
        this.date = date;
        this.product_qty = product_qty;
        this.final_price = final_price;
        this.option = option;
    }
}


    


