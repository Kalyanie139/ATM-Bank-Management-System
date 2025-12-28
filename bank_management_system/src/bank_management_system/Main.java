package bank_management_system;

import javax.swing.UIManager;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        try {
            // Set Look & Feel
            UIManager.setLookAndFeel(
                UIManager.getCrossPlatformLookAndFeelClassName()
            );

            // Start application from Login
            new Login();

        } catch (Exception e) {
            // Show any exception in a dialog
            JOptionPane.showMessageDialog(
                null,
                "An error occurred while starting the application:\n" + e,
                "Startup Error",
                JOptionPane.ERROR_MESSAGE
            );
            e.printStackTrace(); // also print in console for debugging
        }
    }
}
