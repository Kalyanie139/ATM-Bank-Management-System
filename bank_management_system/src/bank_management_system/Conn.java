package bank_management_system;

import java.sql.*; // JDBC classes import kiye database connectivity ke liye

import javax.swing.JOptionPane;

public class Conn {

    // Connection object ->database ke saath connection maintain karta hai
    Connection c;

    // Statement object -> SQL queries execute karne ke kaam aata hai
    Statement s;

    // Constructor -> jaise hi Conn ka object banega, database connect ho jayega
    public Conn() {
        try {
            // MySQL JDBC Driver load kar rahe hai
            // Java ko batata hai ki kaunsa driver use karna hai
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database se connection establish kar rahe hai
            // jdbc:mysql:///bankmanagementsystem → database ka URL
            // root, root → username aur password
            c = DriverManager.getConnection(
            "jdbc:mysql:///bankmanagementsystem",
            System.getenv("DB_USER"),
            System.getenv("DB_PASSWORD"));

            // Statement object create kiya
            // Iski help se hum SQL queries (SELECT, INSERT, UPDATE) chalayenge
            s = c.createStatement();

        } catch (Exception e) {
            // Agar database connect na ho paye

            JOptionPane.showMessageDialog(null, "DB Error: " + e.getMessage());
            e.printStackTrace();

        }
    }
}
