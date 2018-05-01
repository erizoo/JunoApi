package by.boiko.erizo.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Erizo on 29.04.2018.
 */

public class JunoModel {

    @SerializedName("name")
    @Expose
    private String name;

    public JunoModel() {
    }

    public JunoModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
