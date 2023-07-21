package org.example.controller;

import java.util.List;
import java.util.Scanner;

import org.example.model.Stock;

public class StockController {
    private static Scanner scanner = new Scanner(System.in);

    public static int displayMenuAndGetChoice() {
        return scanner.nextInt();
    }

    public static int selectStock(List<Stock> stocks) {
        return scanner.nextInt() - 1;
    }

    public static String getActionFromUser() {
        scanner.nextLine();
        return scanner.nextLine();
    }

    public static int getQuantityFromUser() {
        return scanner.nextInt();
    }
}
