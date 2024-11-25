package view;

import interface_adapter.login.LoginController;
import interface_adapter.match.MatchController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.match.MatchPresenter;
import interface_adapter.profile.ProfilePresenter;

import javax.swing.*;
import java.awt.*;

/**
 * The view for logging into the application.
 */
public class LoginView extends JFrame {

    public LoginView(LoginController loginController, interface_adapter.ProfilePresenter.ProfileController profileController,
                     ProfilePresenter profilePresenter, MatchController matchController
            , LoginPresenter loginPresenter, MatchPresenter matchPresenter) {
        setTitle("Login Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Create the panel layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        // Input fields
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();

        JLabel taglineLabel = new JLabel("Tagline:");
        JTextField taglineField = new JTextField();

        JLabel regionLabel = new JLabel("Region:");
        JComboBox<String> regionField = new JComboBox<>(new String[]{"NA", "EU", "ASIA"});

        JButton loginButton = new JButton("Log In");

        // Add components to the panel
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(taglineLabel);
        panel.add(taglineField);
        panel.add(regionLabel);
        panel.add(regionField);
        panel.add(new JLabel()); // Spacer
        panel.add(loginButton);

        add(panel);

        // Add action listener for the login button
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String tagline = taglineField.getText();
            String region = (String) regionField.getSelectedItem();

            // Call the login controller
            loginController.execute(username, tagline, region);

            // If login is successful, open the MatchView
            if (loginPresenter.getPuuid() != null) {
                new MatchView(matchPresenter, loginPresenter.getPuuid(), region); // Pass MatchPresenter to MatchView
                dispose(); // Close the login window
            } else {
                JOptionPane.showMessageDialog(this, "Login failed: " + loginPresenter.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}
