package zus.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import zus.App;
import zus.model.User;
import zus.model.utility.JDBCUtils;
import zus.view.LoginView;
import zus.view.MainView;

import java.sql.SQLException;

public class LoginControl implements EventHandler<ActionEvent> {

    private LoginView loginView;

    public LoginControl(LoginView loginView)
    {
        this.loginView = loginView;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            User user = JDBCUtils.checkUsers(loginView.getTfUsername().getText());
            if(user == null)
            {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Neuspesno logovanje");
                errorAlert.setContentText("Korisnicko ime ne postoji");
                errorAlert.show();
            }
            else
            {
                user = JDBCUtils.checkPassword(loginView.getTfUsername().getText(), loginView.getTfPassword().getText());
                if(user == null)
                {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setHeaderText("Neuspesno logovanje");
                    errorAlert.setContentText("Neispravno korisnicko ime ili lozinka");
                    errorAlert.show();
                }
                else
                {
                    App.window.setScene(new Scene(new MainView(), 200, 250));
                    App.window.setTitle(user.getName() + " " + user.getFamilyName());
                    App.current = user;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
