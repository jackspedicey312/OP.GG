package app;

import javax.swing.*;
import java.io.IOException;

/**
 * Entry point for the Riot application.
 */
public class RiotMain {

    public static void main(String[] args) throws IOException {
        final RiotApp app = new RiotApp();
        final JFrame application = app
                .addLoginView()
                .addFreeChampionRotationView()
                .addLoginUseCase()
                .addFreeChampionRotationUseCase()
                .build();
        application.pack();
        application.setVisible(true);
    }
}
