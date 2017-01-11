package tests;

import agh.cs.sejm.JasonDownloader;
import agh.cs.sejm.Yearbook;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by Joanna on 2017-01-10.
 */
public class YearbookTest {

    /*
    @Test
    public void sumExpensesFromThisYear() throws Exception {
        JasonDownloader jasonDownloader = new JasonDownloader();
        jasonDownloader.initializePoliticians(Boolean.FALSE);

       assertEquals(jasonDownloader.politiciansSet.getPolitisians().get(15).getLayers().getExpenses().getRoczniki().get(0).sumExpensesFromThisYear(),new Double(147554.51000000004));
    }*/

    @Test
    public void sumExpensesFromThisYearTest() throws Exception {
        LinkedList<Double> a= new LinkedList<>();
        a.add(new Double(2));
        a.add(new Double(3));
        a.add(new Double(5));
        Yearbook yearbook = new Yearbook();
        yearbook.setFields(a);
        assertEquals(yearbook.sumExpensesFromThisYear(),new Double(10));
    }

    @Test
    public void sumExpensesFromThisYearTest2() throws Exception {
        LinkedList<Double> a= new LinkedList<>();
        a.add(new Double(0.5));
        a.add(new Double(0.5));
        Yearbook yearbook = new Yearbook();
        yearbook.setFields(a);
        assertEquals(yearbook.sumExpensesFromThisYear(),new Double(1));
    }

    @Test
    public void sumExpensesFromThisYearTest3() throws Exception {
        LinkedList<Double> a= new LinkedList<>();
        a.add(new Double(2.1));
        a.add(new Double(3.1));
        Yearbook yearbook = new Yearbook();
        yearbook.setFields(a);
        assertEquals(yearbook.sumExpensesFromThisYear(),new Double(5.2));
    }

    @Test
    public void sumExpensesFromThisYearTest4() throws Exception {
        LinkedList<Double> a= new LinkedList<>();
        a.add(new Double(2.45));
        a.add(new Double(3));
        Yearbook yearbook = new Yearbook();
        yearbook.setFields(a);
        assertEquals(yearbook.sumExpensesFromThisYear(),new Double(5.45));
    }

    @Test
    public void sumExpensesFromThisYearTest5() throws Exception {
        LinkedList<Double> a= new LinkedList<>();
        a.add(new Double(2.12));
        a.add(new Double(3.56));
        Yearbook yearbook = new Yearbook();
        yearbook.setFields(a);
        assertEquals(yearbook.sumExpensesFromThisYear(),new Double(5.68));
    }

}