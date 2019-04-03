package com.example.andrii.rxprojectlesson.core.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T extends ListItem, VH extends ViewHolder> extends RecyclerView.Adapter<VH> {

    private List<T> items = new ArrayList<>();

    @Override
    public void onBindViewHolder(@NonNull VH holder, int i) {
        T object = itemAt(holder.getAdapterPosition());

        holder.bind(object, holder.getAdapterPosition());
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

    public void removeItems(T items) {
        this.items.remove(items);

        notifyDataSetChanged();
    }

    public void removeItemsAtPosition(int position) {
        T item = itemAt(position);
        this.items.remove(item);

        notifyDataSetChanged();
    }

    public void clearItems() {
        this.items.clear();

        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return itemAt(position).getViewType();
    }
}
