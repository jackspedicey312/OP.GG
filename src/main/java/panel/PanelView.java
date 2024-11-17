package panel;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings({"checkstyle:WriteTag", "checkstyle:SuppressWarnings"})
public class PanelView extends JPanel implements ActionListener {
    private final ButtonPresenter buttonPresenter;
    private final JButton overviewButton = new JButton("Overview");
    private final JButton matchHistoryButton = new JButton("Match History");
    private final JButton friendsButton = new JButton("Friends");
    private final JButton championsButton = new JButton("Champions");
    private final JButton funFactsButton = new JButton("Fun Facts");
    private final JButton logoutButton = new JButton("Log out");
    private final JPanel panel;

    public PanelView() {
        final JPanel firstPanel = new JPanel();
        this.buttonPresenter = new ButtonPresenter();
        firstPanel.setLayout(new BoxLayout(firstPanel, BoxLayout.X_AXIS));
        firstPanel.add(logoutButton);
        firstPanel.add(Box.createRigidArea(new Dimension(248, 0)));
        firstPanel.add(overviewButton);
        final JPanel secondPanel = new JPanel();
        secondPanel.setLayout(new BoxLayout(secondPanel, BoxLayout.X_AXIS));
        secondPanel.add(matchHistoryButton);
        secondPanel.add(friendsButton);
        secondPanel.add(championsButton);
        secondPanel.add(funFactsButton);
        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(firstPanel);
        mainPanel.add(secondPanel);
        this.panel = mainPanel;

        overviewButton.addActionListener(this);
        matchHistoryButton.addActionListener(this);
        friendsButton.addActionListener(this);
        championsButton.addActionListener(this);
        funFactsButton.addActionListener(this);
        logoutButton.addActionListener(this);
    }

    @SuppressWarnings({"checkstyle:MissingJavadocMethod", "checkstyle:SuppressWarnings", "checkstyle:ParameterName"})
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == overviewButton) {
            this.buttonPresenter.OverviewButtonClicked();
        }
        else if (e.getSource() == matchHistoryButton) {
            this.buttonPresenter.MatchHistoryButtonClicked();
        }
        else if (e.getSource() == friendsButton) {
            this.buttonPresenter.FriendsButtonClicked();
        }
        else if (e.getSource() == championsButton) {
            this.buttonPresenter.ChampionButtonClicked();
        }
        else if (e.getSource() == funFactsButton) {
            this.buttonPresenter.FunFactsButtonClicked();
        }
        else if (e.getSource() == logoutButton) {
            this.buttonPresenter.LogoutClicked();
        }
    }

    public JPanel getPanel() {
        return this.panel;
   }
}
