package com.ood.restaurant;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.View;
import com.ood.restaurant.fragments.MenuFragment;
import com.ood.restaurant.fragments.TableFragment;

/**
 * Main Activity
 */
public class MainActivity extends AppCompatActivity {

    public static orderDatabase myDB;
    public static Context context;

    /**
     * Triggered when the app is created
     * @param savedInstanceState The saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize database and clear it
        myDB = new orderDatabase(this);
        myDB.deleteAllOrders();

        // Save context to a static variable so it can
        // be accessed by other classes
        context = this;

        // Set the layout
        setContentView(R.layout.activity_main);

        // Configure the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Go back to the main screen when the app's home button is selected
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
