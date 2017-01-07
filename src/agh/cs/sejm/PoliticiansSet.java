package agh.cs.sejm;

import com.google.gson.annotations.SerializedName;


import java.util.LinkedList;

/**
 * Created by Joanna on 2017-01-04.
 */
public class PoliticiansSet {

    @SerializedName("Dataobject")
    private LinkedList<Politicians> politisiansList;


    public void addNewPolitisians(LinkedList<Politicians> tmp){
        politisiansList.addAll(tmp);
    }
    public LinkedList<Politicians> getPolitisians() {
        return politisiansList;
    }

    public void setPolitisiansList(LinkedList<Politicians> politisiansList) {
        this.politisiansList = politisiansList;
    }

}

