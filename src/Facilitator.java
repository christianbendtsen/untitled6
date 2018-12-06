
import java.util.Scanner;

public class Facilitator {
    private double pris;
    private int id;
    private int pin;

    public Facilitator() {

    }

    public static void facilitatormenu(Sekretær sekretær) { // to be continued....
        Scanner console = new Scanner(System.in);
        System.out.println("Velkommen facilitator");
        System.out.println("Du har følgende muligheder: ");
        System.out.println("1. Se Arrangementliste");
        System.out.println("2. Log ud");
        int in = console.nextInt();
        switch (in) {
            case 1:
                sekretær.ArrangementListe();
                facilitatormenu(sekretær);
                break;
            case 2:
                StartMenu.validerBruger();
                break;
        }
    }

}
