package model;

public class Prueba {
    private String tipo;
    private  int precio;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }


    @Override
    public String toString() {
        return "Prueba{" +
                "tipo='" + tipo + '\'' +
                ", precio=" + precio +
                '}';
    }
}

