package org.example;

import org.example.controllers.MainController;
import org.example.model.DbTables;
import org.example.view.View;

public class App {

    public static void main(String[] args) {
        var tables = DbTables.getExampleTables();
        var view = new View();
        var mainController = new MainController(tables, view);

        mainController.run();
    }
}
