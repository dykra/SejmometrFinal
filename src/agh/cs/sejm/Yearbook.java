package agh.cs.sejm;
import static java.lang.StrictMath.round;

import com.google.gson.annotations.SerializedName;

import java.util.LinkedList;


/**
 * Created by Joanna on 2017-01-06.
 */
public class Yearbook {
    //od expenses
    @SerializedName("pola")
    private LinkedList<Double> field; //wartosci wydatkow wg punktow

    @SerializedName("rok")
    private String year;


    public LinkedList<Double> getFields() { return field;  }

    public void setFields(LinkedList<Double> field) {
        this.field = field;
    }

    public String getRok() {
        return year;
    }

    public void setRok(String year) {
        this.year = year;
    }


    public Double sumExpensesFromThisYear() {
        Double result = new Double(0.00);
        for (Double expense : this.getFields()) {
            result += expense;
        }
        return result;
    }

}
