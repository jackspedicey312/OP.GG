package entity.match;

import javax.swing.ImageIcon;

public class MatchFactory {

    public Match createMatch(ImageIcon championIcon, int kills, int deaths, int assissts, int duration, String gameMode, long unixTime) {
        return new Match(championIcon, kills, deaths, assissts, duration, gameMode, unixTime);
    }
}
