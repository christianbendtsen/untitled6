import java.util.ArrayList;

public class Personale {
    private int Id;
    private int Pin;
    public static int aktivBruger;

    public boolean CheckPin(int pin) {
        return this.Pin == pin;
    }

    public Personale(){

    }
    public Personale(int id, int pin){
        this.Id=id;
        this.Pin=pin;
    }
    public static ArrayList<Personale> PersonaleListe = new ArrayList<Personale>();

    public static void addDummyDataPersonale()
    {
        PersonaleListe.add(new Personale(0, 000));
        PersonaleListe.add(new Personale(1, 111));
        PersonaleListe.add(new Personale(2, 222));
        PersonaleListe.add(new Personale(3, 333));
        PersonaleListe.add(new Personale(4, 444));
    }
}