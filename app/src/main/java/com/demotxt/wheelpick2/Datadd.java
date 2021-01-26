package com.demotxt.wheelpick2;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;


public class Datadd extends AppCompatActivity {


    public static final String VEHICLE_NAME = "net.simplifiedcoding.firebasedatabaseexample.vehiclename";
    public static final String VEHICLE_ID = "net.simplifiedcoding.firebasedatabaseexample.vehicleid";


    EditText editTextName;
    Spinner spinnerGenre;
    Button buttonAddArtist;
    ListView listViewArtists;


    List<Vehicle> vehicles;


    DatabaseReference databaseVehicles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datadd);


        databaseVehicles = FirebaseDatabase.getInstance().getReference("vehicles");


        editTextName = (EditText) findViewById(R.id.editTextName);
        spinnerGenre = (Spinner) findViewById(R.id.spinnerGenres);
        listViewArtists = (ListView) findViewById(R.id.listViewArtists);

        buttonAddArtist = (Button) findViewById(R.id.buttonAddArtist);


        vehicles = new ArrayList<>();



        buttonAddArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addVehicle();
            }
        });
    }


    private void addVehicle() {

        String name = editTextName.getText().toString().trim();
        String genre = spinnerGenre.getSelectedItem().toString();


        if (!TextUtils.isEmpty(name)) {

            String id = databaseVehicles.push().getKey();


            Vehicle vehicle = new Vehicle(id, name, genre);


            databaseVehicles.child(id).setValue(vehicle);


            editTextName.setText("");


            Toast.makeText(this, "Vehicle added", Toast.LENGTH_LONG).show();
        } else {

            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        //attaching value event listener
        databaseVehicles.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                vehicles.clear();


                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    Vehicle vehicle = postSnapshot.getValue(Vehicle.class);

                    vehicles.add(vehicle);
                }


                VehicleList artistAdapter = new VehicleList(Datadd.this, vehicles);

                listViewArtists.setAdapter(artistAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
