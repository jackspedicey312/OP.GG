package interface_adapter.logout;

import interface_adapter.ViewManagerModel;

/**
 * The presenter for the Logout Use Case.
 * Handles the transition back to the login view after logout.
 */
public class LogoutPresenter {
    private final ViewManagerModel viewManagerModel;

    public LogoutPresenter(ViewManagerModel viewManagerModel) {
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the view for logout by transitioning to the login state.
     */
    public void prepareLogoutView() {
        // Set the state of the ViewManagerModel to "login"
        viewManagerModel.setState("login");

        // Notify listeners about the state change
        viewManagerModel.firePropertyChanged();
    }
}

