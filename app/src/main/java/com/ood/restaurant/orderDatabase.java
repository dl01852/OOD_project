package com.ood.restaurant;
import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.design.widget.TabLayout;


/**
 * Created by david-lewis on 4/25/2016.
 */
public class orderDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Restaurant.db";
    public static final String TABLE_NAME = "orders";
    public static final String TABLE_ID = "id";
    public static final String ORDER = "order";


    public orderDatabase(Context context)
    {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        StringBuilder query = new StringBuilder();
        query.append(String.format("CREATE TABLE %s\n",TABLE_NAME));
        query.append("(");
        query.append(String.format("%s INTEGER PRIMARY KEY,\n",TABLE_ID));
        query.append(String.format("%s text\n",ORDER));
        query.append(")");

        db.execSQL(query.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(String.format("DROP TABLE IF EXISTS %s",TABLE_NAME));
        onCreate(db);
    }

    public boolean insertOrder()
}
