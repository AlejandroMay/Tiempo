package com.egm.alejandro.tiempo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    ListView listado;

    ArrayList<List> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listado = (ListView) findViewById(R.id.listado);

        datos = new ArrayList<List>();

        datos.add(new List("Lunes", "Soleado", "33/32", R.drawable.sol));
        datos.add(new List("Martes", "Soleado", "32/28", R.drawable.sol));
        datos.add(new List("Miércoles", "Nublado", "33/32", R.drawable.nube));
        datos.add(new List("Jueves", "Soleado", "35/32", R.drawable.sol));
        datos.add(new List("Viernes", "Lluvioso", "30/26", R.drawable.lluvia));
        datos.add(new List("Sábado", "Soleado", "33/32", R.drawable.sol));
        datos.add(new List("Domingo", "Soleado", "33/32", R.drawable.sol));

        adaptador adaptadorData = new adaptador(datos, MainActivity.this.getApplicationContext());

        listado.setAdapter(adaptadorData);

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> partner, View view, int position, long id) {
                List seleccion = (List) partner.getItemAtPosition(position);

                CharSequence text = "Has seleccionado el día " + seleccion.getDia() + "\n El clima es: " + seleccion.getEstado() + "\n Con una temperatura de: " + seleccion.getTemperatura();
                Toast toast = Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
