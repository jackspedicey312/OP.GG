package interface_adapter.matchHistory;

import interface_adapter.ViewManagerModel;
import use_case.matchHistory.MatchHistoryOutputBoundary;

public class MatchHistoryPresenter implements MatchHistoryOutputBoundary {

    private final MatchHistoryViewModel matchHistoryViewModel;
    private final ViewManagerModel viewManagerModel;

    public MatchHistoryPresenter(MatchHistoryViewModel matchHistoryViewModel,
                                 ViewManagerModel viewManagerModel) {
        this.matchHistoryViewModel = matchHistoryViewModel;
        this.viewManagerModel = viewManagerModel;
    }


}
