package use_case.overview;

import javax.swing.*;

public interface OverviewOutputBoundary {

    void presentProfileIcon(ImageIcon image);

    void presentProfileLevel(int level);

    void presentGamemode(String gameMode);

    void presentRank(String rank);

    void presentRankIcon(ImageIcon icon);

    void presentDivision(String division);

    void presentLeaguePoints(int leaguePoints);

    void presentWins(int wins);

    void presentLosses(int losses);

    void presentWinRate(int winrate);

    void presentError(String message);
}
