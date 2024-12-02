package interface_adapter.back;

import use_case.back.BackInputBoundary;

public class BackController {
    private final BackInputBoundary backInputBoundary;

    public BackController(BackInputBoundary backInputBoundary) {
        this.backInputBoundary = backInputBoundary;
    }

    public void execute() {
        backInputBoundary.exeute();
    }
}
