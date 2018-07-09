package com.codepath.netflixapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.netflixapp.R;
import com.codepath.netflixapp.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public MovieArrayAdapter(Context context, List<Movie> movies) {

        super(context, android.R.layout.simple_list_item_1, movies);

    }

    public View getView(int position, View convertView, ViewGroup parent){
       //get data item for position
        Movie movie = getItem(position);

        //check the existing views being used
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
        }
        //find the image view
        ImageView lvImage = (ImageView) convertView.findViewById(R.id.lvMovieImage);
        //clear out image from convertView
       lvImage.setImageResource(0);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        //populate data
        tvTitle.setText(movie.getOriginalTitle());
        tvOverview.setText(movie.getOverview());

        Picasso.with(getContext()).load(movie.getPosterPath()).into(lvImage);
        //return the view
        return convertView;

    }
}
