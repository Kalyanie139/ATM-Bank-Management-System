package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    JLabel bankLabel, cardLabel, balanceLabel; // Labels for header, card info, balance
    JTable transactionTable; // Table to display transactions
    JButton exitButton; // Exit button to close mini statement

    String userPin; // User session PIN
    String cardNumber; // User's card number

    public MiniStatement(String pin) {
        this.userPin = pin;

        // -------------------- FRAME SETTINGS --------------------
        setTitle("Mini Statement");
        setSize(600, 500);
        setLocationRelativeTo(null); // Centers the window on screen
        getContentPane().setBackground(Color.WHITE);
        setLayout(null); // REQUIRED because setBounds() is used everywhere

        // -------------------- HEADER LABEL --------------------
        bankLabel = new JLabel("Indian Bank");
        bankLabel.setFont(new Font("System", Font.BOLD, 20));
        bankLabel.setBounds(230, 20, 200, 30);
        add(bankLabel);

        // -------------------- CARD NUMBER LABEL --------------------
        cardLabel = new JLabel();
        cardLabel.setBounds(30, 60, 540, 25);
        cardLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(cardLabel);

        // -------------------- TRANSACTION TABLE --------------------
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Date");
        tableModel.addColumn("Type");
        tableModel.addColumn("Amount");

        transactionTable = new JTable(tableModel);
        transactionTable.setFont(new Font("System", Font.PLAIN, 12));
        transactionTable.setRowHeight(22);

        JScrollPane scrollPane = new JScrollPane(transactionTable);
        scrollPane.setBounds(30, 100, 540, 250);
        add(scrollPane);

        // -------------------- BALANCE LABEL --------------------
        balanceLabel = new JLabel();
        balanceLabel.setFont(new Font("System", Font.BOLD, 14));
        balanceLabel.setBounds(30, 370, 540, 25);
        balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(balanceLabel);

        // -------------------- EXIT BUTTON --------------------
        exitButton = new JButton("EXIT");
        exitButton.setBounds(250, 410, 100, 30);
        exitButton.addActionListener(this);
        add(exitButton);

        // -------------------- FETCH DATA FROM DATABASE --------------------
        double balance = 0;

        try {
            Conn conn = new Conn(); // Connects to database THREE

            // Fetch card number
            Statement stmt1 = conn.c.createStatement();
            ResultSet rsCard = stmt1.executeQuery(
                    "SELECT cardnumber FROM login WHERE pin='" + userPin + "'");

            if (rsCard.next()) {
                cardNumber = rsCard.getString("cardnumber");

                if (cardNumber.length() >= 16) {
                    cardLabel.setText(
                            "Card Number: " +
                            cardNumber.substring(0, 4) +
                            "XXXXXXXX" +
                            cardNumber.substring(12));
                } else {
                    cardLabel.setText("Card Number: " + cardNumber);
                }
            } else {
                cardLabel.setText("Card Number: Not Found");
            }

            // Fetch transactions
            Statement stmt2 = conn.c.createStatement();
            ResultSet rsTransactions = stmt2.executeQuery(
                    "SELECT * FROM bank WHERE pin='" + userPin + "'");

            boolean hasTransaction = false;

            while (rsTransactions.next()) {
                hasTransaction = true;

                String date = rsTransactions.getString("date");
                String type = rsTransactions.getString("type");
                String amount = rsTransactions.getString("amount");

                tableModel.addRow(new Object[]{date, type, amount});

                if (type.equalsIgnoreCase("Deposit")) {
                    balance += Double.parseDouble(amount);
                } else if (type.equalsIgnoreCase("Withdraw")) {
                    balance -= Double.parseDouble(amount);
                }
            }

            if (!hasTransaction) {
                tableModel.addRow(new Object[]{"-", "No transactions found", "-"});
            }

            balanceLabel.setText("Available Balance: Rs " + balance);

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Error fetching mini statement");
        }

        // -------------------- SHOW FRAME --------------------
        setVisible(true);
    }

    // -------------------- BUTTON ACTION --------------------
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exitButton) {
            this.dispose(); // Close only MiniStatement window
        }
    }
}
