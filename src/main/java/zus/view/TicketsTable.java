package zus.view;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import zus.model.Ticket;
import zus.model.Voyage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class TicketsTable extends TableView<Ticket> {
    public TicketsTable(List<Ticket> values)
    {
        super(FXCollections.observableArrayList(values));

        TableColumn<Ticket, Integer> tcVoyageId = new TableColumn<>("ID putovanja");
        TableColumn<Ticket, Integer> tcNumberOfPassangers = new TableColumn<>("Broj putnika");

        tcVoyageId.setCellValueFactory(new PropertyValueFactory<>("voyageId"));
        tcNumberOfPassangers.setCellValueFactory(new PropertyValueFactory<>("numberOfPassengers"));

        super.getColumns().add(tcVoyageId);
        super.getColumns().add(tcNumberOfPassangers);
    }
}
