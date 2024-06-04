package zus.view;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import zus.model.Orb;

import java.util.List;

public class OrbsTable extends TableView<Orb> {
    public OrbsTable(List<Orb> values)
    {
        super(FXCollections.observableArrayList(values));

        TableColumn<Orb, Integer> tcOrbId = new TableColumn<>("ID");
        TableColumn<Orb, String> tcOrbName = new TableColumn<>("Ime");
        TableColumn<Orb, String> tcOrbType = new TableColumn<>("Tip");

        tcOrbId.setCellValueFactory(new PropertyValueFactory<>("orbId"));
        tcOrbName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tcOrbType.setCellValueFactory(new PropertyValueFactory<>("type"));

        super.getColumns().add(tcOrbId);
        super.getColumns().add(tcOrbName);
        super.getColumns().add(tcOrbType);
    }
}
