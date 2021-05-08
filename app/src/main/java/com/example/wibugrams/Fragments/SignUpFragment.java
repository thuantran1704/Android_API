package com.example.wibugrams.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.wibugrams.Home.HomeActivity;
import com.example.wibugrams.R;
import com.google.android.material.textfield.TextInputEditText;


public class SignUpFragment extends Fragment {
    TextInputEditText inputFullName, inputUsername, inputPassword, inputComfirmPass;
    Button btn_signUp;


    public void SignUpFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.fragment_sign_up, container, false);

        inputFullName = view.findViewById(R.id.inputFullName);
        inputUsername = view.findViewById(R.id.inputUsername);
        inputPassword = view.findViewById(R.id.inputPassword);
        inputComfirmPass = view.findViewById(R.id.inputComfirmPass);
        btn_signUp = view.findViewById(R.id.btn_signUp);



        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplication(), HomeActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}