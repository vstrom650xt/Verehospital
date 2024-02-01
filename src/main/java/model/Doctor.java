package model;

public class Doctor {
    private int _idDoctor;
    private int numeroColegiado;
    private String nombre;
    private String especialidad;

    public Doctor(int _idDoctor, int numeroColegiado, String nombre, String especialidad) {
        this._idDoctor = _idDoctor;
        this.numeroColegiado = numeroColegiado;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public int get_idDoctor() {
        return _idDoctor;
    }

    public void set_idDoctor(int _idDoctor) {
        this._idDoctor = _idDoctor;
    }

    public int getNumeroColegiado() {
        return numeroColegiado;
    }

    public void setNumeroColegiado(int numeroColegiado) {
        this.numeroColegiado = numeroColegiado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "_idDoctor=" + _idDoctor +
                ", numeroColegiado=" + numeroColegiado +
                ", nombre='" + nombre + '\'' +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
}
