package com.ood.restaurant.commands;

import com.ood.restaurant.fragments.TableFragment;

public class ReloadTablesCommand {
    public static void execute() {
        TableFragment.tableGrid.invalidateViews();
        TableFragment.tableGrid.setAdapter(TableFragment.tableGrid.getAdapter());
    }
}
