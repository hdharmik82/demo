package com.ibm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ibm.bean.Order;
import com.ibm.bean.Stock;
import com.ibm.dao.ClientDao;

@Service
public class OrderServiceImpl implements OrderService {

	private static Scanner scanner = new Scanner(System.in);
	private Map<Integer, Order> orders = new HashMap<>();
	private int orderIdCounter = 1;
	private List<Stock> stocks = new ArrayList<>();

	public OrderServiceImpl() {
		stocks.add(new Stock(1, "Reliance", "RELIANCE", 1451.50));
		stocks.add(new Stock(2, "LNT", "LARSEN", 923.90));
		stocks.add(new Stock(3, "Tata Steel", "TATASTEEL", 435.60));
	}

	@Override
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
		double commission = action.equalsIgnoreCase("buy") ? orderAmount * 0.005 : orderAmount * 0.01;

		int orderNumber = generateOrderNumber();

		Order order = new Order(orderNumber, selectedStock, action, quantity, orderAmount, commission);
		orders.put(orderNumber, order);

		System.out.println("Your order no." + orderNumber + ", thanks for placing the order.");

	}

	@Override
	public void displayOrderSummary() {
		System.out.print("Enter order number: ");
		int orderNumber = scanner.nextInt();
		scanner.nextLine();

		Order order = getOrder(orderNumber);
		if (order == null) {
			System.out.println("Order not found.");
		} else {
			System.out.println("Order Summary:");
			System.out.println("Order ID: " + order.getOrderNo());
			System.out.println("Stock Name: " + order.getStock().getStockName());
			System.out.println("Action: " + order.getAction());
			System.out.println("Quantity: " + order.getQunatity());
			System.out.println("Order Amount: " + order.getAmount());
			System.out.println("Broker Commission: " + order.getCommission());
		}

	}

	@Override
	public Order getOrder(int orderNumber) {
		// TODO Auto-generated method stub
		return orders.get(orderNumber);
	}

	@Override
	public int generateOrderNumber() {
		// TODO Auto-generated method stub
		return orderIdCounter++;
	}

	@Transactional
	public void getAllStocks() {
		ClientDao dao = new ClientDao();
		List<Stock> list = dao.getAllStocks();
		for(Stock element : list)
		{
			System.out.println(element);
		}
	}

}
