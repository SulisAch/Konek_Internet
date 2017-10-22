package com.example.dziqron.newasyncinternet;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ConnectInternetTask c1;
    DownloadImageTask downloadImage;

    static TextView myText;
    static ImageView myImage;

    ConnectivityManager myConnManager;
    NetworkInfo myInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myText = (TextView)findViewById(R.id.myResult);
        myImage = (ImageView)findViewById(R.id.myImageResult);

        myConnManager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        myInfo = myConnManager.getActiveNetworkInfo();
    }

    public void doSomething(View view) {
        c1 = new ConnectInternetTask(this);
        c1.execute("http://www.google.com");
    }

    public void downloadImage(View view) {
        if (myInfo !=null && myInfo.isConnected()){
            downloadImage = new DownloadImageTask();
            downloadImage.execute("http://mahasiswa.dinus.ac.id/images/foto/A/A11/2014/A11.2014.08163.jpg");
        }
        else {
            Toast.makeText(this,"Internet Not Connected", Toast.LENGTH_SHORT).show();
        }
    }
}

//Membedakan konsep koneksi konvesional dan koneksi berbasis asynctask, Membuat aplikasi yang dapat menjalankan proses background, dan Membuat aplikasi yang dapat terkoneksi dengan Internet