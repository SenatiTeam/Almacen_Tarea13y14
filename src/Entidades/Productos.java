
package Entidades;

public class Productos {
    // Variables
    private int id_Productos;
    private int categoria_id;
    private String nombre_producto;
    private String marca_producto;
    private String descripcion_producto;
    private String codigo_producto;
    private int cantidad_producto;
    private double precio_compra;
    private String fecha_vencimiento;
    private boolean condicion;
    private String Imagen_producto;
    
    // Constructor vacio 
    public Productos() {
    }
    
    // Constructor con parámetros
    public Productos(int id_Productos, int categoria_id, String nombre_producto, String marca_producto, String descripcion_producto, String codigo_producto, int cantidad_producto, double precio_compra, String fecha_vencimiento, boolean condicion, String Imagen_producto) {
        this.id_Productos = id_Productos;
        this.categoria_id = categoria_id;
        this.nombre_producto = nombre_producto;
        this.marca_producto = marca_producto;
        this.descripcion_producto = descripcion_producto;
        this.codigo_producto = codigo_producto;
        this.cantidad_producto = cantidad_producto;
        this.precio_compra = precio_compra;
        this.fecha_vencimiento = fecha_vencimiento;
        this.condicion = condicion;
        this.Imagen_producto = Imagen_producto;
    }
    
    // Get and Set
    public int getId_Productos() {
        return id_Productos;
    }

    public void setId_Productos(int id_Productos) {
        this.id_Productos = id_Productos;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getMarca_producto() {
        return marca_producto;
    }

    public void setMarca_producto(String marca_producto) {
        this.marca_producto = marca_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public int getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(int cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    public double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public boolean isCondicion() {
        return condicion;
    }

    public void setCondicion(boolean condicion) {
        this.condicion = condicion;
    }

    public String getImagen_producto() {
        return Imagen_producto;
    }

    public void setImagen_producto(String Imagen_producto) {
        this.Imagen_producto = Imagen_producto;
    }

    @Override
    public String toString() {
        return "Productos{" + "id_Productos=" + id_Productos + ", categoria_id=" + categoria_id + ", nombre_producto=" + nombre_producto + ", marca_producto=" + marca_producto + ", descripcion_producto=" + descripcion_producto + ", codigo_producto=" + codigo_producto + ", cantidad_producto=" + cantidad_producto + ", precio_compra=" + precio_compra + ", fecha_vencimiento=" + fecha_vencimiento + ", condicion=" + condicion + ", Imagen_producto=" + Imagen_producto + '}';
    }
    
}
