package com.dclinic.patient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dclinic.patient.adapters.BaseRecyclerAdapter;
import com.dclinic.patient.adapters.BaseViewHolder;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class AmbulanceAdapter extends BaseRecyclerAdapter<AmbulanceViewHolder,AmbulanceDataItem> {
    private List<AmbulanceDataItem> ambulanceDataItemList;

    public AmbulanceAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public AmbulanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_ambulance, parent, false);
        return new AmbulanceViewHolder(view);
    }

}

class AmbulanceViewHolder extends BaseViewHolder<AmbulanceDataItem>{

    TextView tvTitle, tvTownship, tvFee, tvAddress, tvService, tvTime;
    MaterialButton btnCall;

    public AmbulanceViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(AmbulanceDataItem mData) {
        tvTitle = itemView.findViewById(R.id.tvTitle);
        tvTownship = itemView.findViewById(R.id.tvTownship);
        tvFee = itemView.findViewById(R.id.tvFee);
        tvAddress = itemView.findViewById(R.id.tvAddress);
        tvService = itemView.findViewById(R.id.tvService);
        tvTime = itemView.findViewById(R.id.tvTime);
        btnCall = itemView.findViewById(R.id.btnCall);
    }
}
