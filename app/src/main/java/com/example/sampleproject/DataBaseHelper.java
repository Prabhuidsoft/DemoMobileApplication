package com.example.sampleproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static String MY_DATABASE_NAME = "College.db";
    public Context context;
    public static SQLiteDatabase database;
    public DataBaseHelper(Context con) {
        super(con,MY_DATABASE_NAME,null,1);
      context=con;
      database=con.openOrCreateDatabase(MY_DATABASE_NAME, Context.MODE_PRIVATE, null);
      createTable();
    }
    private void createTable(){
        database.execSQL("CREATE TABLE IF NOT EXISTS STUDENT (\n" +
                "\t`Student_Id`\tTEXT,\n" +
                "\t`Student_Fname`\tTEXT,\n" +
                "\t`Student_Lname`\tTEXT,\n" +
                "\t`Student_Password`\tTEXT,\n" +
                "\t`Student_Dep`\tTEXT\n" +
                ")");
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
