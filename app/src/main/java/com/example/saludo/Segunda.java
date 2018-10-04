package com.example.saludo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Segunda extends AppCompatActivity {
    @BindView(R.id.textView) TextView saludo;

    public static final String DATO = "nombre";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        ButterKnife.bind(this);

        Intent i = this.getIntent();
        saludo.setText("Hola " + i.getStringExtra(DATO));
    }
}
