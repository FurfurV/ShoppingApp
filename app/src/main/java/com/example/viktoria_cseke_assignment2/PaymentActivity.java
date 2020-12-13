package com.example.viktoria_cseke_assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ArrayAdapter;

public class PaymentActivity extends AppCompatActivity {
    private Toolbar toolbar;
    EditText card, year,month,cvv,name,country,address,city,email;
    Button confirm;

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        toolbar = findViewById(R.id.toolbarbasket);
        setSupportActionBar(toolbar);

        card =(EditText) findViewById(R.id.cardnum);
        year =(EditText) findViewById(R.id.year);
        cvv =(EditText) findViewById(R.id.cvv);
        month = (EditText) findViewById(R.id.month);
        name = (EditText) findViewById(R.id.name);
        country = (EditText) findViewById(R.id.country);
        address = (EditText) findViewById(R.id.address);
        city = (EditText) findViewById(R.id.city);
        email = (EditText) findViewById(R.id.email);

        confirm  = (Button) findViewById(R.id.confirmpayment);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionsignin:
                startActivity(new Intent(this, Login.class));
                return true;

            case R.id.actionopencart:
                startActivity(new Intent(this, Basket.class));
                return true;

            case R.id.actiongohome:
                startActivity(new Intent(this, MainActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}