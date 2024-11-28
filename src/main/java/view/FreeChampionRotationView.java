package view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import data_access.RiotAPIFreeRotationDataAccess;
import interface_adapter.freeChampionRotation.FreeChampionRotationController;
import interface_adapter.freeChampionRotation.FreeChampionRotationViewModel;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.io.IOException;

public class FreeChampionRotationView extends JPanel implements PropertyChangeListener {
    private final JPanel mainPanel = new JPanel();
    private FreeChampionRotationController controller;
    private final FreeChampionRotationViewModel viewModel;

    public FreeChampionRotationView(FreeChampionRotationViewModel viewModel) throws IOException {
        this.viewModel = viewModel;
        this.viewModel.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("loggedIn")) {
            for ( )
        }
    }

    public setFreeChampionRotationController(FreeChampionRotationController controller) {
        this.controller = controller;
    }
}
