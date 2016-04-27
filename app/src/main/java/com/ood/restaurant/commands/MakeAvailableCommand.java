package com.ood.restaurant.commands;

import android.support.v4.app.DialogFragment;
import android.widget.Button;
import com.ood.restaurant.*;

/**
 * Created by Archer on 4/10/16.
 */
public class MakeAvailableCommand implements TableReceiver {
    @Override
    public void execute(Button btnSeatTable, Button btnMakeAvailable, Button btnAddOrder,
                        Button btnViewOrders, int table, DialogFragment df) {
        // Set the table as available
        StaticData.i().tables().set(table, true);

        // Toggle the button states
        ToggleButtonCommand toggleButtonCommand = new ToggleButtonCommand();
        toggleButtonCommand.execute(btnSeatTable);
        toggleButtonCommand.execute(btnMakeAvailable);
        toggleButtonCommand.execute(btnAddOrder);
        toggleButtonCommand.execute(btnViewOrders);


        //Clear SQL holding order
        orderDatabase db = MainActivity.myDB;
        Order order = new Order();
        order.setID(table);
        db.deleteOrder(order);

        // Reload the tables
        ReloadTablesCommand reloadTablesCommand = new ReloadTablesCommand();
        reloadTablesCommand.execute();

        //Close fragment
        df.dismiss();
    }
}
