package zus.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import zus.App;
import zus.view.MainView;

public class PurchaseBackControl implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        App.window.setScene(new Scene(new MainView(), 200, 250));
    }
}
