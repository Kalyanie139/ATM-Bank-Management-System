🏦 ATM Bank Management System

A desktop-based banking simulator built with Java Swing and MySQL.  
This application replicates core ATM functionalities with a focus on secure authentication, transaction handling, and database persistence.

✨ Key Features
- User Management: Multi-step signup process (Personal, Professional, and Account details)
- Secure Login: PIN-based user authentication
- Banking Operations: Deposit, Withdrawal, and Fast Cash
- Account Services: Balance Enquiry, PIN Change, and Mini Statement
- Data Persistence: Complete integration with MySQL using JDBC

🛠️ Tech Stack
- Language: Java 
- GUI: Java Swing and AWT
- Database: MySQL
- API: JDBC

📁 Project Structure: 
- ATM_Project
  - src
    - bank_management_system
      - Login.java          # Entry point and authentication
      - Signup1.java        # User registration flow
      - Signup2.java
      - Signup3.java
      - Transactions.java   # Main dashboard
      - Conn.java           # JDBC connection logic
      - Deposit.java       
      - Withdrawl.java     
      - FastCash.java       
      - BalanceEnquiry.java
      - Pin.java
      - MiniStatement.java
      - icons
        - atm.jpg
        - logo.jpg

🚀 Quick Setup
1. Clone the repository  
   git clone https://github.com/Kalyanie139/ATM-Bank-Management-System.git
2. Database setup  
   Create a MySQL database named bankmanagementsystem and create the required tables.
3. Connect to database  
   Update MySQL credentials in Conn.java.
4. Run the application  
   Execute Login.java or Main.java from your IDE.


📈 Learning Outcomes
- Practical implementation of Object-Oriented Programming concepts
- Hands-on experience with CRUD operations using JDBC
- Designing event-driven and interactive GUIs using Java Swing
- Understanding transaction-based systems and data persistence

Author:  
Kalyani Pradeep Somvanshi  

Note: This project is developed for educational and learning purposes.
