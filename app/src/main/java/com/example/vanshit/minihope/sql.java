package com.example.vanshit.minihope;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import static android.app.PendingIntent.getActivity;


/**
 * Created by Vanshit on 03-26-2017.
 */
class sql extends SQLiteOpenHelper{
       private static final String database_name = "Information";
       private static final String table_name = "User";
       private static final int database_version = 16;
       private static final String id= "S_No";
       private static final String naam = "Name";
       private static final String add = "Address";
       private static final String phone_no = "Phone";
       private static final String prob = "Problem";
       private static final String create_table = "CREATE TABLE " + table_name + "(" +
               id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
               naam + " TEXT," +
               add + " TEXT," +
               phone_no + " TEXT," +
               prob + " TEXT "+ ");" ;
       private static final String drop_table = "DROP TABLE IF EXISTS "+table_name;
        public Context context;
       public sql(Context context){
           super(context,database_name,null,database_version);
           this.context=context;
       }
       @Override
       public void onCreate(SQLiteDatabase db){

           try {
               db.execSQL(create_table);

           }catch(SQLException e){
             //  Toast.makeText(context,"notcreated",Toast.LENGTH_LONG);
               e.printStackTrace();
           }
       }

       @Override
       public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
           try {
               db.execSQL(drop_table);
               onCreate(db);
           }catch(SQLException e){
               e.printStackTrace();
           }
       }
        public long adduser(Section1 sec1){
            SQLiteDatabase db = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(naam,sec1.name);
            contentValues.put(add,sec1.address);
            contentValues.put(phone_no,sec1.phone);
            contentValues.put(prob, sec1.fproblem);
            long id =  db.insert(table_name,null,contentValues);
            db.close();
            //Toast.makeText(context,"4SignUp successful",Toast.LENGTH_SHORT).show();//2nd arg is nullColumnHack.if null values are allowed than we can specify
            return id;                                                        // any one column which can be null in this arg.
        }
        public String databaseToString(){
            String dbstring = "";
            SQLiteDatabase db = getWritableDatabase();
            String query = "SELECT " +naam + " FROM " + table_name + " WHERE 1";

            Cursor c = db.rawQuery(query,null);
            c.moveToFirst();
            while(!c.isAfterLast()){
                if(c.getString(c.getColumnIndex(naam))!=null){
                    dbstring += c.getString(c.getColumnIndex(naam));
                    dbstring += "\n";
                }

            }
            db.close();
            return dbstring;
        }
   }

