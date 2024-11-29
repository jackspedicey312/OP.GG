package use_case.funfacts;

import entity.FunFacts;

public interface FunFactsInputBoundary {
    void fetchFunFacts(String puuid, String region) throws Exception;

    void execute();
}
