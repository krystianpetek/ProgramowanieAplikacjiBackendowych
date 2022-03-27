package Zadanie8;

public class Uzytkownik {

    public Uzytkownik(String imie, String nazwisko, int wiek) {
        Imie = imie;
        Nazwisko = nazwisko;
        Wiek = wiek;
    }

    public Uzytkownik() {
    }

    private String Imie;

    public String getImie() {
        return Imie;
    }

    public void setImie(String imie) {
        Imie = imie;
    }

    private String Nazwisko;

    public String getNazwisko() {
        return Nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        Nazwisko = nazwisko;
    }

    private int Wiek;

    public int getWiek() {
        return Wiek;
    }

    public void setWiek(int wiek) {
        Wiek = wiek;
    }
}
