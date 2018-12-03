import java.util.Scanner;

public class Transport implements EventType {


    public String transportMiddel;
    public double startTidspunkt;
    public double slutTidspunkt;
    public String pickUp;
    public String dropOff;


    public Transport(String transportMiddel, double startTidspunkt, double slutTidspunkt, String pickUp, String dropOff) {

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
        double startTidspunkt = input.nextDouble();
        System.out.print("Slut tidspunkt: ");
        double slutTidspunkt = input.nextDouble();
        System.out.print("Pick Up sted: ");
        System.out.println();
        String pickUp = input.nextLine();
        System.out.println();
        System.out.print("Drop Off sted: ");
        String dropOff = input.nextLine();

        EventType type = new Transport(transportmiddel, startTidspunkt, slutTidspunkt, pickUp, dropOff);
        return type;

    }

    public String toString() {
        return " Transport" + "\n" + "Transportmiddel: " + transportMiddel + "\n" + "Afhentningstidspunkt: " + startTidspunkt + "\n"+
                "Drop Off tidspunkt: " + dropOff + "\n" + " Afhentningssted: " + pickUp + "\n" +
                "Drop Off sted: " + dropOff;
    }

}

