package use_case.logout;

public class LogoutInteractor implements LogoutInputBoundary {
    private final LogoutOutputBoundary logoutPresenter;

    public LogoutInteractor(LogoutOutputBoundary logoutPresenter) {
        this.logoutPresenter = logoutPresenter;
    }

    @Override
    public void execute() {
        logoutPresenter.logout();
    }
}
