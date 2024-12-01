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
                                    BackController backController) throws IOException {
        this.viewModel = viewModel;
        this.viewModel.addPropertyChangeListener(this);
        this.backController = backController;
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        backbutton.addActionListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
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
        mainPanel.removeAll();
        mainPanel.add(panelone);
        mainPanel.add(paneltwo);
        mainPanel.add(panelthree);
        mainPanel.add(panelfour);
        mainPanel.add(panelfive);
        final FreeChampionRotationState freeChampionRotationState = viewModel.getState();
        final int length = freeChampionRotationState.getChampionCount();
        for (int i = 0; i < length; i++) {
            if (i <= 5) {
                final JPanel eachPanel = geteachPanel(freeChampionRotationState, i);
                panelone.add(eachPanel);
            }
            else if (i <= 11) {
                final JPanel eachPanel = geteachPanel(freeChampionRotationState, i);
                paneltwo.add(eachPanel);
            }
            else if (i <= 17) {
                final JPanel eachPanel = geteachPanel(freeChampionRotationState, i);
                panelthree.add(eachPanel);
            }
            else if (i <= 23) {
                final JPanel eachPanel = geteachPanel(freeChampionRotationState, i);
                panelfour.add(eachPanel);
            }
            else {
                final JPanel eachPanel = geteachPanel(freeChampionRotationState, i);
                panelfive.add(eachPanel);
            }
        }
    }

    private JPanel geteachPanel(FreeChampionRotationState state, int ind) {
        final JPanel eachPanel = new JPanel();
        eachPanel.setLayout(new BoxLayout(eachPanel, BoxLayout.Y_AXIS));
        final String name = state.getFreeChampionsName(ind);
        final JLabel namelabel = new JLabel(name);
        ImageIcon icon = state.getFreeChampionIcons(ind);
        Image image = icon.getImage();
        Image newimage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimage);
        final JLabel iconlabel = new JLabel(icon);
        eachPanel.add(namelabel);
        eachPanel.add(iconlabel);
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
