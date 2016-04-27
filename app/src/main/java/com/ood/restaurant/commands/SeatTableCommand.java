package com.ood.restaurant.commands;

import com.ood.restaurant.StaticData;
import android.widget.Button;

/**
 * Created by Archer on 4/10/16.
 */
public class SeatTableCommand implements TableReceiver{
    @Override
    public void execute(Button btnSeatTable, Button btnMakeAvailable, Button btnAddOrder,
                        Button btnViewOrders, int table) {
        // Set the table as seated
        StaticData.i().tables().set(table, false);

        // Toggle the button states
        ToggleButtonCommand toggleButtonCommand = new ToggleButtonCommand();
        toggleButtonCommand.execute(btnSeatTable);
        toggleButtonCommand.execute(btnMakeAvailable);
        toggleButtonCommand.execute(btnAddOrder);
        toggleButtonCommand.execute(btnViewOrders);

        // Reload the tables
        ReloadTablesCommand reloadTablesCommand = new ReloadTablesCommand();
        reloadTablesCommand.execute();
    }
}
