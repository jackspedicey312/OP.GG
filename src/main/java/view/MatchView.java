package view;

import interface_adapter.match.MatchController;
import interface_adapter.match.MatchPresenter;

import javax.swing.*;
import java.awt.*;

/**
 * View for displaying recent matches.
 */
public class MatchView extends JFrame {

    public MatchView(MatchController matchController, String puuid, String region, MatchPresenter matchPresenter) {
        setTitle("Recent Matches");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);

        // Main panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Recent Matches");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextArea matchDisplayArea = new JTextArea(15, 50);
        matchDisplayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(matchDisplayArea);

        JButton fetchButton = new JButton("Fetch Recent Matches");

        // Add components to the panel
        panel.add(title);
        panel.add(scrollPane);
        panel.add(fetchButton);

        add(panel);

        // Action listener for the fetch button
        fetchButton.addActionListener(e -> {
            matchController.fetchRecentMatches(puuid, region, 5); // Fetch last 5 matches

            // Display matches in the text area using MatchPresenter data
            matchDisplayArea.setText(""); // Clear previous results
            matchPresenter.getMatchDetails().forEach(detail -> {
                matchDisplayArea.append(detail + "\n");
            });
        });

        setVisible(true);
    }
}

