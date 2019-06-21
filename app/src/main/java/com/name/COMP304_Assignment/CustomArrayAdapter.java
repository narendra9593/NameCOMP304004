package com.name.COMP304_Assignment;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomArrayAdapter extends ArrayAdapter<String> {

    private final LayoutInflater mInflater;
    private final List<String> items;
    private final int mResource;

     public CustomArrayAdapter(@NonNull Context context, @LayoutRes int resource,
                               @NonNull List objects) {
        super(context, resource, 0, objects);

        mInflater = LayoutInflater.from(context);
        mResource = resource;
        items = objects;
    }
    @Override
    public View getDropDownView(int position, @Nullable View convertView,
                                @NonNull ViewGroup parent) {
        return createItemView(position, parent);
    }

    @Override
    public @NonNull View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, parent);
    }

    private View createItemView(int position, ViewGroup parent){
        final View view = mInflater.inflate(mResource, parent, false);
        TextView offTypeTv = view.findViewById(R.id.offer_type_txt);
        offTypeTv.setText(items.get(position));
        return view;
    }
}