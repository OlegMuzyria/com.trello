package com.trello.api.services;

import com.trello.api.models.Label;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface LabelService {

    @GET("labels/{id}")
    Call<Label> getLabel (@Path("id") String id);

    @POST ("labels")
    Call<Label> createLabel (@Query("idBoard") String idBoard, @Query("name") String name, @Query("color") String color);

    @PUT("labels/{id}")
    Call<Label> updateLabel (@Path("id") String id, @Body Label label);

    @DELETE("labels/{id}")
    Call <ResponseBody> deleteLabel (@Path("id") String id);
}
