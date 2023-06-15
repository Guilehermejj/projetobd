package com.example.projetobd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button cadasbt;
    AcessoBD acessoBD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cadasbt = findViewById(R.id.button);
        EditText nametxt = (EditText) findViewById(R.id.ntxt);
        EditText emailtxt = (EditText) findViewById(R.id.etxt);

        acessoBD = new AcessoBD(MainActivity.this);

        cadasbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario usuario = null;

    try {
        usuario = new Usuario(-1,
                nametxt.getText().toString();
            emailtxt.getText().toString();
        boolean sucesso = acessoBD.adicionarUsuario(usuario);

    }

            }
        });
    }
}