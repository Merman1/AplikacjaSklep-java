package projekt;

import com.mysql.jdbc.PreparedStatement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

@SuppressWarnings( "unchecked" )public class KontrolerZamowienia implements Initializable {
    PreparedStatement pst = null;


    @FXML
    private TableView<zamowienia> Tab2;
    @FXML
    private TableColumn<zamowienia, Integer> idz;
    @FXML
    private TableColumn<zamowienia, String> im;
    @FXML
    private TableColumn<zamowienia, String> na;
    @FXML
    private TableColumn<zamowienia, Integer> wi;
    @FXML
    private TableColumn<zamowienia, String> em;
    @FXML
    private TableColumn<zamowienia, String> ad;
    @FXML
    private TableColumn<zamowienia, String> ko;
    @FXML
    private TableColumn<zamowienia, String> pl;
    @FXML
    private TableColumn<zamowienia, String> da;
    @FXML
    private TableColumn<zamowienia, Integer> nrz;
    @FXML
    private TextField TextWyszukaj;
    @FXML
    private Button DodajButton;
    @FXML
    private Button UsunButton;
    @FXML
    private Button EdytujButton;
    @FXML
    private Button ZamknijButton;
    @FXML
    private TextField Text1;
    @FXML
    private TextField Text2;
    @FXML
    private TextField Text3;
    @FXML
    private TextField Text4;
    @FXML
    private TextField Text5;
    @FXML
    private TextField Text6;
    @FXML
    private TextField Text7;
    @FXML
    private TextField Text8;
    @FXML
    private TextField Text9;
    @FXML
    private TextField Text10;
    int index = -1;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Odswiezanie();
       wyszukaj();

    }
    public void wyszukaj()
    {
        Polaczenie connectNow = new Polaczenie();
        Connection connectDB = connectNow.getConnection();
        final ObservableList WczTab = FXCollections.observableArrayList();

        String danee = "SELECT * FROM zamowienia";

        Statement st = null;
        try {
            st = connectDB.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        zamowienia zamawiania;

        ResultSet rs = null;
        try {
            rs = Objects.requireNonNull(st).executeQuery(danee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (Objects.requireNonNull(rs).next()) {
                int idz = rs.getInt("id_zamowienia");
                String im = rs.getString("Imie");
                String na = rs.getString("Nazwisko");
                int wi = rs.getInt("Numer_telefonu");
                String em = rs.getString("Email");
                String ad = rs.getString("Adres");
                String ko = rs.getString("Kod_pocztowy");
                String pl = rs.getString("Platnosc");
                String da = rs.getString("Data");
                int nrz = rs.getInt("Numer_zamowienia");
                zamawiania = new zamowienia(idz,im, na,wi, em, ad,ko, pl, da, nrz);
                WczTab.add(zamawiania);

            }
            st.close();
        } catch (Exception e) {
            System.out.println("There is an Exception.");
            System.out.println(e.getMessage());
        }
        idz.setCellValueFactory(new PropertyValueFactory<>("id"));
        im.setCellValueFactory(new PropertyValueFactory<>("imie"));
        na.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        wi.setCellValueFactory(new PropertyValueFactory<>("numer_telefonu"));
        em.setCellValueFactory(new PropertyValueFactory<>("email"));
        ad.setCellValueFactory(new PropertyValueFactory<>("adres"));
        ko.setCellValueFactory(new PropertyValueFactory<>("kod_pocztowy"));
        pl.setCellValueFactory(new PropertyValueFactory<>("platnosc"));
        da.setCellValueFactory(new PropertyValueFactory<>("data"));
        nrz.setCellValueFactory(new PropertyValueFactory<>("numer_zamowienia"));

        Tab2.setItems(WczTab);

        FilteredList<zamowienia> wyszukiwanie = new FilteredList<>(WczTab, b->true);
        TextWyszukaj.textProperty().addListener((observable, oldValue, newValue) ->
                wyszukiwanie.setPredicate(zamowienia -> {
                    if(newValue == null || newValue.isEmpty()) {
                        return true;
                    }
                    String literki = newValue.toLowerCase();
                    if(zamowienia.getImie().toLowerCase().contains(literki)) {
                        return true;
                    } else if (zamowienia.getNazwisko().toLowerCase().contains(literki)) {
                        return true;
                    }
                    else return String.valueOf(zamowienia.getNumer_zamowienia()).contains(literki);
                }));
        SortedList<zamowienia> posortowane = new SortedList<>(wyszukiwanie);
        posortowane.comparatorProperty().bind(Tab2.comparatorProperty());
        Tab2.setItems(posortowane);
    }
    public void Odswiezanie()
    {
        Polaczenie connectNow = new Polaczenie();
        Connection connectDB = connectNow.getConnection();
        final ObservableList WczTab = FXCollections.observableArrayList();

        String danee = "SELECT * FROM zamowienia";

        Statement st = null;
        try {
            st = connectDB.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        zamowienia zamawiania;

        ResultSet rs = null;
        try {
            rs = Objects.requireNonNull(st).executeQuery(danee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (Objects.requireNonNull(rs).next()) {
                int idz = rs.getInt("id_zamowienia");
                String im = rs.getString("Imie");
                String na = rs.getString("Nazwisko");
                int wi = rs.getInt("Numer_telefonu");
                String em = rs.getString("Email");
                String ad = rs.getString("Adres");
                String ko = rs.getString("Kod_pocztowy");
                String pl = rs.getString("Platnosc");
                String da = rs.getString("Data");
                int nrz = rs.getInt("Numer_zamowienia");
                zamawiania = new zamowienia(idz,im, na,wi, em, ad,ko, pl, da, nrz);
                WczTab.add(zamawiania);

            }
            st.close();
        } catch (Exception e) {
            System.out.println("There is an Exception.");
            System.out.println(e.getMessage());
        }
        idz.setCellValueFactory(new PropertyValueFactory<>("id"));
        im.setCellValueFactory(new PropertyValueFactory<>("imie"));
        na.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        wi.setCellValueFactory(new PropertyValueFactory<>("numer_telefonu"));
        em.setCellValueFactory(new PropertyValueFactory<>("email"));
        ad.setCellValueFactory(new PropertyValueFactory<>("adres"));
        ko.setCellValueFactory(new PropertyValueFactory<>("kod_pocztowy"));
        pl.setCellValueFactory(new PropertyValueFactory<>("platnosc"));
        da.setCellValueFactory(new PropertyValueFactory<>("data"));
        nrz.setCellValueFactory(new PropertyValueFactory<>("numer_zamowienia"));

        Tab2.setItems(WczTab);
    }
    public void DodawanieProduktu()
    {
        Polaczenie connectNow = new Polaczenie();
        Connection connectDB = connectNow.getConnection();
        String danee = "insert into zamowienia(id_zamowienia,imie,nazwisko,numer_telefonu,email,adres,kod_pocztowy,platnosc,data, numer_zamowienia)values(?,?,?,?,?,?,?,?,?,?)";

        try{
            pst = (PreparedStatement) connectDB.prepareStatement(danee);
            pst.setString(1 , Text1.getText());
            pst.setString(2 , Text2.getText());
            pst.setString(3 , Text3.getText());
            pst.setString(4 , Text4.getText());
            pst.setString(5 , Text5.getText());
            pst.setString(6 , Text6.getText());
            pst.setString(7 , Text7.getText());
            pst.setString(8 , Text8.getText());
            pst.setString(9 , Text9.getText());
            pst.setString(10 , Text10.getText());
            if(Text1.getText().isEmpty()||Text2.getText().isEmpty()||Text3.getText().isEmpty()||Text4.getText().isEmpty()||Text5.getText().isEmpty()||Text6.getText().isEmpty()||Text7.getText().isEmpty()||Text7.getText().isEmpty()||Text9.getText().isEmpty()||Text10.getText().isEmpty()) {
                throw new Exception();
            }else {
                pst.execute();

                JOptionPane.showMessageDialog(null, "Dodano pomyslnie!");
                Odswiezanie();
            }
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Blad dodawania!");
        }
    }
    public void edytowanie()
    {
        try {
            Polaczenie connectNow = new Polaczenie();
            Connection connectDB = connectNow.getConnection();
            String val1 = Text1.getText();
            String val2 = Text2.getText();
            String val3 = Text3.getText();
            String val4 = Text4.getText();
            String val5 = Text5.getText();
            String val6 = Text6.getText();
            String val7 = Text7.getText();
            String val8 = Text8.getText();
            String val9 = Text9.getText();
            String val10 = Text10.getText();

            String danee = "update zamowienia set id_zamowienia= '"+val1+"',imie = '"+val2+"',nazwisko = '"+val3+"',numer_telefonu = '"+val4+"',email = '"+val5+"',adres = '"+val6+"',kod_pocztowy = '"+val7+"',platnosc = '"+val8+"',data = '"+val9+"',numer_zamowienia ='"+val10+"' where id_zamowienia ='"+val1+"' ";
            pst = (PreparedStatement) connectDB.prepareStatement(danee);
            if(Text1.getText().isEmpty()||Text2.getText().isEmpty()||Text3.getText().isEmpty()||Text4.getText().isEmpty()||Text5.getText().isEmpty()||Text6.getText().isEmpty()||Text7.getText().isEmpty()||Text7.getText().isEmpty()||Text9.getText().isEmpty()||Text10.getText().isEmpty()) {
                throw new Exception();
            }else {
                pst.execute();
                JOptionPane.showMessageDialog(null, "Edytowano");
                Odswiezanie();
            }
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Blad przy edytowaniu!");
        }

    }
    public void usuwanie() {
        Polaczenie connectNow = new Polaczenie();
        Connection connectDB = connectNow.getConnection();
        String danee = "delete from zamowienia where id_zamowienia = ?";
        try {
            pst = (PreparedStatement) connectDB.prepareStatement(danee);
            pst.setString(1 , Text1.getText());

                pst.execute();
                JOptionPane.showMessageDialog(null, "Usunieto");
                Odswiezanie();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Blad przy usuwaniu!");

        }
    }
    public void DodajButtonOnActionEvent()
    {
        DodawanieProduktu();


    }
public void EdytujButtonOnActionEvent()
{
    edytowanie();

}
public void UsunButtonOnActionEvent()
{
    usuwanie();

}
    public void zamknijButtonOnAction()
    {
        Stage stage = (Stage) ZamknijButton.getScene().getWindow();
        stage.close();

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
    public void getSelected() {
        index = Tab2.getSelectionModel().getSelectedIndex();
        if(index <= -1)
        {
            return;
        }
        Text1.setText(idz.getCellData(index).toString());
        Text2.setText(im.getCellData(index));
        Text3.setText(na.getCellData(index));
        Text4.setText(wi.getCellData(index).toString());
        Text5.setText(em.getCellData(index));
        Text6.setText(ad.getCellData(index));
        Text7.setText(ko.getCellData(index));
        Text8.setText(pl.getCellData(index));
        Text9.setText(da.getCellData(index));
        Text10.setText(nrz.getCellData(index).toString());
    }
}
