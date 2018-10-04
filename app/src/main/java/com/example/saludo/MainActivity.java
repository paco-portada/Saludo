package com.example.saludo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.editText) EditText texto;
    @BindView(R.id.editText2) EditText enlace;
    @BindView(R.id.button) Button saludar;
    @BindView(R.id.button2) Button navegar;

    @OnClick(R.id.button)
    public void saludar() {
        Intent i;
        i = new Intent(this, Segunda.class);
        i.putExtra(DATO, texto.getText().toString());
        startActivity(i);

    }
    @OnClick(R.id.button2)
    public void navegar() {
        boolean error = false;
        StringBuilder mensaje = new StringBuilder();

        try {
            URL address = new URL(enlace.getText().toString());


            Uri webpage = Uri.parse(address.toString());
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
            else {
                error = true;
                mensaje.append("No hay un navegador instalado");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            error = true;
            mensaje.append("Error en la URL: " + e.getMessage() );
        }
        if (error)
            Toast.makeText(this, mensaje.toString(), Toast.LENGTH_SHORT).show();
    }

    public static final String DATO = "nombre";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //navegar.setOnClickListener(this);
    }

}
