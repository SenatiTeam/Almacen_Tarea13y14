
package negocio;

import Datos.CategoriaDAC;
import Entidades.Categorias;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class categoriaControl {
    // Variables 
    private final CategoriaDAC DATOS;
    private Categorias obj;
    private DefaultTableModel modeloTabla;
    public int registrosMostrados;
    
    // Constructor 
    public categoriaControl(){
        this.DATOS = new CategoriaDAC();
        this.obj = new Categorias();
        this.registrosMostrados = 0;
    }
    
    // Métodos para el giro de negocio 
    public DefaultTableModel listar(String texto){
        List<Categorias> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto));
        
        String[] titulos={"Id_categoria", "Nombre", "Descripción", "Condición"};
        this.modeloTabla = new DefaultTableModel(null, titulos);
        
        String estado;
        String[] registro = new String [4];
        
        this.registrosMostrados = 0;
        
        for(Categorias item:lista){
            if(item.isCondicion()){
                estado="ACTIVO";
            }else{
                estado="INACTIVO";
            }
            registro[0]=Integer.toString(item.getId_categoria());
            registro[1]=item.getNombre();
            registro[2]=item.getDescipcion();
            registro[3]=estado;
            this.modeloTabla.addRow(registro);
            this.registrosMostrados = this.registrosMostrados+1;
        }
        return this.modeloTabla;
    }
    
    // Método para registrar categoria
    public String insertar(String nombre, String descripción){
        if(DATOS.existe(nombre)){
            return "EL NOMBRE DE LA CATEGORÍA YA EXISTE";
        }else{
            obj.setNombre(nombre);
            obj.setDescipcion(descripción);
            if(DATOS.insertar(obj)){
                return "REGISTRO EXITOSO";
            }else{
                return "ERROR AL REGISTRAR LA CATEGORÍA";
            }
        }
    }
    
    // Método para actualizar datos de la categoria
    public String actualizar(int id, String nombre, String nombreAt, String desactivar){
        if(nombre.equals(nombreAt)){
            obj.setId_categoria(id);
            obj.setNombre(nombre);
            obj.setDescipcion(desactivar);
            if(DATOS.actualizar(obj)){
                return "OK";
            }else{
                return "ERROR DE ACTUALIZACIÓN";
            }
        }else{
            if(DATOS.existe(nombre)){
                return "LA CATEGORÍA YA EXISTE";
            }else{
                obj.setId_categoria(id);
                obj.setNombre(nombre);
                obj.setDescipcion(desactivar);
                if(DATOS.actualizar(obj)){
                    return "OK";
                }else{
                    return "ERROR EN LA VALIDACIÓN";
                }
            }
        }
    }
    
    // Métodos para retornar el total de registros
    public int total(){
        return DATOS.total();
    }
    
    public int totalMostrados(){
        return this.registrosMostrados;
    }
    
    // Método para desactivar la categoría
    public String desactivar(int id){
        if(DATOS.desactivar(id)){
            return "OK";
        }else{
            return "NO SE PUDO DESACTIVAR LA CATEGORÍA";
        }
    }
    
    public String activar(int id){
        if(DATOS.activar(id)){
            return "OK";
        }else{
            return "NO SE PUDO ACTIVAR LA CATEGORÍA";
        }
    }
}
