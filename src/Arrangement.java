import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Arrangement {

    private String arrangementNavn;
    private String totalTidOgPris;
    public String kundeEmail;
    public String kundeTlf;
    public Event event = new Event();
    private LocalDateTime eventStart;
    private LocalDateTime eventSlut;
    private ArrayList<Event> eventListe = new ArrayList<Event>();
    public Event listeAfEvents;
    //public Facilitator listeAfFacilitator;




    public ArrayList<Arrangement> listeAfArrangementer = new ArrayList<Arrangement>();

    public ArrayList<Arrangement> getListeAfArrangementer() {

        return listeAfArrangementer;
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


    //læser det første tilknyttede events starttidspunkt fra Arraylisten eventliste - skal bruges til at regne total tid og pris ud
    public LocalDateTime getEventStart (ArrayList<Event> eventListe)
    {
        eventStart = eventListe.get(0).getStartTidspunkt();

        return eventStart;
    }
    //læser det sidste tilknyttede events sluttidspunkt fra Arraylisten eventliste - skal bruges til at regne total tid og pris ud
    public LocalDateTime getEventSlut (ArrayList<Event> eventListe)
    {

        for (int i=0; i<eventListe.size(); i++) {
            eventSlut = eventListe.get(i).getSlutTidspunkt();

        }
        return eventSlut;
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
        while(valg==1) {
            eventListe.add(event.tilføjEvent());
            System.out.println("**Tilføj event 1=ja, 2=nej**");
            valg = console.nextInt();
        }

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
        catch (Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, " not saved");
        }

        return arrangement;

    }
    public static String TotalTidOgPris (LocalDateTime eventStart, LocalDateTime eventSlut)
    {
        long totalTid = Math.abs(Duration.between(eventSlut,eventStart).toMinutes());//finder forskellen på et events start- og sluttidspunkt i minutter
        long totalDage =totalTid/(24 * 60);//finder antal dage ud fra ovenstående forskel i minutter
        long totalTimer= (totalTid/60)-(totalDage*24); //finder antal timer ud fra ovenstående forskel i minutter, fratrukket antal dage
        long totalMinutter = totalTid-(totalTimer*60)-(totalDage*24*60);//finder antal minutter ud fra ovenstående forskel fratrukket dage og timer

        long totalTidIHalveTimer = totalTid/30;//finder antal halve timer ud fra den samlede forskel i minutter - pris for arrangement betales pr. halve timer

        long totalPris;
        //regner prisen for at arrangement ud - én pris for hverdage og én pris for weekend (HUSK at skriv i opgaven, at vi regner pris ud fra hvornår eventet starter)
        if(eventStart.getDayOfWeek() != DayOfWeek.SATURDAY && eventStart.getDayOfWeek() != DayOfWeek.SUNDAY)
        {
            totalPris = (totalTidIHalveTimer*250)+100;//+100 fordi et events startpris er 100 kr.
        }
        else
        {
            totalPris = (totalTidIHalveTimer*350)+100;//+100 fordi et events startpris er 100 kr.
        }
        //returnerer samlet antal dage,timer,minutter og den samlede pris i en string, som kan skrives ud sammen med resten af arrangementets info
        return "Arrangements totale varighed: " + totalDage + " dage " + totalTimer +" timer " +  totalMinutter + " minutter." +
                "\n" + "Totalpris (uden moms): " + totalPris + " kr.";

    }
    public String toString()
    {
        totalTidOgPris = TotalTidOgPris(getEventStart(eventListe), getEventSlut(eventListe));//kalder metoden overnfor for tid og pris, og indsætter et events start og slut tidspunkt
        return "\n" + "Arrangementnavn: " + arrangementNavn + ". \n" + "Kundes email: " + kundeEmail +
                ".\n" + "Kundes telefonnummer: " + kundeTlf + ". \n\n" + "Der er tilknyttet følgende event:" + eventListe
                + "\n" + totalTidOgPris;
    }

}