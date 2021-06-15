package projekt;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class KontrolerMenu {

    @FXML
    private Button zamknijButton;
    @FXML
    private Button wylogujButton;
    @FXML
    private Button ButtonAGDD;
    @FXML
    private Button ButtonAGDM;
    @FXML
    private Button ButtonKomputery;
    @FXML
    private Button ButtonKonsoleGry;
    @FXML
    private Button ButtonSmartfony;
    @FXML
    private Button ButtonTvAudio;
    @FXML
    private Button zamowieniaButton;



    public void zamknijButtonOnAction()
    {
        Stage stage = (Stage) zamknijButton.getScene().getWindow();
        stage.close();
        Platform.exit();

    }
    public void wylogujButtonOnAction()
    {
        Stage stage = (Stage) wylogujButton.getScene().getWindow();
        stage.close();

        try{
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/main.fxml"));
            Stage menuStage = new Stage();
            menuStage.initStyle(StageStyle.DECORATED);
            menuStage.setScene(new Scene(root, 600,400));
            menuStage.setTitle("AGD duze");
            menuStage.getIcons().add(new Image("file:ikona.png"));
            menuStage.show();
        }catch(Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void KontrolerAgdD()
    {
        try{
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/AgdD.fxml"));
            Stage menuStage = new Stage();
            menuStage.initStyle(StageStyle.DECORATED);
            menuStage.setScene(new Scene(root, 839,600));
            menuStage.setTitle("AGD duze");
            menuStage.getIcons().add(new Image("file:ikona.png"));
            menuStage.show();
        }catch(Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }
    public void AgdDButtonOnAction()
    {
        KontrolerAgdD();
        Stage stage = (Stage) zamknijButton.getScene().getWindow();
        stage.close();
    }

    public void KontrolerAgdM()
    {
        try{
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/AgdM.fxml"));
            Stage menuStage = new Stage();
            menuStage.initStyle(StageStyle.DECORATED);
            menuStage.setScene(new Scene(root, 839,600));
            menuStage.setTitle("AGD male");
            menuStage.getIcons().add(new Image("file:ikona.png"));
            menuStage.show();
        }catch(Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }
    public void AgdMButtonOnAction()
    {
        KontrolerAgdM();
        Stage stage = (Stage) zamknijButton.getScene().getWindow();
        stage.close();

    }

    public void KontrolerKomputery()
    {
        try{
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/Komputery.fxml"));
            Stage menuStage = new Stage();
            menuStage.initStyle(StageStyle.DECORATED);
            menuStage.setScene(new Scene(root, 839,600));
            menuStage.setTitle("Komputery");
            menuStage.getIcons().add(new Image("file:ikona.png"));
            menuStage.show();

        }catch(Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }
    public void KomputeryButtonOnAction()
    {
        KontrolerKomputery();
        Stage stage = (Stage) zamknijButton.getScene().getWindow();
        stage.close();
    }


    public void KontrolerKonsoleGry()
    {
        try{
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/KonsoleGry.fxml"));
            Stage menuStage = new Stage();
            menuStage.initStyle(StageStyle.DECORATED);
            menuStage.setScene(new Scene(root, 839,600));
            menuStage.setTitle("Konsole i gry");
            menuStage.getIcons().add(new Image("file:ikona.png"));
            menuStage.show();
        }catch(Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }
    public void KonsoleGryButtonOnAction()
    {
        KontrolerKonsoleGry();
        Stage stage = (Stage) zamknijButton.getScene().getWindow();
        stage.close();
    }

    public void KontrolerSmartfony()
    {
        try{
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/Smartfony.fxml"));
            Stage menuStage = new Stage();
            menuStage.initStyle(StageStyle.DECORATED);
            menuStage.setScene(new Scene(root, 839,600));
            menuStage.setTitle("Smartfony");
            menuStage.getIcons().add(new Image("file:ikona.png"));
            menuStage.show();
        }catch(Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }
    public void SmartfonyButtonOnAction() { KontrolerSmartfony();
        Stage stage = (Stage) zamknijButton.getScene().getWindow();
        stage.close();}

    public void KontrolerTvAudio()
    {
        try{
            Parent root;
            root = FXMLLoader.load(getClass().getResource("/TvAudio.fxml"));
            Stage menuStage = new Stage();
            menuStage.initStyle(StageStyle.DECORATED);
            menuStage.setScene(new Scene(root, 839,600));
            menuStage.setTitle("Tv i Audio");
            menuStage.getIcons().add(new Image("file:ikona.png"));
            menuStage.show();
        }catch(Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }
    public void TvAudioButtonOnAction() { KontrolerTvAudio();
        Stage stage = (Stage) zamknijButton.getScene().getWindow();
        stage.close();}

     public void KontrolerZamowienia()
     {
         try{
             Parent root;
             root = FXMLLoader.load(getClass().getResource("/Zamowienie.fxml"));
             Stage menuStage = new Stage();
             menuStage.initStyle(StageStyle.DECORATED);
             menuStage.setScene(new Scene(root, 800,600));
             menuStage.setTitle("Zamowienia");
             menuStage.getIcons().add(new Image("file:ikona.png"));
             menuStage.show();
         }catch(Exception e)
         {
             e.printStackTrace();
             e.getCause();
         }

         }
         public void zamowieniaButtionOnAction()
         {
             KontrolerZamowienia();
             Stage stage = (Stage) zamknijButton.getScene().getWindow();
             stage.close();
         }


}


