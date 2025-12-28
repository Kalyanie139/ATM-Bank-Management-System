package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Deposit extends JFrame implements ActionListener {

    JLabel headingLabel; // Heading label
    JTextField amountField; // Input field for deposit amount
    JButton depositBtn, backBtn; // Deposit and Back buttons
    JLabel backgroundLabel; // Background label
    String userPin; // User PIN

    public Deposit(String pin) {
        this.userPin = pin;

        // -------------------- BACKGROUND IMAGE --------------------
        ImageIcon atmIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        backgroundLabel = new JLabel(atmIcon);
        backgroundLabel.setBounds(0, 0, 900, 900);
        backgroundLabel.setLayout(null);
        add(backgroundLabel);

        // -------------------- HEADING LABEL --------------------
        headingLabel = new JLabel("ENTER AMOUNT TO DEPOSIT");
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
        depositBtn = new JButton("DEPOSIT");
        depositBtn.setBounds(180, 450, 130, 35);
        backgroundLabel.add(depositBtn);

        backBtn = new JButton("BACK");
        backBtn.setBounds(360, 450, 130, 35);
        backgroundLabel.add(backBtn);

        // -------------------- ADD ACTION LISTENERS --------------------
        depositBtn.addActionListener(this);
        backBtn.addActionListener(this);

        // -------------------- FRAME SETTINGS --------------------
        setSize(900, 900);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == depositBtn) {
            String amountText = amountField.getText().trim();
            if (amountText.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter an amount to deposit");
                return;
            }
            try {
                int amount = Integer.parseInt(amountText);
                Conn c = new Conn();
                java.sql.Timestamp currentTime = new java.sql.Timestamp(System.currentTimeMillis());

                String query = "INSERT INTO bank(pin, `date`, type, amount) VALUES('" + userPin + "','" + currentTime
                        + "','Deposit','" + amount + "')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Deposited Successfully");
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
