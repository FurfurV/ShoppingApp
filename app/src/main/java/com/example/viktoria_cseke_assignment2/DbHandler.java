package com.example.viktoria_cseke_assignment2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHandler extends SQLiteOpenHelper {

    //db version
    private static final int DB_VERSION = 1;

    //db name
    private static final String DB_NAME = "shoppingDb";

    //table names
    private static final String TABLE_USERS = "userdetails";
    private static final String TABLE_CART = "cart";

    // user table -column names
    private static final String KEY_ID = "id";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_ADDRESS = "address";

    //cart table - column names
    private static final String KEY_ITEMNAME = "itemname";
    private static final String KEY_ITEMCODE = "itemcode";
    private static final String KEY_ITEMPRICE = "itemprice";

    public DbHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    //table create statements
    //users table
    private static final String CREATE_TABLE_USERS = "CREATE TABLE " + TABLE_USERS +
            "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_USERNAME + " TEXT,"
            + KEY_PASSWORD + " TEXT,"
            + KEY_ADDRESS + " TEXT" + ")";

    //cart table
    private static final String CREATE_TABLE_CART = "CREATE TABLE " + TABLE_CART +
            "(" + KEY_ITEMNAME + " TEXT,"
            + KEY_ITEMCODE + " STRING PRIMARY KEY ,"
            + KEY_ITEMPRICE + " TEXT," + ")";


    @Override
    public void onCreate(SQLiteDatabase db) {

        //creating tables
        db.execSQL(CREATE_TABLE_USERS);
        db.execSQL(CREATE_TABLE_CART);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if exist
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        // Create tables again
        onCreate(db);

    }
}
