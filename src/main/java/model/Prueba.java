package model;

public class Prueba {
    private  String tipo;
    private String precio;

    public Prueba(String tipo, String precio) {
        this.tipo = tipo;
        this.precio = precio;
    }



    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
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

