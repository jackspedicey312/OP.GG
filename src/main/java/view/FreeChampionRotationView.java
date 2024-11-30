package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import data_access.RiotAPIFreeRotationDataAccess;
import interface_adapter.freeChampionRotation.FreeChampionRotationController;
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

        backbutton.addActionListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        mainPanel.add(new JPanel());
    }

    public void actionPerformed(ActionEvent e) {
        this.backController.execute();
    }

    public String getViewName() {
        return viewName;
    }

    public void setFreeChampionRotationController(FreeChampionRotationController controller) {
        this.controller = controller;
    }
}
