package com.zaelani.apodid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import androidx.appcompat.widget.Toolbar;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_TITLE = "extra_title";
    public static final String EXTRA_DETAIL = "extra_detail";
    public static final String EXTRA_DATE = "extra_date";
    public static final String EXTRA_TRANSLATOR = "extra_translator";
    public static final String EXTRA_KONTEN = "extra_konten";
    public static final String EXTRA_FOTO = "extra_foto";
    public static final String EXTRA_IMAGE = "extra_image";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        Toolbar toolbar = findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);



        String title=getIntent().getStringExtra(EXTRA_TITLE);
        String detail=getIntent().getStringExtra(EXTRA_DETAIL);
        String date=getIntent().getStringExtra(EXTRA_DATE);
        String kreditFoto=getIntent().getStringExtra(EXTRA_FOTO);
        String kreditKonten=getIntent().getStringExtra(EXTRA_KONTEN);
        String translator=getIntent().getStringExtra(EXTRA_TRANSLATOR);
        int image = getIntent().getIntExtra(EXTRA_IMAGE,0);


        ImageView imageView = findViewById(R.id.detail_img);
        Glide.with(this)
                .load(image)
                .into(imageView);

        TextView tvDetail = findViewById(R.id.tv_detail_detail);
        TextView tvDate = findViewById(R.id.tv_detail_date);
        TextView tvTitle = findViewById(R.id.tv_detail_title);
        TextView tvKreditFoto = findViewById(R.id.tv_detail_kredit_foto);
        TextView tvKreditKonten = findViewById(R.id.tv_detail_kredit_konten);
        TextView tvTranslator = findViewById(R.id.tv_detail_translator);

        tvDetail.setText(detail);
        tvDate.setText(date);
        tvKreditFoto.setText(kreditFoto);
        tvTitle.setText(title);
        tvTranslator.setText(translator);
        tvKreditKonten.setText(kreditKonten);


        ImageView tbBack = findViewById(R.id.detail_tb_back);
        tbBack.setOnClickListener(this);

        Button btnLike = findViewById(R.id.btn_detail_like);
        btnLike.setOnClickListener(this);
        Button btnShare = findViewById(R.id.btn_detail_share);
        btnShare.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.detail_tb_back:
                Intent intent = new Intent(DetailActivity.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_detail_like:
                Toast.makeText(this, "Anda menyukai Post ini", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_detail_share:
                Toast.makeText(this, "Terima kasih telah membagikan Post ini", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
