package com.example.watchman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post extends AppCompatActivity {
    String eid,fun,str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        IP i=new IP();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Bundle bundlePost=new Bundle();
        Bundle bundle= getIntent().getExtras();
        eid=bundle.getString("id", "Default");
        fun=bundle.getString("fun", "Default");
        str=bundle.getString("str", "Default");
        String[] sp=str.split(",",3);
        System.out.println(str);
        bundlePost.putString("id",eid);
        bundlePost.putString("name",bundle.getString("name", "Default"));
        if(fun.equals("out"))
        {
            //Start ProgressBar first (Set visibility VISIBLE)
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable() {
                @Override
                public void run() {
                    //Starting Write and Read data with URL
                    //Creating array for parameters
                    String[] field = new String[2];
                    field[0] = "tid";
                    field[1] = "eid";

                    //Creating array for data
                    String[] data = new String[2];
                    data[0] = sp[1];
                    data[1] = eid;
                    String url="http://"+i.getIp()+"/putDataTest.php";
                    PutData putData = new PutData(url, "POST", field, data);
                    if (putData.startPut()) {
                        if (putData.onComplete()) {
                            String result = putData.getResult();
                            //System.out.println(result+"-------------------------------------------------------------------------------------------------------------------------");
                            if(result.equals("success"))
                            {
                                Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),HomePage.class);
                                intent.putExtras(bundlePost);
                                startActivity(intent);

                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),HomePage.class);
                                intent.putExtras(bundlePost);
                                startActivity(intent);

                            }
                        }
                    }
                    //End Write and Read data with URL
                }
            });
        }
        else
        {
            //Start ProgressBar first (Set visibility VISIBLE)
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable() {
                @Override
                public void run() {
                    //Starting Write and Read data with URL
                    //Creating array for parameters
                    String[] field = new String[2];
                    field[0] = "tid";
                    field[1] = "eid";
                    //Creating array for data
                    String[] data = new String[2];
                    data[0] = sp[1];
                    data[1] = eid;
                    String url="http://"+i.getIp()+"/putDataTest1.php";
                    PutData putData = new PutData(url, "POST", field, data);
                    if (putData.startPut()) {
                        if (putData.onComplete()) {
                            String result = putData.getResult();
                            if(result.equals("success"))
                            {
                                Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),HomePage.class);
                                intent.putExtras(bundlePost);
                                startActivity(intent);

                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),HomePage.class);
                                intent.putExtras(bundlePost);
                                startActivity(intent);

                            }
                        }
                    }
                    //End Write and Read data with URL
                }
            });

        }

    }
}