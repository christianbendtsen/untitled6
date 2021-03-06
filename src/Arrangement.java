import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Arrangement {

    private String arrangementNavn;
    private String totalTidOgPris;
    private String kundeEmail;
    private String kundeTlf;
    private Event event = new Event();
    private LocalDateTime eventStart;
    private LocalDateTime eventSlut;
    private ArrayList<Event> eventListe = new ArrayList<Event>();


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
        eventStart = eventListe.get(0).getStartTidspunkt(); // læser plads nummer 0 i arrylisten eventListe

        return eventStart;
    }
    //læser det sidste tilknyttede events sluttidspunkt fra Arraylisten eventliste - skal bruges til at regne total tid og pris ud
    public LocalDateTime getEventSlut (ArrayList<Event> eventListe)
    {

        for (int i=0; i<eventListe.size(); i++) { // så længe i er mindre en længden på arrylisten eventListe looper den
            eventSlut = eventListe.get(i).getSlutTidspunkt(); // returnere det sidste sluttidspunkt

        }
        return eventSlut;
    }
    public void opretArrangement()
    {
        Scanner console = new Scanner(System.in);

        System.out.println("**Udfyld data for nyt arrangement**");
        System.out.println("Angiv navn på fil efterfulgt af et .txt");
        String filepath = console.nextLine();
        System.out.println("Angiv navn på ansvarlig faciliator efterfulgt af .txt");
        String filepath1 = console.nextLine();
        System.out.print("Navn på arrangementet: ");
        System.out.println();
        String arrangementNavn = console.nextLine();
        System.out.print("Kundes Email: ");
        System.out.println();
        String kundeEmail = console.nextLine();
        System.out.print("Kundes telefonnummer: ");
        String kundeTlf =  console.nextLine();
        System.out.println("**Tilføj event 1=ja, 2=nej**");
        int valg = console.nextInt();
        while(valg==1) {
            eventListe.add(event.tilføjEvent()); // Bliver tilføjet til arraylisten eventListe
            System.out.println("**Tilføj event 1=ja, 2=nej**");
            valg = console.nextInt();
        }


        Arrangement arrangement = new Arrangement(arrangementNavn, kundeEmail, kundeTlf, eventListe);
        System.out.println("**Følgende Arrangement er oprettet**");
        System.out.println(arrangement);

        try {
            FileWriter fw = new FileWriter(filepath,true); // opretter et objekt, sætter append true, så vi kan tilføje til filen.
            BufferedWriter bw = new BufferedWriter(fw); // sørger for at det bliver skrevet pænest muligt
            PrintWriter pw = new PrintWriter(bw); // giver adgang til syntaks så vi kan printe

            pw.println(arrangement); // printer hele arrangememtet i en TXT fil
            pw.flush(); // sørger for at alt er skrevet til filen
            pw.close(); // lukker filen

            JOptionPane.showMessageDialog(null, "saved"); // Swing bliver importeret, og en dialog boks kommer frem på skærmen med teksten "saved"
        }
        catch (Exception E)
        {
            JOptionPane.showMessageDialog(null, " not saved");

        }

        try {
            FileWriter fw1 = new FileWriter(filepath1,true);
            BufferedWriter bw1 = new BufferedWriter(fw1);
            PrintWriter pw1 = new PrintWriter(bw1);

            pw1.println(arrangement);
            pw1.flush();
            pw1.close();

            JOptionPane.showMessageDialog(null, "saved");
        }
        catch (Exception E)
        {
            JOptionPane.showMessageDialog(null, " not saved");

        }

    }
    public static String totalTidOgPris(LocalDateTime eventStart, LocalDateTime eventSlut)
    {
        long totalTid = Math.abs(Duration.between(eventSlut,eventStart).toMinutes());//finder forskellen på et events start- og sluttidspunkt i minutter
        long totalDage =totalTid/(24 * 60);//finder antal dage ud fra ovenstående forskel i minutter
        long totalTimer= (totalTid/60)-(totalDage*24); //finder antal timer ud fra ovenstående forskel i minutter, fratrukket antal dage
        long totalMinutter = totalTid-(totalTimer*60)-(totalDage*24*60);//finder antal minutter ud fra ovenstående forskel fratrukket dage og timer

        long totalTidIHalveTimer = totalTid/30;//finder antal halve timer ud fra den samlede forskel i minutter - pris for arrangement betales pr. halve timer

        long totalPris;
        //regner prisen for at arrangement ud - én pris for hverdage og én pris for weekend
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
    public String toString() // skriver arrangement objekt ud som en String, hvis man ikke har toString, så skrives arrangement ud som en "adresse".
    {
        totalTidOgPris = totalTidOgPris(getEventStart(eventListe), getEventSlut(eventListe));//kalder metoden overnfor for tid og pris, og indsætter et events start og slut tidspunkt
        return "\n" + "Arrangementnavn: " + arrangementNavn + ". \n" + "Kundes email: " + kundeEmail +
                ".\n" + "Kundes telefonnummer: " + kundeTlf + ". \n\n" + "Der er tilknyttet følgende event:" + eventListe
                + "\n" + totalTidOgPris;
    }

}