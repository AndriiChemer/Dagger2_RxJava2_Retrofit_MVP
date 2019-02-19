package com.example.andrii.rxprojectlesson.core.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.example.andrii.rxprojectlesson.ui.car.list.presentation.CarGridLayoutAdapter;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T extends ListItem, VH extends ViewHolder> extends RecyclerView.Adapter<VH> {

    private List<T> items = new ArrayList<>();

    @Override
    public void onBindViewHolder(@NonNull VH holder, int i) {
        T object = itemAt(holder.getAdapterPosition());

        holder.bind(object);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private T itemAt(int position) {
        return items.get(position);
    }

    public void setItems(List<T> items) {
        this.items.clear();
        this.items.addAll(items);

        notifyDataSetChanged();
    }

    public void addItems(List<T> items) {
        int firstIndex = this.items.size();
        this.items.addAll(items);

        notifyItemRangeInserted(firstIndex, this.items.size());
    }

    protected List<T> getItems() {
        return items;
    }

    @Override
    public int getItemViewType(int position) {
        return itemAt(position).getViewType();
    }
}
