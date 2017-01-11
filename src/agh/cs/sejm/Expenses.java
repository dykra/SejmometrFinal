package agh.cs.sejm;

import com.google.gson.annotations.SerializedName;

import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Joanna on 2017-01-06.
 */
public class Expenses {
    //{} single object
    //[] sequence of objects
    @SerializedName("punkty")
    private LinkedList<Map<String,String>> punkty;

    public LinkedList<Map<String, String>> getPunkty() {
        return punkty;
    }

    public void setPunkty(LinkedList<Map<String, String>> punkty) {
        this.punkty = punkty;
    }

    public LinkedList<Yearbook> getRoczniki() {
        return roczniki;
    }

    public void setRoczniki(LinkedList<Yearbook> roczniki) {
        this.roczniki = roczniki;
    }

    @SerializedName("roczniki")
    private LinkedList<Yearbook> roczniki;


}
