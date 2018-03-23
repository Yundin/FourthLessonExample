package org.styleru.fourthlessonexample.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Yundin Vladislav
 */
public class ApiService {

    private static String baseUrl = "http://185.17.120.159:8080/";

    public static ApiInterface getApiInterface() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ApiInterface.class);
    }
}
