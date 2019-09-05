package com.example.ubigeo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner continente;
    Spinner region;
    Button button;
    EditText ext_dni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        continente=findViewById(R.id.spinner_departamento);
        region=findViewById(R.id.spinner_provincia);
        button=findViewById(R.id.button);
        ext_dni=findViewById(R.id.ext_dni);
        final List<Mapa> continentes =new ArrayList<>();
        continentes.add(new Mapa("",R.drawable.wow));
        continentes.add(new Mapa("KALINDOR",R.drawable.horda));
        continentes.add(new Mapa("EASTERN KINGDOMS",R.drawable.alianza));
        final List<Mapa> kalindor =new ArrayList<>();
        kalindor.add(new Mapa("OGRIMMAR",R.drawable.horda));
        kalindor.add(new Mapa("THUNDER BUFF",R.drawable.horda));
        kalindor.add(new Mapa("DARNASSUS",R.drawable.alianza));
        kalindor.add(new Mapa("EXODAR",R.drawable.alianza));
        final List<Mapa> eastern =new ArrayList<>();
        eastern.add(new Mapa("SILVERMOON",R.drawable.horda));
        eastern.add(new Mapa("UNDERCITY",R.drawable.horda));
        eastern.add(new Mapa("STORMWIND",R.drawable.alianza));
        eastern.add(new Mapa("IRONFORGE",R.drawable.alianza));

        AdaptadorSpinner adapter=  new AdaptadorSpinner(this, continentes,R.layout.spinner);
        final AdaptadorSpinner kalin=  new AdaptadorSpinner(this, kalindor,R.layout.spinner);
        final AdaptadorSpinner east=  new AdaptadorSpinner(this, eastern,R.layout.spinner);
        continente.setAdapter(adapter);
        //ArrayAdapter<String> blanco = ArrayAdapter.createFromResource(this,
        //        R.array.planets_array, android.R.layout.simple_spinner_item);
        //region.setAdapter(blanco);
        continente.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){

                }else if(i==1){
                    region.setAdapter(kalin);
                }else{
                    region.setAdapter(east);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent (MainActivity.this,Resultado.class);
                intent.putExtra("dni",ext_dni.getText().toString());
                intent.putExtra("continente",continentes.get((int)continente.getSelectedItemId()).nombre);
                intent.putExtra("escudocont",continentes.get((int)continente.getSelectedItemId()).icono);
                if((int)continente.getSelectedItemId()== 1){
                    intent.putExtra("region",kalindor.get((int)region.getSelectedItemId()).nombre);
                    intent.putExtra("escudoreg",kalindor.get((int)region.getSelectedItemId()).icono);
                }else if((int)continente.getSelectedItemId()== 2){
                    intent.putExtra("region",eastern.get((int)region.getSelectedItemId()).nombre);
                    intent.putExtra("escudoreg",eastern.get((int)region.getSelectedItemId()).icono);
                }
                startActivityForResult(intent,1);
            }
        });

    }
}
