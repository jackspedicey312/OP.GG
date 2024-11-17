package panel;

import javax.swing.*;

public class PanelView {
    private final JButton overviewButton = new JButton("Overview");
    private final JButton matchHistoryButton = new JButton("Match History");
    private final JButton friendsButton = new JButton("Friends");
    private final JButton championsButton = new JButton("Champions");
    private final JButton funFactsButton = new JButton("Fun Facts");
    private final JButton logoutButton = new JButton("Logout");
    private final JPanel panel;

    public PanelView(ButtonPresenter buttonPresenter) {
        final JPanel firstpanel = new JPanel();
        firstpanel.setLayout(new BoxLayout(firstpanel, BoxLayout.X_AXIS));
        firstpanel.add(logoutButton);
        firstpanel.add(overviewButton);
        final JPanel secondpanel = new JPanel();
        secondpanel.setLayout(new BoxLayout(secondpanel, BoxLayout.X_AXIS));
        secondpanel.add(matchHistoryButton);
        secondpanel.add(friendsButton);
        secondpanel.add(championsButton);
        secondpanel.add(funFactsButton);
        final JPanel mainpanel = new JPanel();
        mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.Y_AXIS));
        mainpanel.add(firstpanel);
        mainpanel.add(secondpanel);
        this.panel = mainpanel;

        overviewButton.addActionListener(e -> {})
    }

    public JPanel getpanel() {
        return this.panel;
    }
}
