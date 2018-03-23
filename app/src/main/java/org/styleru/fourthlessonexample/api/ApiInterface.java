package org.styleru.fourthlessonexample.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * @author Yundin Vladislav
 */
public interface ApiInterface {

    @GET("example")
    Call<ExampleResponse> getData();

    @POST("example/post")
    Call<Void> replace(@Header("Content-Type") String content_type, @Body ExampleRequest request);
}
