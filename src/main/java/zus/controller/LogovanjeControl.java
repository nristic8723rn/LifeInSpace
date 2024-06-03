package zus.controller;

import com.mysql.cj.log.Log;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import zus.App;
import zus.view.FirstView;
import zus.view.LoginView;

public class LogovanjeControl implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        App.window.setScene(new Scene(new LoginView(), 300, 150));
        App.window.show();
    }
}
