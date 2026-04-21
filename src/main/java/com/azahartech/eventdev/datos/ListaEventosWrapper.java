package com.azahartech.eventdev.datos;

import com.azahartech.eventdev.modelo.Evento;
import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;

@XmlRootElement(name = "catalogo_eventos")
public class ListaEventosWrapper {
    @XmlElement(name = "evento")
    private ArrayList<Evento> lista;

    public ListaEventosWrapper() {}

    @XmlTransient
    public ArrayList<Evento> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Evento> lista) {
        this.lista = lista;
    }
}
