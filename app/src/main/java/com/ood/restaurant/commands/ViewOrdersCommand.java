package com.ood.restaurant.commands;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import com.ood.restaurant.*;
import com.ood.restaurant.TableDialog;

/**
 * This command will close the TableDialog and open the ViewOrdersDialog to show all of the orders
 * for this table
 * @author Michael Palmer
 */
public class ViewOrdersCommand {
    private orderDatabase orderDatabase = MainActivity.myDB;

    /**
     * Execute the command
     * @param dialog TableDialog instance
     * @param activity Activity instance
     * @param tableID Table number to lookup orders on
     */
    public void execute(TableDialog dialog, FragmentActivity activity, int tableID) {
        // Close the table dialog
        dialog.dismiss();

        // Abort and show a toast if there aren't any orders yet
        if (orderDatabase.getOrders(tableID).size() == 0) {
            Toast.makeText(activity, "Table hasn't placed order yet", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create the view orders dialog
        ViewOrdersDialog ordersDialog = new ViewOrdersDialog();

        // Set arguments
        Bundle args = new Bundle();
        args.putInt("table", tableID);
        ordersDialog.setArguments(args);

        // Show the dialog
        ordersDialog.show(activity.getSupportFragmentManager(), "ViewOrdersDialog");
    }
}
