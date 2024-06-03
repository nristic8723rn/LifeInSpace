package zus.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import zus.controller.BackControl;
import zus.controller.LoginControl;

public class LoginView extends BorderPane {
    private TextField tfUsername;
    private TextField tfPassword;
    private Button btnLogin;
    private Button btnBack;

    public LoginView()
    {
        initElements();
        addElements();
        addActions();
    }

    private void initElements() {
        tfUsername = new TextField();
        tfPassword = new TextField();
        btnLogin = new Button("Ulogujte se");
        btnBack = new Button("Nazad");
    }

    private void addElements() {

        setPadding(new Insets(20));

        GridPane gp = new GridPane();
        gp.add(new Label("Korisnicko ime"), 0, 0);
        gp.add(new Label("Lozinka"), 0, 1);
        gp.add(tfUsername, 1, 0);
        gp.add(tfPassword, 1, 1);
        gp.setHgap(10);
        gp.setVgap(10);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(btnBack, btnLogin);
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(gp, hBox);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        setCenter(vBox);
    }

    private void addActions() {
        btnLogin.setOnAction(new LoginControl(this));
        btnBack.setOnAction(new BackControl());
    }

    public TextField getTfUsername() {
        return tfUsername;
    }

    public TextField getTfPassword() {
        return tfPassword;
    }
}
