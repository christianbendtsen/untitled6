import java.util.Scanner;

public class Udflugt implements EventType {

    private String lokation;

    public Udflugt(String lokation)
    {

        this.lokation=lokation;
    }

    public Udflugt()
    {

    }

    public EventType tilføjEventType()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Lokation for udflugt: ");
        String lokation = input.nextLine();

        EventType type = new Udflugt(lokation);
        return type;
        // i stedet for at oprette et objekt af Udflugt, kan vi via vores interface som udflugt implementerer oprette et objekt af EventType,
        // og tilføje Udflugt parameterer, dette kan vi returnere som en eventType som vi kalder type
    }

    public String toString()
    {
        return " Udflugt" + "\n" + "Lokation: " + lokation;
    } // skriver objekt ud som en String, hvis man ikke har toString, så skrives objektet ud som en "adresse".
}
