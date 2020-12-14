package com.example.viktoria_cseke_assignment2.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.viktoria_cseke_assignment2.DbHandler;
import com.example.viktoria_cseke_assignment2.MainActivity;
import com.example.viktoria_cseke_assignment2.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {
    EditText username, password;
    Button signin, signupnxt;

    public LoginFragment() {
        // Required empty public constructor
    }


    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
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
        View v= inflater.inflate(R.layout.fragment_login, container, false);

        username =(EditText) v.findViewById(R.id.username);
        password =(EditText) v.findViewById(R.id.password);
        signin = (Button) v.findViewById(R.id.signin);
        signupnxt = (Button) v.findViewById(R.id.signupnextpg);


        signupnxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(Login.this, SignUpActivity.class));

                SignUpFragment signUpFragment = new SignUpFragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.animator.slideup,0,R.animator.slideup,0 );

                fragmentTransaction.replace(R.id.mymainframe, signUpFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString();
                String passw = password.getText().toString();

                DbHandler dbHandler = new DbHandler(getContext());
                ArrayList<HashMap<String, String>> getuser =dbHandler.getUserByUsername(uname);


                System.out.println(getuser.size());
                if(getuser.size()>0){
                    String dbUser = getuser.get(0).get("username").toString();
                    String dbPass = getuser.get(0).get("password").toString();
                    System.out.println(dbUser);
                    System.out.println(dbPass);
                    System.out.println("----------");
                    System.out.println(uname+" "+passw);
                    System.out.println(passw.equals(dbPass));


                    System.out.println(passw.length()+" "+dbPass.length());

                    if(passw.equals(dbPass)){

                        Toast.makeText(getContext(), "Signed in successfully",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getContext(), MainActivity.class));

                    }else {
                        System.out.println("no pass?");
                        Toast.makeText(getContext(), "Wrong password for this username",Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(getContext(), "User name not found.",Toast.LENGTH_SHORT).show();
                }
            }
        });


        return v;
    }
}