package view;

import interface_adapter.login.LoginController;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.match.MatchController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.match.MatchPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The view for logging into the application.
 */
public class LoginView extends JPanel implements ActionListener, PropertyChangeListener {
    private final LoginViewModel loginViewModel;
    private LoginController loginController;

    private final JTextField usernameField = new JTextField();
    private final JTextField taglineField = new JTextField();
    private final JComboBox<String> regionField = new JComboBox<>(new String[]{"NA", "EU", "ASIA"});
    private final JButton loginButton = new JButton("Log In");

    public LoginView(LoginViewModel loginViewModel) {
        this.loginViewModel = loginViewModel;
        this.loginViewModel.addPropertyChangeListener(this);

        // Create the panel layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        // Input fields
        JLabel usernameLabel = new JLabel("Username:");

        JLabel taglineLabel = new JLabel("Tagline:");

        JLabel regionLabel = new JLabel("Region:");

        loginButton.addActionListener(this);

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
        setVisible(true);
    }

    public void propertyChange(PropertyChangeEvent evt) {
        final LoginState state = (LoginState) evt.getNewValue();
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Call the login controller
        loginController.execute(usernameField.getText(), taglineField.getText(), (String) regionField.getSelectedItem());
    }
}
