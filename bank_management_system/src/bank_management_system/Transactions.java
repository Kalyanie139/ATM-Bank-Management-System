package bank_management_system;
// This package contains all classes related to the bank management system project
// Using package helps to keep the project well organized

import java.awt.*;
// This package is used for GUI related things like colors, fonts and images

import java.awt.event.*;
// This package is used to handle events like button clicks

import javax.swing.*;
// Swing package is used to create GUI components like JFrame, JLabel and JButton

public class Transactions extends JFrame implements ActionListener {
    // This class represents the ATM transaction selection screen
    // JFrame is extended to create a window
    // ActionListener is an interface used to handle button click events
    // It allows this class to respond when any button is pressed

    JLabel l1;
    // Label used to display heading text on the ATM screen

    JButton b1, b2, b3, b4, b5, b6, b7;
    // Buttons for different ATM operations
    // b1 - Deposit
    // b2 - Cash Withdrawal
    // b3 - Fast Cash
    // b4 - Mini Statement
    // b5 - PIN Change
    // b6 - Balance Enquiry
    // b7 - Exit

    String pin;
    // Variable to store user's PIN number
    // This PIN is passed from login screen to this screen

    Transactions(String pin) {
        // Constructor of Transactions class
        // It is called when this screen is opened
        // PIN is received from previous screen

        this.pin = pin;
        // Storing received PIN into class variable
        // Same PIN will be passed to other transaction screens

        ImageIcon i1 = new ImageIcon(
                ClassLoader.getSystemResource("icons/atm.jpg"));
        // Loading ATM background image from project folder using ClassLoader

        JLabel l2 = new JLabel(i1);
        // Label used to set background image on the screen

        l2.setBounds(0, 0, 900, 900);
        // Setting size and position of background image

        add(l2);
        // Adding background label to the main frame

        setLayout(null);
        // Using null layout to manually set position of components

        l1 = new JLabel("Please Select Your Transaction");
        // Heading text displayed to the user

        l1.setForeground(Color.WHITE);
        // Setting text color to white for better visibility

        l1.setFont(new Font("System", Font.BOLD, 16));
        // Setting font style and size of heading text

        l1.setBounds(180, 350, 400, 30);
        // Setting position of heading text on black screen

        l2.add(l1);
        // Adding heading label to background image

        b1 = new JButton("DEPOSIT");
        b2 = new JButton("CASH WITHDRAWL");
        b3 = new JButton("FAST CASH");
        b4 = new JButton("MINI STATEMENT");
        b5 = new JButton("PIN CHANGE");
        b6 = new JButton("BALANCE ENQUIRY");
        b7 = new JButton("EXIT");

        b1.setBounds(150, 410, 160, 35);
        l2.add(b1);

        b2.setBounds(340, 410, 160, 35);
        l2.add(b2);

        b3.setBounds(150, 455, 160, 35);
        l2.add(b3);

        b4.setBounds(340, 455, 160, 35);
        l2.add(b4);

        b5.setBounds(150, 500, 160, 35);
        l2.add(b5);

        b6.setBounds(340, 500, 160, 35);
        l2.add(b6);

        b7.setBounds(260, 535, 160, 28);
        l2.add(b7);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        setSize(900, 900);
        // Setting size of the ATM window

        setLocationRelativeTo(null);
        // Setting location of window at the center of screen like signup screens

        setUndecorated(true);
        // Removing title bar to make it look like ATM screen

        setVisible(true);
        // Making the window visible to the user
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {
            setVisible(false);
            new Deposit(pin).setVisible(true);
        } else if (ae.getSource() == b2) {
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
        } else if (ae.getSource() == b3) {
            setVisible(false);
            new FastCash(pin).setVisible(true);
        } else if (ae.getSource() == b4) {
            new MiniStatement(pin).setVisible(true);
        } else if (ae.getSource() == b5) {
            setVisible(false);
            new Pin(pin).setVisible(true);
        } else if (ae.getSource() == b6) {
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        } else if (ae.getSource() == b7) {
            System.exit(0);
        }
    }
}
