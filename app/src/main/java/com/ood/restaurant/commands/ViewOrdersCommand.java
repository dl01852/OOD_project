package com.ood.restaurant.commands;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.ood.restaurant.*;
import com.ood.restaurant.TableDialog;


/**
 * This command will close the TableDialog and show the table's orders
 *
 * @author Michael Palmer
 */

public class ViewOrdersCommand extends AppCompatActivity {
    /**
     * Invalidate all views in the GridView and reload the adapter. This will change the color
     * of a table when it has been seating or made available.
     */;

    orderDatabase orderDatabase = MainActivity.myDB;

    public void execute(TableDialog dialog, int tableID) {


        // Close the dialog

        Order temp_order = orderDatabase.getOrder(tableID);
        dialog.dismiss();
        Toast.makeText(MainActivity.context,temp_order.getOrderDescription(),Toast.LENGTH_SHORT).show();
        // TODO: Implement this


    }
}
