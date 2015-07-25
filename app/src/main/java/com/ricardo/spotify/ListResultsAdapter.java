package com.ricardo.spotify;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import kaaes.spotify.webapi.android.models.Artist;

/**
 * Created by MACINTOSH on 25/07/2015.
 */
public class ListResultsAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] artistsNames;
    private ArrayList<Artist> artists = new ArrayList<Artist>();

    public ListResultsAdapter(Context context, String[] artistsNames)
    {
        super(context,-1,artistsNames);
        this.context = context;
        this.artistsNames = artistsNames;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.artist_list_item, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.artistName);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.artistImage);

        //set artist name
        textView.setText(artistsNames[position]);
        // change the icon for Windows and iPhone

        imageView.setImageResource(R.drawable.aretha_franklin);



        return rowView;
    }
}
