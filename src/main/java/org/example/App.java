package org.example;

import org.example.controllers.MainController;
import org.example.models.WorkerDb;
import org.example.view.View;

public class App {

    public static void main(String[] args) {
        var workerDb = WorkerDb.getInitializedDb();
        var view = new View();
        var mainController = new MainController(workerDb, view);

        mainController.run();
    }
}
