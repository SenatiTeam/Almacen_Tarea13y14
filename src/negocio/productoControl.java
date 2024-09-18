
package negocio;

import Datos.CategoriaDAC;
import Datos.productoDAO;
import Entidades.Categorias;
import Entidades.Productos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class productoControl {
    private final CategoriaDAC DATOSCAT;
    
    // Constructor
    public productoControl(){
        this.DATOSCAT = new CategoriaDAC();
        this.DATOS = new productoDAO();
        this.obj = new Productos();
        this.registrosMostrados = 0;

    }
    
    // Método para seleccionar la categoria
    public DefaultComboBoxModel selecioner(){
        DefaultComboBoxModel items = new DefaultComboBoxModel();
        List<Categorias> lista = new ArrayList();
        lista=DATOSCAT.seleccionar();
        for(Categorias item:lista){
        items.addElement(new Categorias(item.getId_categoria(), item.getNombre()));
        }
        return items;
    }
    
    // Variables 
    private final productoDAO DATOS;
    private Productos obj;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;
    
}
