package com.ibm.client;

import java.util.Scanner;

import com.ibm.service.OrderServiceImpl;

import lombok.Cleanup;

public class Client {
	public static void main(String[] args) {
		
		@Cleanup
		Scanner scanner = new Scanner(System.in);
		int choice;
		OrderServiceImpl orderService = new OrderServiceImpl();
		
		do {
            System.out.println("Main Menu:");
            System.out.println("1. Place order");
            System.out.println("2. Order summary");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    orderService.placeOrder();
                    break;
                case 2:
                    orderService.displayOrderSummary();
                    break;
                case 3:
                    System.out.println("Exiting the application.");
                    break;
                case 4:
                    orderService.getAllStocks();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);
    }
}
