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
    private RiotAPIFreeRotationDataAccess dataAccess;
    private FreeChampionRotationController controller;
    private final FreeChampionRotationViewModel viewModel;

    public FreeChampionRotationView(FreeChampionRotationViewModel viewModel) throws IOException {
        this.viewModel = viewModel;
        this.viewModel.addPropertyChangeListener(this);

        setSize(400,300);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        for (ImageIcon champion : dataAccess.getFreeChampionsListIcons()) {
            final JPanel championPanel = new JPanel();
            championPanel.add(new JLabel(champion));
            mainPanel.add(championPanel);
        }
        add(mainPanel);
    }

    public setFreeChampionRotationController(FreeChampionRotationController controller) {
        this.controller = controller;
    }
}
