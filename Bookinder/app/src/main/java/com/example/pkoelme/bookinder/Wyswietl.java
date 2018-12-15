package com.example.pkoelme.bookinder;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Wyswietl extends AppCompatActivity {

    TextView password;
    TextView login;
    TextView email;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wyswietl);
        String log = getIntent().getStringExtra("login");
        String pass = getIntent().getStringExtra("password");
        String mail = getIntent().getStringExtra("e-mail");

        context = getApplicationContext();
        password = (TextView) findViewById(R.id.password_wyswietl);
        login = (TextView) findViewById(R.id.login_wyswietl);
        email = (TextView) findViewById(R.id.email_wyswietl);




        password.setText(pass);
        login.setText(log);
        email.setText(mail);



    }
}
