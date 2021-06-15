package projekt;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


public class KontrolerLogowania implements Initializable {


    public Button loginButton;
    @FXML
    private Button wyjscieButton;
    @FXML
    private Label loginMessegeLabel;
    @FXML
    private TextField loginTextField;
    @FXML
    private PasswordField hasloTextField;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    public void loginButtonOnAction()
    {

        if(!loginTextField.getText().isBlank() && !hasloTextField.getText().isBlank())
        {
            validateLogin();
        }
        else
        {
            loginMessegeLabel.setText("Wpisz login i haslo");
        }
        Stage stage = (Stage) wyjscieButton.getScene().getWindow();
        stage.close();
    }
            public void wyjscieButtionOnAction()
            {
                Stage stage= (Stage) wyjscieButton.getScene().getWindow();
                stage.close();
            }
            public void validateLogin()
            {
                Polaczenie connectNow = new Polaczenie();
                Connection connectDB = connectNow.getConnection();

                String verifyLogin = "SELECT count(1) FROM konta WHERE Login = '" +loginTextField.getText() +"'AND Haslo = '" + hasloTextField.getText() + "'" ;

                try{
                    Statement statement = connectDB.createStatement();
                    ResultSet queryResult = statement.executeQuery(verifyLogin);

                    while(queryResult.next())
                    {
                        if(queryResult.getInt(1) == 1)
                        {
                            loginMessegeLabel.setText("Udalo sie zalogowac!");
                            kontrolerMenu();
                        } else
                        {
                            loginMessegeLabel.setText("Nieprawidlowe logowanie! Prosze sprobowac ponownie");
                        }
                    }




                }catch(Exception e)
                {
                    e.printStackTrace();
                    e.getCause();
                }
            }
            public void kontrolerMenu(){
        try{
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/Menu.fxml"));
            Stage menuStage = new Stage();
            menuStage.initStyle(StageStyle.DECORATED);
            menuStage.setScene(new Scene(root, 800,600));
            menuStage.setTitle("Hurtownia sprzetu AGD i RTV");
            menuStage.getIcons().add(new Image("file:ikona.png"));
            menuStage.show();
        }catch(Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
            }
}
