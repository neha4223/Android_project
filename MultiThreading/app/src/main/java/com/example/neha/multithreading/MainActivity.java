package com.example.neha.multithreading;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

import static com.example.neha.multithreading.R.id.image;
import static com.example.neha.multithreading.R.id.imgWallpaper;

public class MainActivity extends AppCompatActivity {
    Button btnStartThread, btnFatchedData;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartThread = (Button) findViewById(R.id.btnStartThread);
        btnFatchedData = (Button) findViewById(R.id.btnFatchedData);
        imageView = (ImageView) findViewById(imgWallpaper);
        Picasso.with(this)
                .load("http://cdn.wonderfulengineering.com/wp-content/uploads/2014/07/hd-iphone-4s-wallpapers-164ios-610x915.jpg").into(imageView);

        btnStartThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable()

                {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //Log.d("TAG","Hiiii Nehu");
                                Toast.makeText(MainActivity.this, "Marry XMAS", Toast.LENGTH_SHORT).show();

                            }
                        });

                    }

                });
                thread.start();


            }
        });
        btnFatchedData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread networkThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Connection connection = Jsoup.connect("http://www.facebook.com");
                            final String title = connection.get().title();

                            //UI thread
                            Handler handler = new Handler(Looper.getMainLooper());
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(MainActivity.this, "Title" + title, Toast.LENGTH_SHORT).show();
                                }
                            });
                        } catch (IOException io) {
                            io.printStackTrace();
                        }
                    }
                });
                networkThread.start();
            }
        });
    }
}