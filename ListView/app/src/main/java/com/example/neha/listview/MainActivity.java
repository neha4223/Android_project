package com.example.neha.listview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
  private ListView listView;

    private ArrayList<String> listViewArray = new ArrayList<>();
    private ArrayList<Integer> imagesArray = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Fill up ArrayList with Data.
        listViewArray.add("Mercury");
        listViewArray.add("Venus");
        listViewArray.add("Earth");
        listViewArray.add("Mars");
        listViewArray.add("Jupiter");
        listViewArray.add("Saturn");
        listViewArray.add("Neptune");
        listViewArray.add("Uranus");
        listViewArray.add("Pluto");
        listViewArray.add("Earth 2.0");
        listViewArray.add("Mars 2.0");

        // Fill up imagesArray with Image Paths
        imagesArray.add(R.drawable.ic_android_black_24dp);
        imagesArray.add(R.drawable.ic_directions_run_black_24dp);
        imagesArray.add(R.drawable.ic_face_black_24dp);
        imagesArray.add(R.drawable.ic_android_black_24dp);
        imagesArray.add(R.drawable.ic_directions_run_black_24dp);
        imagesArray.add(R.drawable.ic_face_black_24dp);
        imagesArray.add(R.drawable.ic_android_black_24dp);
        imagesArray.add(R.drawable.ic_directions_run_black_24dp);
        imagesArray.add(R.drawable.ic_face_black_24dp);
        imagesArray.add(R.drawable.ic_android_black_24dp);
        imagesArray.add(R.drawable.ic_face_black_24dp);


        ListViewAdapter listViewAdapter = new ListViewAdapter();

        listView =(ListView)findViewById(R.id.list_item);
        listView.setAdapter(listViewAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {
                String selectedItem = listView.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, selectedItem, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class ListViewAdapter extends BaseAdapter
    {

        @Override
        public int getCount()
        {
            return listViewArray.size();
        }

        @Override
        public Object getItem(int position)
        {
            return listViewArray.get(position);
        }

        @Override
        public long getItemId(int position)
        {
            return position;

        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup)
        {


        LayoutInflater layoutInflater =getLayoutInflater();
            //LayoutInflater layoutInflater1 =(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rootView =layoutInflater.inflate(R.layout.listview_single_item_ui, null);

            //Init textview of listview_single_item_ui.xml
            TextView textView = (TextView)rootView.findViewById(R.id.single_textview);
            textView.setText(listViewArray.get(position));
            Log.d("TAG", "Position: "+ position);


                        ImageView imageView = (ImageView) rootView.findViewById(R.id.single_imageview);
            imageView.setImageResource(imagesArray.get(position));

            imageView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Toast.makeText(MainActivity.this, "Image Clicked " + view.getId(), Toast.LENGTH_SHORT).show();
                }
            });

           return rootView;
        }
    }

}
