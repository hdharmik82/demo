package com.ibm.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data

public class Order {
	
	private int orderNo; 

	@OneToMany
	private Stock stock; 

	private String action; 

	private int qunatity; 

	private double amount; 

	private double commission;

	public Order(int orderNo, Stock stock, String action, int qunatity, double amount, double commission) {
		super();
		this.orderNo = orderNo;
		this.stock = stock;
		this.action = action;
		this.qunatity = qunatity;
		this.amount = amount;
		this.commission = commission;
	} 
	
	
}
