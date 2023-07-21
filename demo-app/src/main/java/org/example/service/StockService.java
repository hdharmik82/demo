package org.example.service;

import org.example.model.Order;

public interface StockService {

	public void placeOrder();

	public void displayOrderSummary();

	public Order getOrder(int orderNumber);

	public int generateOrderNumber();

}
