import java.util.Scanner;

public class Transport implements EventType {


    public String transportMiddel;
    public String startTidspunkt;
    public String slutTidspunkt;
    public String pickUp;
    public String dropOff;
    
    public Transport(String transportMiddel, String startTidspunkt, String slutTidspunkt, String pickUp, String dropOff) {

        this.transportMiddel = transportMiddel;
        this.startTidspunkt = startTidspunkt;
        this.slutTidspunkt = slutTidspunkt;
        this.pickUp = pickUp;
        this.dropOff = dropOff;
    }

    public Transport() {

    }

    public EventType tilføjEventType() {
        Scanner input = new Scanner(System.in);

        System.out.print("Transportmiddel: ");
        String transportmiddel = input.nextLine();
        System.out.print("Start tidspunkt: ");
        String startTidspunkt = input.nextLine();
        System.out.print("Slut tidspunkt: ");
        String slutTidspunkt = input.nextLine();
        System.out.print("Pick Up sted: ");
        System.out.println();
        String pickUp = input.nextLine();
        System.out.println();
        System.out.print("Drop Off sted: ");
        String dropOff = input.nextLine();

        EventType type = new Transport(transportmiddel, startTidspunkt, slutTidspunkt, pickUp, dropOff);
        return type; // i stedet for at oprette et objekt af Transport, kan vi via vores interface som transport implementerer oprette et objekt af EventType,
        // og tilføje Transports parameterer, dette kan vi returnere som en eventType som vi kalder type

    }

    public String toString() { // skriver objekt ud som en String, hvis man ikke har toString, så skrives objektet ud som en "adresse".
        return " Transport" + "\n" + "Transportmiddel: " + transportMiddel + "\n" + "Afhentningstidspunkt: " + startTidspunkt + "\n"+
                "Drop Off tidspunkt: " + dropOff + "\n" + " Afhentningssted: " + pickUp + "\n" +
                "Drop Off sted: " + dropOff;
    }

}

