package com.example.ubigeo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {
    TextView txt_dni;
    TextView txt_continente;
    TextView txt_region;
    ImageView img_continente;
    ImageView img_region;
    Button btn_cerrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        txt_dni=findViewById(R.id.txt_dni);
        txt_continente=findViewById(R.id.txt_continente);
        txt_region=findViewById(R.id.txt_region);
        img_continente=findViewById(R.id.img_continente);
        img_region=findViewById(R.id.img_region);
        btn_cerrar=findViewById(R.id.btn_cerrar);
        Intent intent = getIntent();
        txt_dni.setText(intent.getStringExtra("dni"));
        txt_continente.setText(intent.getStringExtra("continente"));
        txt_region.setText(intent.getStringExtra("region"));
        img_continente.setImageResource(intent.getIntExtra("escudocont",0));
        img_region.setImageResource(intent.getIntExtra("escudoreg",0));
        btn_cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent();
                setResult(RESULT_OK,intent2);
                finish();
            }
        });
    }
}
