package com.example.neha.gridview_demo;

import android.app.WallpaperManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class FullScreen extends AppCompatActivity
{
    private ImageView imageViewFull;
    private Button btnSetWallpaper;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);

        Intent intent = getIntent();
        final int path = intent.getIntExtra("IMAGE_PATH", R.mipmap.ic_launcher);

        imageViewFull = (ImageView) findViewById(R.id.imageview_full);
        btnSetWallpaper = (Button) findViewById(R.id.btnSetWallpaper);

        imageViewFull.setImageResource(path);


        btnSetWallpaper.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                try
                {
                    WallpaperManager wallpaperManager = WallpaperManager.getInstance(FullScreen.this);
                    wallpaperManager.setResource(path);

                    Toast.makeText(FullScreen.this, "Wallpaper Set", Toast.LENGTH_SHORT).show();
                }
                catch (IOException io)
                {
                    io.printStackTrace();
                }
            }
        });
    }
}
