package com.example.viktoria_cseke_assignment2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

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
    private static final String KEY_ITEMAMOUNT = "itemamount";

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
            + KEY_ITEMCODE + " STRING PRIMARY KEY,"
            + KEY_ITEMPRICE + " TEXT,"
            + KEY_ITEMAMOUNT + " TEXT" + ")";


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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CART);

        // Create tables again
        onCreate(db);

    }

    /*
    *   Creating new user
    */
    public void insertUserDetails(String username, String password, String address){
        SQLiteDatabase db = this.getWritableDatabase();
        //Create a new map of values, where column names are the keys
        ContentValues cValues = new ContentValues();
        cValues.put(KEY_USERNAME, username);
        cValues.put(KEY_PASSWORD, password);
        cValues.put(KEY_ADDRESS, address);

        // Insert the new row, returning the primary key value of the new row
         long newRowId = db.insert(TABLE_USERS,null, cValues);

         db.close();
    }
    /*
    * create new cart
     */
    public void insertCartDetails(String itemname, String itemcode, Double price, String itemamount){
        SQLiteDatabase db = this.getWritableDatabase();
        //Create a new map of values, where column names are the keys
        ContentValues cValues = new ContentValues();
        cValues.put(KEY_ITEMNAME, itemname);
        cValues.put(KEY_ITEMCODE, itemcode);
        cValues.put(KEY_ITEMPRICE, price);
        cValues.put(KEY_ITEMAMOUNT, itemamount);
        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(TABLE_CART,null, cValues);

        db.close();
    }


    /*
    *   get all user details
     */
    public ArrayList<HashMap<String, String>> getUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_USERS;

        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            HashMap<String, String> user = new HashMap<>();
            user.put("id", cursor.getString(cursor.getColumnIndex(KEY_ID)));
            user.put("username", cursor.getString(cursor.getColumnIndex(KEY_USERNAME)));
            user.put("password", cursor.getString(cursor.getColumnIndex(KEY_PASSWORD)));
            user.put("address", cursor.getString(cursor.getColumnIndex(KEY_ADDRESS)));
            userList.add(user);
        }
        return userList;
    }

    /*
     *   get user details based on id
     */
    public ArrayList<HashMap<String, String>> getUserByUsername(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_USERS;
        Cursor cursor = db.query(TABLE_USERS, new String[]{KEY_ID, KEY_USERNAME, KEY_PASSWORD, KEY_ADDRESS},
                KEY_USERNAME + "=?", new String[]{username}, null, null, null, null);
        if (cursor.moveToNext()) {
            HashMap<String, String> user = new HashMap<>();
            user.put("id", cursor.getString(cursor.getColumnIndex(KEY_ID)));
            user.put("username", cursor.getString(cursor.getColumnIndex(KEY_USERNAME)));
            user.put("password", cursor.getString(cursor.getColumnIndex(KEY_PASSWORD)));
            user.put("address", cursor.getString(cursor.getColumnIndex(KEY_ADDRESS)));
            userList.add(user);
        }
        return userList;
    }


    /*
    *   get all cart details
     */
    public ArrayList<HashMap<String, String>> getCartbyNum(String itemcode) {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> cartList = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + TABLE_CART;

        Cursor cursor = db.query(TABLE_CART, new String[]{KEY_ITEMNAME, KEY_ITEMCODE, KEY_ITEMPRICE, KEY_ITEMAMOUNT},
                KEY_ITEMCODE + "=?", new String[]{itemcode}, null, null, null, null);
        while (cursor.moveToNext()) {
            HashMap<String, String> cart = new HashMap<>();
            cart.put("itemname", cursor.getString(cursor.getColumnIndex(KEY_ITEMNAME)));
            cart.put("itemcode", cursor.getString(cursor.getColumnIndex(KEY_ITEMCODE)));
            cart.put("price", cursor.getString(cursor.getColumnIndex(KEY_ITEMPRICE)));
            cart.put("itemamount", cursor.getString(cursor.getColumnIndex(KEY_ITEMAMOUNT)));

            cartList.add(cart);
        }
        return cartList;
    }

    public ArrayList<HashMap<String, String>> getCart() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> cartList = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + TABLE_CART;

        Cursor cursor = db.rawQuery(selectQuery, null);
        while (cursor.moveToNext()) {
            HashMap<String, String> cart = new HashMap<>();
            cart.put("itemname", cursor.getString(cursor.getColumnIndex(KEY_ITEMNAME)));
            cart.put("itemcode", cursor.getString(cursor.getColumnIndex(KEY_ITEMCODE)));
            cart.put("price", cursor.getString(cursor.getColumnIndex(KEY_ITEMPRICE)));
            cart.put("itemamount", cursor.getString(cursor.getColumnIndex(KEY_ITEMAMOUNT)));
            cartList.add(cart);
        }
        return cartList;
    }

    /*
    *   delete user details
     */
    public void deleteUser(String itemcode) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS, KEY_ID + " = ?", new String[]{String.valueOf(itemcode)});
        db.close();
    }


    /*
    *delete cart item details
     */
    public void deleteCartItem(String itemcode) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CART, KEY_ITEMCODE + " = ?", new String[]{itemcode});
        db.close();
    }

    public void deleteCart() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CART,null,null);
        db.close();
    }

    /*
    *   update user details
     */
    public int updateUserDetails(String username, String password, String address, int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cVals = new ContentValues();
        cVals.put(KEY_USERNAME, username);
        cVals.put(KEY_PASSWORD, password);
        cVals.put(KEY_ADDRESS, address);
        int count = db.update(TABLE_USERS, cVals, KEY_ID + " = ?", new String[]{String.valueOf(id)});
        return count;
    }

    /*
    *   update cart
     */
    public int updateCartDetails(String itemname, String itemcode, double price, String itemamount) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cVals = new ContentValues();
        cVals.put(KEY_ITEMNAME, itemname);
        cVals.put(KEY_ITEMPRICE, price);
        cVals.put(KEY_ITEMAMOUNT, itemamount);
        int count = db.update(TABLE_CART, cVals, KEY_ITEMCODE + " = ?", new String[]{itemcode});
        return count;
    }

    public int updateCartAmount(String itemcode, String itemamount) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cVals = new ContentValues();
        cVals.put(KEY_ITEMAMOUNT, itemamount);
        int count = db.update(TABLE_CART, cVals, KEY_ITEMCODE + " = ?", new String[]{itemcode});
        return count;
    }



}
