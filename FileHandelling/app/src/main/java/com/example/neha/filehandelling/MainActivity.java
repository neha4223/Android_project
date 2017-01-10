package com.example.neha.filehandelling;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity
{
    private Button btnCreateNewFolder, btnCreateNewFile, btnWriteData, btnReadData;
    private EditText etxWriteData, etxReadData;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // Path: /storage/emulated/0
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreateNewFolder = (Button) findViewById(R.id.btnCreateNewFolder);
        btnCreateNewFolder.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String path = Environment.getExternalStorageDirectory().getPath()
                        + File.separator
                        + "Android AAA";

                File folder = new File(path);
                boolean isFolderCreated = folder.mkdir();     // mkdir() will create new folder

                if (isFolderCreated)
                    Toast.makeText(MainActivity.this, "Folder Created", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Failed to Create Folder", Toast.LENGTH_SHORT).show();
            }
        });


        btnCreateNewFile = (Button) findViewById(R.id.btnCreateNewFile);
        btnCreateNewFile.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    String path = Environment.getExternalStorageDirectory().getPath()
                            + File.separator
                            + "Android AAA"
                            + File.separator
                            + "TestFile.txt";

                    File file = new File(path);
                    boolean isFileCreated = file.createNewFile();

                    if (isFileCreated)
                        Toast.makeText(MainActivity.this, "File created.", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(MainActivity.this, "File not created.", Toast.LENGTH_SHORT).show();
                }
                catch (IOException io)
                {
                    io.printStackTrace();
                }
            }
        });


        // Example to Write Data
        etxWriteData = (EditText) findViewById(R.id.etxWriteData);
        btnWriteData = (Button) findViewById(R.id.btnWriteData);

        btnWriteData.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    String dataToBeWritten = etxWriteData.getText().toString();

                    String path = Environment.getExternalStorageDirectory().getPath()
                            + File.separator
                            + "Android AAA"
                            + File.separator
                            + "TestFile.txt";

                    File file = new File(path);
                    if (file.exists())
                    {
                        // If file exists, write data to file.
                        FileOutputStream fos = new FileOutputStream(file);
                        fos.write(dataToBeWritten.getBytes()); // This will write data
                        fos.close();
                        fos.flush();

                        Toast.makeText(MainActivity.this, "Data written.", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "File Doesn't Exists. Try Again", Toast.LENGTH_SHORT).show();
                        file.createNewFile();
                    }
                }
                catch (IOException io)
                {
                    io.printStackTrace();
                }
            }
        });


        etxReadData = (EditText) findViewById(R.id.etxReadData);
        btnReadData = (Button) findViewById(R.id.btnReadData);
        btnReadData.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    String path = Environment.getExternalStorageDirectory().getPath()
                            + File.separator
                            + "Android AAA"
                            + File.separator
                            + "TestFile.txt";

                    File file = new File(path);

                    InputStream inputStream = new FileInputStream(file);
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                    StringBuilder stringBuilder = new StringBuilder();
                    String line;

                    while ((line = bufferedReader.readLine()) != null)
                    {
                        stringBuilder.append(line);
                    }

                    etxReadData.setText(stringBuilder.toString());
                }
                catch (IOException fnfe)
                {
                    fnfe.printStackTrace();
                }
            }
        });
    }
}
