package com.ood.restaurant.commands;

import com.ood.restaurant.TableDialog;

/**
 * This command will close the TableDialog and show the table's orders
 *
 * @author Michael Palmer
 */
public class ViewOrdersCommand {
    /**
     * View the table's orders
     */
    public void execute(TableDialog dialog) {
        // Close the dialog
        dialog.dismiss();

        // TODO: Implement this
    }
}
