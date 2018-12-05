import java.io.File;
import java.io.FileNotFoundException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Scanner;

public class Sekretær {
    private String Arrangementnavn;
    private double Pris;

    public Sekretær(){
    }

    public static void ArrangementListe() {
        Scanner console = new Scanner(System.in);
        System.out.println("Du har nu følgende muligheder: ");
        System.out.println("1. Se alle arrangementer for specifik facilitator");
        System.out.println("2. Se specifikt arrangement");
        int in = console.nextInt();
        switch (in) {
            case 1:
            try {

                System.out.print("Skriv facilitatornavn med filtype bagefter: ");
                System.out.println("\nEksempel: gustav.txt");

                Scanner input = new Scanner(System.in);

                File file = new File(input.nextLine());

                input = new Scanner(file);


                while (input.hasNextLine()) {
                    String line = input.nextLine();
                    System.out.println(line);
                }
                input.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            break;
            case 2:
                try {

                    System.out.print("Skriv filnavn med filtype bagefter: ");
                    System.out.println("\nEksempel: DanskeBankJuleFrokost.txt");

                    Scanner input2 = new Scanner(System.in);

                    File file = new File(input2.nextLine());

                    input2 = new Scanner(file);


                    while (input2.hasNextLine()) {
                        String line = input2.nextLine();
                        System.out.println(line);
                    }
                    input2.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
        }

        System.out.println("***************************");
        System.out.println("*Du bliver nu sendt tilbage til din menu*");
        System.out.println("**************************");

    }

    public void opretArrangement() {
        //Arrangement.
    }

    public void sletArrangement() {
    }

    public void redigerArrangement() {
    }

    public static void SekretærMenu(){
        Scanner console = new Scanner (System.in);
        System.out.println("Velkommen Sekretær");
        System.out.println("Vælg følgende handling: ");
        System.out.println("1. Book Arrangement:");
        System.out.println("2. Se Arrangementliste");
        System.out.println("3. Log ud");
        int in = console.nextInt();
        switch (in){
            case 1:
                Arrangement a = new Arrangement();
                a.opretArrangement();
                SekretærMenu();
                break;
            case 2:
                ArrangementListe();
                SekretærMenu();
            case 3:
                StartMenu.validerBruger();
        }



    }
}

