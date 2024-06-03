package zus.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import zus.App;
import zus.model.User;
import zus.model.utility.JDBCUtils;
import zus.view.MainView;
import zus.view.RegistrationView;

import java.sql.SQLException;

public class RegistrationControl implements EventHandler<ActionEvent> {
    private RegistrationView registrationView;

    public RegistrationControl(RegistrationView registrationView)
    {
        this.registrationView = registrationView;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            User user = JDBCUtils.checkUsers(registrationView.getTfUserName().getText());
            if(user == null)
            {
                try {
                    JDBCUtils.insertIntoUsers(registrationView.getTfUserName().getText(), registrationView.getTfPassword().getText()
                            , registrationView.getTfIme().getText(), registrationView.getTfPrezime().getText());

                    App.window.setScene(new Scene(new MainView(), 500, 500));
                    App.window.setTitle(user.getName() + " " + user.getFamilyName());
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            else
            {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Neuspesna registracija");
                errorAlert.setContentText("Korisnicko ime je zauzeto!");
                errorAlert.show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
