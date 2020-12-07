package com.example.viktoria_cseke_assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText username, password;
    Button signin, signupnxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username =(EditText) findViewById(R.id.username);
        password =(EditText) findViewById(R.id.password);
        signin = (Button) findViewById(R.id.signin);
        signupnxt = (Button) findViewById(R.id.signupnextpg);


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString()+"\n";
                String passw = password.getText().toString();

                DbHandler dbHandler = new DbHandler(Login.this);
                dbHandler.GetUserByUsername(uname);
            }
        });

        signupnxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, SignUpActivity.class));

            }
        });
    }
}