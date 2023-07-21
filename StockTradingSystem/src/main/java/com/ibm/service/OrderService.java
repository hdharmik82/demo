package com.ibm.service;

import com.ibm.bean.Order;

public interface OrderService {

	public void placeOrder();

	public void displayOrderSummary();

	public Order getOrder(int orderNumber);

	public int generateOrderNumber();
}
