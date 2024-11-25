package use_case.overview;

import javax.swing.*;

public interface OverviewOutputBoundary {

    void presentProfileIcon(ImageIcon image);

    void presentProfileLevel(int level);

    void presentError(String message);

}
