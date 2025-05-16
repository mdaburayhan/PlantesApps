package com.arsoft.planetsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Planet> {

    private ArrayList<Planet> planetsArraylist;
    Context context;

    public MyCustomAdapter(ArrayList<Planet> planetsArraylist, Context context) {
        super(context, R.layout.item_list_layout, planetsArraylist);
        this.planetsArraylist = planetsArraylist;
        this.context = context;
    }


    private static class MyViewHolder{
        TextView planetName;
        TextView moonCount;
        ImageView planetImg;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // 1- Get the planet object for the current position
        Planet planet = getItem(position);

        // 2- Inflate Layout
        MyViewHolder viewHolder;
        final View result;

        if (convertView == null){
            viewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.item_list_layout,
                    parent,
                    false
            );

            // Finding Views:
            viewHolder.planetName = convertView.findViewById(R.id.planetName);
            viewHolder.moonCount = convertView.findViewById(R.id.moonCount);
            viewHolder.planetImg = convertView.findViewById(R.id.imageView);

            result = convertView;

            convertView.setTag(viewHolder);

        }else {
            viewHolder = (MyViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.planetName.setText(planet.getPlanetName());
        viewHolder.moonCount.setText(planet.getMoonCount());
        viewHolder.planetImg.setImageResource(planet.getPlanetImage());


        return result;


    }

}
