
package Datos;

import Entidades.Productos;
import java.sql.SQLException;
import Datos.CrudInterfaces.productoInterfaz;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import dataBase.Conexion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class productoDAO implements productoInterfaz<Productos>{
    // Variables
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    // Constructor 

    public productoDAO() {
        CON = Conexion.getInstancia();
    }

    @Override
    public List<Productos> listar(String texto) {
        List<Productos> registros = new ArrayList<>();
        try{
            ps = CON.conectar().prepareStatement("SELECT * FROM productos WHERE nombre LIKE ?");
            ps.setString(1, "%"+texto+"%");
            rs = ps.executeQuery();
            while (rs.next()) {                
                registros.add(new Productos(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), 
                        rs.getInt(7), rs.getDouble(8), rs.getString(9), rs.getBoolean(10), rs.getString(11)));
            }
            ps.close();
            rs.close();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE PUEDE MOSTRAR DATOS EN LA TABLA "+e.getMessage());
        }finally{
            ps = null;
            rs = null;
            CON.desconectar();
        }
        return registros;
    }

    @Override
    public boolean insertar(Productos obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(Productos obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean desactivar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean activar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int total() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean existe(String texto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
