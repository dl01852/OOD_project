package com.ood.restaurant.commands;

import android.widget.Button;
import com.ood.restaurant.StaticData;

/**
 * Created by Archer on 4/10/16.
 */
public class MakeAvailableCommand implements TableReceiver {
    @Override
    public void execute(Button btnSeatTable, Button btnMakeAvailable, Button btnAddOrder, int table) {
        // Set the table as available
        StaticData.i().tables().set(table, true);

        // Toggle the button states
        ToggleButtonCommand toggleButtonCommand = new ToggleButtonCommand();
        toggleButtonCommand.execute(btnSeatTable);
        toggleButtonCommand.execute(btnMakeAvailable);
        toggleButtonCommand.execute(btnAddOrder);

        // Reload the tables
        ReloadTablesCommand reloadTablesCommand = new ReloadTablesCommand();
        reloadTablesCommand.execute();
    }
}
