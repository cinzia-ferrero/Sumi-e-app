package com.example.ferrero.sumi_e;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_details_activity);
        Log.v("DetailsActivity", "ok setContentView");

        String title = getIntent().getStringExtra("title");
        Log.v("DetailsActivity", "ok intentTitle");
        Bitmap bitmap = getIntent().getParcelableExtra("image");
        Log.v("DetailsActivity", "ok intentImage");

        TextView titleTextView = (TextView) findViewById(R.id.detail_title);
        titleTextView.setText(title);
        Log.v("DetailsActivity", "ok title painting");

        ImageView imageView = (ImageView) findViewById(R.id.detail_image);
        imageView.setImageBitmap(bitmap);
    }
}
