package br.com.daggerexample;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import br.com.daggerexample.adapter.ModelAdapter;
import br.com.daggerexample.adapter.ModelAdapterRecycler;
import br.com.daggerexample.model.Model;

public class ScrollView extends AppCompatActivity {

    private static final String TAG = "TAG";
    private ModelAdapter modelAdapter;
    private ModelAdapterRecycler adapterRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        modelAdapter = new ModelAdapter(getListModel());
        adapterRecycler = new ModelAdapterRecycler(getListModel());

        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterRecycler);

        RecyclerView gridViewA = findViewById(R.id.grid_view);
        gridViewA.setHasFixedSize(true);
        gridViewA.setLayoutManager(new LinearLayoutManager(this));
        gridViewA.setAdapter(adapterRecycler);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    private List<Model> getListModel(){

        List<Model> itens = new ArrayList<Model>();

        Model modelA = new Model(
                R.drawable.ic_audiotrack_black_24dp,
                getString(R.string.title),
                getString(R.string.description));

        Model modelB = new Model(
                R.drawable.ic_bluetooth_black_24dp,
                getString(R.string.title),
                getString(R.string.description));

        itens.add(modelA);
        itens.add(modelB);
        itens.add(modelA);
        itens.add(modelB);

        return itens;

    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:

                finish(); // Finaliza a Activity atual

                break;

            default:break;
        }

        return true;
    }
}
