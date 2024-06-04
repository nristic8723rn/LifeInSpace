package zus.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import zus.controller.AddControl;
import zus.controller.DoneControl;
import zus.model.HousingUnit;
import zus.model.Person;
import zus.model.utility.JDBCUtils;

public class AddPeopleView extends BorderPane {
    private TableView<Person> tvResidents;
    private TextField tfFirstName;
    private TextField tfLastName;
    private DatePicker dpDateOfBirth;
    private Button btnAdd;
    private Button btnDone;
    private HousingUnit housingUnit;

    public AddPeopleView(HousingUnit housingUnit)
    {
        this.housingUnit = housingUnit;
        initElements();
        addElements();
        addAction();
    }

    private void initElements(){
        tvResidents = new PersonTable(JDBCUtils.selectFromPersonsUsingHousingUnits(housingUnit.getHousingUnitId()));
        tfFirstName = new TextField();
        tfLastName = new TextField();
        dpDateOfBirth = new DatePicker();
        btnAdd = new Button("Dodajte");
        btnDone = new Button("Gotovo");
    }

    private void addElements() {
        setPadding(new Insets(10));

        HBox hb1 = new HBox();
        hb1.getChildren().addAll(btnAdd, btnDone);
        hb1.setSpacing(10);
        hb1.setAlignment(Pos.CENTER);

        VBox vb1 = new VBox();
        vb1.getChildren().addAll(new Label("Lista stanara koji ce ziveti u ovom objektu"), tvResidents);
        vb1.setSpacing(10);
        vb1.setAlignment(Pos.CENTER);

        VBox vb2 = new VBox();
        vb2.getChildren().addAll(new Label("Ime"),tfFirstName, new Label("Prezime"),tfLastName, new Label("Datum rodjenja"),dpDateOfBirth, hb1);
        vb2.setSpacing(10);
        vb2.setAlignment(Pos.CENTER);

        HBox hb2 = new HBox();
        hb2.getChildren().addAll(vb1, vb2);
        hb2.setSpacing(10);
        hb2.setAlignment(Pos.CENTER);

        setCenter(hb2);
    }

    private void addAction() {
        btnAdd.setOnAction(new AddControl(this));
        btnDone.setOnAction(new DoneControl(this));
    }

    public TableView<Person> getTvResidents() {
        return tvResidents;
    }

    public TextField getTfFirstName() {
        return tfFirstName;
    }

    public TextField getTfLastName() {
        return tfLastName;
    }

    public DatePicker getDpDateOfBirth() {
        return dpDateOfBirth;
    }

    public HousingUnit getHousingUnit() {
        return housingUnit;
    }

}
