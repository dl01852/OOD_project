package com.ood.restaurant;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ood.restaurant.commands.*;

/**
 * Table Dialog
 * @author Michael Palmer
 */
public class TableDialog extends DialogFragment implements View.OnClickListener {

    private int table;
    private Button btnSeatTable, btnMakeAvailable, btnAddOrder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the dialog
        View rootView = inflater.inflate(R.layout.dialog_table, container, false);

        // Get arguments passed in (table number) and set the title
        table = getArguments().getInt("table");
        super.getDialog().setTitle(getString(R.string.tableN, table + 1));

        // Load Buttons into variables and set listeners
        btnSeatTable = (Button) rootView.findViewById(R.id.btn_seat_table);
        btnMakeAvailable = (Button) rootView.findViewById(R.id.btn_make_available);
        btnAddOrder = (Button) rootView.findViewById(R.id.btn_add_order);
        btnSeatTable.setOnClickListener(this);
        btnMakeAvailable.setOnClickListener(this);
        btnAddOrder.setOnClickListener(this);

        // Set the initial state of the buttons based on the table status
        if (!StaticData.i().tables().get(table)) {
            toggleButton(btnSeatTable);
        } else {
            toggleButton(btnMakeAvailable);
            toggleButton(btnAddOrder);
        }

        return rootView;
    }

    /**
     * Toggle a button's state (enabled/disabled)
     * @param button Button to toggle
     */
    private void toggleButton(Button button) {
        if (button.isEnabled()) {
            button.setTextColor(Color.GRAY);
        } else {
            button.setTextColor(Color.WHITE);
        }
        button.setEnabled(!button.isEnabled());
    }

    /**
     * Handle on click events
     * @param v View that received the event
     */
    @Override
    public void onClick(View v) {
        SeatTableCommand seatCommand = new SeatTableCommand();
        MakeAvailableCommand makeAvailableCommand = new MakeAvailableCommand();
        AddOrderCommand addOrderCommand = new AddOrderCommand();
        switch( v.getId() ) {
            case R.id.btn_seat_table:
                // Seat Table button was clicked - execute the SeatTableCommand
                seatCommand.execute(btnSeatTable, btnMakeAvailable, btnAddOrder, table);
                break;

            case R.id.btn_make_available:
                // Make Available button was clicked - execute the MakeAvailableCommand
                makeAvailableCommand.execute(btnSeatTable, btnMakeAvailable, btnAddOrder, table);
                break;

            case R.id.btn_add_order:
                // Add Order button was clicked - execute the AddOrderCommand
                addOrderCommand.execute(this);
                break;
        }
    }
}
