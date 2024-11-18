import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import New.User;
import org.json.JSONArray;
import org.json.JSONObject;

import static data_access.generateMatch.generateMatch;
import static data_access.generateMatchList.generateMatchList;
import static data_access.generatePuuid.generatePuuid;

public class RiotApp extends JFrame {
    private JTextField usernameField;
    private JTextField taglineField;
    private JComboBox<String> regionBox;
    private JTextArea outputArea;
    private JButton fetchButton;
    private static final String API_KEY = "RGAPI-f4800267-6eb1-45a5-89d8-b130ffff4f87";

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
        String region;
        if (regionBox.getSelectedItem().equals("NA")) {
            region = "americas";
        }
        else if (regionBox.getSelectedItem().equals("EU")) {
            region = "europe";
        }
        else {
            region = "asia";
        }
        String puuid = generatePuuid(username, tagline, region, API_KEY);

        // Create RiotMain instance and generate PUUID
        User user = new User(username, tagline, region, puuid, generateMatchList(puuid, region, API_KEY));
        try {
            final RiotMain riotMain = new RiotMain(user);
            outputArea.append("Generated PUUID: " + puuid + "\n\n");

            // Create MatchInfo instance and fetch recent matches and details
            displayMatchData(riotMain);

        } catch (Exception ex) {
            outputArea.append("Error: " + ex.getMessage());
        }
    }

    /**
     * Display recent matches and the details of the first match in the output area
     * @param matchInfo the MatchInfo instance
     */
    private void displayMatchData(RiotMain riotMain) {
        try {
            String puuid = riotMain.getPuuid();
            String region = riotMain.getRegion();

            // Fetch recent matches
            JSONArray recentMatches = riotMain.getMatchList();
            outputArea.append("Recent Matches: \n");
            for (int i = 0; i < recentMatches.length(); i++) {
                outputArea.append(recentMatches.getString(i) + "\n");
            }

            // Display details of the first match if available
            if (recentMatches.length() > 0) {
                String matchId = recentMatches.getString(0);
                JSONObject matchDetails = generateMatch(matchId, region, API_KEY);
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
