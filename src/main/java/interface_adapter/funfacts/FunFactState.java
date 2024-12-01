package interface_adapter.funfacts;

import entity.FunFacts.FunFacts;

public class FunFactState {
    private FunFacts funFacts;

    public void setFunFacts(FunFacts funFacts) {
        this.funFacts = funFacts;
    }

    public FunFacts getFunFacts() {
        return funFacts;
    }

    public int getTotalPlaytime() {
        return funFacts.getTotalPlaytime();
    }

    public int getLongestGamePlayed() {
        return funFacts.getLongestGamePlayed();
    }

    public String getOldestGamePlayed() {
        return funFacts.getOldestGamePlayed();
    }

    public String getLongestGamePlayedDate() {
        return funFacts.getLongestGamePlayedDate();
    }

    public int getTotalSurvivedSingleDigitHp() {
        return funFacts.getTotalSurvivedSingleDigitHp();
    }

    public int getTotalSurrenders() {
        return funFacts.getTotalSurrenders();
    }

    public int getTotalPentakills() {
        return funFacts.getTotalPentakills();
    }

    public int getTotalKills() {
        return funFacts.getTotalKills();
    }

    public int getTotalDeaths() {
        return funFacts.getTotalDeaths();
    }

    public int getTotalLosses() {
        return funFacts.getTotalLosses();
    }

    public int getTotalWins() {
        return funFacts.getTotalWins();
    }

    public int getTotalSnowballsHit() {
        return funFacts.getTotalSnowballsHit();
    }

    public int getTotalSavedAllies() {
        return funFacts.getTotalSavedAllies();
    }

}
