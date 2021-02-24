package com.dclinic.patient.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dclinic.patient.AmbulanceAdapter;
import com.dclinic.patient.AmbulanceModel;
import com.dclinic.patient.R;
import com.dclinic.patient.utils.Utils;
import com.google.gson.Gson;


public class AmbulanceActivity extends AppCompatActivity {
    AmbulanceModel model;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        Gson gson = new Gson();
        String str = Utils.getJson(getApplicationContext(), "ambulance_data.json");
        model = gson.fromJson(str, AmbulanceModel.class);

        final AmbulanceAdapter adapter = new AmbulanceAdapter(model.getData());
        recyclerView.setAdapter(adapter);
    }
}