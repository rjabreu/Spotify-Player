package com.ricardo.spotify;

import android.support.annotation.ArrayRes;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import kaaes.spotify.webapi.android.SpotifyApi;
import kaaes.spotify.webapi.android.SpotifyService;
import kaaes.spotify.webapi.android.models.Artist;
import kaaes.spotify.webapi.android.models.ArtistsPager;
import kaaes.spotify.webapi.android.models.Image;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by MACINTOSH on 25/07/2015.
 */
public class SpotifyHelper {
    ArrayList<Artist> foundArtists = new ArrayList<Artist>();
    int flag = 0;

    ArrayList<Artist> getArtists(String artistName)
    {
        searchArtist(artistName);

        for(int i = 3; i < foundArtists.size(); i++)
            foundArtists.remove(i);
        return foundArtists;

    }


    String[] getArtistsNames()
    {
        String[] names = new String[foundArtists.size()];

        if(foundArtists != null && flag == 1)
        {
            for(int i = 0; i < foundArtists.size(); i++)
            {
                names[i] = foundArtists.get(i).name;
                foundArtists.remove(i);
            }
            flag = 0;
            return names;
        }
        return names;
    }

    /*ArrayList<Image>getArtistsImage()
    {
        ArrayList<Image> lstImages = new ArrayList<Image>() ;
        return lstImages.add(foundArtists.get(0).images);
    }*/

    void searchArtist(String artistName){
        SpotifyApi api = new SpotifyApi();
        SpotifyService spotify = api.getService();



        spotify.searchArtists(artistName, new Callback<ArtistsPager>() {
            @Override
            public void success(ArtistsPager artistsPager, Response response) {
                 for(int i = 0; i < artistsPager.artists.items.size(); i++)
                 {

                     foundArtists.add(artistsPager.artists.items.get(i));
                 }

            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("Artist failed:",error.getUrl().toString());
            }
        });


        flag = 1;

    }
}
