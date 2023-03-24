package com.example.orguevalls_projecte;

import static com.example.orguevalls_projecte.R.drawable.ic_play_f;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String titols[];
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, String[] countryList) {
        this.context = context;
        this.titols = countryList;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return titols.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_list_view, null);
        TextView concert = (TextView) view.findViewById(R.id.textViewItem);
        ImageView image = view.findViewById(R.id.imageButton);
        concert.setText(titols[i]);
        image.setImageResource(R.drawable.ic_play_f);
        return view;
    }
}