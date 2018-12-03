import java.util.Scanner;

public class StartMenu {

    // Personale personale = new Personale();
    // Facilitator facilitator = new Facilitator();

    public static void  validerBruger(){
        Sekretær sekretær = new Sekretær();

        System.out.println("\n\n");
        System.out.println("*********************************");
        System.out.println("* Velkommen til PlanOrgan bruger log-in *");
        System.out.println("*********************************");

        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("Indtast venligst Id : ");
            int inId = input.nextInt();
            System.out.println("Indtast venligst Pin: ");
            int inPin = input.nextInt();
            if (inId == 1 && inPin == 111) {
                Facilitator.facilitatormenu(sekretær);
            } else if (Personale.PersonaleListe.get(inId).CheckPin(inPin)) {
                Sekretær.SekretærMenu();
                break;
            } else {
                System.out.println("* Forkert log-in, prøv igen *");
            }
        }
        validerBruger();
    }

}