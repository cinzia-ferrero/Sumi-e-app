package com.example.ferrero.sumi_e;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


import java.util.ArrayList;

public class FragmentGallery extends Fragment {

    public static final String KEY_TITLE = "title";
    public static final String KEY_IMAGE = "image";
    private static String TAG = FragmentGallery.class.getSimpleName();
    private View myFragmentView;
    private GridView gridView;
    private GridViewAdapter gridAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        myFragmentView = inflater.inflate(R.layout.fragment_gallery_layout, container, false);

        gridView = (GridView) myFragmentView.findViewById(R.id.gridView);
        gridAdapter = new GridViewAdapter(myFragmentView.getContext(), R.layout.gallery_grid_item_layout, getData());
        gridView.setAdapter(gridAdapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                ImageItem item = (ImageItem) parent.getItemAtPosition(position);

                //Start details activity
                startActivity(DetailsActivity.getStartIntent(getContext())
                        .putExtra(KEY_TITLE, item.getTitle())
                        .putExtra(KEY_IMAGE, item.getTitle().contains("0") ? R.drawable.image_1 : R.drawable.image_2)
                );

            }
        });

        return myFragmentView;
    }

    // Put images and titles in ArrayList<ImageItem>
    private ArrayList<ImageItem> getData() {
        final ArrayList<ImageItem> imageItems = new ArrayList<>();
        TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);
        for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            imageItems.add(new ImageItem(bitmap, "Image#" + i));
        }
        return imageItems;
    }

}