package org.example.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="order_table")
public class Order {
	
	
	private int orderId;
	private Stock stock;
	private String action;
	private int quantity;
	private double orderAmount;
	private double brokerCommission;
	
	 public Order(int orderId, Stock stock, String action, int quantity, double orderAmount, double brokerCommission) {
	        this.orderId = orderId;
	        this.stock = stock;
	        this.action = action;
	        this.quantity = quantity;
	        this.orderAmount = orderAmount;
	        this.brokerCommission = brokerCommission;
	    }
}
