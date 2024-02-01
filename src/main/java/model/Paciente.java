package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Paciente {
  private int idPaciente;
  private String nombre;
  private int edad;
  private String direccion;
  private List<Dolencia> dolenciaList = new ArrayList<>();


  public int getIdPaciente() {
    return idPaciente;
  }

  public void setIdPaciente(int idPaciente) {
    this.idPaciente = idPaciente;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public List<Dolencia> getDolenciaList() {
    return dolenciaList;
  }

  public void setDolenciaList(List<Dolencia> dolenciaList) {
    this.dolenciaList = dolenciaList;
  }

  @Override
  public String toString() {
    return "Paciente{" +
            "idPaciente=" + idPaciente +
            ", nombre='" + nombre + '\'' +
            ", edad=" + edad +
            ", direccion='" + direccion + '\'' +
            ", dolenciaList=" + dolenciaList +
            '}';
  }
}
