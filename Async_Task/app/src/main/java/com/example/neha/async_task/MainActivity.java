package com.example.neha.async_task;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

import static com.example.neha.async_task.R.attr.title;

public class MainActivity extends AppCompatActivity
{
    private Button  btnFetchDataAsync;
    private EditText etxEnterURL;
    private ProgressDialog progressDialog;
    String etxURL;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etxEnterURL=(EditText)findViewById(R.id.etxEnterURL);
        btnFetchDataAsync=(Button)findViewById(R.id.btnFetchDataAsync);
        btnFetchDataAsync.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                etxURL = etxEnterURL.getText().toString();

                // Start AsyncTask
                BackgroundWorkerThread backgroundWorkerThread = new BackgroundWorkerThread();
                backgroundWorkerThread.execute(etxURL);    // Start AsyncTask
            }
        });


        // Use Handler to provide Delay
        // In case of delay just call postDelayed method and do not pass anything to Handler
        Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Toast.makeText(MainActivity.this, "Executed after 5 seconds", Toast.LENGTH_SHORT).show();
            }
        }, 5000);

    }
    public class BackgroundWorkerThread extends AsyncTask<String, Void, String>
    {
        @Override
        protected void onPreExecute()
        {
            // onPreExecute runs on UI Thread
            super.onPreExecute();
            // Show Progress
            progressDialog = ProgressDialog.show(MainActivity.this, "Please Wait", "We're fetching your title", true);
        }

        @Override
        protected String doInBackground(String... params)
        {
            // doInBackground runs on Background Thread

            try
            {
                // URL is in Array's 0th position
                String url = params[0];

                Connection connection = Jsoup.connect(url);
                String title = connection.get().title();

                return title;
            }
            catch (IOException io)
            {
                io.printStackTrace();
            }
            catch (IllegalArgumentException iae)
            {
                iae.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String title)
        {
            // onPostExecute runs on UI Thread
            super.onPostExecute(title);

            // Hide the ProgressDialog
            progressDialog.dismiss();

            if (title != null)
            {
                Toast.makeText(MainActivity.this, "Title is " + title, Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(MainActivity.this, "Exception Occurred.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
