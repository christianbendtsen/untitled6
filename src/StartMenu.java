import java.util.Scanner;

public class StartMenu {

    public static void  validerBruger(){

        Sekretær sekretær = new Sekretær();

        System.out.println("\n\n");
        System.out.println("********************************************");
        System.out.println("* Velkommen til PlanOrgan personale log-in *");
        System.out.println("********************************************");
try{
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("Indtast venligst Id : ");
            int inId = input.nextInt();
            System.out.println("Indtast venligst Pin: ");
            int inPin = input.nextInt();
            if (Personale.Facilitatorliste.get(inId).CheckPin(inPin)) {
                Facilitator.facilitatormenu(sekretær);
            } else if (Personale.Sekretærliste.get(inId).CheckPin(inPin)) {
                Sekretær.SekretærMenu();
                break;
            } else {
                System.out.println("*** !!! Forkert log-in, prøv igen !!! ***");
            }
        }
        validerBruger();}
        catch (Exception ex){
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("************************************************************************************");
        System.out.println("Vi forstår ikke dit log in. Log ind med dit ID og Pinkode eller kontakt adminstrator");
        System.out.println("************************************************************************************");

            validerBruger();
        }
    }

}