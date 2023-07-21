package org.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.example.model.Order;
import org.example.model.Stock;

public class StockServiceImpl implements StockService {
	private static Scanner scanner = new Scanner(System.in);
	private Map<Integer, Order> orders = new HashMap<>();
	private int orderIdCounter = 1;
	private List<Stock> stocks = new ArrayList<>();

	public StockServiceImpl() {
		stocks.add(new Stock("Reliance", "RELIANCE", 1451.50));
		stocks.add(new Stock("LNT", "LARSEN", 923.90));
		stocks.add(new Stock("Tata Steel", "TATASTEEL", 435.60));
	}

	public void placeOrder() {
		System.out.println("Available Stocks:");
		for (int i = 0; i < stocks.size(); i++) {
			System.out.println((i + 1) + ". " + stocks.get(i));
		}

		System.out.print("Select stock (enter number): ");
		int stockChoice = scanner.nextInt();
		scanner.nextLine();

		if (stockChoice < 1 || stockChoice > stocks.size()) {
			System.out.println("Invalid stock selection. Please try again.");
			return;
		}

		Stock selectedStock = stocks.get(stockChoice - 1);

		System.out.println("Selected stock: " + selectedStock.getStockName() + " - " + selectedStock.getCurrentPrice());

		System.out.print("Select action (buy/sell): ");
		String action = scanner.nextLine();

		if (!action.equalsIgnoreCase("buy") && !action.equalsIgnoreCase("sell")) {
			System.out.println("Invalid action. Please enter 'buy' or 'sell'.");
			return;
		}

		System.out.print("Enter quantity: ");
		int quantity = scanner.nextInt();
		scanner.nextLine();

		if (quantity <= 0) {
			System.out.println("Quantity must be a positive integer.");
			return;
		}

		double orderAmount = selectedStock.getCurrentPrice() * quantity;
		double brokerCommission = action.equalsIgnoreCase("buy") ? orderAmount * 0.005 : orderAmount * 0.01;

		int orderNumber = generateOrderNumber();

		Order order = new Order(orderNumber, selectedStock, action, quantity, orderAmount, brokerCommission);
		orders.put(orderNumber, order);

		System.out.println("Your order no." + orderNumber + ", thanks for placing the order.");
	}

	public void displayOrderSummary() {
		System.out.print("Enter order number: ");
		int orderNumber = scanner.nextInt();
		scanner.nextLine();

		Order order = getOrder(orderNumber);
		if (order == null) {
			System.out.println("Order not found.");
		} else {
			System.out.println("Order Summary:");
			System.out.println("Order ID: " + order.getOrderId());
			System.out.println("Stock Name: " + order.getStock().getStockName());
			System.out.println("Action: " + order.getAction());
			System.out.println("Quantity: " + order.getQuantity());
			System.out.println("Order Amount: " + order.getOrderAmount());
			System.out.println("Broker Commission: " + order.getBrokerCommission());
		}
	}

	public Order getOrder(int orderNumber) {
		return orders.get(orderNumber);
	}

	public int generateOrderNumber() {
		return orderIdCounter++;
	}
}