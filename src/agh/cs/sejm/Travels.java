package agh.cs.sejm;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Joanna on 2017-01-06.
 */
public class Travels {

    @SerializedName("kraj")
    private String country;

    @SerializedName("koszt_suma")
    private String travelCostsSum;

    @SerializedName("liczba_dni")
    private String amountDays;


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTravelCostsSum() {
        return travelCostsSum;
    }

    public void setTravelCostsSum(String travelCostsSum) {
        this.travelCostsSum = travelCostsSum;
    }

    public String getAmountDays() {
        return amountDays;
    }

    public void setAmountDays(String amountDays) {
        this.amountDays = amountDays;
    }

}
