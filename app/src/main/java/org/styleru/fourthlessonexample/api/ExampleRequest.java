package org.styleru.fourthlessonexample.api;

/**
 * @author Yundin Vladislav
 */
public class ExampleRequest {

    public String name;
    public String description;
    public String about;

    public ExampleRequest(String name, String description, String about) {
        this.name = name;
        this.description = description;
        this.about = about;
    }
}
