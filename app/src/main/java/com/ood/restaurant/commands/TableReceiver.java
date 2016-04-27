package com.ood.restaurant.commands;

import android.support.v4.app.DialogFragment;
import android.widget.Button;

/**
 * Created by Archer on 4/10/16.
 */
public interface TableReceiver {
    void execute(Button btnSeatTable, Button btnMakeAvailable, Button btnAddOrder,
                 Button btnViewOrders, int table, DialogFragment df);
}
