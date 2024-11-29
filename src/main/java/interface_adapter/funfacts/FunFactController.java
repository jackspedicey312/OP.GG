package interface_adapter.funfacts;

import use_case.funfacts.FunFactsInputBoundary;

public class FunFactController {
    private final FunFactsInputBoundary funFactsInputBoundary;

    public FunFactController(FunFactsInputBoundary funFactsInputBoundary) {
        this.funFactsInputBoundary = funFactsInputBoundary;
    }

    public void fetchFunFacts(String puuid, String region) throws Exception {
        funFactsInputBoundary.fetchFunFacts(puuid, region);
    }
}
