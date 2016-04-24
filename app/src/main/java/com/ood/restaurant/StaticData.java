package com.ood.restaurant;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Singleton pattern
 */
public class StaticData {

    private static StaticData instance = null;
    private ArrayList<Boolean> tableList = new ArrayList<>();
//    private HashMap<Integer, TextView> tableViews = new HashMap<>();

    /**
     * Private constructor
     */
    private StaticData() {
        for (int i = 0; i < 15; i++) {
            tableList.add(true);
        }
    }

    /**
     * Get the singleton instance
     * @return Singleton instance
     */
    public static synchronized StaticData i() {
        if (instance == null) {
            instance = new StaticData();
        }
        return instance;
    }

    /**
     * Get the table list
     * @return Table list
     */
    public ArrayList<Boolean> tables() {
        return this.tableList;
    }

    /**
     * Get the table text views
     * @return HashMap of text views
     */
//    public HashMap<Integer, TextView> tableViews() {
//        return this.tableViews;
//    }
}
