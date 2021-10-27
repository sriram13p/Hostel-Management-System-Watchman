package com.example.watchman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class Display extends AppCompatActivity {
    TextView name,id;
    Button accept,deny;
    String str;
    ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        name=findViewById(R.id.name);
        id=findViewById(R.id.id);
        accept=findViewById(R.id.accept);
        deny=findViewById(R.id.deny);
        imageView=findViewById(R.id.imageView);
        Bundle bundle= getIntent().getExtras();
        str=bundle.getString("str", "Default");
        String s[]=str.split(",");

        name.setText(s[4]);
        id.setText(s[3]);

        try{

            Glide.with(this).load(s[5]).into(imageView);
        }catch (NullPointerException e){
            Toast.makeText( getApplication(),"image not found",Toast.LENGTH_LONG).show();
        }




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