package view;

import interface_adapter.match.MatchController;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * The view for displaying match data.
 */
public class MatchView extends JFrame {

    public MatchView(MatchController matchController, String puuid, String region) {
        setTitle("Match History");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Panel for match data
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Recent Matches");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(title);

        // Fetch recent matches
        try {
            // Retrieve match IDs from the controller
            matchController.fetchRecentMatches(puuid, region, 5);

            // Display matches (Assume MatchPresenter prints match data to the console or logs)
            JLabel matchLabel = new JLabel("Match data displayed in console/logs.");
            matchLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(matchLabel);

        } catch (Exception e) {
            JLabel errorLabel = new JLabel("Error fetching matches: " + e.getMessage());
            errorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(errorLabel);
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        add(scrollPane);

        setVisible(true);
    }
}
