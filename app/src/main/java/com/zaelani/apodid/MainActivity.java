package com.zaelani.apodid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.zaelani.apodid.adapter.ListApodidAdapter;
import com.zaelani.apodid.model.Apodid;
import com.zaelani.apodid.model.ApodidData;

import java.util.ArrayList;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView rvApodid;
    private ArrayList<Apodid> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvApodid = findViewById(R.id.rvApod);
        rvApodid.setHasFixedSize(true);

        list.addAll(ApodidData.getListData());
        showRecyclerList();

        ImageView imageView = findViewById(R.id.iv_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Glide.with(this)
                .load(R.drawable.avaig)
                .apply(new RequestOptions().circleCropTransform())
                .into(imageView);

        imageView.setOnClickListener(this);


    }

    private void showRecyclerList() {
        rvApodid.setLayoutManager(new LinearLayoutManager(this));
        ListApodidAdapter listApodidAdapter = new ListApodidAdapter(list);
        rvApodid.setAdapter(listApodidAdapter);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_profile) {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        }
    }
}