package bank_management_system;

import javax.swing.*; //For JFrame
import java.awt.*;//For Colour package
import java.util.*; //package for generation of random application number
import com.toedter.calendar.JDateChooser;
import java.awt.event.*; //For Action listener function

public class Signup1 extends JFrame implements ActionListener {

    // Globally declaring Textfields that we will use as boxes that will hold
    // entered data
    JTextField nameTextField;
    JTextField fnameTextField;
    JTextField emailTextField;
    JTextField addressTextField;
    JTextField cityTextField;
    JTextField stateTextField;
    JTextField pinTextField;

    JButton next;
    JRadioButton male, female, yes, no;

    JDateChooser dateChooser;

    // Declaring other variables also global
    long random;

    Signup1() {

        setLayout(null);// Because bydefault layout centre alligned attay ,but hame position hamare acc
                        // chaiye text ki images ki in frame

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);// Will generate a absolute application number

        // LABELS THAT WILL BE DISPLAYED ON SIGNUP WINDOW
        JLabel formno = new JLabel("APPLICATION FORM NUMBER :" + random);
        formno.setFont(new Font("Arial", Font.BOLD, 38));
        formno.setBounds(100, 20, 800, 40);
        add(formno);// Very important as this step ensures that label will be displayed on text

        // <-------------Personal Details--------------------------->
        JLabel personalDetails = new JLabel("Page 1: Personal Details.");
        personalDetails.setFont(new Font("Arial", Font.BOLD, 22));
        personalDetails.setBounds(300, 80, 400, 30);
        add(personalDetails);// Very important as this step ensures that label will be displayed on text

        // <-------------Name--------------------------->
        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Arial", Font.BOLD, 20));
        name.setBounds(100, 180, 100, 30);
        add(name);// Very important as this step ensures that label will be displayed on text

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Arial", Font.BOLD, 14));
        nameTextField.setBounds(300, 180, 400, 30);
        nameTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));//// Border of box dark aur clear dikhne
                                                                                //// ke liye
        add(nameTextField);

        // <-------------Father's Name--------------------------->
        JLabel fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Arial", Font.BOLD, 20));
        fname.setBounds(100, 220, 200, 30);
        add(fname);// Very important as this step ensures that label will be displayed on text

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Arial", Font.BOLD, 14));
        fnameTextField.setBounds(300, 220, 400, 30);
        fnameTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));//// Border of box dark aur clear
                                                                                 //// dikhne ke liye
        add(fnameTextField);
        // <-------------DOB--------------------------->
        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Arial", Font.BOLD, 20));
        dob.setBounds(100, 260, 200, 30);
        add(dob);// Very important as this step ensures that label will be displayed on text

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 260, 400, 30);

        // 👉 Text box black border + white background + black text
        JComponent dateEditor = (JComponent) dateChooser.getDateEditor().getUiComponent();
        dateEditor.setBackground(Color.WHITE);
        dateEditor.setForeground(Color.BLACK);
        dateEditor.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(dateChooser);

        // <-------------Gender--------------------------->
        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Arial", Font.BOLD, 20));
        gender.setBounds(100, 300, 200, 30);
        add(gender);// Very important as this step ensures that label will be displayed on text

        // Logic that will display logic
        male = new JRadioButton("Male");
        male.setBounds(300, 300, 80, 30);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(400, 300, 100, 30);
        female.setBackground(Color.WHITE);
        add(female);
        // Logic that will ensure both wont be selected at same time
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        // <-------------Email--------------------------->
        JLabel email = new JLabel("Email: ");
        email.setFont(new Font("Arial", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);// Very important as this step ensures that label will be displayed on text

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Arial", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        emailTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));//// Border of box dark aur clear
                                                                                 //// dikhne ke liye
        add(emailTextField);

        // <-------------Marital Status--------------------------->
        JLabel marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("Arial", Font.BOLD, 20));
        marital.setBounds(100, 380, 400, 30);
        add(marital);// Very important as this step ensures that label will be displayed on text

        yes = new JRadioButton("Married");
        yes.setBounds(300, 380, 80, 30);
        yes.setBackground(Color.WHITE);
        add(yes);
        no = new JRadioButton("UnMarried");
        no.setBounds(400, 380, 120, 30);
        no.setBackground(Color.WHITE);
        add(no);

        // Logic that insures both wont be selected at once
        ButtonGroup martialgroup = new ButtonGroup();
        martialgroup.add(yes);
        martialgroup.add(no);

        // <-------------Address--------------------------->
        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Arial", Font.BOLD, 20));
        address.setBounds(100, 420, 200, 30);
        add(address);// Very important as this step ensures that label will be displayed on text

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Arial", Font.BOLD, 14));
        addressTextField.setBounds(300, 420, 400, 30);
        addressTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));//// Border of box dark aur clear
                                                                                   //// dikhne ke liye
        add(addressTextField);

        // <-------------City--------------------------->
        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Arial", Font.BOLD, 20));
        city.setBounds(100, 460, 200, 30);
        add(city);// Very important as this step ensures that label will be displayed on text

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Arial", Font.BOLD, 14));
        cityTextField.setBounds(300, 460, 400, 30);
        cityTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));//// Border of box dark aur clear dikhne
                                                                                //// ke liye
        add(cityTextField);

        // <-------------State--------------------------->
        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Arial", Font.BOLD, 20));
        state.setBounds(100, 500, 200, 30);
        add(state);// Very important as this step ensures that label will be displayed on text

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Arial", Font.BOLD, 14));
        stateTextField.setBounds(300, 500, 400, 30);
        stateTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(stateTextField);

        // <-------------Pin code-------------------------->
        JLabel pin = new JLabel("Pin Code: ");
        pin.setFont(new Font("Arial", Font.BOLD, 20));
        pin.setBounds(100, 540, 200, 30);
        add(pin);// Very important as this step ensures that label will be displayed on text

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        pinTextField.setBounds(300, 540, 400, 30);
        pinTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(pinTextField);

        // <-------------Next Button---------->
        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Arial", Font.BOLD, 14));
        next.setBounds(620, 600, 80, 30);
        next.addActionListener(this);// This will ensure that the interupt action is adddressed
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocationRelativeTo(null); // This centers the window
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        String formno = "" + random; // long ->String
        String name = nameTextField.getText(); // It gives us the value in textbox
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

        String gender = null;
        if (male.isSelected()) {// Is selected tells which button ws selected
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }

        String marital = null;
        if (yes.isSelected()) {
            marital = "Married";
        } else if (no.isSelected()) {
            marital = "UnMarried";
        }

        // getText se ham directly value nikal sakte hai from text box.
        String email = emailTextField.getText();
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();

        // Exception Handling as SQL is an external entity
        // Also addying checks that ensures data is entered correctly
        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is required!");
                return;
            } else if (fname.equals("")) {
                JOptionPane.showMessageDialog(null, "Father's name is required!");
                return;
            } else if (email.equals("")) {
                JOptionPane.showMessageDialog(null, "Email address is required!");
                return;
            } else if (address.equals("")) {
                JOptionPane.showMessageDialog(null, "Address is required!");
                return;
            } else if (state.equals("")) {
                JOptionPane.showMessageDialog(null, "State is required!");
                return;
            } else if (city.equals("")) {
                JOptionPane.showMessageDialog(null, "City is required!");
                return;
            } else if (pin.equals("")) {
                JOptionPane.showMessageDialog(null, "Pin code is required!");
                return;
            }

            // Connection establishment ke liye now we will use Conn class
            else {

                // Database se connection establish karne ke liye Conn class ka object bana rahe
                // hain
                // Jaise hi object banega, constructor ke andar JDBC + MySQL connection open ho
                // jaata hai
                Conn c = new Conn();

                // Step 2: Check if Statement is created or not
                if (c.s == null) {
                    JOptionPane.showMessageDialog(null, "Database connection failed!");
                    return;
                }

                // Ab hum SQL query ko Java String ke form me likh rahe hain
                // Database ko directly Java variables samajh nahi aate
                // Isliye variables ko SQL ke saath concatenate ( + ) karke String bana rahe
                // hain ""->Java String, ''->SQL string
                // Signup is Table name.
                String query = "insert into signup (formno, name, father_name, dob, gender, email, marital, address, city, state, pincode)values('"
                        + formno + "','" // formno Java variable → SQL me value ke form me jaayega
                        + name + "','" // applicant ka name insert hoga
                        + fname + "','" // father ka name database me store hoga
                        + dob + "','" // date of birth SQL table me insert hogi
                        + gender + "','" // selected gender value database ko milegi
                        + email + "','" // email id ko SQL string me convert kiya ja raha hai
                        + marital + "','" // marital status ka data insert hoga
                        + address + "','" // address ko string bana ke database ko bhej rahe hain
                        + city + "','" // city value SQL query ka part ban rahi hai
                        + state + "','" // state ka data database me store hoga
                        + pin + "')"; // pin code last value ke roop me insert hoga

                // Ab final SQL query JDBC ke through MySQL database ko bhej rahe hain
                // executeUpdate() ka use INSERT / UPDATE / DELETE queries ke liye hota hai
                // Query successful hui to data permanently database me save ho jaayega
                c.s.executeUpdate(query);

                // ✅ SUCCESS MESSAGE ONLY AFTER INSERT
                JOptionPane.showMessageDialog(null,
                        "Data captured successfully!\nMoving to next page...");
                setVisible(false);
                new Signup2(formno).setVisible(true);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); // SHOW SQL ERROR
            e.printStackTrace();
        }

    }

}
