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
        return type;
    }

    public String toString()
    {
        return " Møde" + "\n" + "Udstyr: " + udstyr;
    }



}
