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
    }

    public String toString()
    {
        return " Udflugt" + "\n" + "Lokation: " + lokation;
    }
}
