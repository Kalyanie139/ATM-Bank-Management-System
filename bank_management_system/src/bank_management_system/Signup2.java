package bank_management_system;

import javax.swing.*; //For JFrame
import java.awt.*;//For Colour package
import java.awt.event.*; //For Action listener function

public class Signup2 extends JFrame implements ActionListener  {

    // Globally declaring Textfields that we will use as boxes that will hold
    // entered data
    JTextField panTextField;
    JTextField aadharTextField;
    JButton next;
    JRadioButton seniorYes, seniorNo, existingYes, existingNo;
    JComboBox<String> religionComboBox, categoryComboBox, incomeComboBox,
            educationComboBox, occupationComboBox;
    String formno;

    Signup2(String formno) {
        this.formno = formno;

        setLayout(null);// Because bydefault layout centre alligned attay ,but hame position hamare acc
                        // chaiye text ki images ki in frame

        setTitle("New Application Form Page-02:");

        // <-------------Additional Details Heading--------------------------->
        JLabel additionalDetails = new JLabel("Page 2: Additional Details.");
        additionalDetails.setFont(new Font("Arial", Font.BOLD, 22));
        additionalDetails.setBounds(300, 80, 400, 30);
        add(additionalDetails);// Very important as this step ensures that label will be displayed on text

        // <-------------Religion--------------------------->
        JLabel religionLabel = new JLabel("Religion: ");
        religionLabel.setFont(new Font("Arial", Font.BOLD, 20));
        religionLabel.setBounds(100, 180, 100, 30);
        add(religionLabel);// Very important as this step ensures that label will be displayed on text

        // Combobox is a class in Java used to create dropdowns
        String valReligion[] = { "Hindu", "Muslim", "Sikh", "Christian", "Other" };
        religionComboBox = new JComboBox<String>(valReligion);
        religionComboBox.setBackground(Color.WHITE);
        religionComboBox.setBounds(300, 180, 400, 30);
        religionComboBox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));// Border of box dark aur clear
                                                                                   // dikhne
        add(religionComboBox);

        // <-------------Category--------------------------->
        JLabel categoryLabel = new JLabel("Category: ");
        categoryLabel.setFont(new Font("Arial", Font.BOLD, 20));
        categoryLabel.setBounds(100, 220, 200, 30);
        add(categoryLabel);// Very important as this step ensures that label will be displayed on text

        String valCategory[] = { "General", "OBC", "SC", "ST", "Other" };
        categoryComboBox = new JComboBox<String>(valCategory);
        categoryComboBox.setBackground(Color.WHITE);
        categoryComboBox.setBounds(300, 220, 400, 30);
        categoryComboBox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));// Border of box dark aur clear
        add(categoryComboBox);

        // <-------------Income--------------------------->
        JLabel incomeLabel = new JLabel("Income: ");
        incomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        incomeLabel.setBounds(100, 260, 200, 30);
        add(incomeLabel);// Very important as this step ensures that label will be displayed on text

        String valIncome[] = { "NULL", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000", ">10,00,000" };
        incomeComboBox = new JComboBox<String>(valIncome);
        incomeComboBox.setBackground(Color.WHITE);
        incomeComboBox.setBounds(300, 260, 400, 30);
        incomeComboBox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));// Border of box dark aur clear
        add(incomeComboBox);

        // <-------------Educational Qualification--------------------------->
        JLabel eduLabel = new JLabel("Educational ");
        eduLabel.setFont(new Font("Arial", Font.BOLD, 20));
        eduLabel.setBounds(100, 310, 250, 30);
        add(eduLabel);// Very important as this step ensures that label will be displayed on text
        JLabel eduLabel2 = new JLabel("Qualification: ");
        eduLabel2.setFont(new Font("Arial", Font.BOLD, 20));
        eduLabel2.setBounds(100, 330, 250, 30);
        add(eduLabel2);// Very important as this step ensures that label will be displayed on text

        String valEducation[] = { "Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Other" };
        educationComboBox = new JComboBox<String>(valEducation);
        educationComboBox.setBackground(Color.WHITE);
        educationComboBox.setBounds(300, 315, 400, 30);
        educationComboBox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));// Border of box dark aur clear
        add(educationComboBox);

        // <-------------Occupation--------------------------->
        JLabel occupationLabel = new JLabel("Occupation: ");
        occupationLabel.setFont(new Font("Arial", Font.BOLD, 20));
        occupationLabel.setBounds(100, 380, 400, 30);
        add(occupationLabel);// Very important as this step ensures that label will be displayed on text

        String valOccupation[] = { "Salaried", "Self-employed", "Business", "Student", "Retired" };
        occupationComboBox = new JComboBox<String>(valOccupation);
        occupationComboBox.setBackground(Color.WHITE);
        occupationComboBox.setBounds(300, 380, 400, 30);
        occupationComboBox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));// Border of box dark aur clear
        add(occupationComboBox);

        // <-------------Pan Number--------------------------->
        JLabel panLabel = new JLabel("Pan Number: ");
        panLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panLabel.setBounds(100, 420, 200, 30);
        add(panLabel);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Arial", Font.BOLD, 14));
        panTextField.setBounds(300, 420, 400, 30);
        panTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(panTextField);

        // <-------------Aadhar Number--------------------------->
        JLabel aadharLabel = new JLabel("Aadhar Number: ");
        aadharLabel.setFont(new Font("Arial", Font.BOLD, 20));
        aadharLabel.setBounds(100, 460, 200, 30);
        add(aadharLabel);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Arial", Font.BOLD, 14));
        aadharTextField.setBounds(300, 460, 400, 30);
        aadharTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        add(aadharTextField);

        // <-------------Senior Citizen--------------------------->
        JLabel seniorLabel = new JLabel("Senior Citizen: ");
        seniorLabel.setFont(new Font("Arial", Font.BOLD, 20));
        seniorLabel.setBounds(100, 500, 200, 30);
        add(seniorLabel);

        seniorYes = new JRadioButton("Yes");
        seniorYes.setBounds(300, 500, 80, 30);
        seniorYes.setBackground(Color.WHITE);
        add(seniorYes);

        seniorNo = new JRadioButton("No");
        seniorNo.setBounds(400, 500, 80, 30);
        seniorNo.setBackground(Color.WHITE);
        add(seniorNo);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(seniorYes);
        seniorGroup.add(seniorNo);

        // <-------------Existing Account--------------------------->
        JLabel existingLabel = new JLabel("Existing Account: ");
        existingLabel.setFont(new Font("Arial", Font.BOLD, 20));
        existingLabel.setBounds(100, 540, 200, 30);
        add(existingLabel);

        existingYes = new JRadioButton("Yes");
        existingYes.setBounds(300, 540, 80, 30);
        existingYes.setBackground(Color.WHITE);
        add(existingYes);

        existingNo = new JRadioButton("No");
        existingNo.setBounds(400, 540, 80, 30);
        existingNo.setBackground(Color.WHITE);
        add(existingNo);

        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(existingYes);
        existingGroup.add(existingNo);

        // <-------------Next Button---------->
        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Arial", Font.BOLD, 14));
        next.setBounds(620, 600, 80, 30);
        add(next);next.addActionListener(this); //This is Action listener and will perform desired action

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocationRelativeTo(null); // This centers the window
        setVisible(true);
        

    }

    public void actionPerformed(ActionEvent ae) {
       // Ye code tab chalega jab NEXT button pe click hoga
        String religion = (String) religionComboBox.getSelectedItem(); 
        // JComboBox se selected value ,also we typecast it to string as getselecteditem which is used to retrieve data from 
        // from dropdown returns a object
        String category = (String) categoryComboBox.getSelectedItem();
        String income = (String) incomeComboBox.getSelectedItem();
        String education = (String) educationComboBox.getSelectedItem();
        String occupation = (String) occupationComboBox.getSelectedItem();
        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();
        String senior = null;
        if(seniorYes.isSelected())
        {
            senior="Yes";
        }
        else if(seniorNo.isSelected())
        {
            senior="No";
        }
        String existing = null;
        if(existingYes.isSelected())
        {
            existing="Yes";
        }
        else if(existingNo.isSelected())
        {
            existing="No";
        }


        // Exception Handling as SQL is an external entity
        // Also addying checks that ensures data is entered correctly
        try {
            if (religion.equals("")) {
                JOptionPane.showMessageDialog(null, "Religion is required!");//JOptionPane displays popup message on screen 
                return;
            } else if (category.equals("")) {
                JOptionPane.showMessageDialog(null, "Categoryi s required!");
                return;
            } else if (income.equals("")) {
                JOptionPane.showMessageDialog(null, "Income details are required!");
                return;
            } else if (education.equals("")) {
                JOptionPane.showMessageDialog(null, "Educational details are required!");
                return;
            } else if (occupation.equals("")) {
                JOptionPane.showMessageDialog(null, "Occupation is required!");
                return;
            }
            else if (pan.equals("")) {
                JOptionPane.showMessageDialog(null, "Pan number is required!");
                return;
            } else if (aadhar.equals("")) {
                JOptionPane.showMessageDialog(null, "Aadhar number is required!");
                return;
            } else if (senior == null) {
                JOptionPane.showMessageDialog(null, "Senior citizen status is required!");
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
                String query = "insert into signuptwo (formno, religion, category, income, education, occupation, pan, aadhar, senior, existing)values('"
                        + formno + "','" // applicant ka name insert hoga
                        + religion + "','" // father ka name database me store hoga
                        + category + "','" // date of birth SQL table me insert hogi
                        + income + "','" // selected gender value database ko milegi
                        + education + "','" // email id ko SQL string me convert kiya ja raha hai
                        + occupation + "','" // marital status ka data insert hoga
                        + pan + "','" // address ko string bana ke database ko bhej rahe hain
                        + aadhar + "','" // city value SQL query ka part ban rahi hai
                        + senior + "','" 
                        + existing + "' )"; // pin code last value ke roop me insert hoga

                // Ab final SQL query JDBC ke through MySQL database ko bhej rahe hain
                // executeUpdate() ka use INSERT / UPDATE / DELETE queries ke liye hota hai
                // Query successful hui to data permanently database me save ho jaayega
                c.s.executeUpdate(query);

                // ✅ SUCCESS MESSAGE ONLY AFTER INSERT
                JOptionPane.showMessageDialog(null,
                        "Data captured successfully!\nMoving to next page...");
                //Signup 3 class object
                new Signup3(formno).setVisible(true);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); // SHOW SQL ERROR
            e.printStackTrace();
      }

    }

    public static void main(String[] args) {
        new Signup2(null);
    }

}
