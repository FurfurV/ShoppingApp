package com.example.viktoria_cseke_assignment2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

                String name = username.getText().toString();
                String pass = password.getText().toString();
                String addrss = address.getText().toString();

                DbHandler dbHandler = new DbHandler(getContext());
                dbHandler.InsertUserDetails(name, pass, addrss);
//                intent = new Intent(MainActivity.this, DetailsActivity.class);
//                startActivity(intent);
                Toast.makeText(getContext(), "Sign up successful",Toast.LENGTH_SHORT).show();

                ArrayList<HashMap<String, String>> userList = dbHandler.GetUsers();
                ArrayList<HashMap<String, String>> getuser = dbHandler.GetUserByUsername(name);

                LoginFragment loginFragment = new LoginFragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.animator.slideup,0,R.animator.slideup,0 );
                fragmentTransaction.replace(R.id.mymainframe, loginFragment);
                fragmentTransaction.commit();
            }
        });

        return v;
    }
}