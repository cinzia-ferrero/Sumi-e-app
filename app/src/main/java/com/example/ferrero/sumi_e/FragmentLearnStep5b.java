package com.example.ferrero.sumi_e;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class FragmentLearnStep5b extends Fragment implements View.OnTouchListener {
    View myFragmentView;
    ImageView imgpiatto;
    ImageView imgsuzuri;
    int imgPremuta = -1;
    int stato = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myFragmentView = inflater.inflate(R.layout.fragment_learn_layout5, container, false);

        imgpiatto = (ImageView) myFragmentView.findViewById(R.id.piatto_nero5);
        imgpiatto.setOnTouchListener(this);

        imgsuzuri = (ImageView) myFragmentView.findViewById(R.id.suzuri_ink5);
        imgsuzuri.setOnTouchListener(this);

        return myFragmentView;
    }


    @Override
    public boolean onTouch(View view, MotionEvent event) {

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
                imgPremuta = 1;
                checkState();
                return true;
            }
            return false;
        }

        if ((ImageView) view == imgpiatto) {
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


            if (distanceFromCenter < radius + radius * 0.2 && distanceFromCenter > radius - radius * 0.2) {
                // 1° quadrante
                if (xTouch > centerX && yTouch < centerY) {
                    imgPremuta = 2;
                    checkState();
                }
                // 2° quadrante
                if (xTouch > centerX && yTouch > centerY) {
                    imgPremuta = 3;
                    checkState();
                }
                // 3° quadrante
                if (xTouch < centerX && yTouch > centerY) {
                    imgPremuta = 4;
                    checkState();
                }
                // 4° quadrante
                if (xTouch < centerX && yTouch < centerY) {
                    imgPremuta = 5;
                    checkState();
                }
                return true;
            }
            return false;
        }


        return false;
    }

    public void checkState() {
        switch (stato) {
            case 0:
                if (imgPremuta == 1) {
                    imgsuzuri.setImageResource(R.drawable.suzuri_withink_meno);
                    stato = 1;
                }
                break;
            case 1:
                if (imgPremuta == 2) {
                    imgpiatto.setImageResource(R.drawable.piattino_nero_puro1);
                    stato = 2;
                }
                if (imgPremuta == 3) {
                    imgpiatto.setImageResource(R.drawable.piattino_nero_puro2);
                    stato = 2;
                }
                if (imgPremuta == 4) {
                    imgpiatto.setImageResource(R.drawable.piattino_nero_puro3);
                    stato = 2;
                }
                if (imgPremuta == 5) {
                    imgpiatto.setImageResource(R.drawable.piattino_nero_puro4);
                    stato = 2;
                }
                break;
            case 2:
                Button buttonContinua = (Button) myFragmentView.findViewById(R.id.id_button5continua);
                buttonContinua.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }


}
