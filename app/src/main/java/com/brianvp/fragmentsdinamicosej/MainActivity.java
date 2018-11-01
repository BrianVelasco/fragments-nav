package com.brianvp.fragmentsdinamicosej;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements RojoFragment.OnFragmentInteractionListener,
VerdeFragment.OnFragmentInteractionListener,AzulFragment.OnFragmentInteractionListener{

    AzulFragment fragmentAzul;
    RojoFragment fragmentRojo;
    VerdeFragment fragmentVerde;

    Button azul,rojo,verde,nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentAzul = new AzulFragment();
        fragmentRojo = new RojoFragment();
        fragmentVerde = new VerdeFragment();

        azul =(Button) findViewById(R.id.bntAzul);
        rojo =(Button) findViewById(R.id.bntRojo);
        verde =(Button) findViewById(R.id.bntVerde);
        nav = (Button) findViewById(R.id.nav);

        //Colocar fragment por defecto
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragment,fragmentRojo).commit();
    }
    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    public void onClick(View v){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (v.getId()){
            case R.id.bntRojo:
                transaction.replace(R.id.contenedorFragment,fragmentRojo);
                break;
            case R.id.bntAzul:
                transaction.replace(R.id.contenedorFragment,fragmentAzul);
                break;
            case R.id.bntVerde:
                transaction.replace(R.id.contenedorFragment,fragmentVerde);
                break;
            case R.id.nav:
                Intent intent= new Intent(MainActivity.this,NavActivity.class);
                startActivity(intent);
        }
        transaction.commit();


    }


}
