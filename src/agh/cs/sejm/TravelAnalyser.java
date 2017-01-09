package agh.cs.sejm;

import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Joanna on 2017-01-07.
 */
public class TravelAnalyser {
    //TODO uwzględnić w kazdej metodzie czas trwania podrozy i kadencję

    //TODO posła/posłanki, który wykonał najwięcej podróży zagranicznych

    //TODO posła/posłanki, który najdłużej przebywał za granicą NIE DZIALA
    public String theLongestTraveler(int term, PoliticiansSet politiciansSet){
        if (term != 7 && term != 8) {
            throw new IllegalArgumentException("Program wylicza dane tylko dla VII i VIII kadencji. " + term);
        }
        boolean isTerm7 = false;
        if (term == 7) isTerm7 = true;
        String result = "";

        int currentTime = 0;
        int longestTime = 0;

        for (Politicians politician : politiciansSet.getPolitisians()) {
            if ((politician.isTerm7() && isTerm7)
                    || (!isTerm7 && politician.isTerm8())) {
                for (Map<String, String> travel : politician.getLayers().getTravels()) {
                     if (!travel.get("country_code").equals("PL")) {
                         currentTime += Integer.parseInt(travel.get("liczba_dni"));
                    }
                }
                if (currentTime > longestTime) {
                    longestTime = 0;
                    result = politician.getData().getFirstName() +" "+ politician.getData().getLastName();
                }
                currentTime = 0;
            }
        }
        if (result.equals("")) result = "Nie ma polityka który podróżowałby za granice w tej kadencji.";

    return result;}


    public String mostExpensiveTravel (int term, PoliticiansSet politiciansSet){
        if (term != 7 && term != 8) {
            throw new IllegalArgumentException("Program wylicza dane tylko dla VII i VIII kadencji. " + term);
        }
        boolean isTerm7 = false;
        if (term == 7) isTerm7 = true;
        String result = "";
        Double cost = new Double(0);
        for (Politicians politician : politiciansSet.getPolitisians()) {
            if ((politician.isTerm7() && isTerm7)
                    || (!isTerm7 && politician.isTerm8())) {
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


    //--------------------------------------------
    public LinkedList<Politicians> italyTravelers (int term, PoliticiansSet politiciansSet){
        if (term != 7 && term != 8) {
            throw new IllegalArgumentException("Program wylicza dane tylko dla VII i VIII kadencji. " + term);
        }
        boolean isTerm7 = false;
        if (term == 7) isTerm7 = true;

        LinkedList<Politicians> result = new LinkedList<>();
        for (Politicians politician : politiciansSet.getPolitisians()){
            if ((politician.isTerm7() && isTerm7)
                    || (!isTerm7 && politician.isTerm8())){
                for (Map<String, String> map : politician.getLayers().getTravels()){
                    if (map.get("country_code").equals("IT")){
                        result.add(politician);
                        break;
                    }
                }
            }
        }
    return result;}
}
