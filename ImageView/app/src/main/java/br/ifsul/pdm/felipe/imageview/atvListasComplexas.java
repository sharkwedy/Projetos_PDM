package br.ifsul.pdm.felipe.imageview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class atvListasComplexas extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atv_listas_complexas);

        final ArrayList<Contato> contato = new ArrayList<Contato>();

        contato.add(new Contato("João", "joao@rmail.com"));
        contato.add(new Contato("Jose", "jose@rmail.com"));
        contato.add(new Contato("Maria", "maria@gmail.com"));
        contato.add(new Contato("Mateus", "mateus@gmail.com"));
        contato.add(new Contato("Judas", "judas@gmail.com"));
        contato.add(new Contato("Pedro", "pedro@gmail.com"));
        contato.add(new Contato("Tiago", "tiago@gmail.com"));
        contato.add(new Contato("Marcos", "marcos@gmail.com"));

        final ArrayAdapter<Contato> ad = new Adaptador(this, R.layout.item_da_lista, contato);

        ListView lv = (ListView) findViewById(R.id.lista);
        lv.setAdapter(ad);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contato pessoa = contato.get(position);
                String s = pessoa.nome;
                Toast.makeText(getApplicationContext(), "Você clicou em: " + s, Toast.LENGTH_SHORT).show();
            }
        });

        EditText etBusca = (EditText) findViewById(R.id.editTextProcuraItem);
        etBusca.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence textoBusca, int start, int before, int count) {
                ad.getFilter().filter(textoBusca);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_atv_listas_complexas, menu);
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
