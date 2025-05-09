package org.jala.university.presentation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.jala.university.commons.presentation.ViewSwitcher;
public class MainView extends Application {

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new Pane());
        ViewSwitcher.setup(primaryStage, scene);
        ViewSwitcher.switchTo(TransactionView.MAIN.getView());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Transaction Module Application");
        primaryStage.show();
    }
}
