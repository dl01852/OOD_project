package com.ood.restaurant.commands;

import com.ood.restaurant.R;
import com.ood.restaurant.TableDialog;
import com.ood.restaurant.fragments.MenuFragment;

/**
 * This command will close the TableDialog and open the MenuFragment
 *
 * @author Michael Palmer
 */
public class AddOrderCommand {
    /**
     * Invalidate all views in the GridView and reload the adapter. This will change the color
     * of a table when it has been seating or made available.
     */
    public static int table;
    public void execute(TableDialog dialog,int table) {

        this.table = table;
        // Close the dialog
        dialog.dismiss();

        // Open the MenuFragment
        dialog.getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_layout, new MenuFragment())
                .addToBackStack("MenuFragment")
                .commit();
    }
}
