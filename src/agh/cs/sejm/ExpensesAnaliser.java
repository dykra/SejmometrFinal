package agh.cs.sejm;

import java.math.BigDecimal;

/**
 * Created by Joanna on 2017-01-07.
 */
public class ExpensesAnaliser {
    //klasa wyliczająca dane dotyczące wydatków
    //todo zbyt duza "doklasnosc"
    //todo za duza srednia wydatków dla posłów!!!!!!!!!!!!!!!!!!
    //zaokrąglanie wyniku albo znależć czemu odczytuje zbyt dużą wartość


    public Double averageOfPoliticiansExpenses(PoliticiansSet politiciansSet, int term) {

        if (term != 7 && term != 8) {
            throw new IllegalArgumentException("Program wylicza dane tylko dla VII lub VIII kadencji. " + term);
        }
        Double average = new Double(0);
        boolean isTerm7 = false;
        if (term == 7) isTerm7 = true;
        int i = 0;
        int a = 0, b=0, c  =0, d=0;
        for (Politicians politician : politiciansSet.getPolitisians()) {
            if ((politician.isTerm7() && isTerm7)
                    || (!isTerm7 && politician.isTerm8())) {
                i++;
                for (Rocznik rocznik : politician.getLayers().getExpenses().getRoczniki()) {
/*
                    if (belongTo7thTerm(rocznik.getRok()) && isTerm7) {
                        average = sumExpensesFromThisYear(rocznik, average);
                    }
                    if (!belongTo7thTerm(rocznik.getRok()) && !isTerm7) {
                        average = sumExpensesFromThisYear(rocznik, average);
                    }*/
if(politician.isTerm7() && isTerm7)
                    for (Double expense : rocznik.getPola()) {
                        average += expense;
                    }
                }
            }
        }
        System.out.println(average);
        if (i > 0) average /= i;
        return average;
    }

    public Double pettyExpenses(String firstname, String lastname, int term, PoliticiansSet politiciansSet) {
        if (term != 7 && term != 8) {
            throw new IllegalArgumentException("Program wylicza dane tylko dla VII i VIII kadencji. " + term);
        }
        Double expenses = new Double(0);
        boolean isTerm7 = false;
        if (term == 7) isTerm7 = true;

        Politicians wantedPolitician = null;
        for (Politicians politician : politiciansSet.getPolitisians()) {
            if (canWeTakeThisEnvoy(politician,isTerm7,firstname,lastname)) {
                wantedPolitician = politician;
            }
        }
        if (wantedPolitician == null) {
            throw new IllegalArgumentException(firstname + " " + lastname + "  Wybrany polityk nie istnieje");
        }

        for (Rocznik rocznik : wantedPolitician.getLayers().getExpenses().getRoczniki()) {

            if (belongTo7thTerm(rocznik.getRok()) && isTerm7) {
                expenses = sumPettyExpenses(rocznik, expenses);
            }
            if (!belongTo7thTerm(rocznik.getRok()) && !isTerm7) {
                expenses = sumPettyExpenses(rocznik, expenses);
            }
        }
        return expenses;
    }

    private Double sumPettyExpenses(Rocznik rocznik, double expenses) {

        return expenses += rocznik.getPola().get(12);
    }


    //suma wydatków posła/posłanki o określonym imieniu i nazwisku
    public Double politicianExpenses(String firstname, String lastname, int term, PoliticiansSet politiciansSet) {
        if (term != 7 && term != 8) {
            throw new IllegalArgumentException("Program wylicza dane tylko dla VII i VIII kadencji. " + term);
        }
        Double expenses = new Double(0);
        boolean isTerm7 = false;
        if (term == 7) isTerm7 = true;
        //szukamy posła który nas interesuje
        Politicians wantedPolitician = null;
        for (Politicians politician : politiciansSet.getPolitisians()) {
            if (canWeTakeThisEnvoy(politician,isTerm7,firstname,lastname)) {
                wantedPolitician = politician;
            }
        }
        if (wantedPolitician == null) {
            throw new IllegalArgumentException(firstname + " " + lastname + "  Wybrany polityk nie istnieje");
        }

        //teraz liczymy wydatki tego polityka w kadencji term
        for (Rocznik rocznik : wantedPolitician.getLayers().getExpenses().getRoczniki()) {

            if (belongTo7thTerm(rocznik.getRok()) && isTerm7) {
                expenses = sumExpensesFromThisYear(rocznik, expenses);
            }
            if (!belongTo7thTerm(rocznik.getRok()) && !isTerm7) {
                expenses = sumExpensesFromThisYear(rocznik, expenses);
            }
        }
        return expenses;
    }

    private Double sumExpensesFromThisYear(Rocznik rocznik, Double expenses) {
        Double result = expenses;
        for (Double expense : rocznik.getPola()) {
            result += expense;
        }
        return result;
    }

    private boolean belongTo7thTerm(String stringYear) {
        int year = Integer.parseInt(stringYear);
        if (year <= 2015) return true;
        return false;
    }


    private boolean canWeTakeThisEnvoy(Politicians politician, boolean isTerm7, String firstname, String lastname) {

        return (politician.isTerm7() && isTerm7 && firstname.equals(politician.getData().getFirstName()) && lastname.equals(politician.getData().getLastName()))
                || (!isTerm7 && !politician.isTerm7() && firstname.equals(politician.getData().getFirstName()) && lastname.equals(politician.getData().getLastName()));
    }
}
