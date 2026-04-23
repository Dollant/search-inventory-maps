package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static HashMap<String, Product> inventory = new HashMap<>();

    public static void main(String[] args) {

        loadInventory();

        Scanner keyboard = new Scanner(System.in);
        String searchAgain = "yes";

        System.out.println("\nAvailable products:");
        for (String key : inventory.keySet()) {
            System.out.println("- " + key);
        }

        while (searchAgain.equalsIgnoreCase("yes")) {
            System.out.print("\nEnter a product name to search: ");
            String search = keyboard.nextLine().trim();

            Product found = inventory.get(search);

            if (found != null) {
                System.out.printf("Found! ^_^ - ID: %d | Name: %s | Price: $%.2f%n",
                        found.getProductID(),
                        found.getName(),
                        found.getPrice());
            } else {

                System.out.println("Product not found: " + search);
            }

            System.out.print("\nDo you want to search again? :) | (yes/no): ");
            searchAgain = keyboard.nextLine().trim();
        }

        System.out.println("Goodbye! ^v^");
        keyboard.close();
    }

    public static void loadInventory() {

        String fileName = "src/main/resources/inventory.csv";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] tokens = line.split("\\|");

                int productID = Integer.parseInt(tokens[0].trim());
                String name = tokens[1].trim();
                double price = Double.parseDouble(tokens[2].trim());

                Product product = new Product(productID, name, price);

                inventory.put(name, product);
            }

            reader.close();
            System.out.println("Inventory loaded. " +inventory.size() + " products found!");

        } catch (IOException e) {
            System.out.println("Could not load inventory: " + e.getMessage());
        }
    }
}
