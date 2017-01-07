package main;

import agh.cs.sejm.ExpensesAnaliser;
import agh.cs.sejm.JasonDownloader;

import java.io.IOException;

/**
 * Created by Joanna on 2016-12-16.
 */
public class SejmSystem {
    public static void main(String[] args) {

        try {
            //ArgumentsParser parser = new ArgumentsParser();
            //int result = parser.parseArguments(args);
            //argumentu o nr kadencji i ewentualnego imienia i naziwka nie parsujemy -> prosto z args
            //gdy imie i nazwisko potem sprawdzić, po wczytaniu czy istnieje i ewentualnie wyrzucić błąd
            //result ma inf o tym ktora funkcje bd realizować

            final long startTime = System.currentTimeMillis();

            JasonDownloader jasonDownloader = new JasonDownloader();
            jasonDownloader.initializePoliticians();

            ExpensesAnaliser a = new ExpensesAnaliser();

            System.out.print(a.politicianExpenses("Maks", "Kraczkowski", 7, jasonDownloader.politiciansSet) + "\n");
            System.out.print(a.averageOfPoliticiansExpenses(jasonDownloader.politiciansSet,7) + "\n" );
            System.out.print(a.pettyExpenses("Piotr", "Szeliga", 7, jasonDownloader.politiciansSet));

            final long endTime = System.currentTimeMillis();

            System.out.println(endTime-startTime);
        }catch (IllegalArgumentException ex){
            System.out.print(ex.getMessage());

        } catch (IOException e) {
            System.out.print("Wystąpił problem z wczytaniem pliku.   " + e.getMessage());
        }


    }


}
