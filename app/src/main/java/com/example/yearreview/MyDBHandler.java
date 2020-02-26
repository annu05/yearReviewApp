package com.example.yearreview;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "yearReviewDB.db";
    private static final String TABLE_ANIME = "Anime";
    private static final String COLUMN_animeID = "animeID";
    private static final String COLUMN_animeName = "animeName";
    private static final String COLUMN_animeImage = "animeImage";
    private static final String COLUMN_animeRating = "animerating";
    private static final String COLUMN_animestartdate = "animestartdate";
    private static final String COLUMN_animestartmonth = "animestartmonth";
    private static final String COLUMN_animestartyear = "animestartyear";
    private static final String COLUMN_animeenddate = "animeenddate";
    private static final String COLUMN_animeendmonth = "animeendmonth";
    private static final String COLUMN_animeendyear = "animeendyear";
    private static final String COLUMN_episode = "episode";
    public MyDBHandler(@Nullable MainActivity context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super( context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                    "CREATE TABLE " + TABLE_ANIME + "(" +
                            COLUMN_animeID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                            COLUMN_animeName + " TEXT," +
                            COLUMN_animeImage + " TEXT," +
                            COLUMN_animeRating + " INTEGER," +
                            COLUMN_animestartdate + " INTEGER," +
                            COLUMN_animestartmonth + " TEXT," +
                            COLUMN_animestartyear + " INTEGER," +
                            COLUMN_animeenddate + " INTEGER," +
                            COLUMN_animeendmonth + " TEXT," +
                            COLUMN_animeendyear + " INTEGER," +
                            COLUMN_episode + " INTEGER " + ")";


        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public List<Anime> getAllanime() {
        List<Anime> animeList = new ArrayList<Anime>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ANIME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Anime anime = new Anime();
                anime.setAnimeID(Integer.parseInt(cursor.getString(0)));
                anime.setAnimeName(cursor.getString(1));
                anime.setAnimeImage(cursor.getString(2));
                anime.setAnimerating(Integer.parseInt(cursor.getString(3)));
                anime.setAnimestartdate(Integer.parseInt(cursor.getString(4)));
                anime.setAnimestartmonth(cursor.getString(5));
                anime.setAnimestartyear(Integer.parseInt(cursor.getString(6)));
                anime.setAnimeenddate(Integer.parseInt(cursor.getString(7)));
                anime.setAnimeendmonth(cursor.getString(8));
                anime.setAnimeendyear(Integer.parseInt(cursor.getString(9)));
                anime.setEpisode(Integer.parseInt(cursor.getString(10)));



                // Adding contact to list
               animeList.add(anime);
            } while (cursor.moveToNext());
        }

        // return contact list
        return animeList;
    }
    public Boolean addHandler(String name,String image,String rating,String startdate,String startmonth,String startyear,String enddate,String endmonth,String endyear,String episode) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_animeName,name);
        values.put(COLUMN_animeImage,image);
        values.put(COLUMN_animeRating,rating);
        values.put(COLUMN_animestartdate,startdate);
        values.put(COLUMN_animestartmonth,startmonth);
        values.put(COLUMN_animestartyear,startyear);
        values.put(COLUMN_animeenddate,enddate);
        values.put(COLUMN_animeendmonth,endmonth);
        values.put(COLUMN_animeendyear,endyear);
        values.put(COLUMN_episode,episode);
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.insert(TABLE_ANIME, null, values);
        db.close();

        if(result==-1){
            return false;
        }else{
            return true;
        }

    }
    public Anime findHandler(String animeName) {
        String query = "Select * FROM " + TABLE_ANIME + "WHERE" + COLUMN_animeName + " = " + "'" + animeName + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Anime anime = new Anime();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            anime.setAnimeID(Integer.parseInt(cursor.getString(0)));
            anime.setAnimeName(cursor.getString(1));
            cursor.close();
        } else {
            anime = null;
        }
        db.close();
        return anime;
    }
    public boolean updateHandler(int animeid, String animename, String animeImage,int animerating,int animestartdate,String animestartmonth,int animestartyear,int animeenddate,String animeendmonth,int animeendyear,int episode) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_animeID,animeid);
        values.put(COLUMN_animeName,animename);
        values.put(COLUMN_animeImage,animeImage);
        values.put(COLUMN_animeRating,animerating);
        values.put(COLUMN_animestartdate,animestartdate);
        values.put(COLUMN_animestartmonth,animestartmonth);
        values.put(COLUMN_animestartyear,animestartyear);
        values.put(COLUMN_animeenddate,animeenddate);
        values.put(COLUMN_animeendmonth,animeendmonth);
        values.put(COLUMN_animeendyear,animeendyear);
        values.put(COLUMN_episode,episode);
        return db.update(TABLE_ANIME, values, COLUMN_animeID + "=" + animeid, null) > 0;
    }

}
