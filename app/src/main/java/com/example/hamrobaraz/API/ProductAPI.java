package com.example.hamrobaraz.API;

import com.example.hamrobaraz.module.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductAPI {


    @GET("products/allProducts")
    Call<List<Products>> getAllProducts();
}

