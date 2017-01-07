package agh.cs.sejm;

import com.google.gson.annotations.SerializedName;



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
