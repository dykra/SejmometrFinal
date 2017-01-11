package agh.cs.sejm;

import static java.lang.StrictMath.round;

/**
 * Created by Joanna on 2017-01-07.
 */
public class ExpensesAnaliser extends Analiser{
    //klasa wyliczająca dane dotyczące wydatków

    public double averageOfPoliticiansExpenses(PoliticiansSet politiciansSet, int term) {
        //Double average = new Double(0);
double average = 0;
        boolean isTerm7 = is7thTermandSetTerms(term);
        int i = 0;
        for (Politicians politician : politiciansSet.getPolitisians()) {
            if ((politician.isTerm7() && isTerm7)
                    || (!isTerm7 && politician.isTerm8())) {
                i++;
                for (Yearbook yearbook : politician.getPoliticiansYearbooks()) {

                    if (isYearIn7thTerm(yearbook.getRok()) && isTerm7) {
                        average += yearbook.sumExpensesFromThisYear().doubleValue();
                    }
                    if (!isYearIn7thTerm(yearbook.getRok()) && !isTerm7) {
                        average += yearbook.sumExpensesFromThisYear().doubleValue();
                    }
                }
            }
        }

        if (i != 0) average /= i;

        average *=100;
        average = round(average);
        average/=100;
        return average;
    }


    public Double pettyExpenses(String firstname, String lastname, int term, PoliticiansSet politiciansSet) {
        boolean isTerm7 = is7thTermandSetTerms(term);
        Double expenses = new Double(0);

        Politicians wantedPolitician = giveWantedPolitician(firstname, lastname,term, politiciansSet,isTerm7);

        if (wantedPolitician == null) {
            throw new IllegalArgumentException(firstname + " " + lastname + "  Wybrany polityk nie istnieje");
        }

        for (Yearbook yearbook : wantedPolitician.getPoliticiansYearbooks()) {

            if (isYearIn7thTerm(yearbook.getRok()) && isTerm7) {
                expenses = sumPettyExpenses(yearbook, expenses);
            }
            if (!isYearIn7thTerm(yearbook.getRok()) && !isTerm7) {
                expenses = sumPettyExpenses(yearbook, expenses);
            }
        }
        return expenses;
    }


    //suma wydatków posła/posłanki o określonym imieniu i nazwisku
    public Double politicianExpenses(String firstname, String lastname, int term, PoliticiansSet politiciansSet) {

        Double expenses = new Double(0);
        boolean isTerm7 = is7thTermandSetTerms(term);
        //szukamy posła który nas interesuje
        Politicians wantedPolitician = giveWantedPolitician(firstname,lastname,term,politiciansSet,isTerm7);
        if (wantedPolitician == null) {
            throw new IllegalArgumentException(firstname + " " + lastname + "  Wybrany polityk nie istnieje");
        }

        for (Yearbook yearbook : wantedPolitician.getPoliticiansYearbooks()) {

            if (isYearIn7thTerm(yearbook.getRok()) && isTerm7) {
                expenses += yearbook.sumExpensesFromThisYear();
            }
            if (!isYearIn7thTerm(yearbook.getRok()) && !isTerm7) {
                expenses += yearbook.sumExpensesFromThisYear();
            }
        }
        return expenses;
    }


    private boolean isYearIn7thTerm(String stringYear) {
        int year = Integer.parseInt(stringYear);
        if (year <= 2015) return true;
        return false;
    }


    private boolean canWeTakeThisEnvoy(Politicians politician, boolean isTerm7, String firstname, String lastname) {
        return (politician.isTerm7() && isTerm7 && firstname.equals(politician.getData().getFirstName()) && lastname.equals(politician.getData().getLastName()))
                || (!isTerm7 && !politician.isTerm7() && firstname.equals(politician.getData().getFirstName()) && lastname.equals(politician.getData().getLastName()));
    }

    private Double sumPettyExpenses(Yearbook yearbook, double expenses) {
        return expenses += yearbook.getFields().get(12);
    }

    private Politicians giveWantedPolitician(String firstname, String lastname, int term, PoliticiansSet politiciansSet, boolean isTerm7){
        Politicians wantedPolitician = null;
        for (Politicians politician : politiciansSet.getPolitisians()) {
            if (canWeTakeThisEnvoy(politician,isTerm7,firstname,lastname)) {
                wantedPolitician = politician;
            }
        }
        return wantedPolitician;
    }

}
