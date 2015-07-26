package com.ricardo.spotify;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import kaaes.spotify.webapi.android.models.Artist;

/**
 * Created by MACINTOSH on 25/07/2015.
 */
public class ListResultsAdapter extends ArrayAdapter<Artist> {

    private final Context context;
    private ArrayList<Artist> artists;


    public ListResultsAdapter(Context context, ArrayList<Artist> artists)
    {
        super(context,-1,artists);
        this.context = context;
        this.artists = artists;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.artist_list_item, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.artistName);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.artistImage);
        //set artist name
        textView.setText(artists.get(position).name);
        // set artist image
        try
        {
            //Picasso.with(context).load(artists.get(position).images.get(position).url).into(imageView);
        }catch (Exception message)
        {
            Log.d("Error picasso: ",message.getCause().toString());
        }

        return rowView;
    }

    private class LoadArtistImage extends AsyncTask<Void, Void, Void>
    {
        ImageView imageView;
        int position;

        LoadArtistImage(ImageView imageView, int position){
            this.imageView = imageView;
            this.position = position;
        }

        @Override
        protected Void doInBackground(Void... params) {

            return null;
        }


    }
}
