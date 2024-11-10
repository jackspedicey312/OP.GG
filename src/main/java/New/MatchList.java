package New;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

import java.util.ArrayList;

public class MatchList {

    private final ArrayList<Match> matches;

    public MatchList(String puuid, String region, String token) {

        String url = "https://" + region + ".api.riotgames.com/lol/match/v5/matches/by-puuid/" + puuid
                + "/ids?api_key=" + token;
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        final Response response = client.newCall(request).execute();
        final JSONObject responseBody = new JSONObject(response.body().string());
        System.out.println(responseBody);

        }
    }
}

MatchList lol = new Matchlist("lelowel", "NA1", "americas", "RGAPI-f4800267-6eb1-45a5-89d8-b130ffff4f87");