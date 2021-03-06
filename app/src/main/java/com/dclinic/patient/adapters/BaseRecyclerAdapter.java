package com.dclinic.patient.adapters;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public abstract class BaseRecyclerAdapter<T extends BaseViewHolder, W> extends RecyclerView.Adapter<T> {

    protected List<W> mData;

    protected LayoutInflater mLayoutInflator;

    public BaseRecyclerAdapter(Context context) {
        mData = new ArrayList<>();
        mLayoutInflator = LayoutInflater.from(context);
    }

    private void removeDuplicates() {
        HashSet<W> set = new HashSet<>(mData.size());
        set.addAll(mData);
        mData = new ArrayList<>(set);
    }

    @Override
    public void onBindViewHolder(@NonNull T holder, int position) {
        if (!mData.isEmpty())
            holder.setData(mData.get(position));
    }

    @Override
    public int getItemCount() {

        return mData.size();
    }

    public W getItemAt(int position) {
        if (position < mData.size() - 1)
            return mData.get(position);

        return null;
    }

    public void addNewData(W newItem, int position) {
        if (mData != null) {
            mData.add(position, newItem);
            notifyDataSetChanged();
        }
    }

    public void update(List<W> newDataList) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffUtils<W>(mData, newDataList));
        diffResult.dispatchUpdatesTo(this);
    }

    public List<W> getItems() {
        if (mData == null)
            return new ArrayList<>();
        return mData;

    }

    public void appendNewData(List<W> newData) {
        clearData();
        if (mData.isEmpty())
            mData.addAll(newData);
        else
            update(newData);
        notifyDataSetChanged();
    }

    public void removeData(W data) {
        mData.remove(data);
        notifyDataSetChanged();
    }

    public void removeDataList(List<W> data) {
        mData.removeAll(data);
        notifyDataSetChanged();
    }

    public void addNewData(W data) {
        mData.add(data);
        notifyDataSetChanged();
    }

    public void addNewDataList(List<W> dataList) {
        mData.addAll(dataList);
        notifyDataSetChanged();
    }

    public void clearData() {
        mData = new ArrayList<>();
        notifyDataSetChanged();
    }

}
