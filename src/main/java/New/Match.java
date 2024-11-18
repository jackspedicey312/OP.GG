package New;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Match {

    private final JSONObject match;

    public Match(JSONObject match) {
        this.match = match;
    }

}

