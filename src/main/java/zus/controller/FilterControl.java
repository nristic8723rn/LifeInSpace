package zus.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import zus.model.Person;
import zus.model.utility.JDBCUtils;

import java.util.List;

public class FilterControl implements EventHandler<ActionEvent> {

    private final TextField firstNameTextField;
    private final TextField lastNameTextField;
    private final TextField yearTextField;

    private final TableView<Person> personTableView;

    public FilterControl(TextField firstNameTextField, TextField lastNameTextField, TextField yearTextField, TableView<Person> personTableView) {
        this.firstNameTextField = firstNameTextField;
        this.lastNameTextField = lastNameTextField;
        this.yearTextField = yearTextField;
        this.personTableView = personTableView;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

    }
}
