package com.example.ferrero.sumi_e;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class FragmentLearnStep2b extends Fragment implements View.OnTouchListener {

    public int points = 0;
    View myFragmentView;
    ImageView img;
    float prevX = 0;
    float prevY = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myFragmentView = inflater.inflate(R.layout.fragment_learn_layout2, container, false);

        img = (ImageView) myFragmentView.findViewById(R.id.suzuri);
        img.setOnTouchListener(this);

        return myFragmentView;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        boolean result;
        ProgressBar progressBar = (ProgressBar) myFragmentView.findViewById(R.id.progress);

        if (points < 100) {
            float currentX = 0;
            float currentY = 0;
            float width = img.getWidth();
            float height = img.getHeight();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    //Register the first touch on TouchDown and this should not change unless finger goes up.
                    currentX = event.getRawX();
                    currentY = event.getRawY();
                    prevX = currentX;
                    prevY = currentY;
                    //As the event is consumed, return true
                    result = true;
                    break;

                case MotionEvent.ACTION_MOVE:
                    currentX = event.getRawX();
                    currentY = event.getRawY();

                    if (Math.abs(currentX - prevX) > width * 0.3 && Math.abs(currentY - prevY) < height * 0.5) {
                        prevX = currentX;
                        prevY = currentY;
                        points += 3;
                        progressBar.setProgress(points);
                    }

                    result = true;
                    break;

                default:
                    result = false;
                    break;
            }
            return result;
        } else {
            Button buttonContinua = (Button) myFragmentView.findViewById(R.id.id_button2continua);
            buttonContinua.setVisibility(View.VISIBLE);
            img.setImageResource(R.drawable.suzuri_withink);
        }
        return false;
    }

}