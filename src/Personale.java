import java.util.ArrayList;

public class Personale {
    private int Id;
    private int Pin;
    public static ArrayList<Personale> Sekretærliste = new ArrayList<Personale>();
    public static ArrayList<Personale> Facilitatorliste = new ArrayList<>();


    public boolean CheckPin(int pin) {
        return this.Pin == pin;
    }

    public Personale(int id, int pin){
        this.Id=id;
        this.Pin=pin;
    }


    public static void addSekretærDummyData()
    {
        Sekretærliste.add(new Personale(0, 00));
        Sekretærliste.add(new Personale(1, 11));
        Sekretærliste.add(new Personale(2, 22));
        Sekretærliste.add(new Personale(3, 33));
    }

    public static void addFacilitatorDummyData()
    {
        Facilitatorliste.add(new Personale(0,000));
        Facilitatorliste.add(new Personale(1,111));
        Facilitatorliste.add(new Personale(2,222));
        Facilitatorliste.add(new Personale(3,333));

    }
}