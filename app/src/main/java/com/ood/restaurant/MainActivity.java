package com.ood.restaurant;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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

        // Set the initial fragment
        setFragment(new TableFragment());
    }

    /**
     * Set fragment
     * @param fragment Fragment to load
     */
    private void setFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_layout, fragment)
                .commit();
    }
}
