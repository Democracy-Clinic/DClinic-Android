package com.dclinic.patient;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.List;

public class AmbulanceAdapter extends RecyclerView.Adapter<AmbulanceAdapter.ViewHolder> {
    private List<DataItem> dataItemList;

    public AmbulanceAdapter(List<DataItem> dataItemList) {
        this.dataItemList = dataItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_ambulance, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DataItem item = dataItemList.get(position);
        holder.tvTitle.setText(item.getName());
        holder.tvService.setText(item.getService());
        holder.tvAddress.setText(item.getAddress());
        holder.tvTownship.setText(item.getTownship());
        holder.tvTime.setText(item.getHour());
        holder.tvFee.setText(item.getFee());
    }

    @Override
    public int getItemCount() {
        return dataItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvTownship, tvFee, tvAddress, tvService, tvTime;
        MaterialButton btnCall;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvTownship = itemView.findViewById(R.id.tvTownship);
            tvFee = itemView.findViewById(R.id.tvFee);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvService = itemView.findViewById(R.id.tvService);
            tvTime = itemView.findViewById(R.id.tvTime);
            btnCall = itemView.findViewById(R.id.btnCall);
        }
    }
}
