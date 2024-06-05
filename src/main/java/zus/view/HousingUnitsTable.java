package zus.view;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import zus.model.HousingUnit;
import zus.model.Person;

import java.time.LocalDate;
import java.util.List;

public class HousingUnitsTable extends TableView<HousingUnit> {
    public HousingUnitsTable(List<HousingUnit> values)
    {
        super(FXCollections.observableArrayList(values));

        TableColumn<HousingUnit, Integer> tcHousingUnitId = new TableColumn<>("ID objekta");
        TableColumn<HousingUnit, Integer> tcOrbId = new TableColumn<>("ID planete");
        TableColumn<HousingUnit, String> tcName = new TableColumn<>("Ime objekta");

        tcHousingUnitId.setCellValueFactory(new PropertyValueFactory<>("housingUnitId"));
        tcOrbId.setCellValueFactory(new PropertyValueFactory<>("orbId"));
        tcName.setCellValueFactory(new PropertyValueFactory<>("name"));

        super.getColumns().add(tcHousingUnitId);
        super.getColumns().add(tcOrbId);
        super.getColumns().add(tcName);
    }
}
