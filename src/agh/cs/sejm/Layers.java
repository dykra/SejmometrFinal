package agh.cs.sejm;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;


/**
 * Created by Joanna on 2017-01-06.
 */
public class Layers {
    //zestaw wydatków i podrózy dla danego posła

    @SerializedName("wydatki")
    private Expenses expenses;

    public Expenses getExpenses() {
        return expenses;
    }

    public void setExpenses(Expenses expenses) {
        this.expenses = expenses;
    }

//-----------------------------------------------------------------

    @SerializedName("wyjazdy")
    private JsonElement tmpTravels;

    public LinkedList<Map<String, String>> getTravels() {
        return travels;
    }

    public void setTravels(LinkedList<Map<String, String>> travels) {
        this.travels = travels;
    }

    private LinkedList<Map<String,String>> travels;
    //gdy pusta lista to jsonobject, a takto jsonarray

    public JsonElement getTmpTravels() {
        return tmpTravels;
    }

    public void setTmpTravels(JsonElement tmpTravels) {
        this.tmpTravels = tmpTravels;
    }

    @SuppressWarnings("unchecked")
    public void loadTravels() {
        if (this.tmpTravels.isJsonObject())
            this.travels= new LinkedList<Map<String,String>>();
        else {
            this.travels = new Gson().fromJson(this.tmpTravels, LinkedList.class);
        }
    }
}




