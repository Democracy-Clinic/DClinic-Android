package com.dclinic.patient.adapters;


import android.view.View;

import androidx.recyclerview.widget.RecyclerView;


public abstract class BaseViewHolder<W> extends RecyclerView.ViewHolder implements View.OnClickListener {

    public BaseViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
    }

    public abstract void setData(W mData);
}
