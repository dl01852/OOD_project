package com.ood.restaurant.commands;

import android.widget.Button;

/**
 * Created by Archer on 4/10/16.
 */
public interface TableReceiver {
    void execute(Button btnSeatTable, Button btnMakeAvailable, Button btnAddOrder, int table);
}
