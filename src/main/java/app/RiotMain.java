package app;

import javax.swing.*;

/**
 * Entry point for the Riot application.
 */
public class RiotMain {

    public static void main(String[] args) {
        final RiotApp app = new RiotApp();
        final JFrame application = app.addLoginView().addLoginUseCase().build();
    }
}
