package com.company;

public class Application {
    int[][] a = new int[3][3];

    public void run() {
        View view = new View();
        Controller controller = new Controller();
        view.setController(controller);
        controller.setView(view);
        view.create();
    }
}
