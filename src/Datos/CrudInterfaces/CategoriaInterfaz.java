
package Datos.CrudInterfaces;

import java.util.List;


public interface CategoriaInterfaz <T> {
    // Método para el CRUD
    public List<T> Litar(String texto);
    public boolean insertar (T obj);
    public boolean actualizar(T obj);
    public boolean desactivar (int id);
    public boolean activar (int id);
    public int total();
    public boolean existe (String texto);
}
