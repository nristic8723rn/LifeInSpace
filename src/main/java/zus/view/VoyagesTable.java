package zus.view;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import zus.model.HousingUnit;
import zus.model.Person;
import zus.model.Voyage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class VoyagesTable extends TableView<Voyage> {
    public VoyagesTable(List<Voyage> values)
    {
        super(FXCollections.observableArrayList(values));

        TableColumn<Voyage, Integer> tcVoyageId = new TableColumn<>("ID");
        TableColumn<Voyage, Integer> tcOrbId = new TableColumn<>("ID nebeskog tela");
        TableColumn<Voyage, LocalDate> tcDOD = new TableColumn<>("Datum polaska");
        TableColumn<Voyage, LocalTime> tcTOD = new TableColumn<>("Vreme polaska");
        TableColumn<Voyage, String> tcName = new TableColumn<>("Ime prevoza");
        TableColumn<Voyage, Integer> tcCapacity = new TableColumn<>("Kapacitet");

        tcVoyageId.setCellValueFactory(new PropertyValueFactory<>("voyageId"));
        tcOrbId.setCellValueFactory(new PropertyValueFactory<>("orbId"));
        tcDOD.setCellValueFactory(new PropertyValueFactory<>("dateOfDeparture"));
        tcTOD.setCellValueFactory(new PropertyValueFactory<>("timeOfDeparture"));
        tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tcCapacity.setCellValueFactory(new PropertyValueFactory<>("capacity"));

        super.getColumns().add(tcVoyageId);
        super.getColumns().add(tcOrbId);
        super.getColumns().add(tcDOD);
        super.getColumns().add(tcTOD);
        super.getColumns().add(tcName);
        super.getColumns().add(tcCapacity);
    }
}
