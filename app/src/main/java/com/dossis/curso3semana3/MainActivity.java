package com.dossis.curso3semana3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dossis.curso3semana3.pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList mascotas;
    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setActionBar();
        crearArrayMascotas();
        asociarRecyclerView();
        inicializarAdapter();
    }

    private void setActionBar() {

        setSupportActionBar((Toolbar) findViewById(R.id.miActionBar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        ImageView imgFavoritos = (ImageView) findViewById(R.id.imgFavoritos);
        imgFavoritos.setOnClickListener(v -> {
            Intent intentFavoritos = new Intent(MainActivity.this, FavoritosActivity.class);
            startActivity(intentFavoritos);
        });
    }

    private void crearArrayMascotas() {
        if (mascotas == null) {
            mascotas = new ArrayList<Mascota>();
            mascotas.add(new Mascota(1, "Rufo", 0, R.drawable.perro1));
            mascotas.add(new Mascota(2, "Chicho", 0, R.drawable.perro2));
            mascotas.add(new Mascota(3, "Luisma", 0, R.drawable.perro3));
            mascotas.add(new Mascota(4, "Baraja", 0, R.drawable.perro4));
            mascotas.add(new Mascota(5, "Rajoy", 0, R.drawable.perro5));
            mascotas.add(new Mascota(6, "Mourinho", 0, R.drawable.perro6));
            mascotas.add(new Mascota(7, "Ojopipa", 0, R.drawable.perro7));
            mascotas.add(new Mascota(8, "Carahuevo", 0, R.drawable.perro8));
        }

    }

    private void asociarRecyclerView() {
        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    private void inicializarAdapter() {
        MascotaAdapter adapter = new MascotaAdapter(mascotas,true);
        rvMascotas.setAdapter(adapter);
    }
}