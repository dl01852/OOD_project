package com.ood.restaurant.commands;

import android.graphics.Color;
import android.widget.Button;

import com.ood.restaurant.StaticData;

/**
 * Created by Archer on 4/10/16.
 */
public class MakeAvailableCommand implements TableReceiver {
    @Override
    public void execute(Button btnSeatTable, Button btnMakeAvailable, Button btnAddOrder, int table) {
        StaticData.i().tables().set(table, false);
        toggleButton(btnSeatTable);
        toggleButton(btnMakeAvailable);
        toggleButton(btnAddOrder);
        StaticData.i().tableViews().get(table).setBackgroundColor(Color.GREEN);
    }

    private void toggleButton(Button button) {
        if (button.isEnabled()) {
            button.setTextColor(Color.GRAY);
        } else {
            button.setTextColor(Color.WHITE);
        }
        button.setEnabled(!button.isEnabled());
    }
}
