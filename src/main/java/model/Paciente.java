package model;

import java.util.ArrayList;
import java.util.List;

public class Paciente {
  private String _idPaciente;
  private String nombre;
  private int edad;
  private String direccion;
  private List<Dolencia> dolenciaList = new ArrayList<>();


  public Paciente(String _idPaciente, String nombre, int edad, String direccion, List<Dolencia> dolenciaList) {
    this._idPaciente = _idPaciente;
    this.nombre = nombre;
    this.edad = edad;
    this.direccion = direccion;
    this.dolenciaList = dolenciaList;
  }

  public String get_idPaciente() {
    return _idPaciente;
  }

  public void set_idPaciente(String _idPaciente) {
    this._idPaciente = _idPaciente;
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
            "idPaciente=" + _idPaciente +
            ", nombre='" + nombre + '\'' +
            ", edad=" + edad +
            ", direccion='" + direccion + '\'' +
            ", dolenciaList=" + dolenciaList +
            '}';
  }
}
