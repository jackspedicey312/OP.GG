package view;

import interface_adapter.ViewModel;

public class LoggedInViewModel extends ViewModel<LoggedInState> {

    public LoggedInViewModel() {
        super("loggedIn");
        setState(new LoggedInState());
    }
}
