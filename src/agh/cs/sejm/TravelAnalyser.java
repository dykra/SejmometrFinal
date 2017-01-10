package agh.cs.sejm;

import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Joanna on 2017-01-07.
 */
public class TravelAnalyser extends Analiser{


    public String theBiggestAbroadTraveller(int term, PoliticiansSet politiciansSet){
        boolean isTerm7 = is7thTermandSetTerms(term);
        String result = "";

        int currentAmountofAbroadTravels = 0;
        int maxAmountOfAbroadTravels = 0;

        for (Politicians politician : politiciansSet.getPolitisians()) {
            if (isPoliticiansTermCorrect(isTerm7, politician)) {
                for (Map<String, String> travel : politician.getLayers().getTravels()) {
                    if (!travel.get("country_code").equals("PL")) {
                        currentAmountofAbroadTravels ++;
                    }
                }
                if (currentAmountofAbroadTravels >= maxAmountOfAbroadTravels) {
                    maxAmountOfAbroadTravels = currentAmountofAbroadTravels;
                    result = politician.getData().getFirstName() +" "+ politician.getData().getLastName();
                }
                currentAmountofAbroadTravels = 0;
            }
        }
        if (result.equals("")) result = "Nie ma polityka który podróżowałby za granice w tej kadencji.";

        return result;}



    public String theLongestAbroadTraveler(int term, PoliticiansSet politiciansSet){
        boolean isTerm7 = is7thTermandSetTerms(term);
        String result = "";

        int currentTime = 0;
        int longestTime = 0;

        for (Politicians politician : politiciansSet.getPolitisians()) {
            if (isPoliticiansTermCorrect(isTerm7, politician)) {
                for (Map<String, String> travel : politician.getLayers().getTravels()) {
                     if (!travel.get("country_code").equals("PL")) {
                         currentTime += Integer.parseInt(travel.get("liczba_dni"));
                    }
                }
                if (currentTime >= longestTime) {
                    longestTime = currentTime;
                    result = politician.getData().getFirstName() +" "+ politician.getData().getLastName();
                }
                currentTime = 0;
            }
        }
        if (result.equals("")) result = "Nie ma polityka który podróżowałby za granice w tej kadencji.";

    return result;}

    //--------------------------------------------
    public String mostExpensiveTravel (int term, PoliticiansSet politiciansSet){

        boolean isTerm7 = is7thTermandSetTerms(term);

        String result = "";
        Double cost = new Double(0);
        for (Politicians politician : politiciansSet.getPolitisians()) {
            if (isPoliticiansTermCorrect(isTerm7, politician)) {
                for (Map<String, String> travel : politician.getLayers().getTravels()) {
                    if (!travel.get("country_code").equals("PL")) {
                        Double result2 = Double.parseDouble(travel.get("koszt_suma"));
                        if (result2 > cost) {
                            cost = Double.parseDouble(travel.get("koszt_suma"));
                            result = politician.getData().getFirstName() + " " + politician.getData().getLastName();
                        }
                    }
                }
            }
            if (result.equals("")) result = "Nie ma polityka który podróżowałby za granice w tej kadencji.";
        }
    return result;}


    public LinkedList<Politicians> italyTravelers (int term, PoliticiansSet politiciansSet){

        boolean isTerm7 = is7thTermandSetTerms(term);

        LinkedList<Politicians> result = new LinkedList<>();
        for (Politicians politician : politiciansSet.getPolitisians()){
            if (isPoliticiansTermCorrect(isTerm7, politician)){
                for (Map<String, String> map : politician.getLayers().getTravels()){
                    if (map.get("country_code").equals("IT")){
                        result.add(politician);
                        break;
                    }
                }
            }
        }
    return result;}

    private boolean isPoliticiansTermCorrect(boolean isTerm7, Politicians politician){
        return (politician.isTerm7() && isTerm7)
                || (!isTerm7 && politician.isTerm8());
    }
}
