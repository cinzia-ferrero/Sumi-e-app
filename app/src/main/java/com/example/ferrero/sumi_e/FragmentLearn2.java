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

public class FragmentLearn2 extends Fragment implements View.OnTouchListener {

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
        /*
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.suzuri, options);
        int imageHeight = img.getDrawable().getBounds().height();
        int imageWidth = img.getDrawable().getBounds().width();
        Log.v("FragmentLearn3", "imageHeight: "+imageHeight+" "+img.getHeight()+" imageWidth: "+imageWidth+" "+img.getWidth());
        img.setImageBitmap(decodeSampledBitmapFromResource(getResources(), R.id.suzuri, 100, 100));
        */

        Log.v("FragmentLearn2", "entrato in onCreateView");
        img.setOnTouchListener(this);


        /*
        final GestureDetector gesture = new GestureDetector(getActivity(),
                new GestureDetector.SimpleOnGestureListener() {

                    @Override
                    public boolean onDown(MotionEvent e) {
                        return true;
                    }

                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                                           float velocityY) {

                        Log.v("FragmentLearn2", "onFling has been called!");
                        final int SWIPE_MIN_DISTANCE = 120;
                        final int SWIPE_MAX_OFF_PATH = 250;
                        final int SWIPE_THRESHOLD_VELOCITY = 10;
                        try {
                            if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
                                return false;
                            if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
                                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                                Log.v("FragmentLearn2", "Right to Left");
                            } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                                Log.v("FragmentLearn2", "Left to Right");
                            }
                        } catch (Exception e) {
                            // nothing
                        }

                        return super.onFling(e1, e2, velocityX, velocityY);
                    }
                });

        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gesture.onTouchEvent(event);
            }
        });
        */

        return myFragmentView;
    }

    /*
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
    */

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        boolean result;
        ProgressBar progressBar = (ProgressBar) myFragmentView.findViewById(R.id.progress);

        if (points < 100) {
            float currentX = 0;
            float currentY = 0;
            float width = img.getWidth();
            float height = img.getHeight();
            //Log.v("FragmentLearn2", "width: " + width + "height: " + height);

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    //Log.v("FragmentLearn2", "enter ACTION_DOWN");
                    //Register the first touch on TouchDown and this should not change unless finger goes up.
                    currentX = event.getRawX();
                    currentY = event.getRawY();
                    prevX = currentX;
                    prevY = currentY;
                    //As the event is consumed, return true
                    result = true;
                    break;

                case MotionEvent.ACTION_MOVE:
                    //Log.v("FragmentLearn2", "enter ACTION_MOVE");
                    currentX = event.getRawX();
                    currentY = event.getRawY();
                    //Log.v("FragmentLearn2", "currentX: "+currentX+"\ncurrentY: "+currentY+"\nprevX: "+prevX+"\nprevY: "+prevY);

                    if (Math.abs(currentX - prevX) > width * 0.3 && Math.abs(currentY - prevY) < height * 0.5) {
                        prevX = currentX;
                        prevY = currentY;
                        points += 3;
                        Log.v("FragmentLearn2 ok", "if move verificato, points: " + points);
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