package bank_management_system;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    // Buttons globally declare kiye
    // Taaki actionPerformed() me access ho sake
    JButton login, clear, signup;

    // Text fields for card number aur pin
    JTextField cardTextField;
    JPasswordField pinTextField;

    // Constructor → UI yahi pe design hota hai
    Login() {

        // Frame ka title set kiya
        setTitle("AUTOMATED TELLER MACHINE");

        // Null layout use kar rahe hai
        // Isme hume manually position dena padta hai
        setLayout(null);

        // <-- ATM LOGO -->
        // Logo image ko system resources se load kar rahe hai
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);// Image ko resize kar rahe hai ,for
                                                                                  // that create Image class object
        ImageIcon i3 = new ImageIcon(i2);// Resized image ko wapas ImageIcon me convert kiya
        // Label ke andar image set ki
        JLabel label = new JLabel(i3); // Staight away image aap frame pe nahi paste kar sakte hence we use JLabel and
                                       // pass ImageIcon object and no Image object
        // Logo ki position set ki
        label.setBounds(100, 30, 120, 120);
        add(label); // Add function ki sahyata se image frame par place hogi

        // <-- WELCOME TEXT-->
        // Welcome heading and we do so by using JLabel
        JLabel text = new JLabel("Welcome To ATM");
        // Font thoda kam rakha taaki screen clean lage
        text.setFont(new Font("Osward", Font.BOLD, 40));
        // Position set ki
        text.setBounds(300, 40, 600, 100);
        add(text);

        // <-- CARD NUMBER -->

        // Card number label
        JLabel cardno = new JLabel("Card Number:");
        cardno.setFont(new Font("Osward", Font.BOLD, 28));
        cardno.setBounds(100, 200, 300, 40);
        add(cardno);

        // Card number text field. Box jiske mein card no. enter karenge.
        cardTextField = new JTextField();
        cardTextField.setBounds(350, 200, 400, 40);
        cardTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        cardTextField.setTransferHandler(new TransferHandler("text")); // explicit paste ko allow karta hai
        add(cardTextField);

        // <-- PIN -->
        // Pin label
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Osward", Font.BOLD, 28));
        pin.setBounds(100, 270, 300, 40);
        add(pin);

        // Pin ke liye password field
        // Taaki pin hide rahe
        pinTextField = new JPasswordField();
        pinTextField.setBounds(350, 270, 400, 40);
        pinTextField.setFont(new Font("Arial", Font.PLAIN, 18));
        add(pinTextField);

        // <-- BUTTONS --->

        // Sign In button
        login = new JButton("Sign In");
        login.setBounds(250, 360, 140, 42);
        login.setFont(new Font("Arial", Font.BOLD, 15));
        login.addActionListener(this); // Click handle karne ke liye
        add(login);

        // Sign Up button
        signup = new JButton("Sign Up");
        signup.setBounds(410, 360, 140, 42);
        signup.setFont(new Font("Arial", Font.BOLD, 15));
        signup.addActionListener(this);
        add(signup);

        // Clear button
        clear = new JButton("Clear");
        clear.setBounds(570, 360, 140, 42);
        clear.setFont(new Font("Arial", Font.BOLD, 15));
        clear.addActionListener(this);
        add(clear);

        // ---------------- FRAME SETTINGS ----------------

        // Frame ka size set kiya
        setSize(900, 550);

        // Screen pe frame kaha open hoga by default centre alligned
        setLocationRelativeTo(null);

        // Frame visible kiya
        setVisible(true);
    }

    // <-- BUTTON CLICK HANDLING --->
    // yeh function basically button click karne par kya karna hai yeh decide karta
    // hai logic checking ..etc

    public void actionPerformed(ActionEvent ae) { // ae tells konsa button click kiya hai by using getsource funcion

        // Agar Clear button press hua
        if (ae.getSource() == clear) {

            // Dono fields empty kar do
            cardTextField.setText("");// To manually reset what to display in text box
            pinTextField.setText("");
        }

        // Agar Sign In button press hua
        else if (ae.getSource() == login) {

            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '" + cardnumber + "' and pin = '" + pinnumber + "'";
            try {

                //If the query executes and data matches it will return some data
                ResultSet rs=conn.s.executeQuery(query);//Type of data it returns is of type ResultSet
                if(rs.next())
                {
                    setVisible(false);
                    //And now take to menu that is transaction class
                    new Transactions(pinnumber).setVisible(true);
                }
                else{
                    //Throw error that says data is incorrect
                    JOptionPane.showMessageDialog(null, "Incorrect Cardnumber or Pin!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage()); // SHOW SQL ERROR
                e.printStackTrace();
            }
        }

        // Agar Sign Up button press hua
        else if (ae.getSource() == signup) {
            // Current window set visible false and signup true
            setVisible(false);
            new Signup1().setVisible(true);
        }
    }

}
