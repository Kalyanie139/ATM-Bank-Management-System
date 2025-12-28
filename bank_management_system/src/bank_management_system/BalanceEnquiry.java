package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;//Resultset is present in this package
//The logic for Balance Display is in Constructor because screen ke khulte hi display karna hai not when jab koi button click hoga

public class BalanceEnquiry extends JFrame implements ActionListener {

    JLabel headingLabel; // Label to display balance information
    JButton backButton; // Button to go back to Transactions
    String userPin; // Stores current user's PIN
    JLabel backgroundLabel = new JLabel(); // Background label

    public BalanceEnquiry(String pin) {
        this.userPin = pin;

        // -------------------- BACKGROUND --------------------
        ImageIcon atmIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        backgroundLabel.setIcon(atmIcon); // Set the original image to JLabel
        backgroundLabel.setBounds(0, 0, 900, 900);
        backgroundLabel.setLayout(null);
        add(backgroundLabel);
        // -------------------- HEADING --------------------
        headingLabel = new JLabel();
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setFont(new Font("System", Font.BOLD, 16));
        headingLabel.setBounds(200, 400, 700, 35);
        backgroundLabel.add(headingLabel);

        // -------------------- BACK BUTTON --------------------
        backButton = new JButton("BACK");
        backButton.setBounds(280, 450, 150, 35);
        backgroundLabel.add(backButton);
        backButton.addActionListener(this);

        // -------------------- FETCH BALANCE --------------------
        int balance = 0;
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin='" + pin + "'");// Fetch all transactions of
                                                                                          // the current user using PIN
            while (rs.next()) {// Loop through each transaction record
                if (rs.getString("type").equals("Deposit")) {// If the transaction type is Deposit, add amount to
                                                             // balance

                    balance += rs.getInt("amount");
                } else {// Otherwise (Withdraw / FastCash), subtract amount from balance
                    balance -= rs.getInt("amount");
                }
            }
        } catch (Exception e) {// Print error if any issue occurs during database operation
            System.out.println(e);
        }

        headingLabel.setText("Your Current Account Balance is Rs " + balance);

        // -------------------- FRAME SETTINGS --------------------
        setSize(900, 900);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(userPin).setVisible(true);
    }

}