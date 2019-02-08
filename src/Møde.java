import java.util.Scanner;

public class Møde implements EventType {

    private String udstyr;

    public Møde(String udstyr){

        this.udstyr=udstyr;
    }

    public Møde()
    {

    }

    public EventType tilføjEventType()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Hvilket udstyr skal bookes: ");
        String udstyr = input.nextLine();

        EventType type = new Møde(udstyr);
        return type;// i stedet for at oprette et objekt af Møde, kan vi via vores interface som møde implementerer oprette et objekt af EventType,
        // og tilføje Møde parameterer, dette kan vi returnere som en eventType som vi kalder type
    }

    public String toString()
    {
        return " Møde" + "\n" + "Udstyr: " + udstyr;
    }
    // skriver objekt ud som en String, hvis man ikke har toString, så skrives objektet ud som en "adresse".



}
