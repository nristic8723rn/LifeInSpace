package zus.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import zus.App;
import zus.view.FirstView;

public class BackControl implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        App.current = null;
        App.window.setScene(new Scene(new FirstView(), 150, 150));
        App.window.setTitle("Dobrodosli");
    }
}
