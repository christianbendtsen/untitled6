import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Event {
    private String navn;
    private int pris = 100;
    private String beskrivelse;
    private LocalDateTime startTidspunkt;
    private LocalDateTime slutTidspunkt;
    private String facilitator;
    private EventType type;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy,HH:mm"); // den der definerer hvilket format dato og tid skal skrives ind, for at kunne parse bruger input til localDateTime  objekt


    Transport transport = new Transport();
    Møde møde = new Møde();
    Udflugt udflugt = new Udflugt();

    public Event(String navn, String beskrivelse, int pris, LocalDateTime startTidspunkt, LocalDateTime slutTidspunkt, String facilitator, EventType type) {
        this.navn = navn;
        this.pris = pris;
        this.beskrivelse = beskrivelse;
        this.startTidspunkt=startTidspunkt;
        this.slutTidspunkt=slutTidspunkt;
        this.facilitator=facilitator;
        this.type = type;
    }

    public Event() {

    }

    public LocalDateTime getStartTidspunkt()
    {
        return startTidspunkt;
    }

    public LocalDateTime getSlutTidspunkt()
    {

        return slutTidspunkt;
    }

    public Event tilføjEvent() {
        Scanner console = new Scanner(System.in);

        System.out.print("Eventnavn: ");
        System.out.println();
        String navn = console.nextLine();
        System.out.print("Uddybende beskrivelse: ");
        System.out.println();
        String beskrivelse = console.nextLine();

        System.out.print("Starttidspunkt - dato og klokkeslet (dd.MM.åååå,TT:mm): ");
        LocalDateTime startTidspunkt;
        while (true){

            try{
                startTidspunkt = LocalDateTime.parse(console.next(), formatter); // parser bruger input
                break;
            }

            catch(DateTimeParseException e){

                System.out.print("Skriv venligst dato og klokkelset i følgende format: dd.MM.åååå,TT:mm "); // hvis det ikke kan parses
                console.nextLine();
            }
        }
        System.out.print("Sluttidspunkt - dato og klokkeslet (dd.MM.åååå,TT:mm): ");
        LocalDateTime slutTidspunkt;
        while (true){

            try{
                slutTidspunkt = LocalDateTime.parse(console.next(), formatter);
                break;
            }

            catch(DateTimeParseException e){

                System.out.print("Skriv venligst dato og klokkelset i følgende format: dd.MM.åååå,TT:mm ");
                console.nextLine();
            }
        }
        System.out.print("Ansvarlig facilitator: ");
        String facilitator = console.next();
        System.out.println("** Vælg eventtype **");
        System.out.println("** transport = 1, møde = 2, udflugt = 3 **");
        int typeValg = console.nextInt();
        EventType eventType = null;
        if (typeValg==1)
        {
            eventType = transport.tilføjEventType(); // 1 betyder at eventType = transport + metoden tilføjEventType(fra vores eventType interface)
        }
        else if (typeValg == 2)
        {
            eventType = møde.tilføjEventType(); // metoden tilføjEventType returnerer et objekt af eventType, i både transport, møde og udflugt(med forskellige parameterer)
        }
        else if (typeValg==3)
        {
            eventType = udflugt.tilføjEventType();
        }
        else {
            System.out.print("Vælg eventtype: transport = 1, møde = 2, udflugt = 3");
        }

        Event event = new Event(navn, beskrivelse, pris, startTidspunkt, slutTidspunkt, facilitator, eventType);
        return event; // bruges i arrangement hvor det gemmes i en arrayliste

    }

    public String toString() { // skriver  objekt ud som en String, hvis man ikke har toString, så skrives objektet ud som en "adresse".
        return "\n" + "Eventnavn: " + navn + " \n" + "Eventbeskrivelse: " + beskrivelse + " \n" +
                "Startpris: " + pris + "\n" + "Startdato og tid: " + startTidspunkt + "\n" + "Slutdato og tid: " + slutTidspunkt + "\n" +
                "Ansvarlig facilitator: " + facilitator + "\n" + "EventType: " + type;
    }

}
