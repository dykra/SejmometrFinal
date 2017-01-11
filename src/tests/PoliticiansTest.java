package tests;

import agh.cs.sejm.Data;
import agh.cs.sejm.Politicians;

import org.junit.Test;

import java.util.LinkedList;
import static org.junit.Assert.*;

/**
 * Created by Joanna on 2017-01-10.
 */
public class PoliticiansTest {
    @Test
    public void isTerm7() throws Exception {
        Politicians politicians = new Politicians();
        Data data = new Data();
        LinkedList<String> terms= new LinkedList<>();
        terms.add("7");
        terms.add("23");
        data.setTerms(terms);
        politicians.setData(data);
        assertEquals(Boolean.TRUE,politicians.isTerm7());
    }

    @Test
    public void isTerm8() throws Exception {
        Politicians politicians = new Politicians();
        Data data = new Data();
        LinkedList<String> terms= new LinkedList<>();
        terms.add("19");
        terms.add("28");
        terms.add("ala");
        data.setTerms(terms);
        politicians.setData(data);
        assertEquals(Boolean.FALSE,politicians.isTerm8());
    }

    @Test
    public void isTerm8_2() throws Exception {
        Politicians politicians = new Politicians();
        Data data = new Data();
        LinkedList<String> terms= new LinkedList<>();
        terms.add("8");
        terms.add("23");
        terms.add("19023yh");
        data.setTerms(terms);
        politicians.setData(data);
        assertEquals(Boolean.TRUE,politicians.isTerm8());
    }

}