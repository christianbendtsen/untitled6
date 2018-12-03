import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        StartMenu startMenu = new StartMenu();
        Personale.addDummyDataPersonale();
        startMenu.validerBruger();

        Arrangement a = new Arrangement();

    }
}
