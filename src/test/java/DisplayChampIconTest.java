import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class DisplayChampIconTest {

    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(() -> {
            try {
                createAndShowGUI();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private static void createAndShowGUI() throws IOException {

        // THIS IS A SUPER ROUGH DRAFT IT'S JUST TO SHOW WHAT THE FREE CHAMPION ROTATION SECTION SHOULD LOOK LIKE.

        JFrame frame = new JFrame("Champion Icons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(1000, 800);


        FreeChampionRotation freeChampionRotation = new FreeChampionRotation();
        freeChampionRotation.generateCurrentFreeRotation();
        ArrayList<String> championNames = freeChampionRotation.getFreeChampionsList();
        ArrayList<ImageIcon> championIcons = freeChampionRotation.getFreeChampionsListIcons();

        for (int i = 0; i < championNames.size(); i++) {

            String ChampionName = championNames.get(i);
            frame.add(new JLabel(ChampionName));

            ImageIcon championIcon = championIcons.get(i);
            JLabel label = new JLabel(championIcon);
            frame.add(label);

        }
        frame.setVisible(true);
    }

}

