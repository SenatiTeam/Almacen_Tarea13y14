
package Entidades;

public class Categorias {
    // Atributos 
    private int id_categoria;
    private String Nombre;
    private String Descipcion;
    private boolean condicion;
    
    // Constructor sin parametros 
    public Categorias() {
    }
    
    // Constructor con parametros 
    public Categorias(int id_categoria, String Nombre, String Descipcion, boolean condicion) {
        this.id_categoria = id_categoria;
        this.Nombre = Nombre;
        this.Descipcion = Descipcion;
        this.condicion = condicion;
    }
    
    // Get and Set

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescipcion() {
        return Descipcion;
    }

    public void setDescipcion(String Descipcion) {
        this.Descipcion = Descipcion;
    }

    public boolean isCondicion() {
        return condicion;
    }

    public void setCondicion(boolean condicion) {
        this.condicion = condicion;
    }

    @Override
    public String toString() {
        return "Categorias{" + "id_categoria=" + id_categoria + ", Nombre=" + Nombre + ", Descipcion=" + Descipcion + ", condicion=" + condicion + '}';
    }
}
