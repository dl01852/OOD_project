package com.ood.restaurant;

import java.util.ArrayList;

/**
 * Singleton pattern
 */
public class StaticData {

    private static StaticData instance = null;
    private ArrayList<Boolean> tableList = new ArrayList<>();

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
}
