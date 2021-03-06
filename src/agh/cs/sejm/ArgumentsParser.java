package agh.cs.sejm;

import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Joanna on 2016-12-15.
 */
public class ArgumentsParser {

    private JasonDownloader jasonDownloader;
    private ExpensesAnaliser expensesAnaliser;
    private TravelAnalyser travelAnalyser;



    public void parseArguments(String[] args) throws IOException {
        if (args.length == 1 && args[0].equals("actualize")){
                jasonDownloader = new JasonDownloader();
                jasonDownloader.actualizePolitisians();
                System.out.println("Zaktualizowano pliki na dysku.");
        }
        if (args.length == 4 || args.length ==2 || args.length == 3) {

            if (Integer.parseInt(args[0]) != 7 && Integer.parseInt(args[0]) !=8) throw new IllegalArgumentException(args[0] + "Podałeś nieprawidłowy numer kadencji.");
            else {
                jasonDownloader = new JasonDownloader();
                jasonDownloader.initializePoliticians(Boolean.FALSE);
                expensesAnaliser = new ExpensesAnaliser();
                travelAnalyser = new TravelAnalyser();
            }

            if (args.length == 4){
                // gdy mamy imię i nazwisko
                switch (args[3]){
                    case "all":
                        System.out.println(this.expensesAnaliser.politicianExpenses(args[1], args[2],Integer.parseInt(args[0]), jasonDownloader.politiciansSet).toString());
                        break;
                    case "small":
                        System.out.println(this.expensesAnaliser.pettyExpenses(args[1], args[2],Integer.parseInt(args[0]), jasonDownloader.politiciansSet).toString());
                        break;
                    default:
                        throw new IllegalArgumentException(args[3] + "   Dla konkrentego posła można podać tylko wszystkie lub drobne wydatki.");
                }
            }
            else if(args.length == 2)  {
                //nie mamy konkretnego posła tylko ogolne
                switch (args[1]) {
                    case "avg":
                       System.out.println(this.expensesAnaliser.averageOfPoliticiansExpenses(jasonDownloader.politiciansSet,Integer.parseInt(args[0])));
                        break;
                    case "traveller":
                        System.out.println(this.travelAnalyser.theBiggestAbroadTraveller(Integer.parseInt(args[0]), jasonDownloader.politiciansSet ));
                        break;
                    case "longestTimeAbroad":
                        System.out.println(this.travelAnalyser.theLongestAbroadTraveler(Integer.parseInt(args[0]), jasonDownloader.politiciansSet ));
                        break;
                    case "expensiveAbroad":
                        System.out.println(this.travelAnalyser.mostExpensiveTravel(Integer.parseInt(args[0]), jasonDownloader.politiciansSet ));
                        break;
                    case "italy":
                        
                        LinkedList<Politicians> result = travelAnalyser.italyTravelers(8,jasonDownloader.politiciansSet);
                        for (int i=0; i < result.size(); i++) {
                            System.out.println(result.get(i).getData().getFirstName() + result.get(i).getData().getLastName());
                            //System.out.println(result.get(i).getData().getLastName());
                        }
                        break;
                    default:
                        throw new IllegalArgumentException(args[1] + "Podałeś nieprawidłowe argumenty.");
                }
            }
        }else
            throw new IllegalArgumentException("Podano niewłasciwą ilość argumentów");
        }
}
