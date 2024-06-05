package zus.view;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import zus.model.Person;

import java.time.LocalDate;
import java.util.List;

public class ResidentTable extends TableView<Person> {
    public ResidentTable(List<Person> values) {
        super(FXCollections.observableArrayList(values));

        TableColumn<Person, Integer> tcPersonId = new TableColumn<>("ID");
        TableColumn<Person, String> tcFirstName = new TableColumn<>("Ime");
        TableColumn<Person, String> tcLastName = new TableColumn<>("Prezime");
        TableColumn<Person, LocalDate> tcDOB = new TableColumn<>("Datum rodjenja");
        TableColumn<Person, Integer> tcHousingUnitId = new TableColumn<>("ID prebivalista");

        tcPersonId.setCellValueFactory(new PropertyValueFactory<>("personId"));
        tcFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tcLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tcDOB.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        tcHousingUnitId.setCellValueFactory(new PropertyValueFactory<>("housingID"));

        super.getColumns().add(tcPersonId);
        super.getColumns().add(tcFirstName);
        super.getColumns().add(tcLastName);
        super.getColumns().add(tcDOB);
        super.getColumns().add(tcHousingUnitId);
    }
}
