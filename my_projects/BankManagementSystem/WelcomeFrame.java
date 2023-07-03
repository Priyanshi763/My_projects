package bank_management;

import java.awt.*;

public class WelcomeFrame extends Frame {
    private String customerName;

    public WelcomeFrame(String customerName) {
        this.customerName = customerName;
        setTitle("Welcome");
        setSize(300, 200);
        setLocationRelativeTo(null);

        // Create a label to display the welcome message
        Label welcomeLabel = new Label("Welcome! " + customerName);
        welcomeLabel.setAlignment(Label.CENTER);

        // Set the layout manager for the frame
        setLayout(new BorderLayout());

        // Add the welcome label to the center of the frame
        add(welcomeLabel, BorderLayout.CENTER);

        setVisible(true);
    }
}