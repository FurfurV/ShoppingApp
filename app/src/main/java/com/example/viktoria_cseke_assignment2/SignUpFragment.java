package com.example.viktoria_cseke_assignment2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SignUpFragment extends Fragment {
    EditText username,password,passrepeat,address;
    Button signup;


    public SignUpFragment() {
        // Required empty public constructor
    }
    public static SignUpFragment newInstance() {
        SignUpFragment fragment = new SignUpFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sign_up, container, false);

        username=(EditText) v.findViewById(R.id.usernameSignup);
        password=(EditText) v.findViewById(R.id.passwordSignup);
        passrepeat=(EditText) v.findViewById(R.id.passwordSignupconfirm);
        address=(EditText) v.findViewById(R.id.addressSignup);
        signup=(Button) v.findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return v;
    }
}