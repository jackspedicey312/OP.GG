package use_case.funfacts;

public interface FunFactsOutputBoundary {
    void presentTotalPlaytime(int totalPlaytime);

    void presentTotalWins(int wins);

    void presentTotalLosses(int loss);

    void presentTotalKills(int kills);

    void presentTotalDeaths(int deaths);

    void presentLongestGamePlayed(int longestGamePlayed);

    void presentLongestGamePlayedDate(String longestGamePlayedDated);

    void presentOldestGamePlayed(String oldestGamePlayed);

    void presentTotalSurvivedSingleDigitHp(int survivedSingleDigitHp);

    void presentTotalSurrenders(int totalSurrenders);

    void presentTotalPentakills(int totalPentakills);

    void presentTotalSnowballs(int totalSnowballs);

    void presentTotalSavedAllies(int savedAllies);
}

