import java.io.File;
import java.util.Scanner;

public class Sekretær {



    public static void ArrangementListe() {
        Scanner console = new Scanner(System.in);
        System.out.println("Du har nu følgende muligheder: ");
        System.out.println("1. Se alle arrangementer for specifik facilitator");
        System.out.println("2. Se specifikt arrangement");
        System.out.println("3. Log ud");
        int in = console.nextInt();
        switch (in) {
            case 1:
            try {

                System.out.print("Skriv facilitatornavn med filtype bagefter: ");
                System.out.println("\nEksempel: gustav.txt");

                Scanner input = new Scanner(System.in); // importerer scanner for at læse filer

                File file = new File(input.nextLine()); // opretter objekt af Fil, med det formål at få filepath, brugeren selv taster ind.

                input = new Scanner(file); // scanner bruger den fil vi lige har oprettet


                while (input.hasNextLine()) { // så længe scanneren har en næste linje den kan scanne.
                    String line = input.nextLine(); // så længe der er en ny linje bliver den udskrevet.
                    System.out.println(line);
                }
                input.close(); // for at lukke scanneren

            } catch (Exception ex) {
                ex.printStackTrace(); //  printer evt fejl
                System.out.println("Kunne ikke finde ønskede fil");
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
                    System.out.println("Kunne ikke finde ønskede fil");
                    ArrangementListe();

                }
            case 3: {
                StartMenu.validerBruger();
            }
        }

        System.out.println("***************************");
        System.out.println("*Du bliver nu sendt tilbage til din menu*");
        System.out.println("**************************");

    }


    public static void sekretærMenu(){
        Scanner console = new Scanner (System.in);
        System.out.println("Velkommen Sekretær");
        System.out.println("Vælg følgende handling: ");
        System.out.println("1. Book Arrangement");
        System.out.println("2. Se Arrangementliste");
        System.out.println("3. Slet arrangement");
        System.out.println("4. Log ud");
        int in = console.nextInt();
        switch (in){
            case 1:
                Arrangement a = new Arrangement(); // opretter instans af arrangement for at kunne kalder metoden opret arrrangement
                a.opretArrangement();
                sekretærMenu();
                break;
            case 2:
                ArrangementListe();
                sekretærMenu();
            case 3:
                sletArrangement();
                sekretærMenu();
                case 4:
                StartMenu.validerBruger();
        }
    }
    public static void sletArrangement() {
        Scanner console = new Scanner(System.in);

        System.out.println("Du har nu følgende muligheder: ");
        System.out.println("1. Slet arrangement");
        System.out.println("2. Tilbage til sekretærmenu");
        System.out.println("3. Log ud");

        int in = console.nextInt();
        switch (in) {

            case 1:
            System.out.println("Skriv navn på fil som ønskes slettet efterfulgt af .txt");

            Scanner scanner = new Scanner(System.in);

            File file = new File(scanner.nextLine());


            if (file.delete()) {
                System.out.println(file.getName() + " er slettet");
            } else {
                System.out.println("operation fejlede");
            }
            break;
            case 2:
                sekretærMenu();
            break;
            case 3:
                StartMenu.validerBruger();
                break;
        }
    }
}

