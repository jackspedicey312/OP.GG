package use_case.matchHistory;

public class MatchHistoryInteractor implements MatchHistoryInputBoundary {
    
    private final MatchHistoryOutputBoundary matchHistoryPresenter;
    
    public MatchHistoryInteractor(MatchHistoryOutputBoundary matchHistoryPresenter) {
        this.matchHistoryPresenter = matchHistoryPresenter;
    }
    
    @Override
    public void execute() {
        matchHistoryPresenter.prepareView();
    }
}
