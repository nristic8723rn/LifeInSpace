package zus.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import zus.App;
import zus.model.utility.JDBCUtils;
import zus.view.AddPeopleView;
import zus.view.OrbsView;

import java.sql.SQLException;

public class DoneControl implements EventHandler<ActionEvent> {
    private AddPeopleView addPeopleView;

    public DoneControl(AddPeopleView addPeopleView) {
        this.addPeopleView = addPeopleView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            JDBCUtils.insertUserIntoHousingUnit(App.current.getUsername(),addPeopleView.getHousingUnit().getHousingUnitId());
            App.window.setScene(new Scene(new OrbsView(), 350, 300));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
