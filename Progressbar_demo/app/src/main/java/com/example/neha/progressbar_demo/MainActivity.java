package com.example.neha.progressbar_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    private Button btnclk;
    private SeekBar seekbar;
    private ImageView image;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnclk=(Button)findViewById(R.id.btnclk);
        seekbar=(SeekBar)findViewById(R.id.seekbar);
        image=(ImageView)findViewById(R.id.image);
        editText=(EditText)findViewById(R.id.etxinput);
        btnclk.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this,"Have a Nice Day!!!",Toast.LENGTH_SHORT).show();
            }
        });
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                 Toast.makeText(MainActivity.this,"SeekBar progress"+ progress,Toast.LENGTH_SHORT).show();
                image.setRotation(progress);
                editText.setText(" "+progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
                  Toast.makeText(MainActivity.this,"Start",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                Toast.makeText(MainActivity.this,"Stop",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
