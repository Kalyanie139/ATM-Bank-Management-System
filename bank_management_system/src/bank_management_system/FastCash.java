package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JLabel l1; // Heading label
    JButton b1, b2, b3, b4, b5, b6, b7; // Fast Cash buttons
    String pin; // User PIN

    public FastCash(String pin) {
        this.pin = pin;

        // -------------------- BACKGROUND --------------------
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        JLabel l2 = new JLabel(i1);
        l2.setBounds(0, 0, 900, 900);
        add(l2);

        // -------------------- HEADING --------------------
        l1 = new JLabel("SELECT WITHDRAWAL AMOUNT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(200, 350, 700, 35);
        l2.add(l1);

        // -------------------- BUTTONS --------------------
        b1 = new JButton("Rs 100");
        b2 = new JButton("Rs 500");
        b3 = new JButton("Rs 1000");
        b4 = new JButton("Rs 2000");
        b5 = new JButton("Rs 5000");
        b6 = new JButton("Rs 10000");
        b7 = new JButton("BACK");

        b1.setBounds(150, 400, 150, 35);
        l2.add(b1);

        b2.setBounds(350, 400, 150, 35);
        l2.add(b2);

        b3.setBounds(150, 445, 150, 35);
        l2.add(b3);

        b4.setBounds(350, 445, 150, 35);
        l2.add(b4);

        b5.setBounds(150, 490, 150, 35);
        l2.add(b5);

        b6.setBounds(350, 490, 150, 35);
        l2.add(b6);

        b7.setBounds(350, 535, 150, 35);
        l2.add(b7);

        // -------------------- ACTION LISTENERS --------------------
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        // -------------------- FRAME SETTINGS --------------------
        setSize(900, 900);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }
    // -------------------- BUTTON ACTION HANDLER --------------------

    public void actionPerformed(ActionEvent ae) {
        try {
            // ------------------ BACK BUTTON ------------
            // If BACK is clicked, go back to Transactions screen
            if (ae.getSource() == b7) {
                setVisible(false);
                new Transactions(pin).setVisible(true);
                return;
            }

            // ------------ FETCH SELECTED AMOUNT --------------------
            JButton clickedButton = (JButton) ae.getSource();
            int amount = Integer.parseInt(clickedButton.getText().substring(3));

              // -------------------- DATABASE CONNECTION --------------------
            Conn c = new Conn();
            java.sql.Timestamp date = new java.sql.Timestamp(new Date().getTime());


            // ------------ CALCULATE CURRENT BALANCE --------------------
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin='" + pin + "'");
            int balance = 0;

            while (rs.next()) {
                if ("Deposit".equals(rs.getString("type"))) {//Very crutial line that check this amount was of type deposit that is was amount deposited in account
                    balance += rs.getInt("amount");
                } else {
                    balance -= rs.getInt("amount");
                }
            }

            // -------------------- BALANCE CHECK --------------------
            if (balance < amount) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }

            // -------------------- RECORD WITHDRAWAL --------------------
            c.s.executeUpdate(
                    "INSERT INTO bank(pin, date, type, amount) VALUES('" +
                            pin + "', '" + date + "', 'Withdraw', '" + amount + "')");

            JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");

            // -------------------- RETURN TO TRANSACTIONS --------------------
            setVisible(false);
            new Transactions(pin).setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}