import java.io.File;
import java.util.Scanner;

public class Sekretær {
    private String Arrangementnavn;
    private double Pris;

    public Sekretær(){
    }

    public static void ArrangementListe() {
        try {
            System.out.print("Skriv filnavn med filtype bagefter: ");

            Scanner input = new Scanner(System.in);

            File file = new File(input.nextLine());

            input = new Scanner(file);


            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);
            }
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace(); //printStackTrace viser fejlen, hvis der er en fejl
        }

        //Scanner reader = new Scanner(newFileInputStream("hej.txt""));

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

    public static void sekretærMenu(){
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
                sekretærMenu();
                break;
            case 2:
                ArrangementListe();
                sekretærMenu();
            case 3:
                StartMenu.validerBruger();
        }



    }
}

