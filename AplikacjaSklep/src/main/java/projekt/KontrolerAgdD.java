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
import javafx.scene.control.*;
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

@SuppressWarnings( "unchecked" )public class KontrolerAgdD implements Initializable {



    PreparedStatement pst = null;

    @FXML
    private Button DodajButton;
    @FXML
    private Button UsunButton;
    @FXML
    private Button EdytujButton;
    @FXML
    private Button ZamknijButton;
    @FXML
    private TableView<agd1> Tab1;
    @FXML
    private TableColumn<agd1, Integer> idp;
    @FXML
    private TableColumn<agd1, String> naz;
    @FXML
    private TableColumn<agd1, Integer> cen;
    @FXML
    private TableColumn<agd1, Integer> rat;
    @FXML
    private TableColumn<agd1,String> proc;
    @FXML
    private TableColumn<agd1,String> op;

    @FXML
    private TextField TextWyszukaj;
    @FXML
    private TextField TextD1;
    @FXML
    private TextField TextD2;
    @FXML
    private TextField TextD3;
    @FXML
    private TextField TextD4;
    @FXML
    private TextField TextD5;
    @FXML
    private TextArea TextD6;


    int index = -1;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Odswiezanie();
        wyszukiwanie();

        }

public void DodawanieProduktu()
{
    Polaczenie connectNow = new Polaczenie();
    Connection connectDB = connectNow.getConnection();

    String danee = "insert into agd_duze(id_produktu,nazwa,producent,cena,raty,opis)values(?,?,?,?,?,?)";

    try{


        pst = (PreparedStatement) connectDB.prepareStatement(danee);
        pst.setString(1 , TextD1.getText());
        pst.setString(2 , TextD2.getText());
        pst.setString(3 , TextD3.getText());
        pst.setString(4 , TextD4.getText());
        pst.setString(5 , TextD5.getText());
        pst.setString(6 , TextD6.getText());

        if(TextD1.getText().isEmpty()||TextD2.getText().isEmpty()||TextD3.getText().isEmpty()||TextD4.getText().isEmpty()||TextD5.getText().isEmpty()||TextD6.getText().isEmpty()) {
            throw new Exception();
        }else {
            pst.execute();

            JOptionPane.showMessageDialog(null, "Dodano pomyslnie!");
            Odswiezanie();
        }
    }catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Blad dodawania!");
    }

}
public void edytowanie()
{
try {
    Polaczenie connectNow = new Polaczenie();
    Connection connectDB = connectNow.getConnection();
    String val1 = TextD1.getText();
    String val2 = TextD2.getText();
    String val3 = TextD3.getText();
    String val4 = TextD4.getText();
    String val5 = TextD5.getText();
    String val6 = TextD6.getText();

    String danee = "update agd_duze set id_produktu= '"+val1+"',nazwa = '"+val2+"',producent = '"+val3+"',cena = '"+val4+"',raty = '"+val5+"',opis = '"+val6+"' where id_produktu ='"+val1+"' ";
    pst = (PreparedStatement) connectDB.prepareStatement(danee);
    if(TextD1.getText().isEmpty()||TextD2.getText().isEmpty()||TextD3.getText().isEmpty()||TextD4.getText().isEmpty()||TextD5.getText().isEmpty()||TextD6.getText().isEmpty()) {
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
public void wyszukiwanie()
{
    Polaczenie connectNow = new Polaczenie();
    Connection connectDB = connectNow.getConnection();
    final ObservableList WczTab = FXCollections.observableArrayList();

    String danee = "SELECT * FROM agd_duze";

    Statement st = null;
    try {
        st = connectDB.createStatement();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    agd1 sklep1;

    ResultSet rs = null;
    try {
        assert st != null;
        rs = st.executeQuery(danee);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        while (Objects.requireNonNull(rs).next()) {
            int id1 = rs.getInt("id_produktu");
            String nazwa = rs.getString("nazwa");
            String producent=rs.getString("producent");
            String opis=rs.getString("opis");
            int cena = rs.getInt("cena");
            int raty = rs.getInt("raty");
            sklep1 = new agd1(id1,nazwa,producent,cena,raty,opis);
            WczTab.add(sklep1);

        }
        st.close();

    } catch(Exception  e) {
        System.out.println("Wyjątek!.");
        System.out.println(e.getMessage());
    }
    idp.setCellValueFactory(new PropertyValueFactory<>("id1"));
    naz.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
    proc.setCellValueFactory(new PropertyValueFactory<>("producent"));
    cen.setCellValueFactory(new PropertyValueFactory<>("cena"));
    rat.setCellValueFactory(new PropertyValueFactory<>("raty"));
    op.setCellValueFactory(new PropertyValueFactory<>("opis"));

    Tab1.setItems(WczTab);

    FilteredList<agd1> wyszukiwanie = new FilteredList<>(WczTab, b->true);
    TextWyszukaj.textProperty().addListener((observable, oldValue, newValue) ->
    {
        wyszukiwanie.setPredicate(agd1 -> {
            if(newValue == null || newValue.isEmpty()) {
                return true;
            }
            String literki = newValue.toLowerCase();
            if(agd1.getNazwa().toLowerCase().indexOf(literki) != -1) {
                return true;
            } else if (agd1.getProducent().toLowerCase().indexOf(literki) != -1) {
                return true;
            }
            else if (String.valueOf(agd1.getRaty()).indexOf(literki) != -1)
                return true;
            else
                return false;
        });
    });
    SortedList<agd1> posortowane = new SortedList<>(wyszukiwanie);
    posortowane.comparatorProperty().bind(Tab1.comparatorProperty());
    Tab1.setItems(posortowane);
}
public void usuwanie() {
    Polaczenie connectNow = new Polaczenie();
    Connection connectDB = connectNow.getConnection();
    String danee = "delete from agd_duze where id_produktu = ?";
    try {
        pst = (PreparedStatement) connectDB.prepareStatement(danee);
        pst.setString(1 , TextD1.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Usunieto");
            Odswiezanie();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Blad przy usuwaniu!");

    }
}
public void Odswiezanie()
{

    Polaczenie connectNow = new Polaczenie();
    Connection connectDB = connectNow.getConnection();
    final ObservableList WczTab = FXCollections.observableArrayList();

    String danee = "SELECT * FROM agd_duze";

    Statement st = null;
    try {
        st = connectDB.createStatement();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    agd1 sklep1;

    ResultSet rs = null;
    try {
        assert st != null;
        rs = st.executeQuery(danee);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        while (Objects.requireNonNull(rs).next()) {
            int id1 = rs.getInt("id_produktu");
            String nazwa = rs.getString("nazwa");
            String producent=rs.getString("producent");
            String opis=rs.getString("opis");
            int cena = rs.getInt("cena");
            int raty = rs.getInt("raty");
            sklep1 = new agd1(id1,nazwa,producent,cena,raty,opis);
            WczTab.add(sklep1);

        }
        st.close();

    } catch(Exception  e) {
        System.out.println("Wyjątek!.");
        System.out.println(e.getMessage());
    }
    idp.setCellValueFactory(new PropertyValueFactory<>("id1"));
    naz.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
    proc.setCellValueFactory(new PropertyValueFactory<>("producent"));
    cen.setCellValueFactory(new PropertyValueFactory<>("cena"));
    rat.setCellValueFactory(new PropertyValueFactory<>("raty"));
    op.setCellValueFactory(new PropertyValueFactory<>("opis"));

    Tab1.setItems(WczTab);
}

public void EdytujButtonOnActionEvent()
{
    edytowanie();




}
public void DodajButtonOnActionEvent()
{
    DodawanieProduktu();


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
        index = Tab1.getSelectionModel().getSelectedIndex();
        if(index <= -1)
        {
            return;
        }
        TextD1.setText(idp.getCellData(index).toString());
        TextD2.setText(naz.getCellData(index));
        TextD3.setText(proc.getCellData(index));
        TextD4.setText(cen.getCellData(index).toString());
        TextD5.setText(rat.getCellData(index).toString());
        TextD6.setText(op.getCellData(index));
    }
}
