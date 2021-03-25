package com.example.watchman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    Button in,out,lock;
    TextView nameholder;
    Bundle bundleHome = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        nameholder=findViewById(R.id.nameholder);
        in=findViewById(R.id.in);
        out=findViewById(R.id.out);
        lock=findViewById(R.id.lock);

        Bundle bundle = getIntent().getExtras();
        bundleHome.putString("eid",bundle.getString("id", "Default") );
        bundleHome.putString("name",bundle.getString("name", "Default") );

        nameholder.setText("Hi "+bundle.getString("name", "Default"));
        lock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Logging Out!",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //IN Button
        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundleHome.putString("fun","in");
                Intent intent=new Intent(getApplicationContext(),Scanner.class);
                intent.putExtras(bundleHome);
                startActivity(intent);


            }
        });
        // OUT Button
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundleHome.putString("fun","out");
                Intent intent=new Intent(getApplicationContext(),Scanner.class);
                intent.putExtras(bundleHome);
                startActivity(intent);


            }
        });

    }
}