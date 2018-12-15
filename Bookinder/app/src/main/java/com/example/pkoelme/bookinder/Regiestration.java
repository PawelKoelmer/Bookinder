package com.example.pkoelme.bookinder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Regiestration extends AppCompatActivity {
    Context context;
    Button register;
    String email;
    String password;
    String login;
    EditText log;
    EditText pass;
    EditText mail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiestration);
        context = getApplicationContext();
        register = (Button) findViewById(R.id.register);
        log = (EditText) findViewById(R.id.login);
        pass = (EditText) findViewById(R.id.password);
        mail = (EditText) findViewById(R.id.email);



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login = log.getText().toString();
                email = mail.getText().toString();
                password = pass.getText().toString();
                if(login.length() != 0 && email.length() != 0 && password.length() != 0) {
                    Intent intent = new Intent(context, Wyswietl.class);
                    intent.putExtra("login", login);
                    intent.putExtra("password", password);
                    intent.putExtra("e-mail", email);
                    startActivity(intent);
                }
                else
                    Toast.makeText(context,"Brak danych",Toast.LENGTH_LONG).show();
            }
        });
    }
}
