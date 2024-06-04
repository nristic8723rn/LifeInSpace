package zus.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import zus.model.HousingUnit;
import zus.model.Person;
import zus.model.base.Server;
import zus.model.utility.JDBCUtils;
import zus.view.AddPeopleView;

import java.time.LocalDate;
import java.util.List;

public class AddControl implements EventHandler<ActionEvent> {

    private AddPeopleView addPeopleView;

    public AddControl(AddPeopleView addPeopleView) {
        this.addPeopleView = addPeopleView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        HousingUnit housingUnit = addPeopleView.getHousingUnit();
        int orbID = housingUnit.getOrbId();
        String firstName = addPeopleView.getTfFirstName().getText();
        String lastName = addPeopleView.getTfLastName().getText();
        LocalDate dateOfBirth = addPeopleView.getDpDateOfBirth().getValue();

        JDBCUtils.insertIntoPerson(orbID, housingUnit.getHousingUnitId(), firstName, lastName, dateOfBirth, null);
        addPeopleView.getTvResidents().refresh();
    }
}
