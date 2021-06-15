package projekt;

public class zamowienia {
    int id;
    int numer_telefonu;

    public int getNumer_zamowienia() {
        return numer_zamowienia;
    }

    public void setNumer_zamowienia(int numer_zamowienia) {
        this.numer_zamowienia = numer_zamowienia;
    }

    int numer_zamowienia;
    String imie;
    String nazwisko;
    String email;
    String adres;
    String kod_pocztowy;
    String platnosc;
    String data;

    public int getNumer_telefonu() {
        return numer_telefonu;
    }

    public void setNumer_telefonu(int numer_telefonu) {
        this.numer_telefonu = numer_telefonu;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getKod_pocztowy() {
        return kod_pocztowy;
    }

    public void setKod_pocztowy(String kod_pocztowy) {
        this.kod_pocztowy = kod_pocztowy;
    }

    public String getPlatnosc() {
        return platnosc;
    }

    public void setPlatnosc(String platnosc) {
        this.platnosc = platnosc;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public zamowienia(int id, String imie, String nazwisko, int numer_telefonu, String email, String adres, String kod_pocztowy, String platnosc, String data, int numer_zamowienia)
    {
        this.id=id;
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.numer_telefonu=numer_telefonu;
        this.email=email;
        this.adres=adres;
        this.kod_pocztowy=kod_pocztowy;
        this.platnosc=platnosc;
        this.data=data;
        this.numer_zamowienia=numer_zamowienia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
