package com.dossis.curso3semana3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import static com.dossis.curso3semana3.MainActivity.mascotas;

public class FavoritosActivity extends AppCompatActivity {

    public ArrayList mascotasOrdenadas;
    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        setActionBar();
        crearArrayMascotas();
        asociarRecyclerView();
        inicializarAdapter();

    }

    private void setActionBar() {
        setSupportActionBar((Toolbar) findViewById(R.id.miActionBar));
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        ImageView imgFavoritos = (ImageView) findViewById(R.id.imgFavoritos);
        imgFavoritos.setVisibility(View.INVISIBLE);

    }

    private void crearArrayMascotas() {
        mascotasOrdenadas = (ArrayList) mascotas.clone();
        Collections.sort(mascotasOrdenadas);
        mascotasOrdenadas.subList(5, mascotasOrdenadas.size()).clear();
    }

    private void asociarRecyclerView() {
        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    private void inicializarAdapter() {
        MascotaAdapter adapter = new MascotaAdapter(mascotasOrdenadas,false);
        rvMascotas.setAdapter(adapter);

    }
}