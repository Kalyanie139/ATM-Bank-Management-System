package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pin extends JFrame implements ActionListener {

    JPasswordField t1, t2; // Fields to enter new PIN and re-enter PIN
    JButton b1, b2; // Buttons: CHANGE and BACK
    JLabel l1, l2, l3; // Labels for heading and input fields
    String pin; // Stores current user PIN

    Pin(String pin) {
        this.pin = pin; // Store the current session PIN

        // -------------------- BACKGROUND --------------------
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        JLabel l4 = new JLabel(i1);
        l4.setBounds(0, 0, 900, 900);
        add(l4);

        // -------------------- HEADING --------------------
        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setForeground(Color.WHITE);
        l1.setBounds(260, 300, 400, 35);
        l4.add(l1);

        // -------------------- NEW PIN LABEL --------------------
        l2 = new JLabel("New PIN:");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.WHITE);
        l2.setBounds(160, 350, 150, 35);
        l4.add(l2);

        // -------------------- RE-ENTER PIN LABEL --------------------
        l3 = new JLabel("Re-Enter New PIN:");
        l3.setFont(new Font("System", Font.BOLD, 16));
        l3.setForeground(Color.WHITE);
        l3.setBounds(160, 400, 200, 35);
        l4.add(l3);

        // -------------------- INPUT FIELDS --------------------
        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 20));
        t1.setBounds(330, 350, 180, 30);
        l4.add(t1);

        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 20));
        t2.setBounds(330, 400, 180, 30);
        l4.add(t2);

        // -------------------- BUTTONS --------------------
        b1 = new JButton("CHANGE");
        b1.setBounds(350, 480, 150, 35);
        l4.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(350, 525, 150, 35);
        l4.add(b2);

        // -------------------- ACTION LISTENERS --------------------
        b1.addActionListener(this);
        b2.addActionListener(this);

        // -------------------- FRAME SETTINGS --------------------
        setLayout(null);
        setSize(900, 900);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }

    // -------------------- BUTTON ACTION HANDLER --------------------
    public void actionPerformed(ActionEvent ae) {
        try {

            // -------------------- BACK BUTTON --------------------
            if (ae.getSource() == b2) {
                dispose();// To close the current widow smoothly and open new one if required so
                new Transactions(pin).setVisible(true);
                ;
                return;
            }

            // -------------------- FETCH USER INPUT --------------------
            String npin = new String(t1.getPassword());
            String rpin = new String(t2.getPassword());

            // -------------------- VALIDATIONS --------------------
            if (npin.equals("")) {
                JOptionPane.showMessageDialog(this, "Enter New PIN");
                return;
            }

            if (rpin.equals("")) {
                JOptionPane.showMessageDialog(this, "Re-Enter New PIN");
                return;
            }

            if (!npin.equals(rpin)) {
                JOptionPane.showMessageDialog(this, "Entered PIN does not match");
                return;
            }

            // -------------------- DATABASE CONNECTION --------------------
            Conn c1 = new Conn();

            // -------------------- UPDATE PIN IN DATABASE --------------------
            String q1 = "UPDATE bank SET pin = '" + rpin + "' WHERE pin = '" + pin + "'";
            String q2 = "UPDATE login SET pin = '" + rpin + "' WHERE pin = '" + pin + "'";
            String q3 = "UPDATE signupthree SET pin = '" + rpin + "' WHERE pin = '" + pin + "'";

            c1.s.executeUpdate(q1);
            c1.s.executeUpdate(q2);
            c1.s.executeUpdate(q3);

            JOptionPane.showMessageDialog(this, "PIN changed successfully");

            dispose();
            new Transactions(rpin).setVisible(true);
            ;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); // 🌟
        }
    }
}
