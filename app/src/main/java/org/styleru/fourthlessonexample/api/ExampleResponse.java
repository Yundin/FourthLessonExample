package org.styleru.fourthlessonexample.api;

import com.google.gson.annotations.SerializedName;

/**
 * @author Yundin Vladislav
 */
public class ExampleResponse {

    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("about")
    private String about;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAbout() {
        return about;
    }
}
