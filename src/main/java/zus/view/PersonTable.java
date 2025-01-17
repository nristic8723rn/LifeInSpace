package zus.view;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import zus.model.Person;

import java.time.LocalDate;
import java.util.List;

public class PersonTable extends TableView<Person> {
    public PersonTable(List<Person> values) {
        super(FXCollections.observableArrayList(values));

        TableColumn<Person, Integer> tcPersonId = new TableColumn<>("ID");
        TableColumn<Person, String> tcFirstName = new TableColumn<>("Ime");
        TableColumn<Person, String> tcLastName = new TableColumn<>("Prezime");
        TableColumn<Person, LocalDate> tcDOB = new TableColumn<>("Datum rodjenja");

        tcPersonId.setCellValueFactory(new PropertyValueFactory<>("personId"));
        tcFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tcLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tcDOB.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));

        super.getColumns().add(tcPersonId);
        super.getColumns().add(tcFirstName);
        super.getColumns().add(tcLastName);
        super.getColumns().add(tcDOB);
    }
}
