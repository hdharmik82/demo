package org.example;

import org.example.controller.StockController;
import org.example.service.StockServiceImpl;

public class App {

	public static void main(String[] args) {
		StockServiceImpl stockService = new StockServiceImpl();

		int choice;
		do {
			System.out.println("Main Menu:");
			System.out.println("1. Place order");
			System.out.println("2. Order summary");
			System.out.println("3. Exit");
			System.out.print("Enter your choice: ");
			choice = StockController.displayMenuAndGetChoice();

			switch (choice) {
			case 1:
				stockService.placeOrder();
				break;
			case 2:
				stockService.displayOrderSummary();
				break;
			case 3:
				System.out.println("Exiting the application.");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		} while (choice != 3);
	}
}