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
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.replace(R.id.mymainframe, signUpFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString()+"\n";
                String passw = password.getText().toString();

                DbHandler dbHandler = new DbHandler(getContext());
                dbHandler.GetUserByUsername(uname);
            }
        });


        return v;
    }
}