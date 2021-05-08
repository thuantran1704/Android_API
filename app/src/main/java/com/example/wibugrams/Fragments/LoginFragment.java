package com.example.wibugrams.Fragments;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.wibugrams.Common;
import com.example.wibugrams.Home.HomeActivity;
import com.example.wibugrams.Model.JSONResponseUser;
import com.example.wibugrams.R;
import com.example.wibugrams.Retrofit.ApiInterface;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment {
    TextInputEditText edtEmail, edtPassword;
    Button btn_login;
    ApiInterface service;
    final String key = "VSBG";
    Activity activity = this.getActivity();
    public void LoginFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.fragment_login, container, false);

        edtEmail = view.findViewById(R.id.edtEmail);
        edtPassword = view.findViewById(R.id.edtPassword);
        btn_login = view.findViewById(R.id.btn_login);

        service = Common.getGsonService();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getActivity().getApplication(), HomeActivity.class);
//                startActivity(intent);
                if(Common.isConnectedToInternet(getActivity().getBaseContext())){
                    ProgressDialog mDialog = new ProgressDialog(getActivity().getBaseContext().getApplicationContext());

                    service.getUserLogin(key, edtEmail.getText().toString(), edtPassword.getText().toString()).enqueue(new Callback<JSONResponseUser>() {
                        @Override
                        public void onResponse(Call<JSONResponseUser> call, Response<JSONResponseUser> response) {
                            if(Integer.parseInt(response.body().getStatus())==1){
                                Common.currentUser.setUsername(edtEmail.getText().toString());

                                Toast.makeText(getActivity().getBaseContext().getApplicationContext(), "Sign in successfully !", Toast.LENGTH_SHORT).show();

                                Intent intentHome = new Intent(getContext(), HomeActivity.class);
                                startActivity(intentHome);
                                getActivity().getFragmentManager().popBackStack();
                            }else{
                                Toast.makeText(getContext(), "Sign in failed !", Toast.LENGTH_SHORT).show();
                            }
                        }
                        @Override
                        public void onFailure(Call<JSONResponseUser> call, Throwable t) {
                            Toast.makeText(getActivity().getBaseContext().getApplicationContext(), ""+t.getMessage() , Toast.LENGTH_SHORT).show();
                        }
                    });

                }else{
                    Toast.makeText(getActivity().getBaseContext(), "Please check your connection !!", Toast.LENGTH_SHORT).show();
//                    return;
                }
            }
        });
        return view;
    }
}