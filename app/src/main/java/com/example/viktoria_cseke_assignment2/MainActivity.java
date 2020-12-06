package com.example.viktoria_cseke_assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    private BreadFragment breadFragment;
    private DairyFragment dairyFragment;
    private ProduceFragment produceFragment;
    private MeatFragment meatFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        breadFragment = new BreadFragment();
        dairyFragment = new DairyFragment();
        produceFragment = new ProduceFragment();
        meatFragment = new MeatFragment();

        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),0);

        viewPagerAdapter.addFragment(breadFragment,"Bakery");
        viewPagerAdapter.addFragment(dairyFragment,"Dairy");
        viewPagerAdapter.addFragment(produceFragment,"Produce");
        viewPagerAdapter.addFragment(meatFragment,"Meat");
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_bread);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_milk);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_carrot);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_meat);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
//        if (id== R.id.actionsignin){
//
//            Toast.makeText(this,"Sign in", Toast.LENGTH_SHORT).show();
//        }else if(id== R.id.actionopencart){
//            Toast.makeText(this,"cart", Toast.LENGTH_SHORT).show();
//        }else {
//            Toast.makeText(this,"home", Toast.LENGTH_SHORT).show();
//        }
//        return super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case R.id.actionsignin:
                startActivity(new Intent(this, Login.class));
                return true;

            case R.id.actionopencart:
                Toast.makeText(this,"cart", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(this, Help.class));
                return true;

            case R.id.actiongohome:
                Toast.makeText(this,"home", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(this, Help.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


}