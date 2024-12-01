package view;

import javax.swing.*;
import java.awt.*;

import entity.match.Match;
import entity.matchHistory.MatchHistory;
import interface_adapter.back.BackController;
import interface_adapter.login.LoginState;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class MatchHistoryView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "MatchHistory";
    private MatchHistoryViewModel matchHistoryViewModel;
    private BackController backController;
    private JPanel mainPanel;
    private JPanel listPanel;
    private JPanel buttonPanel;
    private JButton backbutton = new JButton("Back");

    public MatchHistoryView(MatchHistoryViewModel matchHistoryViewModel,
                            BackController backController) {

        this.matchHistoryViewModel = loggedInViewModel;
        this.backController = backController;
        this.matchHistoryViewModel.addPropertyChangeListener(this);

        this.mainPanel = new JPanel(new BorderLayout());
        this.listPanel = new JPanel(new BorderLayout());
        listPanel.setBorder(BorderFactory.createTitledBorder("Match History"));
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        this.buttonPanel = new JPanel(new BorderLayout());
        backbutton.addActionListener(this);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        this.mainPanel.add(listPanel);
        this.mainPanel.add(buttonPanel);
    }

    public void propertyChange(PropertyChangeEvent evt) {
        final MatchHistory matches = matchHistoryViewModel.getstate().getMatchHistory();
        final int length = matches.getLength();
        listPanel.removeAll();
        for (int i = 0; i < length; i++) {
            final Match match = matches.getMatch(i);
            final JPanel eachmatch = createMatchDetails(match);
            listPanel.add(eachmatch);
        }
    }

    @SuppressWarnings({"checkstyle:MethodName", "checkstyle:SuppressWarnings"})
    private JPanel createMatchDetails(Match match) {
        JPanel backPanel = new JPanel();
        backPanel.setLayout(new BoxLayout(backPanel, BoxLayout.X_AXIS));
        JPanel leftPanel = new JPanel();

        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        JPanel leftupPanel = new JPanel();
        leftupPanel.setLayout(new BoxLayout(leftupPanel, BoxLayout.Y_AXIS));
        JLabel aram = new JLabel(match.getGameMode());
        JLabel date = new JLabel(match.getDate());
        leftPanel.add(aram);
        leftPanel.add(date);

        JPanel leftmiddlePanel = new JPanel();

        JPanel leftdownPanel = new JPanel();
        leftdownPanel.setLayout(new BoxLayout(leftdownPanel, BoxLayout.Y_AXIS));
        JLabel result = new JLabel(match.getResult());
        JLabel duration = new JLabel(match.getDuration());
        leftdownPanel.add(result);
        leftdownPanel.add(duration);

        leftPanel.add(leftupPanel);
        leftPanel.add(leftmiddlePanel);
        leftPanel.add(leftdownPanel);

        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
        JLabel icon = new JLabel(match.getChampionIcon());
        middlePanel.add(icon);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        JPanel rightupPanel = new JPanel();
        JPanel rightmiddlePanel = new JPanel();
        JLabel kda = new JLabel(getkda(match));
        rightmiddlePanel.add(kda);
        JPanel rightdownPanel = new JPanel();

        rightPanel.add(rightupPanel);
        rightPanel.add(rightmiddlePanel);
        rightPanel.add(rightdownPanel);

        backPanel.add(leftPanel);
        backPanel.add(middlePanel);
        backPanel.add(rightPanel);
        return backPanel;
    }

    private String getkda(Match match) {
        final int k = match.getKills();
        final int d = match.getDeaths();
        final int a = match.getAssissts();
        final String strk = String.valueOf(k);
        final String strd = String.valueOf(d);
        final String stra = String.valueOf(a);
        return strk + "/" + strd + "/" + stra;
    }

    public void actionPerformed(ActionEvent e) {
        this.backController.execute();
    }

    public String getViewName() {
        return viewName;
    }

    public void setBackController(BackController backController) {
        this.backController = backController;
    }

}
