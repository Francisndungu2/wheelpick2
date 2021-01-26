package com.demotxt.wheelpick2;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.List;



class VehicleList extends ArrayAdapter<Vehicle> {
    private Activity context;
    List<Vehicle> vehicles;

    public VehicleList(Activity context, List<Vehicle> vehicles) {
        super(context, R.layout.activity_layout_vehicle_list, vehicles);
        this.context = context;
        this.vehicles = vehicles;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.activity_layout_vehicle_list, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewGenre = (TextView) listViewItem.findViewById(R.id.textViewGenre);

        Vehicle vehicle = vehicles.get(position);
        textViewName.setText(vehicle.getArtistName());
        textViewGenre.setText(vehicle.getArtistGenre());

        return listViewItem;
    }
}