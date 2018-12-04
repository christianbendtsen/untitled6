import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Arrangement {

    private String arrangementNavn;
    //private double totalVarighed;
    //private double totalPris;
    public String kundeEmail;
    public String kundeTlf;
    public Event event = new Event();
    public Event listeAfEvents;
    //public Facilitator listeAfFacilitator;
    String filepath;




    public ArrayList<Arrangement> listeAfArrangementer = new ArrayList<Arrangement>();

    public ArrayList<Arrangement> getListeAfArrangementer() {

        return listeAfArrangementer;
    }

    private ArrayList<Event> eventListe = new ArrayList<Event>();

    public ArrayList<Event> getEventListe (){
        return eventListe;
    }

    public Arrangement (String arrangementNavn, String kundeEmail, String kundeTlf, ArrayList<Event> eventListe)
    {
        this.arrangementNavn=arrangementNavn;
        this.kundeEmail=kundeEmail;
        this.kundeTlf=kundeTlf;
        this.eventListe=eventListe;
    }

    public Arrangement()
    {

    }


    public Arrangement opretArrangement()
    {
        Scanner console = new Scanner(System.in);

        System.out.println("**Udfyld data for nyt arrangement**");
        System.out.println("Angiv navn på fil efterfulgt af et .txt");
        String filepath = console.nextLine();
        System.out.print("Navn på arrangementet: ");
        System.out.println();
        String arrangementNavn = console.nextLine();
        System.out.print("Kundes Email: ");
        System.out.println();
        String kundeEmail = console.nextLine();
        System.out.print("Kundes telefonnummer: ");
        String kundeTlf;
        while (true) {
            try {
                kundeTlf = console.nextLine();
                break;
            }
            catch (InputMismatchException e) {
                System.out.print("Input er ikke et tal. Skriv venligst tal: ");
                console.nextLine();
            }
        }

        System.out.println("**Tilføj event 1=ja, 2=nej**");
        int valg = console.nextInt();
        do {
            eventListe.add(event.tilføjEvent());
            System.out.println("**Tilføj event 1=ja, 2=nej**");
            valg = console.nextInt();
        }
        while (valg == 1);

        Arrangement arrangement = new Arrangement(arrangementNavn, kundeEmail, kundeTlf, eventListe);
        System.out.println("**Følgende Arrangement er oprettet**");
        System.out.println(arrangement);

        try {
            FileWriter fw = new FileWriter(filepath,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(arrangement);
            pw.flush();
            pw.close();

            JOptionPane.showMessageDialog(null, "saved");
        }
        catch (Exception E)
        {
            JOptionPane.showMessageDialog(null, " not saved");

        }

        //String indhold = Filer.getIndhold("arrangementer.csv");//oprindeligt arrangementer.csv
        //indhold += "\n" + arrangement;//tilføjer den nye
        //Filer.skrivFil("arrangementer.csv", indhold);

        return arrangement;


    }

    public String toString()
    {
        return "\n" + "Arrangementnavn: " + arrangementNavn + ". \n" + "Kundes email: " + kundeEmail +
                ".\n" + "Kundes telefonnummer: " + kundeTlf + ". \n\n" + "Der er tilknyttet følgende event:" + eventListe;
    }

}