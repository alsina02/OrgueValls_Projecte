package com.example.orguevalls_projecte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class CantatesActivity extends AppCompatActivity {

    private ListView simpleList;
    private String[] titols = {"El Nano", "Cantanta Orgue"};
    private int oldPosition = 2147483647;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cantates);
        setTitle("Reproductor de Cantates");

        simpleList = (ListView)findViewById(R.id.concertListView);
        // ArrayAdapter customAdapter = new ArrayAdapter(this, R.layout.activity_list_view, R.id.textViewItem, titols);
        CustomAdapter customAdapter = new CustomAdapter(this, titols);
        simpleList.setAdapter(customAdapter);

        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ImageView thisImageView = view.findViewById(R.id.imageButton);
                ImageView oldImageView = thisImageView;
                if (oldPosition != 2147483647) {
                    oldImageView = getViewByPosition(oldPosition, simpleList).findViewById(R.id.imageButton);
                    if ((mp.isPlaying() && oldPosition == position) || oldPosition != position) {
                        mp.pause();
                        thisImageView.setImageResource(R.drawable.ic_play_f);
                    } else if ((!mp.isPlaying() && oldPosition == position)) {
                        mp.start();
                        thisImageView.setImageResource(R.drawable.ic_pause_foreground);
                    }
                }

                switch (position) {
                    case 1: if ((oldPosition != position && oldPosition != 2147483647) || oldPosition == 2147483647) {
                        mp = MediaPlayer.create(CantatesActivity.this, R.raw.orgue_poblet);
                        mp.start();

                        if (oldPosition != 2147483647) {
                            oldImageView.setImageResource(R.drawable.ic_play_f);
                        }

                        thisImageView.setImageResource(R.drawable.ic_pause_foreground);
                    }
                        break;
                    default: if ((oldPosition != position && oldPosition != 2147483647) || oldPosition == 2147483647) {
                        mp = MediaPlayer.create(CantatesActivity.this, R.raw.elnano_melendi);
                        mp.start();

                        if (oldPosition != 2147483647) {
                            oldImageView.setImageResource(R.drawable.ic_play_f);
                        }

                        thisImageView.setImageResource(R.drawable.ic_pause_foreground);
                    }
                        break;
                }

                oldPosition = position;
            }
        });
    }

    public View getViewByPosition(int pos, ListView listView) {
        final int firstListItemPosition = listView.getFirstVisiblePosition();
        final int lastListItemPosition = firstListItemPosition + listView.getChildCount() - 1;

        if (pos < firstListItemPosition || pos > lastListItemPosition ) {
            return listView.getAdapter().getView(pos, null, listView);
        } else {
            final int childIndex = pos - firstListItemPosition;
            return listView.getChildAt(childIndex);
        }
    }
}