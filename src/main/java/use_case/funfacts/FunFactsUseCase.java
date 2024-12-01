package use_case.funfacts;

import data_access.RiotAPIFunFactsDataAccess;
import entity.FunFacts.FunFacts;

public class FunFactsUseCase implements FunFactsInputBoundary {
    private final RiotAPIFunFactsDataAccess dataAccess;
    private final FunFactsOutputBoundary presenter;

    public FunFactsUseCase(RiotAPIFunFactsDataAccess dataAccess, FunFactsOutputBoundary presenter) {
        this.dataAccess = dataAccess;
        this.presenter = presenter;
    }

    public void fetchFunFacts(String puuid, String region) throws Exception {
        final FunFacts funFacts = dataAccess.fetchFunFacts(puuid, region);
        presenter.presentTotalWins(funFacts.getTotalWins());
        presenter.presentTotalLosses(funFacts.getTotalLosses());
        presenter.presentTotalKills(funFacts.getTotalKills());
        presenter.presentTotalDeaths(funFacts.getTotalDeaths());
        presenter.presentTotalPlaytime(funFacts.getTotalPlaytime());
        presenter.presentLongestGamePlayed(funFacts.getLongestGamePlayed());

        presenter.presentLongestGamePlayedDate(funFacts.getLongestGamePlayedDate());
        presenter.presentTotalSurrenders(funFacts.getTotalSurrenders());
        presenter.presentTotalPentakills(funFacts.getTotalPentakills());
        presenter.presentTotalSavedAllies(funFacts.getTotalSavedAllies());
        presenter.presentTotalSnowballs(funFacts.getTotalSnowballsHit());
        presenter.presentTotalSurvivedSingleDigitHp(funFacts.getTotalSurvivedSingleDigitHp());
        presenter.presentOldestGamePlayed(funFacts.getOldestGamePlayed());
    }

    @Override
    public void execute() {

    }
}

