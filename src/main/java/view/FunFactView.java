package view;

import interface_adapter.funfacts.FunFactPresenter;

import javax.swing.*;
import java.awt.*;

public class FunFactView extends JFrame {

    public FunFactView(FunFactPresenter presenter) {
        setTitle("Fun Facts");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500, 1250);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Fun Facts");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(title);

        final int playtime = presenter.getTotalPlaytime();
        final JLabel playtimeLabel = new JLabel(String.valueOf(playtime));
        playtimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(playtimeLabel);

        final int wins = presenter.getTotalWins();
        final JLabel winLabel = new JLabel(String.valueOf(wins));
        winLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(winLabel);

        final int losses = presenter.getTotalLosses();
        final JLabel lossLabel = new JLabel(String.valueOf(losses));
        lossLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lossLabel);

        final int totalKills = presenter.getTotalKills();
        final JLabel killLabel = new JLabel(String.valueOf(totalKills));
        killLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(killLabel);

        final int totalDeaths = presenter.getTotalDeaths();
        final JLabel deathLabel = new JLabel(String.valueOf(totalDeaths));
        deathLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(deathLabel);

        final String oldestGamePlayed = presenter.getOldestGamePlayed();
        final JLabel oldestGamePlayedLabel = new JLabel(oldestGamePlayed);
        oldestGamePlayedLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(oldestGamePlayedLabel);

        final int longestGamePlayed = presenter.getLongestGamePlayed();
        final JLabel longestGamePlayedLabel = new JLabel(String.valueOf(longestGamePlayed));
        longestGamePlayedLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(longestGamePlayedLabel);

        final String longestGamePlayedDate = presenter.getLongestGamePlayedDate();
        final JLabel longestGamePlayedDateLabel = new JLabel(longestGamePlayedDate);
        longestGamePlayedDateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(longestGamePlayedDateLabel);

        final int totalSurrenders = presenter.getTotalSurrenders();
        final JLabel surrenderLabel = new JLabel(String.valueOf(totalSurrenders));
        surrenderLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(surrenderLabel);

        final int totalPentakills = presenter.getTotalPentakills();
        final JLabel pentakillLabel = new JLabel(String.valueOf(totalPentakills));
        pentakillLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(pentakillLabel);

        final int totalSurvivedSingleDigitHp = presenter.getTotalSurvivedSingleDigitHp();
        final JLabel singleHpLabel = new JLabel(String.valueOf(totalSurvivedSingleDigitHp));
        singleHpLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(singleHpLabel);

        final int totalSnowballs = presenter.getTotalSnowballsHit();
        final JLabel snowballLabel = new JLabel(String.valueOf(totalSnowballs));
        snowballLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(snowballLabel);

        final int totalSavedAllies = presenter.getTotalSavedAllies();
        final JLabel savedAlliesLabel = new JLabel(String.valueOf(totalSavedAllies));
        savedAlliesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(savedAlliesLabel);



    }
}
