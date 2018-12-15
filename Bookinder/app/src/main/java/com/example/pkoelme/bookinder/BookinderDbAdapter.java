package com.example.pkoelme.bookinder;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class BookinderDbAdapter {

    private static final String DEBUG_TAG = "SqLiteBookinderManager";
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "Bookinder.db";
    private static final String DB_USER_TABLE = "User";

    public static final String KEY_ID = "_id";
    public static final String ID_OPTIONS = "INTEGER PRIMARY KEY AUTOINCREMENT";
    public static final int ID_COLUMN = 0;
    public static final String LOGIN_DESCRIPTION = "Login";
    public static final String LOGIN_OPTION = "TEXT NOT NULL";
    public static final int LOGIN_COLUMN = 1;
    public static final String PASSWORD_DESCRIPTION = "password";
    public static final String PASSWORD_OPTION = "TEXT NOT NULL";
    public static final int PASSWORD_COLUMN = 2;
    public static final String EMAIL_DESCRIPTION = "E-mail";
    public static final String EMAIL_OPTION = "TEXT NOT NULL";
    public static final int EMAIL_COLUMN = 4;

    private static final String USER_TABLE_CREATE =
            "CREATE TABLE" + DB_USER_TABLE +
                    "(" + KEY_ID + " " + ID_OPTIONS + ", "
                    + LOGIN_DESCRIPTION + " " + LOGIN_OPTION + ", "
                    + PASSWORD_DESCRIPTION + " " + PASSWORD_OPTION + ", "
                    + EMAIL_DESCRIPTION + " " + EMAIL_OPTION
                    + ");";

    private static final String USER_DROP_TABLE = "DROP TABLE IF EXIST " + DB_USER_TABLE;

    private SQLiteDatabase db;
    private Context context;
    private DatabaseHelper dbHelper;

    private static class DatabaseHelper extends SQLiteOpenHelper{


        public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
        db.execSQL(USER_TABLE_CREATE);
            Log.d(DEBUG_TAG, "Tworzenie bazy ...");
            Log.d(DEBUG_TAG, "Table " + DB_USER_TABLE + "ver. " + DB_VERSION + "CREATED");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(USER_TABLE_CREATE);
            Log.d(DEBUG_TAG, "Update bazy");
            Log.d(DEBUG_TAG, "Table" + DB_USER_TABLE + " update z ver." + oldVersion + "to  ver." +newVersion);
            Log.d(DEBUG_TAG, "Wyczyszczono Dane");
            onCreate(db);
        }
    }
    public BookinderDbAdapter(Context context){
        this.context = context;
    }
    public BookinderDbAdapter open(){
        dbHelper = new DatabaseHelper(context, DB_NAME, null, DB_VERSION);
        try{
            db = dbHelper.getWritableDatabase();
        }catch (SQLException e){
            db = dbHelper.getReadableDatabase();
        }
        return this;
    }
    public void close(){
        dbHelper.close();
    }
}
