import java.util.ArrayList;
import java.util.Scanner;

public class Sekretær {
    private String Arrangementnavn;
    private double Pris;

    public Sekretær(){
    }

    public void ArrangementListe() {
        System.out.println("You know nothing Jon Snow");
        StartMenu.validerBruger();
    }

    public void opretArrangement() {
        //Arrangement.
    }

    public void sletArrangement() {
    }

    public void redigerArrangement() {
    }

    public static void SekretærMenu(){
        Scanner console = new Scanner (System.in);
        System.out.println("Velkommen Sekretær");
        System.out.println("Vælg følgende handling: ");
        System.out.println("1. Book Arrangement:");
        Arrangement a = new Arrangement();
        a.opretArrangement();

    }
}

