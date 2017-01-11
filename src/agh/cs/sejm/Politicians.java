package agh.cs.sejm;

import com.google.gson.annotations.SerializedName;

import java.util.LinkedList;


/**
 * Created by Joanna on 2017-01-05.
 */
public class Politicians {
    @SerializedName("id")
    private String id;

    @SerializedName("data")
    private Data data;

    @SerializedName("layers")
    private Layers layers;


    private LinkedList<String> getTermsList(){
        return this.getData().getTerms();
    }

    public boolean isTerm7(){
        for(String tmp :this.getTermsList()){
            if (tmp.equals("7")) return true;
        }
        return false;}

    public boolean isTerm8(){
        for(String tmp :this.getTermsList()){
            if (tmp.equals("8")) return true;
        }
        return false;}

    public LinkedList<Yearbook> getPoliticiansYearbooks(){

        return this.getLayers().getExpenses().getRoczniki();
    }



    public String getId() {
        return id;
    }

    public Data getData() {
        return data;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setData(Data data) {
        this.data = data;
    }


    public Layers getLayers() {
        return layers;
    }

    public void setLayers(Layers layers) {
        this.layers = layers;
    }

}
