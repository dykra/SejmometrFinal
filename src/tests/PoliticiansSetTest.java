package tests;

import agh.cs.sejm.Politicians;
import agh.cs.sejm.PoliticiansSet;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by Joanna on 2017-01-10.
 */
public class PoliticiansSetTest {
    @Test
    public void addNewPolitisiansAndSetPoliticiansTest() throws Exception {
        PoliticiansSet politiciansSet = new PoliticiansSet();
        LinkedList<Politicians> a= new LinkedList<>();
        a.add(new Politicians());
        a.add(new Politicians());
        LinkedList<Politicians> b= new LinkedList<>();
        b.add(new Politicians());
        b.add(new Politicians());
        politiciansSet.setPolitisiansList(a);
        politiciansSet.addNewPolitisians(b);
        assertEquals(4,politiciansSet.getPolitisians().size());
    }

    @Test
    public void setPolitisians() throws Exception {
        PoliticiansSet politiciansSet = new PoliticiansSet();
        LinkedList<Politicians> a= new LinkedList<>();
        a.add(new Politicians());
        a.add(new Politicians());
        politiciansSet.setPolitisiansList(a);
        assertEquals(2,politiciansSet.getPolitisians().size());
    }

}