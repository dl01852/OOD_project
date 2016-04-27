package com.ood.restaurant;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.View;
import com.ood.restaurant.fragments.TableFragment;

public class MainActivity extends AppCompatActivity {

    public static  orderDatabase myDB;
    public static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Initialize database and clear it
        myDB = new orderDatabase(this);
        myDB.deleteAllOrders();

        // Save context
        context = this;

        // Set the layout
        setContentView(R.layout.activity_main);

        // Configure the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_layout,new TableFragment())
                        .commit();
            }
        });

        // Start the TableFragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_layout, new TableFragment())
                .commit();
    }

}
