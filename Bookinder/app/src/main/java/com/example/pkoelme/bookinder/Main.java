package com.example.pkoelme.bookinder;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;



public class Main extends AppCompatActivity {
    String zamknieto = "Zamknieto";
    Button exit;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context =getApplicationContext();
        exit = (Button) findViewById(R.id.regiesterButton);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, Regiestration.class);
                startActivity(intent);
            }
        });
    }
}
