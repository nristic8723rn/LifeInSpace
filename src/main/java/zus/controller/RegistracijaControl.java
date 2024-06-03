package zus.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import zus.App;
import zus.view.FirstView;
import zus.view.RegistrationView;

public class RegistracijaControl implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        App.window.setScene(new Scene(new RegistrationView(), 300, 250));
        App.window.show();
    }
}
