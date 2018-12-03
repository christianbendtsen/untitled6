import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Event {
    Sekretær sekretær = new Sekretær(); //bruger vi på linje 86
    Transport t = new Transport();
    private String navn;
    private int pris = 100;
    private String beskrivelse;
    private String startDato;
    private String slutDato;
    private double tidStart;
    private double tidSlut;
    private String facilitator;
    private EventType type;




    Transport transport = new Transport();
    Møde møde = new Møde();
    Udflugt udflugt = new Udflugt();

    public Event(String navn, String beskrivelse, int pris, String startDato, String slutDato, double tidStart, double tidSlut, String facilitator, EventType type) {
        this.navn = navn;
        this.pris = pris;
        this.beskrivelse = beskrivelse;
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.tidStart = tidStart;
        this.tidSlut = tidSlut;
        this.facilitator=facilitator;
        this.type = type;
    }

    public Event() {

    }

    public Event tilføjEvent() {
        Scanner console = new Scanner(System.in);

        System.out.print("Eventnavn: ");
        System.out.println();
        String navn = console.nextLine();
        System.out.print("Uddybende beskrivelse: ");
        System.out.println();
        String beskrivelse = console.nextLine();

        System.out.println("Startdato for Event (dd.MM.yyyy): ");
        System.out.println();
        String startDato = console.nextLine();
        System.out.print("Slutdato for Event (dd.MM.yyyy): ");
        System.out.println();
        String slutDato = console.nextLine();
        System.out.print("Starttid: ");
        double tidStart = console.nextDouble();
        System.out.print("Sluttid: ");
        double tidSlut = console.nextDouble();
        System.out.print("Ansvarlig facilitator: ");
        String facilitator = console.next();
        System.out.println("** Vælg eventtype **");
        System.out.println("** transport = 1, møde = 2, udflugt = 3 **");
        int typeValg = console.nextInt();
        EventType e = null;
        if (typeValg==1)
        {
            e = transport.tilføjEventType();
        }
        else if (typeValg == 2)
        {
            e = møde.tilføjEventType();
        }
        else if (typeValg==3)
        {
            e = udflugt.tilføjEventType();
        }
        else {
            System.out.print("Vælg eventtype: transport = 1, møde = 2, udflugt = 3");
        }

        /*try {
            FileWriter fw = new FileWriter(filepath,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(navn+ ","+ pris+ ","+ beskrivelse+ ","+ startDato+ ","+ slutDato+ ","+ tidStart+ ","+ tidSlut+ ","+ facilitator+","+ type+",");
            pw.flush();
            pw.close();

            JOptionPane.showMessageDialog(null, "saved");
        }
        catch (Exception E)
        {
            JOptionPane.showMessageDialog(null, " not saved");

        }*/



        Event event = new Event(navn, beskrivelse, pris, startDato, slutDato, tidStart, tidSlut, facilitator, e);
        return event;




    }

    public String toString() {
        return "\n" + "Eventnavn: " + navn + " \n" + "Eventbeskrivelse: " + beskrivelse + " \n" +
                "Pris: " + pris + "\n" + "Startdato: " + startDato + "\n" + "Slutdato: " + slutDato + "\n" +
                "Start tid: " + tidStart + ". \n" + "Slut tid: " + tidSlut + "\n" +
                "Ansvarlig facilitator: " + facilitator + "\n" + "EventType: " + type;
    }
}
