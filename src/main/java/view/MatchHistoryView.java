package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import interface_adapter.matchHistory.MatchHistoryState;
import org.jetbrains.annotations.NotNull;

import entity.match.Match;
import entity.matchHistory.MatchHistory;
import interface_adapter.back.BackController;
import interface_adapter.matchHistory.MatchHistoryViewModel;

@SuppressWarnings({"checkstyle:WriteTag", "checkstyle:SuppressWarnings"})
public class MatchHistoryView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "matchHistory";
    private MatchHistoryViewModel matchHistoryViewModel;
    private BackController backController;
    private JPanel mainPanel;
    private JPanel listPanel;
    private JPanel buttonPanel;
    private JButton backbutton = new JButton("Back");

    public MatchHistoryView(MatchHistoryViewModel matchHistoryViewModel,
                            BackController backController) {

        this.matchHistoryViewModel = matchHistoryViewModel;
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
        final MatchHistoryState match = matchHistoryViewModel.getState();
        final int length = match.getLength();
        listPanel.removeAll();
        for (int i = 0; i < length; i++) {
            final JPanel eachmatch = createMatchDetails(match, i);
            listPanel.add(eachmatch);
        }
    }

    @SuppressWarnings({"checkstyle:MethodName", "checkstyle:SuppressWarnings"})
    private JPanel createMatchDetails(MatchHistoryState match, int ind) {
        final JPanel backPanel = new JPanel();
        backPanel.setLayout(new BoxLayout(backPanel, BoxLayout.X_AXIS));

        final JPanel leftPanel = getleftjPanel(match, ind);

        final JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
        final JLabel icon = new JLabel(match.getChampionIcon(ind));
        middlePanel.add(icon);

        final JPanel rightPanel = getrightjPanel(match, ind);

        backPanel.add(leftPanel);
        backPanel.add(middlePanel);
        backPanel.add(rightPanel);
        return backPanel;
    }

    @NotNull
    private static JPanel getleftjPanel(MatchHistoryState match, int ind) {
        final JPanel leftPanel = new JPanel();

        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        final JPanel leftupPanel = new JPanel();
        leftupPanel.setLayout(new BoxLayout(leftupPanel, BoxLayout.Y_AXIS));
        final JLabel aram = new JLabel(match.getGameMode(ind));
        final JLabel date = new JLabel(match.getDate(ind));
        leftPanel.add(aram);
        leftPanel.add(date);

        final JPanel leftmiddlePanel = new JPanel();

        final JPanel leftdownPanel = new JPanel();
        leftdownPanel.setLayout(new BoxLayout(leftdownPanel, BoxLayout.Y_AXIS));
        final JLabel result = new JLabel(match.getWinOrLoss(ind));
        final JLabel duration = new JLabel(match.getDuration(ind));
        leftdownPanel.add(result);
        leftdownPanel.add(duration);

        leftPanel.add(leftupPanel);
        leftPanel.add(leftmiddlePanel);
        leftPanel.add(leftdownPanel);
        return leftPanel;
    }

    @NotNull
    private JPanel getrightjPanel(MatchHistoryState match, int ind) {
        final JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        final JPanel rightupPanel = new JPanel();
        final JPanel rightmiddlePanel = new JPanel();
        final JLabel kda = new JLabel(getkda(match, ind));
        rightmiddlePanel.add(kda);
        final JPanel rightdownPanel = new JPanel();

        rightPanel.add(rightupPanel);
        rightPanel.add(rightmiddlePanel);
        rightPanel.add(rightdownPanel);
        return rightPanel;
    }

    private String getkda(MatchHistoryState match, int ind) {
        final int k = match.getKills(ind);
        final int d = match.getDeaths(ind);
        final int a = match.getAssissts(ind);
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
