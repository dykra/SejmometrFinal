package agh.cs.sejm;

import com.google.gson.annotations.SerializedName;

import java.util.LinkedList;

/**
 * Created by Joanna on 2017-01-06.
 */
public class Data {


    @SerializedName("poslowie.imie_pierwsze")
    private String firstName;


    @SerializedName("poslowie.nazwisko")
    private String lastName;

    @SerializedName("poslowie.kadencja")
    private LinkedList<String> terms; // lista kadencji posłow


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LinkedList<String> getTerms() {
        return terms;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTerms(LinkedList<String> terms) {
        this.terms = terms;
    }


}
