package view;

import interface_adapter.match.MatchPresenter;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import org.json.JSONObject;

/**
 * The view for displaying match data.
 */
public class MatchView extends JFrame {

    public MatchView(MatchPresenter matchPresenter, String puuid, String region) {
        setTitle("Match History");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Recent Matches");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(title);

        // Fetch match details from the presenter
        List<JSONObject> matchDetails = matchPresenter.getMatchDetails();
        if (matchDetails != null && !matchDetails.isEmpty()) {
            for (JSONObject match : matchDetails) {
                JLabel matchLabel = new JLabel(match.toString(4)); // Pretty-print JSON
                matchLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                panel.add(matchLabel);
            }
        } else {
            JLabel noMatchesLabel = new JLabel("No match data available.");
            noMatchesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(noMatchesLabel);
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        add(scrollPane);
        final PanelView panelview = new PanelView(puuid, region);
        add(panelview.getPanel(), BorderLayout.CENTER);

        setVisible(true);
    }
}
