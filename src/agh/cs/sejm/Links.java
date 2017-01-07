package agh.cs.sejm;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Created by Joanna on 2017-01-05.
 */
public class Links {
    //self, next,last, 3 pojedyncze obiekty

    @SerializedName("Links")
    private Map<String, String> Links;

    public String getLinks(String key) {
        return Links.get(key);
    }

    public void setLinks(String key, String value) {
        Links.replace(key,value);
    }
}
