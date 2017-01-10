package com.example.neha.gridview_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
private GridView gridView;
    private ArrayList<Integer> imagesArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView=(GridView)findViewById(R.id.gridview);

         // Fill up imagesArray with Image Paths
        imagesArray.add(R.drawable.image1);
        imagesArray.add(R.drawable.image2);
        imagesArray.add(R.drawable.image3);
        imagesArray.add(R.drawable.image4);
        imagesArray.add(R.drawable.image5);
        imagesArray.add(R.drawable.image6);
        imagesArray.add(R.drawable.images7);
        imagesArray.add(R.drawable.images8);
        imagesArray.add(R.drawable.image9);
        imagesArray.add(R.drawable.images10);
        imagesArray.add(R.drawable.images11);
        imagesArray.add(R.drawable.images12);
        imagesArray.add(R.drawable.images13);
        imagesArray.add(R.drawable.images14);
        imagesArray.add(R.drawable.images15);
        imagesArray.add(R.drawable.images16);


        gridView.setAdapter(new GridViewAdapter());

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView ,View view, int position, long id) {
                int path = (int) adapterView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "Path: " + path, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, FullScreen.class);
                intent.putExtra("IMAGE_PATH", path);
                startActivity(intent);

            }
        });
    }

    private class GridViewAdapter extends BaseAdapter
    {

        @Override
        public int getCount()
        {
            return imagesArray.size();
        }

        @Override
        public Object getItem(int position)
        {
            return imagesArray.get(position);
        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup)
        {
            LayoutInflater layoutInflater = getLayoutInflater();
            View rootView = layoutInflater.inflate(R.layout.activity_grid_view_single_item, null);

            ImageView imageView = (ImageView) rootView.findViewById(R.id.imageview_single);
            imageView.setImageResource(imagesArray.get(position));


            return rootView;
        }
    }

}
