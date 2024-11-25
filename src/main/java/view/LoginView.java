package view;

import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.match.MatchController;
import interface_adapter.match.MatchPresenter;

import javax.swing.*;
import java.awt.*;

/**
 * View for logging in and transitioning to MatchView after successful login.
 */
public class LoginView extends JFrame {

    public LoginView(LoginController loginController, MatchController matchController,
                     LoginPresenter loginPresenter, MatchPresenter matchPresenter) {
        setTitle("Login Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Main panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        // Username field
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();

        // Tagline field
        JLabel taglineLabel = new JLabel("Tagline:");
        JTextField taglineField = new JTextField();

        // Region dropdown
        JLabel regionLabel = new JLabel("Region:");
        JComboBox<String> regionComboBox = new JComboBox<>(new String[]{"NA", "EU", "ASIA"});

        // Login button
        JButton loginButton = new JButton("Log In");

        // Add components to the panel
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(taglineLabel);
        panel.add(taglineField);
        panel.add(regionLabel);
        panel.add(regionComboBox);
        panel.add(new JLabel()); // Empty space
        panel.add(loginButton);

        add(panel);

        // Add action listener for the login button
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String tagline = taglineField.getText();
            String region = (String) regionComboBox.getSelectedItem();

            if (username.isEmpty() || tagline.isEmpty() || region == null) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Call the LoginController to handle the login
            loginController.execute(username, tagline, region);

            // Example of using loginPresenter for displaying messages
            String puuid = loginPresenter.getPuuid();
            if (puuid != null) {
                JOptionPane.showMessageDialog(this, "Login Successful! PUUID: " + puuid, "Success", JOptionPane.INFORMATION_MESSAGE);

                // Open MatchView and dispose of LoginView
                new MatchView(matchController, puuid, region, matchPresenter);
                dispose(); // Close the LoginView
            } else {
                JOptionPane.showMessageDialog(this, "Login Failed: " + loginPresenter.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}


