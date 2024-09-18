
package Datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Entidades.Categorias;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Datos.CrudInterfaces.CategoriaInterfaz;
import Entidades.Categorias;
import dataBase.Conexion;
import java.util.List;

public class CategoriaDAC implements CategoriaInterfaz<Categorias>{
    // Variables
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    // Constructor
    public CategoriaDAC() {
        CON = Conexion.getInstancia();
    }
    
    @Override
    public List<Categorias> listar(String texto) {
        List<Categorias> registros = new ArrayList<>();
        try {
            ps = CON.conectar().prepareStatement("SELECT * FROM Categorias WHERE nombre LIKE ?");
            ps.setString(1, "%"+texto+"%");
            rs = ps.executeQuery();
            while (rs.next()) {                
                registros.add(new Categorias(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDE MOSTRAR DATOS EN LA TABLA "+e.getMessage());
        }finally{
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return registros;
    }

    @Override
    public boolean insertar(Categorias obj) {
        resp=false;
        try {
            ps= CON.conectar().prepareStatement("INSERT INTO categorias(nombre, deescripcion, condicion) VALUES(?, ?, 1)");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDescipcion());
            if (ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR AL INSERTAR CATEGORIA "+e.getMessage());
        }finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean actualizar(Categorias obj) {
        resp=false;
        try {
            ps = CON.conectar().prepareStatement("UPDATE categorias SET nombre=?,deescripcion=? WHERE id_Categorias=?");
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDescipcion());
            ps.setInt(3, obj.getId_categoria());
            if(ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDEN ACTUALIZAR LOS DATOS "+e.getMessage());
        }finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean desactivar(int id) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("UPDATE Categorias SET condicion = 0 WHERE id_Categorias=?");
            ps.setInt(1, id);
            if(ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDE DESACTIVAR LA CATEGORÍA"+e.getMessage());
        }finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public boolean activar(int id) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("UPDATE Categorias SET condicion = 1 WHERE id_Categorias=?");
            ps.setInt(1, id);
            if(ps.executeUpdate()>0){
                resp=true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDE ACTIVAR LA CATEGORÍA"+e.getMessage());
        }finally{
            ps=null;
            CON.desconectar();
        }
        return resp;
    }

    @Override
    public int total() {
        int totalRegistros = 0;
        try {
            ps = CON.conectar().prepareStatement("SELECT COUNT(id_Categorias) FROM categorias");
            rs = ps.executeQuery();
            while (rs.next()) {
                totalRegistros = rs.getInt("COUNT(id_Categorias)");
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDE OBTENER EL TOTAL DE CATEGORIAS " + e.getMessage());
        }finally{
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return totalRegistros;
    }

    @Override
    public boolean existe(String texto) {
        resp=false;
        try {
            ps=CON.conectar().prepareStatement("SELECT nombre FROM categorias WHERE nombre=?");
            ps.setString(1, texto);
            rs=ps.executeQuery();
            rs.last();
            if(rs.getRow()>0){
                resp=true;
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDE VALIDAR DATOS "+e.getMessage());
        }finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return resp;
    }
    
    // Método para la consulta SQL para seleccionar categorías 
    public List<Categorias> seleccionar(){
        List<Categorias> registros = new ArrayList();
        try {
            ps = CON.conectar().prepareStatement("SELECT id_Categorias, nombre FROM categorias ORDER BY nombre ASC");
            rs = ps.executeQuery();
            while(rs.next()){
                registros.add(new Categorias(rs.getInt(1), rs.getString(2)));
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDE CARGAR CATEGORIAS " +e.getMessage());
        }finally{
            ps=null;
            rs=null;
            CON.desconectar();
        }
        return registros;
    }
    
}
