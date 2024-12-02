package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
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
public class MatchHistoryView extends JPanel implements ActionListener, PropertyChangeListener, MouseWheelListener {
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
    }

    public void propertyChange(PropertyChangeEvent evt) {
        this.removeAll();
        // Set up main layout
        this.mainPanel = new JPanel(new BorderLayout());
        this.listPanel = new JPanel();
        listPanel.setBorder(BorderFactory.createTitledBorder("Match History"));
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        // Add scroll functionality to the listPanel
        JScrollPane scrollPane = new JScrollPane(listPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Set up button panel and add the back button
        this.buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        backbutton.addActionListener(this);
        buttonPanel.add(backbutton);

        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        this.setLayout(new BorderLayout());
        this.add(mainPanel, BorderLayout.CENTER);

        // Add mouse wheel listener to the main panel for scrolling
        this.addMouseWheelListener(this);

        final MatchHistoryState match = matchHistoryViewModel.getState();
        final int length = match.getLength();
        listPanel.removeAll();

        for (int i = 0; i < length; i++) {
            final JPanel eachmatch = createMatchDetails(match, i);
            listPanel.add(eachmatch);
        }
        listPanel.revalidate();
        listPanel.repaint();
    }

    @SuppressWarnings({"checkstyle:MethodName", "checkstyle:SuppressWarnings"})
    private JPanel createMatchDetails(MatchHistoryState match, int ind) {
        final JPanel backPanel = new JPanel();
        backPanel.setLayout(new BoxLayout(backPanel, BoxLayout.X_AXIS));

        final JPanel leftPanel = getleftjPanel(match, ind);
        final JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
        ImageIcon icon = match.getChampionIcon(ind);

        if (icon != null) {
            Image image = icon.getImage();
            Image newImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            icon = new ImageIcon(newImage);
            final JLabel iconLabel = new JLabel(icon);
            middlePanel.add(iconLabel);
        }
        else {
            JLabel iconLabel = new JLabel("No Image Available");
            middlePanel.add(iconLabel);
        }

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

        final JLabel aram = new JLabel(match.getGameMode(ind));
        final JLabel date = new JLabel(match.getDate(ind));
        leftPanel.add(aram);
        leftPanel.add(date);

        final JPanel leftdownPanel = new JPanel();
        leftdownPanel.setLayout(new BoxLayout(leftdownPanel, BoxLayout.Y_AXIS));
        final JLabel result = new JLabel(match.getWinOrLoss(ind));
        final JLabel duration = new JLabel(match.getDuration(ind));
        leftdownPanel.add(result);
        leftdownPanel.add(duration);

        leftPanel.add(leftdownPanel);
        return leftPanel;
    }

    @NotNull
    private JPanel getrightjPanel(MatchHistoryState match, int ind) {
        final JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        final JLabel kda = new JLabel(getkda(match, ind));
        rightPanel.add(kda);
        return rightPanel;
    }

    private String getkda(MatchHistoryState match, int ind) {
        final int k = match.getKills(ind);
        final int d = match.getDeaths(ind);
        final int a = match.getAssissts(ind);
        return k + "/" + d + "/" + a;
    }

    public void actionPerformed(ActionEvent e) {
        this.backController.execute();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        JScrollPane scrollPane = (JScrollPane) mainPanel.getComponent(1);
        if (e.getWheelRotation() < 0) {
            // Scroll up
            scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getValue() - 30);
        } else {
            // Scroll down
            scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getValue() + 30);
        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setBackController(BackController backController) {
        this.backController = backController;
    }
}
