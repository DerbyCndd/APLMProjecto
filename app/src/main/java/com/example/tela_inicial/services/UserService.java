package com.example.tela_inicial.services;

import com.example.tela_inicial.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {
    @POST("/user/inserir")
    Call<User> inserir(@Body User user);
}
