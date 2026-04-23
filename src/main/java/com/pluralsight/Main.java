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

        while (searchAgain.equalsIgnoreCase("yes")) {
            System.out.print("\nEnter a product name to search: ");
            String search = keyboard.nextLine().trim();
        }

    }
}
