package com.ood.restaurant;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.ood.restaurant.fragments.TableFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the layout
        setContentView(R.layout.activity_main);

        // Configure the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Start the TableFragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_layout, new TableFragment())
                .commit();
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        myDB.deleteAllOrders();
    }

}
