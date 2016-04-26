package com.ood.restaurant;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by david-lewis on 4/25/2016.
 *
 * Quick mockup of an a database...
 */
public class orderDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Restaurant.db";
    public static final String TABLE_NAME = "orders";
    public static final String ORDER_ID = "id";
    public static final String ORDER = "description";

    private int id;
    private String orderDescription;


    public orderDatabase(Context context)
    {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        // Create the query to create a table in the database..
        String query = String.format("CREATE TABLE %s\n", TABLE_NAME) +
                "(" +
                String.format("%s INTEGER PRIMARY KEY,\n", ORDER_ID) +
                String.format("%s text\n", ORDER) +
                ")";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // function is mandatory.. we'll have no use for it though.
        db.execSQL(String.format("DROP TABLE IF EXISTS %s",TABLE_NAME));
        onCreate(db);
    }

    public boolean insertOrder(Order order)
    {
        // inserting an order into the database.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(ORDER,order.getOrderDescription());
        db.insert(TABLE_NAME,null,contentValues);
        db.close();

        return true;
    }

    public boolean updateOrder(Order order)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(ORDER,order.getOrderDescription());

        db.update(TABLE_NAME,contentValues,"id = ?",new String[]{Integer.toString(order.getId())});
        return true;
    }

    public Order getOrder(int id) {
        Order order; // order to be returned.
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorData = db.rawQuery("SELECT * FROM orders WHERE id = ?", new String[]{String.valueOf(id)});

        if (cursorData.moveToFirst()) {
            this.id = cursorData.getInt(cursorData.getColumnIndex(ORDER_ID));
            this.orderDescription = cursorData.getString(cursorData.getColumnIndex(ORDER));
            cursorData.close();


            order = new Order(id, orderDescription);
            db.close();
            return order;
        } else
            return null; // Error
    }

    public Integer deleteOrder(Order order)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"WHERE id = ?",new String[]{Integer.toString(order.getId())});
    }

    public void deleteAllOrders()
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
