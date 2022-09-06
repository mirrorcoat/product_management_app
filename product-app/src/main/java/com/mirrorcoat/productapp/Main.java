package com.mirrorcoat.productapp;

import java.util.Scanner;

import com.mirrorcoat.productapp.dao.ProductDao;
import com.mirrorcoat.productapp.dto.Product;

public class Main {
    public static void main(String[] args ) {
        System.out.print("Enter a new product name: ");
        Scanner scan = new Scanner(System.in);
        String pName = scan.next();

        System.out.print("Enter a new product price: ");
        int pPrice = scan.nextInt();

        Product product = new Product(pName, pPrice);

        // Scanner scan = new Scanner(System.in);
        ProductDao productDao = new ProductDao();
        productDao.create(product);

        // Product myProduct;
        // System.out.println("Enter Product Id for the product you would like to see: ");
        // int pId = scan.nextInt();
        // myProduct = productDao.findByID(pId);

        // if (myProduct != null) {
        //     System.out.println(myProduct.toString());
        // } else {
        //     System.out.println("Product does not exist with that ID");
        // }

        scan.close();
    }
}
