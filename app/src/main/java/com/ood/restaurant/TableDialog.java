package com.ood.restaurant;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ood.restaurant.fragments.MenuFragment;
import com.ood.restaurant.fragments.TableFragment;

public class TableDialog extends DialogFragment implements View.OnClickListener {

    private int table;
    private Button btnSeatTable, btnMakeAvailable, btnAddOrder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialog_table, container, false);

        table = getArguments().getInt("table");
        super.getDialog().setTitle(getString(R.string.tableN, table + 1));

        btnSeatTable = (Button) rootView.findViewById(R.id.btn_seat_table);
        btnMakeAvailable = (Button) rootView.findViewById(R.id.btn_make_available);
        btnAddOrder = (Button) rootView.findViewById(R.id.btn_add_order);
        btnSeatTable.setOnClickListener(this);
        btnMakeAvailable.setOnClickListener(this);
        btnAddOrder.setOnClickListener(this);

        if (StaticData.i().tables().get(table)) {
            toggleButton(btnSeatTable);
        } else {
            toggleButton(btnMakeAvailable);
            toggleButton(btnAddOrder);
        }

        return rootView;
    }

    private void toggleButton(Button button) {
        if (button.isEnabled()) {
            button.setTextColor(Color.GRAY);
        } else {
            button.setTextColor(Color.WHITE);
        }
        button.setEnabled(!button.isEnabled());
    }

    @Override
    public void onClick(View v) {
        switch( v.getId() ) {
            case R.id.btn_seat_table:
                StaticData.i().tables().set(table, true);
                toggleButton(btnSeatTable);
                toggleButton(btnMakeAvailable);
                toggleButton(btnAddOrder);
                StaticData.i().tableViews().get(table).setBackgroundColor(0xFFCCCCCC);
                break;

            case R.id.btn_make_available:
                StaticData.i().tables().set(table, false);
                toggleButton(btnSeatTable);
                toggleButton(btnMakeAvailable);
                toggleButton(btnAddOrder);
                StaticData.i().tableViews().get(table).setBackgroundColor(Color.GREEN);
                break;

            case R.id.btn_add_order:
                // Close dialog
                this.dismiss();

                // Open menu fragment
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_layout, new MenuFragment())
                        .addToBackStack("MenuFragment")
                        .commit();
                break;
        }
    }
}
