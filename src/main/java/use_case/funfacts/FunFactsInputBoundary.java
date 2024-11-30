package use_case.funfacts;

public interface FunFactsInputBoundary {
    void fetchFunFacts(String puuid, String region) throws Exception;

    void execute();
}
