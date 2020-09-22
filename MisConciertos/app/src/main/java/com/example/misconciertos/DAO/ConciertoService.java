package com.example.misconciertos.DAO;

import android.widget.ArrayAdapter;

import com.example.misconciertos.DTO.Concierto;
import com.example.misconciertos.MainActivity;

import java.util.ArrayList;

public class ConciertoService {

    Concierto concierto = new Concierto();

    ArrayList<Concierto> listaConciertos = new ArrayList<>();

    public ArrayList<Concierto> AgregarConcierto(Concierto conc){
        concierto.setArtista(conc.getArtista());
        concierto.setFecha(conc.getFecha());
        concierto.setGenero(conc.getGenero());
        concierto.setCalificacion(conc.getCalificacion());
        concierto.setValorEntrada(conc.getValorEntrada());
        listaConciertos.add(concierto);

        return listaConciertos;
    }

    public ArrayList<Concierto> listarConciertos(){
        return listaConciertos;
    }


}
