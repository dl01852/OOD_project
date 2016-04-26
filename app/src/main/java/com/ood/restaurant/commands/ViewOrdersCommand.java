package com.ood.restaurant.commands;

import com.ood.restaurant.TableDialog;

/**
 * This command will close the TableDialog and show the table's orders
 *
 * @author Michael Palmer
 */
public class ViewOrdersCommand {
    /**
     * Invalidate all views in the GridView and reload the adapter. This will change the color
     * of a table when it has been seating or made available.
     */
    public void execute(TableDialog dialog) {
        // Close the dialog
        dialog.dismiss();

        // TODO: Implement this
    }
}
