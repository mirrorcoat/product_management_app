package com.mirrorcoat.productapp;

import java.util.Scanner;

import com.mirrorcoat.productapp.dao.ProductDao;
import com.mirrorcoat.productapp.dto.Product;

public class Main {
    public static void main(String[] args ) {
        Scanner scan = new Scanner(System.in);
        ProductDao productDao = new ProductDao();
        String menuSelect = "";

        System.out.println("Welcome to the Product Management System App! (enter 'q' to quit)");

        while (!menuSelect.equals("q")) {
            System.out.println("Pick an option:\n1. Add a new product\n2. Display a product (searches by ID)\n3. Delete a product (delete by ID)");
            menuSelect = scan.next();

            if (menuSelect.equals("1")) {
                System.out.print("Enter a new product name: ");
                String pName = scan.next();
                System.out.print("Enter a new product price: ");
                int pPrice = scan.nextInt();
                productDao.create(new Product(pName, pPrice));
            } else if (menuSelect.equals("2")) {
                System.out.print("Enter ID of product to display: ");
                int id = scan.nextInt();
                Product product = productDao.findByID(id);
                if (product != null) {
                    System.out.println("\n" + product.toString() + "\n");
                } else {
                    System.out.println("No product exists with id: " + id);
                }
            } else if (menuSelect.equals("3")) {
                System.out.print("Enter ID of product to delete: ");
                int id = scan.nextInt();
                productDao.deleteByID(id);
            } else if (!menuSelect.equals("q")) {
                System.out.println("Choice selected is not a valid option. Please select from the following:");
            }
        }
        scan.close();
    }
}
