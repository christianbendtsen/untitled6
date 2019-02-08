import java.util.Scanner;

public class StartMenu {

    public static void  validerBruger(){

        Sekretær sekretær = new Sekretær(); // opretter ny instans af klassen sekretær

        System.out.println("\n\n");
        System.out.println("********************************************");
        System.out.println("* Velkommen til PlanOrgan personale log-in *");
        System.out.println("********************************************");
try{
        Scanner input = new Scanner(System.in); // importerer en scanner til at tage imod bruger input

            System.out.println("Indtast venligst Id : ");
            int inId = input.nextInt();
            System.out.println("Indtast venligst Pin: ");
            int inPin = input.nextInt();

            if (Personale.Facilitatorliste.get(inId).CheckPin(inPin)) {
                Facilitator.facilitatormenu(sekretær); // Sektretær som parameter for at bruge metoden arrangementlisten

            } else if (Personale.Sekretærliste.get(inId).CheckPin(inPin)) {
                Sekretær.sekretærMenu();

            }
}
        catch (Exception ex){
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("*********************************************************");
        System.out.println("Vi forstår ikke dit log in. Log ind med dit ID og Pinkode");
        System.out.println("*********************************************************");

            validerBruger();
        }
    }

}