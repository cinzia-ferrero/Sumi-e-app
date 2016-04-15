package com.example.ferrero.sumi_e;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, DetailsActivity.class);
        return intent;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_details_activity);
        Log.v("DetailsActivity", "ok setContentView");

        String title = getIntent().getStringExtra("title");
        int drawableId = getIntent().getIntExtra(FragmentGallery.KEY_IMAGE, 0);

//        Bitmap bitmap = getIntent().getParcelableExtra("image");

        TextView titleTextView = (TextView) findViewById(R.id.detail_title);
        titleTextView.setText(title);

        if (drawableId != 0) {
            ImageView imageView = (ImageView) findViewById(R.id.detail_image);
            Drawable drawable = getResources().getDrawable(drawableId);
            imageView.setImageDrawable(drawable);
        }

    }
}
