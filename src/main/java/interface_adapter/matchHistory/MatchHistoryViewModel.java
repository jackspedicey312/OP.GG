package interface_adapter.matchHistory;

import interface_adapter.ViewModel;

public class MatchHistoryViewModel extends ViewModel<MatchHistoryState> {

    public MatchHistoryViewModel() {
        super("matchHistory");
        setState(new MatchHistoryState());
    }
}
