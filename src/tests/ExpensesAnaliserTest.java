package tests;

import agh.cs.sejm.*;
import org.junit.Test;
import sun.plugin.javascript.navig4.Layer;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by Joanna on 2017-01-10.
 */
public class ExpensesAnaliserTest {
    @Test
    public void averageOfPoliticiansExpenses() throws Exception {
        ExpensesAnaliser expensesAnaliser = new ExpensesAnaliser();
        PoliticiansSet politiciansSet = new PoliticiansSet();

        LinkedList<Politicians> politicians = new LinkedList<>();
        Politicians politician1 = new Politicians();
        Data data1 = new Data();

        LinkedList<String> terms1 = new LinkedList<>();
        terms1.add("7");
        data1.setTerms(terms1);
        politician1.setData(data1);

        Layers layer1 = new Layers();
        Expenses expenses1 = new Expenses();

        LinkedList<Yearbook> yearbooks1 = new LinkedList<>();
        yearbooks1.add(new Yearbook());
        yearbooks1.get(0).setRok("2012");
        expenses1.setRoczniki(yearbooks1);
        LinkedList<Double> doubleList1 = new LinkedList<>();
        doubleList1.add(0,new Double(2));
        doubleList1.add(1, new Double(3));
        yearbooks1.get(0).setFields(doubleList1);

        expenses1.setRoczniki(yearbooks1);
        layer1.setExpenses(expenses1);
        politician1.setLayers(layer1);

        politicians.add(politician1);



        politiciansSet.setPolitisiansList(politicians);
        double result = 5;
        assertEquals(result,expensesAnaliser.averageOfPoliticiansExpenses(politiciansSet,7),0.01);
    }


    @Test
    public void politicianExpenses() throws Exception {
        ExpensesAnaliser expensesAnaliser = new ExpensesAnaliser();
        PoliticiansSet politiciansSet = new PoliticiansSet();

        LinkedList<Politicians> politicians = new LinkedList<>();
        Politicians politician1 = new Politicians();
        Data data1 = new Data();

        LinkedList<String> terms1 = new LinkedList<>();
        terms1.add("7");
        data1.setTerms(terms1);
        politician1.setData(data1);

        Layers layer1 = new Layers();
        Expenses expenses1 = new Expenses();

        LinkedList<Yearbook> yearbooks1 = new LinkedList<>();
        yearbooks1.add(new Yearbook());
        yearbooks1.get(0).setRok("2012");
        expenses1.setRoczniki(yearbooks1);
        LinkedList<Double> doubleList1 = new LinkedList<>();
        doubleList1.add(0,new Double(2));
        doubleList1.add(1, new Double(3));
        doubleList1.add(2, new Double(8));
        doubleList1.add(3, new Double(3.20));
        doubleList1.add(4, new Double(3.12));
        yearbooks1.get(0).setFields(doubleList1);

        expenses1.setRoczniki(yearbooks1);
        layer1.setExpenses(expenses1);
        politician1.setLayers(layer1);

        politicians.add(politician1);


        politiciansSet.setPolitisiansList(politicians);
        double result = 19.33;
        assertEquals(result,expensesAnaliser.averageOfPoliticiansExpenses(politiciansSet,7),0.01);
    }

}