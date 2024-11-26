package view;

import interface_adapter.login.LoginController;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import java.awt.*;

/**
 * The view for logging into the application.
 */
public class LoginView extends JFrame implements ActionListener, PropertyChangeListener {
    private LoginViewModel loginViewModel;
    private final String viewName = "log in";
    private LoginController loginController;
    private String username;
    private String tagline;
    private String region;
    private JLabel errorLabel = new JLabel();

    public LoginView(LoginViewModel loginViewModel) {
        // Add listener for the property change
        this.loginViewModel = loginViewModel;
        this.loginViewModel.addPropertyChangeListener(this);
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
        panel.add(errorLabel); // Spacer
        panel.add(loginButton);

        add(panel);

        setVisible(true);

        final LoginState currentState = loginViewModel.getState();
        currentState.setLoginError("");

        // Add action listener for the login button
        loginButton.addActionListener(e -> {
            this.username = usernameField.getText();
            this.tagline = taglineField.getText();
            this.region = (String) regionField.getSelectedItem();

            // Call the login controller
            loginController.execute(username, tagline, region);

        });

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final LoginState state = (LoginState) evt.getNewValue();
        setFields(state);
        errorLabel.setText(state.getLoginError());
    }

    private void setFields(LoginState state) {
        errorLabel.setText(state.getLoginError());
    }

    public String getViewName() {
        return viewName;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
