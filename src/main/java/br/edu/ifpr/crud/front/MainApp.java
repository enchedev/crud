package br.edu.ifpr.crud.front;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        Group group = new Group();

        Scene scene = new Scene(group ,600, 300);

        stage.setTitle("Welcome!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
