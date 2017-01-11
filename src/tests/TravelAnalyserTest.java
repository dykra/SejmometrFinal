package tests;

import agh.cs.sejm.JasonDownloader;
import agh.cs.sejm.TravelAnalyser;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Joanna on 2017-01-11.
 */
public class TravelAnalyserTest {

    @Test
    public void mostExpensiveTravelTest() throws Exception {

        JasonDownloader jasonDownloader = new JasonDownloader();
        jasonDownloader.initializePoliticians(Boolean.FALSE);

        TravelAnalyser travelAnalyser = new TravelAnalyser();
        assertEquals("Adam Szejnfeld" ,travelAnalyser.mostExpensiveTravel(7,jasonDownloader.politiciansSet));
        assertEquals("Witold Waszczykowski" ,travelAnalyser.mostExpensiveTravel(8,jasonDownloader.politiciansSet));
    }

    @Test
    public void longestAbroadTravellerTest() throws Exception {

        JasonDownloader jasonDownloader = new JasonDownloader();
        jasonDownloader.initializePoliticians(Boolean.FALSE);

        TravelAnalyser travelAnalyser = new TravelAnalyser();
        assertEquals("Tadeusz Iwiński" ,travelAnalyser.theLongestAbroadTraveler(7,jasonDownloader.politiciansSet));
        assertEquals("Jan Dziedziczak" ,travelAnalyser.theLongestAbroadTraveler(8,jasonDownloader.politiciansSet));
    }

}