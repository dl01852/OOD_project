package com.ood.restaurant.commands;

import com.ood.restaurant.fragments.TableFragment;

import android.graphics.Color;
import android.widget.Button;

/**
 * Created by Archer on 4/10/16.
 */
public class SeatTableCommand implements TableReceiver{
    @Override
    public void execute(Button btnSeatTable, Button btnMakeAvailable, Button btnAddOrder, int table) {
        TableFragment.tableList.set(table, true);
        toggleButton(btnSeatTable);
        toggleButton(btnMakeAvailable);
        toggleButton(btnAddOrder);
        TableFragment.tableViews.get(table).setBackgroundColor(0xFFCCCCCC);
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
