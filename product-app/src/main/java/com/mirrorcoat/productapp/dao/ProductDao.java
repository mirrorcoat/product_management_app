package com.mirrorcoat.productapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mirrorcoat.productapp.dto.Product;

public class ProductDao {
    private static final String DB_PATH = "jdbc:sqlite:path_to_db.db";
    private static final String INSERT_PRODUCT = "INSERT INTO product (name, price) VALUES (?,?);";
    private static final String SEL_BY_ID = "SELECT * FROM product WHERE id=?";
    private static final String DELETE_BY_ID = "DELETE FROM product WHERE id=?";

    public ProductDao() {

    }

    public boolean create(Product product) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_PATH);
            PreparedStatement ps = connection.prepareStatement(INSERT_PRODUCT);
            ps.setString(1, product.getName());
            ps.setInt(2, product.getPrice());

            int row = ps.executeUpdate();
            if (row == 1) {
                connection.close();
                return true;
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        } finally {
            try {
                if (connection != null) connection.close();
            } catch(SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return false;
    }

    public Product findByID(int id) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_PATH);
            PreparedStatement ps = connection.prepareStatement(SEL_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Product product = new Product();
            if (rs.next()) {
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getInt("price"));
                return product;
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        } finally {
            try {
                if (connection != null) connection.close();
            } catch(SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }

    public boolean deleteByID(int id) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_PATH);
            PreparedStatement ps = connection.prepareStatement(DELETE_BY_ID);
            ps.setInt(1, id);

            int row = ps.executeUpdate();
            if (row == 1) {
                connection.close();
                return true;
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        } finally {
            try {
                if (connection != null) connection.close();
            } catch(SQLException e) {
                System.err.println(e.getMessage());
            }
        }
        return false;
    }
}
