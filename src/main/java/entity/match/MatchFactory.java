package entity.match;

import javax.swing.ImageIcon;

public class MatchFactory {

    public Match createMatch(ImageIcon championIcon, int kills, int deaths, int assissts, boolean winOrLoss, int duration, String gameMode, long unixTime) {
        return new Match(championIcon, kills, deaths, assissts, winOrLoss, duration, gameMode, unixTime);
    }
}
