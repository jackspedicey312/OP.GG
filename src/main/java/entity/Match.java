package entity;

public class Match {
    private String matchId;
    private String timestamp;
    private String result;
    private String participants;

    public Match(String matchId, String timestamp, String result, String participants) {
        this.matchId = matchId;
        this.timestamp = timestamp;
        this.result = result;
        this.participants = participants;
    }

    // Getters and Setters
    public String getMatchId() {
        return matchId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getResult() {
        return result;
    }

    public String getParticipants() {
        return participants;
    }
}
