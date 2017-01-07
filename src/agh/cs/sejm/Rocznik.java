package agh.cs.sejm;

import com.google.gson.annotations.SerializedName;

import java.util.LinkedList;

/**
 * Created by Joanna on 2017-01-06.
 */
public class Rocznik {
    //od expenses
    @SerializedName("pola")
    private LinkedList<Double> field; //wartosci wydatkow wg punktow

    @SerializedName("rok")
    private String year;


    public LinkedList<Double> getPola() { return field;  }

    public void setPola(LinkedList<Double> field) {
        this.field = field;
    }

    public String getRok() {
        return year;
    }

    public void setRok(String year) {
        this.year = year;
    }

}
