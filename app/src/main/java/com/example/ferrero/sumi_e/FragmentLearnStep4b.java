package com.example.ferrero.sumi_e;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class FragmentLearnStep4b extends Fragment implements View.OnTouchListener {
    public int points = 0;
    View myFragmentView;
    ImageView imgpiatto;
    ImageView imgsuzuri;
    int imgPremuta = -1;
    int stato = 0;
    float prevX = 0;
    float prevY = 0;
    boolean down = false;
    ProgressBar progressBar;
    int firstEnterDown = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myFragmentView = inflater.inflate(R.layout.fragment_learn_layout4b, container, false);

        imgpiatto = (ImageView) myFragmentView.findViewById(R.id.piatto_nero);
        imgpiatto.setOnTouchListener(this);

        imgsuzuri = (ImageView) myFragmentView.findViewById(R.id.suzuri_ink4);
        imgsuzuri.setOnTouchListener(this);

        progressBar = (ProgressBar) myFragmentView.findViewById(R.id.progress4);

        return myFragmentView;
    }

    /*
     *
     * This method checks if the image of the suzuri is pressed and if the movement on the dish is correct.
     * The progress bar is updated accordingly to the user progress mixing the ink.
     *
    */
    @Override
    public boolean onTouch(View view, MotionEvent event) {

        if ((ImageView) view == imgpiatto) {
            float currentX = 0;
            float currentY = 0;

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    currentX = event.getRawX();
                    currentY = event.getRawY();
                    prevX = currentX;
                    prevY = currentY;
                    down = true;
                    firstEnterDown++;
                    checkState();
                    return true;

                case MotionEvent.ACTION_MOVE:
                    if (points < 100 && down == true) {
                        int pos[] = new int[2];
                        imgpiatto.getLocationOnScreen(pos);
                        float ulcx = pos[0];
                        float ulcy = pos[1];
                        float width = imgpiatto.getWidth();
                        float height = imgpiatto.getHeight();
                        float centerX = ulcx + width / 2;
                        float centerY = ulcy + height / 2;
                        double radius = width / 2 * 0.9;

                        float xTouch = event.getRawX();
                        float yTouch = event.getRawY();

                        double distanceFromCenter = Math.sqrt(Math.pow((double) (centerX - xTouch), (double) 2)
                                + Math.pow((double) (centerY - yTouch), (double) 2));

                        if (distanceFromCenter < radius) { // the finger has to be inside the dish
                            currentX = event.getRawX();
                            currentY = event.getRawY();
                            double distanceFromPrev = Math.sqrt(Math.pow((double) (prevX - xTouch), (double) 2)
                                    + Math.pow((double) (prevY - yTouch), (double) 2));
                            if (distanceFromPrev > width * 0.2) { // the finger has to move (so the new position has to be significantly different from the previous one)
                                prevX = currentX;
                                prevY = currentY;
                                points += 2;
                                progressBar.setProgress(points);
                            }
                        }
                    } else if (points >= 100) { // change the state to the final and call checkstate() to show the Continue button
                        stato = 2;
                        checkState();
                    }
                    return true;

                case MotionEvent.ACTION_UP:
                    prevX = 0;
                    prevY = 0;
                    down = false;
                    return true;

                default:
                    return false;
            }
        }

        if ((ImageView) view == imgsuzuri) {
            int pos[] = new int[2];
            imgsuzuri.getLocationOnScreen(pos);
            float ulcx = pos[0];
            float ulcy = pos[1];
            float width = imgsuzuri.getWidth();
            float height = imgsuzuri.getHeight();

            float xTouch = event.getRawX();
            float yTouch = event.getRawY();

            if (xTouch > ulcx && xTouch < ulcx + width && yTouch > ulcy && yTouch < ulcy + height) {
                imgPremuta = 2;
                checkState();
                return true;
            }
            return false;
        }

        return false;
    }

    /*
     *
     * This method checks if the user taps first the image of suzuri and then change the image of dish
     * when the user first enter it. When the process is finished the button Continue is shown.
     *
    */
    public void checkState() {
        switch (stato) {
            case 0:
                if (imgPremuta == 2) {
                    imgsuzuri.setImageResource(R.drawable.suzuri_withink_meno);
                    stato = 1;
                }
                break;
            case 1:
                if (firstEnterDown == 1) {
                    imgpiatto.setImageResource(R.drawable.piattino_nero_media);
                }
                break;
            case 2:
                Button buttonContinua = (Button) myFragmentView.findViewById(R.id.id_button4continua);
                buttonContinua.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }


}