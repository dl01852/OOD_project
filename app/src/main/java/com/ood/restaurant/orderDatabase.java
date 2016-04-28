package com.ood.restaurant;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


/**
 * Created by david-lewis on 4/25/2016.
 *
 * Quick mockup of an a database...
 */
public class orderDatabase extends SQLiteOpenHelper {

    // fields for the DB name, tables and the column.s
    public static final String DATABASE_NAME = "Restaurant.db";
    public static final String TABLE_NAME = "orders";
    public static final String ORDER_ID = "id";
    public static final String ORDER = "description";
    public static final String TABLE_ID ="tableID";
    public static final String ORDER_COST = "cost";
    public static final int DATABASE_VERSION = 3;

    // data fields needed to populate an Order object.
    private int id;
    private String orderDescription;
    private double cost;


    public orderDatabase(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        // Create the query to create a table in the database..
        String query = String.format("CREATE TABLE %s\n", TABLE_NAME) +
                "(" +
                String.format("%s INTEGER PRIMARY KEY,\n", ORDER_ID) +
                String.format("%s text,\n", ORDER) +
                String.format("%s INTEGER,\n",TABLE_ID) +
                String.format("%s DECIMAL(3,2)\n",ORDER_COST) +
                ")";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // function is mandatory.. we'll have no use for it though.
        db.execSQL(String.format("DROP TABLE IF EXISTS %s",TABLE_NAME));
        onCreate(db);
    }

    public boolean insertOrder(Order order,int TableID)
    {
        // inserting an order into the database.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(ORDER,order.getOrderDescription());
        contentValues.put(TABLE_ID,TableID);
        contentValues.put(ORDER_COST,order.getCost());
        db.insert(TABLE_NAME,null,contentValues);
        db.close();

        return true;
    }
    public Order getOrder(int id) {
        Order order; // order to be returned.
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorData = db.rawQuery("SELECT * FROM orders WHERE TableID = ?", new String[]{String.valueOf(id)});

        if (cursorData.moveToFirst()) {
            this.id = cursorData.getInt(cursorData.getColumnIndex(ORDER_ID));
            this.orderDescription = cursorData.getString(cursorData.getColumnIndex(ORDER));
            this.cost = cursorData.getDouble(cursorData.getColumnIndex(ORDER_COST));
            cursorData.close();


            order = new Order(id, orderDescription,cost);
            db.close();
            return order;
        } else
            return null; // Error
    }

    /**
     * Get all of the orders for a specific table
     * @param id Table id
     * @return ArrayList of Orders
     */
    public ArrayList<Order> getOrders(int id) {
        // Initialize
        ArrayList<Order> orders = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Select data from the database
        Cursor cursor = db.rawQuery("SELECT * FROM orders WHERE TableID = ?",
                new String[]{String.valueOf(id)});

        // Loop through the query results
        if (cursor.moveToFirst()) {
            do {
                // Save data from the query
                int orderId = cursor.getInt(cursor.getColumnIndex(ORDER_ID));
                String description = cursor.getString(cursor.getColumnIndex(ORDER));
                double cost = cursor.getDouble(cursor.getColumnIndex(ORDER_COST));

                // Create a new Order object and add it to the ArrayList
                Order order = new Order(orderId, description,cost);
                orders.add(order);
            } while (cursor.moveToNext());
        }

        // Close the cursor and return the orders
        cursor.close();
        return orders;
    }

    public Integer deleteOrder(Order order)// delete an order from the DB
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"tableID = " + order.getId(), null);
    }

    public void deleteAllOrders() // deletes All orders from DB.
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(String.format("SELECT * FROM %s",TABLE_NAME),null);

        while(cursor.moveToNext())
        {
            db.delete(TABLE_NAME,"id = ?", new String[]{Integer.toString(cursor.getInt(cursor.getColumnIndex(ORDER_ID)))});
        }

        cursor.close();
        db.close();
    }


}
