package com.demotxt.wheelpick2;

import com.google.firebase.database.IgnoreExtraProperties;


@IgnoreExtraProperties
public class Vehicle {
    private String artistId;
    private String artistName;
    private String artistGenre;

    public Vehicle(){

    }

    public Vehicle(String artistId, String artistName, String artistGenre) {
        this.artistId = artistId;
        this.artistName = artistName;
        this.artistGenre = artistGenre;
    }

    public String getArtistId() {
        return artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getArtistGenre() {
        return artistGenre;
    }
}
