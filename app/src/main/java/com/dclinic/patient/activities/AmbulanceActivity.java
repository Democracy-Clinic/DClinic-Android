package com.dclinic.patient.activities;

import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dclinic.patient.AmbulanceAdapter;
import com.dclinic.patient.R;
import com.dclinic.patient.data.error.NegativeResult;
import com.dclinic.patient.data.error.PositiveResult;
import com.dclinic.patient.viewmodels.AmbulanceViewModel;


public class AmbulanceActivity extends BaseActivity {

    private AmbulanceViewModel viewModel;
    RecyclerView recyclerView;
    private AmbulanceAdapter adapter;

    @Override
    int inflate() {
        return R.layout.activity_ambulance;
    }


    @Override
    void init() {
        adapter = new AmbulanceAdapter(this);
        viewModel = new ViewModelProvider(this).get(AmbulanceViewModel.class);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        viewModel.getAmbulanceListLiveData().observe(this, listResultEvent -> {
            if (listResultEvent instanceof PositiveResult) {
                adapter.appendNewData(listResultEvent.getData());
            } else {
                //show error view or something
                Toast.makeText(this, ((NegativeResult) listResultEvent).getData().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.fetchAmbulanceList();
    }
}