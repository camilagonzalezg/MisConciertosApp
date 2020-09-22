package com.example.misconciertos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.misconciertos.DAO.ConciertoService;
import com.example.misconciertos.DTO.Concierto;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnFecha,btnRegistrar;
    private Spinner spnGenero,spnCalificacion;
    private TextView txtArtista,txtFecha,txtEntrada;
    private int dia,mes,anio;
    private ListView listView;
    private ArrayList<Concierto> lista;
    private ArrayAdapter<Concierto> adapter;
    private ConciertoService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtArtista = findViewById(R.id.listArtista);

        txtEntrada = findViewById(R.id.listValor);

        txtFecha = findViewById(R.id.listFecha);

        btnFecha = findViewById(R.id.btnFecha);

        btnRegistrar = findViewById(R.id.btnRegistrar);

        spnGenero = findViewById(R.id.spnGenero);

        String[] generos = {"Rock","Jazz","Pop","Regueton","Salsa","Metal"};

        spnGenero.setAdapter(new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,generos));

        spnCalificacion = findViewById(R.id.spnValoracion);

        String[] valoracion = {"1","2","3","4","5","6","7"};

        spnCalificacion.setAdapter(new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,valoracion));

        btnFecha.setOnClickListener(this);

        listView = findViewById(R.id.listView);

        ConciertoService service = new ConciertoService();
        lista = service.listarConciertos();
        adapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_spinner_item,lista);
        listView.setAdapter(adapter);
        btnRegistrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Concierto concierto = new Concierto();
                ConciertoService service = new ConciertoService();
                String artista = txtArtista.getText().toString();
                int entrada = Integer.parseInt(txtEntrada.getText().toString()) ;
                String fecha = txtFecha.getText().toString();
                String genero = spnGenero.getSelectedItem().toString();
                String valoracion = spnCalificacion.getSelectedItem().toString();

                if(!artista.isEmpty() && entrada > 0 && !fecha.isEmpty()){
                    concierto.setFecha(fecha);
                    concierto.setArtista(artista);
                    concierto.setValorEntrada(entrada);
                    concierto.setCalificacion(valoracion);
                    concierto.setGenero(genero);
                    service.AgregarConcierto(concierto);
                    txtArtista.setText("");
                    txtEntrada.setText("");
                    txtFecha.setText("");
                    addConc(concierto);
                    Toast.makeText(MainActivity.this,"Concierto guardado",Toast.LENGTH_LONG).show();

                }else{
                    AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);

                    if(artista.isEmpty()){
                        alerta.setMessage("Ingrese el artista")
                                .setPositiveButton("Aceptar",null)
                                .create().show();
                    }else if(entrada <= 0){
                        alerta.setMessage("Ingrese un valor válido de la entrada")
                                .setPositiveButton("Aceptar",null)
                                .create().show();
                    }else{
                        alerta.setMessage("Seleccione la fecha")
                                .setPositiveButton("Aceptar",null)
                                .create().show();
                    }
                }
            }
        });


    }


    public void addConc(Concierto conc){
        lista.add(conc);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        if(view==btnFecha){
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            anio = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    txtFecha.setText(day+"/"+month+"/"+year);
                }
            },anio,mes,dia);
            datePickerDialog.show();
        }
    }
}