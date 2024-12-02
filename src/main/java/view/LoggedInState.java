package view;

import entity.user.User;

public class LoggedInState {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
