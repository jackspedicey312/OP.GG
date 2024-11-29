package view;

import interface_adapter.funfacts.FunFactPresenter;

import javax.swing.*;
import java.awt.*;

public class FunFactView extends JFrame {
    public FunFactView(FunFactPresenter presenter) {
        setTitle("Fun Facts");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Fun Facts");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(title);
    }
}
