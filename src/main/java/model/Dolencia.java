package model;

import java.util.ArrayList;
import java.util.List;

public class Dolencia {
    private int idDoctor;
    private String nombre;
    private List<Prueba> pruebaList = new ArrayList<>();

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Prueba> getPruebaList() {
        return pruebaList;
    }

    public void setPruebaList(List<Prueba> pruebaList) {
        this.pruebaList = pruebaList;
    }

    @Override
    public String toString() {
        return "Dolencia{" +
                "idDoctor=" + idDoctor +
                ", nombre='" + nombre + '\'' +
                ", pruebaList=" + pruebaList +
                '}';
    }
}
