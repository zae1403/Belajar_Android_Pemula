package com.zaelani.apodid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar toolbar = findViewById(R.id.about_toolbar);
        setSupportActionBar(toolbar);

        ImageView tb_back = findViewById(R.id.about_tb_back);
        tb_back.setOnClickListener(this);

        ImageView imageView = findViewById(R.id.civ_profile);
        Glide.with(this)
                .load(R.drawable.avaig)
                .apply(new RequestOptions().override(200,200))
                .into(imageView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.about_tb_back:
                Intent intent = new Intent(AboutActivity.this,MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
