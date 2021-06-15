package projekt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Aplikacja extends Application {

    private Stage primaryStage;


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Real Estate Listings");
        okno();
    }
    public void okno() {
        try {
            FXMLLoader root= new FXMLLoader();
                    root.setLocation(Aplikacja.class.getResource("/main.fxml"));
            primaryStage.initStyle(StageStyle.DECORATED);
            primaryStage.getIcons().add(new Image("file:ikona.png"));
            Pane mainLayout = root.load();
            Scene scene = new Scene(mainLayout);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Hurtownia sprzetu AGD i RTV");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }


    public static void main(String[] args) {

        launch(args);
    }
}
