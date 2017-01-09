package agh.cs.sejm;

/**
 * Created by Joanna on 2016-12-15.
 */
public class ArgumentsParser {
//todo 7 jako aktualizacja plików
    public int parseArguments(String[] args) {
        int result=-1;
        if (args.length <= 4 && args.length >=2 ) {
            if (args.length == 4){
                // gdy mamy imię i nazwisko
                switch (args[3]){
                    case "all":
                        result = 0;
                        break;
                    case "minorExpenses":
                        result = 1;
                        break;
                    default:
                        throw new IllegalArgumentException(args[3] + "Dla konkrentego posła można podać tylko wszystkie lub drobne wydatki.");
                }
            }
            else {
                //nie mamy konkretnego posła tylko ogolne
                switch (args[1]) {
                    case "avg":
                        result = 2;
                        break;
                    case "traveller":
                        result = 3;
                        break;
                    case "longestTimeAbroad":
                        result = 4;
                        break;
                    case "expensiveAbroad":
                        result = 5;
                        break;
                    case "italy":
                        result = 6;
                        break;
                    default:
                        throw new IllegalArgumentException(args[1] + "Podałeś nieprawidłowe argumenty.");
                }
            }
        }else
            throw new IllegalArgumentException("Podano niewłasciwą ilość argumentów");

        return result;}

}
