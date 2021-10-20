package com.example.watchman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.telephony.SmsManager;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post extends AppCompatActivity {
    String eid,fun,str,phone,msg;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        IP i=new IP();

        Bundle bundlePost=new Bundle();
        Bundle bundle= getIntent().getExtras();
        eid=bundle.getString("id", "Default");
        fun=bundle.getString("fun", "Default");
        str=bundle.getString("str", "Default");
        String[] sp=str.split(",",3);
        phone=sp[2];
      //  System.out.println(str);
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
                                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                                LocalDateTime now = LocalDateTime.now();
                                msg="Your child left the campus at "+dtf.format(now);
                                bundlePost.putString("phone",phone);
                                bundlePost.putString("msg",msg);

                                Intent intent=new Intent(getApplicationContext(),SMS.class);
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
                                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                                LocalDateTime now = LocalDateTime.now();
                                msg="Your child came back to campus at "+dtf.format(now);
                                bundlePost.putString("phone",phone);
                                bundlePost.putString("msg",msg);

                                Intent intent=new Intent(getApplicationContext(),SMS.class);
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