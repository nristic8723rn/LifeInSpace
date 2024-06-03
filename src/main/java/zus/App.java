package zus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import zus.model.User;
import zus.model.utility.JDBCUtils;
import zus.view.FirstView;
import zus.view.MainView;

public class App extends Application {
    public static Stage window;
    public static User current;
    @Override
    public void start(Stage stage) throws Exception {
        JDBCUtils.connect();
        window = stage;
        window.setScene(new Scene(new FirstView(), 150, 150));
        window.setTitle("Dobrodosli");
        window.show();
    }
}
