package zus.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import zus.controller.RegistrationControl;

public class RegistrationView extends BorderPane {

    private TextField tfUserName;
    private TextField tfPassword;
    private TextField tfIme;
    private TextField tfPrezime;
    private Button btnRegister;

    public RegistrationView()
    {
        initElements();
        addElements();
        addActions();
    }

    private void initElements() {
        tfUserName = new TextField();
        tfPassword = new TextField();
        tfIme = new TextField();
        tfPrezime = new TextField();
        btnRegister = new Button("Registrujte se");
    }

    private void addElements() {
        GridPane gp = new GridPane();
        gp.add(new Label("Korisnicko ime"), 0, 0);
        gp.add(new Label("Lozinka"), 0, 1);
        gp.add(new Label("Ime"), 0 , 2);
        gp.add(new Label("Prezime"), 0, 3);
        gp.add(tfUserName, 1, 0);
        gp.add(tfPassword, 1, 1);
        gp.add(tfIme, 1, 2);
        gp.add(tfPrezime, 1, 3);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setAlignment(Pos.CENTER);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(gp, btnRegister);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        setCenter(vBox);
    }

    private void addActions() {
        btnRegister.setOnAction(new RegistrationControl(this));
    }

    public TextField getTfUserName() {
        return tfUserName;
    }

    public TextField getTfPassword() {
        return tfPassword;
    }

    public TextField getTfIme() {
        return tfIme;
    }

    public TextField getTfPrezime() {
        return tfPrezime;
    }
}
