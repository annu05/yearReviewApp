package com.example.yearreview;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

import androidx.annotation.Nullable;

public class MyDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "yearReviewDB.db";
    private static final String TABLE_NAME = "Anime";
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
    public MyDBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder query = new StringBuilder();
        query.append("CREATE TABLE"+TABLE_NAME+"(");
        query.append(COLUMN_animeID+"int primary key autoincrement,");
        query.append(COLUMN_animeName+"TEXT,");
        query.append(COLUMN_animeImage+"TEXT,");
        query.append(COLUMN_animeRating+"int,");
        query.append(COLUMN_animestartdate+"int,");
        query.append(COLUMN_animestartmonth+"TEXT,");
        query.append(COLUMN_animestartyear+"int,");
        query.append(COLUMN_animeenddate+"int,");
        query.append(COLUMN_animeendmonth+"TEXT,");
        query.append(COLUMN_animeendyear+"int,");
        query.append(COLUMN_episode+"int)");


        db.execSQL(String.valueOf(query));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public String loadHandler() {
        String result = "";
        String query = "select * from Anime";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            int result_0 = cursor.getInt(0);
            String result_1 = cursor.getString(1);
            result += String.valueOf(result_0) + " " + result_1 +
                    System.getProperty("line.separator");
        }
        cursor.close();
        db.close();
        return result;
    }
    public void addHandler(Anime anime) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_animeID,anime.getAnimeID());
        values.put(COLUMN_animeName,anime.getAnimeName());
        values.put(COLUMN_animeImage,anime.getAnimeImage());
        values.put(COLUMN_animeRating,anime.getAnimerating());
        values.put(COLUMN_animestartdate,anime.getAnimestartdate());
        values.put(COLUMN_animestartmonth,anime.getAnimestartmonth());
        values.put(COLUMN_animestartyear,anime.getAnimestartyear());
        values.put(COLUMN_animeenddate,anime.getAnimeenddate());
        values.put(COLUMN_animeendmonth,anime.getAnimeendmonth());
        values.put(COLUMN_animeendyear,anime.getAnimeendyear());
        values.put(COLUMN_episode,anime.getEpisode());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();

    }
    public Anime findHandler(String animeName) {
        String query = "Select * FROM " + TABLE_NAME + "WHERE" + COLUMN_animeName + " = " + "'" + animeName + "'";
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
        return db.update(TABLE_NAME, values, COLUMN_animeID + "=" + animeid, null) > 0;
    }

}
