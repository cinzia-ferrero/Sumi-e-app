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

public class FragmentLearnStep3b extends Fragment implements View.OnTouchListener {

    View myFragmentView;
    ImageView imgpiatto;
    ImageView imgsuzuri;
    ImageView imgacqua;
    int imgPremuta = -1;
    int stato = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myFragmentView = inflater.inflate(R.layout.fragment_learn_layout3, container, false);

        imgpiatto = (ImageView) myFragmentView.findViewById(R.id.piatto);
        imgpiatto.setOnTouchListener(this);

        imgsuzuri = (ImageView) myFragmentView.findViewById(R.id.suzuri_ink);
        imgsuzuri.setOnTouchListener(this);

        imgacqua = (ImageView) myFragmentView.findViewById(R.id.acqua);
        imgacqua.setOnTouchListener(this);

        return myFragmentView;
    }


    @Override
    public boolean onTouch(View view, MotionEvent event) {

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

            if (distanceFromCenter < radius) {
                imgPremuta = 1;
                checkState();
                return true;
            }
            return false;
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

        if ((ImageView) view == imgacqua) {
            int pos[] = new int[2];
            imgacqua.getLocationOnScreen(pos);
            float ulcx = pos[0];
            float ulcy = pos[1];
            float width = imgacqua.getWidth();
            float height = imgacqua.getHeight();
            float centerX = ulcx + width / 2;
            float centerY = ulcy + height / 2;
            double radius = width / 2 * 0.9;

            float xTouch = event.getRawX();
            float yTouch = event.getRawY();

            double distanceFromCenter = Math.sqrt(Math.pow((double) (centerX - xTouch), (double) 2)
                    + Math.pow((double) (centerY - yTouch), (double) 2));

            if (distanceFromCenter < radius) {
                imgPremuta = 3;
                checkState();
                return true;
            }
            return false;
        }

        return false;
    }

    public void checkState() {
        switch (stato) {
            case 0:
                if (imgPremuta == 3) {
                    imgacqua.setImageResource(R.drawable.acqua_riflessi);
                    stato = 1;
                }
                break;
            case 1:
                if (imgPremuta == 1) {
                    imgpiatto.setImageResource(R.drawable.piattino_rosso_acqua);
                    stato = 2;
                }
                break;
            case 2:
                if (imgPremuta == 2) {
                    imgsuzuri.setImageResource(R.drawable.suzuri_withink_meno);
                    stato = 3;
                }
                break;
            case 3:
                if (imgPremuta == 1) {
                    imgpiatto.setImageResource(R.drawable.piattino_rosso_diluito);
                    Button buttonContinua = (Button) myFragmentView.findViewById(R.id.id_button3continua);
                    buttonContinua.setVisibility(View.VISIBLE);
                    stato = 4;
                }
                break;
            default:
                break;
        }
    }

}
