package com.example.wibugrams;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.wibugrams.Model.User;
import com.example.wibugrams.Retrofit.ApiInterface;
import com.example.wibugrams.Retrofit.RetrofitClient;

import java.util.ArrayList;

public class Common {

    public static User currentUser = new User();
    public static String DELETE ="Delete";
    public static String USER_KEY ="User";
    public static String PWD_KEY ="Password";
    public static ArrayList<User> dataUser = new ArrayList<>();


    public static boolean isConnectedToInternet(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager !=null){
            NetworkInfo[] info = connectivityManager.getAllNetworkInfo();

            if(info != null){
                for(int i = 0; i<info.length; i++){
                    if(info[i].getState() == NetworkInfo.State.CONNECTED){
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public static final String BASE_URL = "https://project-api-levi.herokuapp.com/api/";


    public static ApiInterface getScalarsService(){
        return RetrofitClient.getRetrofitInstanceScalars(BASE_URL).create(ApiInterface.class);
    }

    public static ApiInterface getGsonService(){
        return RetrofitClient.getRetrofitInstanceGson(BASE_URL).create(ApiInterface.class);
    }
}
