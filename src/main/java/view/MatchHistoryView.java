package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

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
        this.buttonPanel = new JPanel(new BorderLayout());
        backbutton.addActionListener(this);

        this.mainPanel.add(listPanel, BorderLayout.WEST);
        this.mainPanel.add(buttonPanel, BorderLayout.EAST);
    }

    public void actionPerformed(ActionEvent e) {
        this.backController.execute();
    }

    public String getViewName() {
        return viewName;
    }


}
