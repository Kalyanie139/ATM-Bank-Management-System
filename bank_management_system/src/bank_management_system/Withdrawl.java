package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Withdrawl extends JFrame implements ActionListener {

    JLabel headingLabel; // Heading label
    JTextField amountField; // Input field for deposit amount
    JButton withdrawBtn, backBtn; // Deposit and Back buttons
    JLabel backgroundLabel; // Background label
    String userPin; // User PIN

    public Withdrawl(String pin) {
        this.userPin = pin;

        // -------------------- BACKGROUND IMAGE --------------------
        ImageIcon atmIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        backgroundLabel = new JLabel(atmIcon);
        backgroundLabel.setBounds(0, 0, 900, 900);
        backgroundLabel.setLayout(null);
        add(backgroundLabel);

        // -------------------- HEADING LABEL --------------------
        headingLabel = new JLabel("ENTER AMOUNT TO WITHDRAW");
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setFont(new Font("System", Font.BOLD, 16));
        headingLabel.setBounds(180, 350, 300, 35);
        backgroundLabel.add(headingLabel);

        // -------------------- INPUT FIELD --------------------
        amountField = new JTextField();
        amountField.setFont(new Font("Raleway", Font.BOLD, 22));
        amountField.setBounds(180, 400, 300, 30);
        backgroundLabel.add(amountField);

        // -------------------- BUTTONS --------------------
        withdrawBtn = new JButton("WITHDRAW");
        withdrawBtn.setBounds(180, 450, 130, 35);
        backgroundLabel.add(withdrawBtn);

        backBtn = new JButton("BACK");
        backBtn.setBounds(360, 450, 130, 35);
        backgroundLabel.add(backBtn);

        // -------------------- ADD ACTION LISTENERS --------------------
        withdrawBtn.addActionListener(this);
        backBtn.addActionListener(this);

        // -------------------- FRAME SETTINGS --------------------
        setSize(900, 900);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdrawBtn) {
            String amountText = amountField.getText().trim(); // Get amount entered by user
            if (amountText.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter an amount to withdraw");
                return;
            }
            try {
                int amount = Integer.parseInt(amountText);// Convert entered amount from String to int
                Conn c = new Conn(); // Database connection is created ONLY when withdraw button is clicked

                // Very important step that will ensure ki actually bank mein balance hain hi ya
                // nahi
                int balance = 0;
                // Fetch all transactions of this user using PIN
                java.sql.ResultSet rs = c.s.executeQuery(
                        "SELECT * FROM bank WHERE pin='" + userPin + "'");

                // Loop through all transactions
                while (rs.next()) {

                    // Agar transaction Deposit hai toh amount add karo
                    if (rs.getString("type").equals("Deposit")) {
                        balance += rs.getInt("amount");

                        // Agar Withdraw / FastCash hai toh amount minus karo
                    } else {
                        balance -= rs.getInt("amount");
                    }

                }

                // -------------------- CHECKPOINT BEFORE WITHDRAW --------------------
                // Check if user has sufficient balance or not
                if (balance < amount) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return; // Withdrawal yahin stop ho jayega
                }

                // -------------------- PERFORM WITHDRAW --------------------
                java.sql.Timestamp currentTime = new java.sql.Timestamp(System.currentTimeMillis());
                // Insert withdraw transaction into bank table
                String query = "INSERT INTO bank(pin, `date`, type, amount) VALUES('" +
                        userPin + "','" + currentTime + "','Withdraw','" + amount + "')";

                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(
                        null, "Rs. " + amount + " Withdrawn Successfully");

                // Close current screen and go back to Transactions
                setVisible(false);
                new Transactions(userPin).setVisible(true);

            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                e.printStackTrace();
            }

        } else if (ae.getSource() == backBtn) {
            setVisible(false);
            new Transactions(userPin).setVisible(true);
        }
    }

}
