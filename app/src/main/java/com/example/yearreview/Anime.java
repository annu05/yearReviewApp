package com.example.yearreview;

public class Anime {
    // fields
    private int animeID;
    private String animeName;
    private String animeImage;
    private int animerating;
    private int animestartdate;
    private String animestartmonth;
    private int animestartyear;
    private int animeenddate;
    private String animeendmonth;
    private int animeendyear;
    private int episode;

    // constructors
    public Anime() {}
    public Anime(int animeid, String animename, String animeImage,int animerating,int animestartdate,String animestartmonth,int animestartyear,int animeenddate,String animeendmonth,int animeendyear,int episode) {
        this.animeID = animeid;
        this.animeName = animename;
        this.animeImage = animeImage;
        this.animerating = animerating;
        this.animestartdate = animestartdate;
        this.animestartmonth = animestartmonth;
        this.animestartyear = animestartyear;
        this.animeenddate = animeenddate;
        this.animeendmonth = animeendmonth;
        this.animeendyear = animeendyear;
        this.episode = episode;
    }
    // properties


    public int getAnimeID() {
        return animeID;
    }

    public void setAnimeID(int animeID) {
        this.animeID = animeID;
    }

    public String getAnimeName() {
        return animeName;
    }

    public void setAnimeName(String animeName) {
        this.animeName = animeName;
    }

    public String getAnimeImage() {
        return animeImage;
    }

    public void setAnimeImage(String animeImage) {
        this.animeImage = animeImage;
    }

    public int getAnimerating() {
        return animerating;
    }

    public void setAnimerating(int animerating) {
        this.animerating = animerating;
    }

    public int getAnimestartdate() {
        return animestartdate;
    }

    public void setAnimestartdate(int animestartdate) {
        this.animestartdate = animestartdate;
    }

    public String getAnimestartmonth() {
        return animestartmonth;
    }

    public void setAnimestartmonth(String animestartmonth) {
        this.animestartmonth = animestartmonth;
    }

    public int getAnimestartyear() {
        return animestartyear;
    }

    public void setAnimestartyear(int animestartyear) {
        this.animestartyear = animestartyear;
    }

    public int getAnimeenddate() {
        return animeenddate;
    }

    public void setAnimeenddate(int animeenddate) {
        this.animeenddate = animeenddate;
    }

    public String getAnimeendmonth() {
        return animeendmonth;
    }

    public void setAnimeendmonth(String animeendmonth) {
        this.animeendmonth = animeendmonth;
    }

    public int getAnimeendyear() {
        return animeendyear;
    }

    public void setAnimeendyear(int animeendyear) {
        this.animeendyear = animeendyear;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }
}