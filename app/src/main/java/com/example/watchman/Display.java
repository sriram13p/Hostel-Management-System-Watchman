package com.example.watchman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Display extends AppCompatActivity {
    TextView name,id;
    Button accept,deny;
    String str;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        name=findViewById(R.id.name);
        id=findViewById(R.id.id);
        accept=findViewById(R.id.accept);
        deny=findViewById(R.id.deny);
        Bundle bundle= getIntent().getExtras();
        str=bundle.getString("str", "Default");
        String s[]=str.split(",");

        name.setText(s[4]);
        id.setText(s[3]);




        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Post.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();

            }
        });

        deny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),HomePage.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();

            }
        });


    }
}