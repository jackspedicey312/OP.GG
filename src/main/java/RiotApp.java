import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.json.JSONArray;
import org.json.JSONObject;
import panel.PanelView;

public class RiotApp extends JFrame {
    private JTextField usernameField;
    private JTextField taglineField;
    private JComboBox<String> regionBox;
    private JTextArea outputArea;
    private JButton fetchButton;

    public RiotApp() {
        setTitle("Riot API Data Fetcher");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        usernameField = new JTextField(15);
        taglineField = new JTextField(15);
        regionBox = new JComboBox<>(new String[]{"NA", "EU", "ASIA"});
        outputArea = new JTextArea(15, 30);
        outputArea.setEditable(false);
        fetchButton = new JButton("Fetch Data");

        // Set up layout and add components
        JPanel inputPanel = new JPanel(new GridLayout(5, 1));
        inputPanel.add(new JLabel("Username:"));
        inputPanel.add(usernameField);
        inputPanel.add(new JLabel("Tagline:"));
        inputPanel.add(taglineField);
        inputPanel.add(new JLabel("Region:"));
        inputPanel.add(regionBox);
        inputPanel.add(fetchButton);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(inputPanel, BorderLayout.NORTH);
        container.add(new JScrollPane(outputArea), BorderLayout.CENTER);
        PanelView panelView = new PanelView();
        container.add(panelView.getPanel(), BorderLayout.CENTER);

        // Add action listener to fetch button
        fetchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fetchData();
            }
        });
    }

    /**
     * Fetch data from RiotMain and MatchInfo based on user input
     */
    private void fetchData() {
        outputArea.setText("");

        // Get user inputs
        String username = usernameField.getText().trim();
        String tagline = taglineField.getText().trim();
        String region = (String) regionBox.getSelectedItem();

        // Create RiotMain instance and generate PUUID
        try {
            RiotMain riotMain = new RiotMain(username, tagline, region);
            riotMain.generatePUUID();
            String puuid = riotMain.getPuuid();
            outputArea.append("Generated PUUID: " + puuid + "\n\n");

            // Create MatchInfo instance and fetch recent matches and details
            MatchInfo matchInfo = new MatchInfo(riotMain);
            displayMatchData(matchInfo);

        } catch (Exception ex) {
            outputArea.append("Error: " + ex.getMessage());
        }
    }

    /**
     * Display recent matches and the details of the first match in the output area
     * @param matchInfo the MatchInfo instance
     */
    private void displayMatchData(MatchInfo matchInfo) {
        try {
            String puuid = matchInfo.riotMain.getPuuid();
            String region = matchInfo.riotMain.getRegion();

            // Fetch recent matches
            JSONArray recentMatches = matchInfo.getRecentMatches(puuid, region);
            outputArea.append("Recent Matches: \n");
            for (int i = 0; i < recentMatches.length(); i++) {
                outputArea.append(recentMatches.getString(i) + "\n");
            }

            // Display details of the first match if available
            if (recentMatches.length() > 0) {
                String matchId = recentMatches.getString(0);
                JSONObject matchDetails = matchInfo.getMatchDetails(matchId, region);
                outputArea.append("\nMatch Details for match ID " + matchId + ":\n" + matchDetails.toString(2));
            }

        }
        catch (Exception ex) {
            outputArea.append("Error fetching match data: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RiotApp app = new RiotApp();
            app.setVisible(true);
        });
    }
}
