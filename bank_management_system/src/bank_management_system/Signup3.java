package bank_management_system;
// Package name where this file belongs

import java.awt.*;
// Used for GUI elements like Font, Color, Image

import java.awt.event.*;
// Used to detect button click events

import javax.swing.*;
// Used for Swing GUI components

import java.util.*;
// Used for Random class to generate card number and PIN

public class Signup3 extends JFrame implements ActionListener {
    // This class represents Page 3 of the account opening form
    // JFrame is used to create the window
    // ActionListener is used to respond when buttons are clicked

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
    // Labels are used to show text on the screen

    JRadioButton r1, r2, r3, r4;
    // Radio buttons allow user to select only ONE account type

    JButton b1, b2;
    // b1 = Submit button
    // b2 = Cancel button

    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    // Checkboxes are used to select multiple banking services

    String formno;
    // Stores form number received from previous signup page

    Signup3(String formno) {
        // Constructor is called when Signup3 object is created
        // It receives form number from previous page

        this.formno = formno;

        setTitle("APPLICATION FORM - PAGE 3");
        // Setting title of the window

        // Loading bank logo image
        ImageIcon i1 = new ImageIcon(
                ClassLoader.getSystemResource("icons/logo.jpg"));

        // Resizing the logo image
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        // Label to display the logo
        JLabel l14 = new JLabel(i3);
        l14.setBounds(100, 30, 100, 100); // logo at left
        add(l14);

        // Form number on top right
        l11 = new JLabel("Form No:");
        l11.setFont(new Font("Raleway", Font.BOLD, 16));
        l11.setBounds(600, 70, 100, 30);
        add(l11);

        l12 = new JLabel(formno);
        l12.setFont(new Font("Raleway", Font.BOLD, 16));
        l12.setBounds(700, 70, 100, 30);
        add(l12);

        // Centering "Page 3: Account Details" between logo and Form No
        l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(300, 70, 300, 30); // visually centered between logo and Form No
        add(l1);

        l2 = new JLabel("Account Type:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));
        l2.setBounds(100, 150, 200, 30);
        add(l2);

        // Creating radio buttons for account type
        r1 = new JRadioButton("Saving Account");
        r1.setBounds(350, 150, 200, 30);
        add(r1);
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setBounds(350, 190, 200, 30);
        add(r2);
        r3 = new JRadioButton("Current Account");
        r3.setBounds(350, 230, 200, 30);
        add(r3);
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setBounds(350, 270, 250, 30);
        add(r4);

        // Grouping radio buttons so only one can be selected
        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);
        groupgender.add(r3);
        groupgender.add(r4);

        // Adding spacing before next section
        l3 = new JLabel("Card Number:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        l3.setBounds(100, 330, 200, 30);
        add(l3);

        // Dummy card number shown only for UI
        l4 = new JLabel("XXXX-XXXX-XXXX-4184");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        l4.setBounds(350, 330, 250, 30);
        add(l4);

        l5 = new JLabel("(Your 16-digit Card number)");
        l5.setFont(new Font("Raleway", Font.BOLD, 12));
        l5.setBounds(350, 360, 250, 20);
        add(l5);

        l7 = new JLabel("PIN:");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));
        l7.setBounds(100, 400, 100, 30);
        add(l7);

        // Dummy PIN shown for UI
        l8 = new JLabel("XXXX");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        l8.setBounds(350, 400, 100, 30);
        add(l8);

        l9 = new JLabel("(4-digit password)");
        l9.setFont(new Font("Raleway", Font.BOLD, 12));
        l9.setBounds(350, 430, 150, 20);
        add(l9);

        l10 = new JLabel("Services Required:");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));
        l10.setBounds(100, 470, 250, 30);
        add(l10);

        // Creating checkboxes for banking services
        c1 = new JCheckBox("ATM CARD");
        c1.setBounds(350, 470, 200, 30);
        add(c1);
        c2 = new JCheckBox("Internet Banking");
        c2.setBounds(350, 500, 200, 30);
        add(c2);
        c3 = new JCheckBox("Mobile Banking");
        c3.setBounds(350, 530, 200, 30);
        add(c3);
        c4 = new JCheckBox("EMAIL Alerts");
        c4.setBounds(350, 560, 200, 30);
        add(c4);
        c5 = new JCheckBox("Cheque Book");
        c5.setBounds(350, 590, 200, 30);
        add(c5);
        c6 = new JCheckBox("E-Statement");
        c6.setBounds(350, 620, 200, 30);
        add(c6);

        // Declaration checkbox (unchecked by default)
        c7 = new JCheckBox(
                "I hereby declare that the above entered details correct to the best of my knowledge.",
                false);
        c7.setBounds(100, 660, 700, 30);
        add(c7);

        // Creating buttons
        b1 = new JButton("Submit");
        b1.setBounds(250, 700, 150, 40); // slightly bigger buttons
        add(b1);
        b2 = new JButton("Cancel");
        b2.setBounds(450, 700, 150, 40);
        add(b2);

        // Using absolute positioning
        setLayout(null);

        // Adding action listeners to buttons
        b1.addActionListener(this);
        b2.addActionListener(this);

        setSize(850, 850);
        setLocationRelativeTo(null); // center window
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        // This method runs automatically when a button is clicked

        String atype = null;
        // This variable will store selected account type

        // Checking which radio button is selected
        if (r1.isSelected()) {
            atype = "Saving Account";
        } else if (r2.isSelected()) {
            atype = "Fixed Deposit Account";
        } else if (r3.isSelected()) {
            atype = "Current Account";
        } else if (r4.isSelected()) {
            atype = "Recurring Deposit Account";
        }

        // Random class is used to generate random numbers
        Random ran = new Random();

        /*
         * Generating 16-digit card number
         * nextLong() gives a random long value
         * % 90000000L limits the range
         * 5040936000000000L ensures card number starts from a fixed prefix
         */
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String cardno = "" + Math.abs(first7);
        // Math.abs() is used to avoid negative number

        /*
         * Generating 4-digit PIN
         * % 9000 ensures range of 4 digits
         * +1000 ensures minimum value is 1000
         */
        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);

        // Storing selected facilities in a single string
        String facility = "";

        if (c1.isSelected()) {
            facility = facility + " ATM Card";
        }
        if (c2.isSelected()) {
            facility = facility + " Internet Banking";
        }
        if (c3.isSelected()) {
            facility = facility + " Mobile Banking";
        }
        if (c4.isSelected()) {
            facility = facility + " EMAIL Alerts";
        }
        if (c5.isSelected()) {
            facility = facility + " Cheque Book";
        }
        if (c6.isSelected()) {
            facility = facility + " E-Statement";
        }

        try {
            // If Submit button is clicked
            if (ae.getSource() == b1) {

                // Checking if account type is selected or not
                if (atype == null) {
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                } else {
                    // Creating database connection
                    Conn c1 = new Conn();

                    /*
                     * q1 stores account details in signup3 table
                     * q2 stores login credentials in login table
                     */
                    String q1 = "insert into signupthree(formno,accountType,cardnumber,pin,facility) values('" + formno
                            + "','" + atype + "','" + cardno + "','" + pin
                            + "','" + facility + "')";
                    String q2 = "insert into login(formno,cardnumber,pin)values('" + formno + "','" + cardno + "','"
                            + pin + "')";

                    // Executing SQL queries
                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);

                    // Showing generated card number and PIN to user
                    JOptionPane.showMessageDialog(
                            null,
                            "Card Number: " + cardno + "\n Pin: " + pin);

                    // Opening Deposit screen
                    setVisible(false);
                    new Deposit(pin).setVisible(true);

                }
            }
            // If Cancel button is clicked
            else if (ae.getSource() == b2) {
                setVisible(false);
                new Login().setVisible(true);
            }
        } catch (Exception ex) {
            // Handling any database or runtime errors
            ex.printStackTrace();
        }
    }


}
