package com.ood.restaurant;

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
    private Button btnSeatTable, btnMakeAvailable, btnAddOrder, btnViewOrders;

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
        btnViewOrders = (Button) rootView.findViewById(R.id.btn_view_orders);
        btnSeatTable.setOnClickListener(this);
        btnMakeAvailable.setOnClickListener(this);
        btnAddOrder.setOnClickListener(this);
        btnViewOrders.setOnClickListener(this);

        // Set the initial state of the buttons based on the table status
        ToggleButtonCommand toggleButtonCommand = new ToggleButtonCommand();
        if (!StaticData.i().tables().get(table)) {
            toggleButtonCommand.execute(btnSeatTable);
        } else {
            toggleButtonCommand.execute(btnMakeAvailable);
            toggleButtonCommand.execute(btnAddOrder);
            toggleButtonCommand.execute(btnViewOrders);
        }

        return rootView;
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
        ViewOrdersCommand viewOrdersCommand = new ViewOrdersCommand();
        switch( v.getId() ) {
            case R.id.btn_seat_table:
                // Seat Table button was clicked - execute the SeatTableCommand
                seatCommand.execute(btnSeatTable, btnMakeAvailable, btnAddOrder,
                        btnViewOrders, table);
                break;

            case R.id.btn_make_available:
                // Make Available button was clicked - execute the MakeAvailableCommand
                makeAvailableCommand.execute(btnSeatTable, btnMakeAvailable, btnAddOrder,
                        btnViewOrders, table);
                break;

            case R.id.btn_add_order:
                // Add Order button was clicked - execute the AddOrderCommand
                addOrderCommand.execute(this);
                break;

            case R.id.btn_view_orders:
                viewOrdersCommand.execute(this,table);
                break;
        }
    }
}
