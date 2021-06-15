package projekt;

public class agd1 {
    int id1,cena,raty;
    String  nazwa,producent,opis;

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public agd1(int id1, String nazwa, String producent, int cena, int raty, String opis) {
        this.id1 = id1;
        this.cena = cena;
        this.raty = raty;
        this.nazwa = nazwa;
        this.producent=producent;
        this.opis=opis;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getRaty() {
        return raty;
    }

    public void setRaty(int raty) {
        this.raty = raty;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getProducent() {return producent;}

    public void setProducent(String producent) {this.producent=producent;}

    public String getOpis() {return opis;}

    public void setOpis(String opis) { this.opis=opis;}
}
