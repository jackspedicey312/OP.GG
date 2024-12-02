package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import data_access.RiotAPIFreeRotationDataAccess;
import interface_adapter.freeChampionRotation.FreeChampionRotationController;
import interface_adapter.freeChampionRotation.FreeChampionRotationState;
import interface_adapter.freeChampionRotation.FreeChampionRotationViewModel;
import interface_adapter.back.BackController;

import javax.swing.*;
import java.io.IOException;

public class FreeChampionRotationView extends JPanel implements PropertyChangeListener, ActionListener {
    private final String viewName = "freeChampionRotation";
    private JButton backbutton = new JButton("Back");
    private final JPanel mainPanel = new JPanel();
    private FreeChampionRotationController controller;
    private final FreeChampionRotationViewModel viewModel;
    private BackController backController;


    public FreeChampionRotationView(FreeChampionRotationViewModel viewModel,
                                    BackController backController) {
        this.viewModel = viewModel;
        this.viewModel.addPropertyChangeListener(this);
        this.backController = backController;

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        this.add(mainPanel, BorderLayout.CENTER);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final FreeChampionRotationState state = (FreeChampionRotationState) evt.getNewValue();

        final JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Free Champion Rotation");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titlePanel.add(titleLabel);
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setMaximumSize(new Dimension(400, 200));

        final JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        backbutton.addActionListener(this);
        buttonPanel.add(backbutton, BorderLayout.NORTH);

        final JPanel panelone = new JPanel();
        panelone.setLayout(new BoxLayout(panelone, BoxLayout.X_AXIS));
        final JPanel paneltwo = new JPanel();
        paneltwo.setLayout(new BoxLayout(paneltwo, BoxLayout.X_AXIS));
        final JPanel panelthree = new JPanel();
        panelthree.setLayout(new BoxLayout(panelthree, BoxLayout.X_AXIS));
        final JPanel panelfour = new JPanel();
        panelfour.setLayout(new BoxLayout(panelfour, BoxLayout.X_AXIS));
        final JPanel panelfive = new JPanel();
        panelfive.setLayout(new BoxLayout(panelfive, BoxLayout.X_AXIS));
        this.removeAll();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(buttonPanel, BorderLayout.WEST);
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(panelone);
        this.add(paneltwo);
        this.add(panelthree);
        this.add(panelfour);
        this.add(panelfive);
        final int length = state.getChampionCount();
        for (int i = 0; i < length; i++) {
            if (i <= 5) {
                final JPanel eachPanel = geteachPanel(state, i);
                panelone.add(eachPanel);
            }
            else if (i <= 11) {
                final JPanel eachPanel = geteachPanel(state, i);
                paneltwo.add(eachPanel);
            }
            else if (i <= 17) {
                final JPanel eachPanel = geteachPanel(state, i);
                panelthree.add(eachPanel);
            }
            else if (i <= 23) {
                final JPanel eachPanel = geteachPanel(state, i);
                panelfour.add(eachPanel);
            }
            else {
                final JPanel eachPanel = geteachPanel(state, i);
                panelfive.add(eachPanel);
            }
        }
    }

    private JPanel geteachPanel(FreeChampionRotationState state, int ind) {
        final JPanel eachPanel = new JPanel();
        eachPanel.setLayout(new BoxLayout(eachPanel, BoxLayout.Y_AXIS));

        final String name = state.getFreeChampionsName(ind);
        final JLabel namelabel = new JLabel(name);

        // Image Icon needs to be reduced in size here.
        final ImageIcon originalIcon = state.getFreeChampionIcons(ind);

        JLabel iconLabel;
        if (originalIcon != null) {
            // Resize the icon if it is not null
            final Image scaledImage = originalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            final ImageIcon scaledIcon = new ImageIcon(scaledImage);
            iconLabel = new JLabel(scaledIcon);
        }
        else {
            // Use a placeholder or default text if the icon is null
            iconLabel = new JLabel("No Image Available");
            iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        }

        eachPanel.add(namelabel);
        eachPanel.add(iconLabel);
        return eachPanel;
    }

    public void actionPerformed(ActionEvent e) {
        this.backController.execute();
    }

    public String getViewName() {
        return viewName;
    }

    public void setFreeChampionRotationController(FreeChampionRotationController newcontroller) {
        this.controller = newcontroller;
    }
}
