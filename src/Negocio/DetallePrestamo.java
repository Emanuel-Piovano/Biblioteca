package Negocio;

import Datos.Datos;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DetallePrestamo {
    //Atributos
    private int id;
    private int prestamoId;
    private int libroId;
    private String nombreLibro;
    private String autorLibro;
    private int cantidad;
    private float precioUnitario;
    private float precioTotal;

    //Métodos
    //Método constructor 1
    public DetallePrestamo() {
        this.id = 0;
        this.prestamoId = 0;
        this.libroId = 0;
        this.nombreLibro = "";
        this.autorLibro = "";
        this.cantidad = 0;
        this.precioUnitario = 0;
        this.precioTotal = 0;
    }

    //Método constructor 2
    public DetallePrestamo(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    
    //Getters y Setters
    //Getter id
    public int getId() {
        return id;
    }

    //Setter id
    public void setId(int id) {
        this.id = id;
    }

    //Getter prestamoId
    public int getPrestamoId() {
        return prestamoId;
    }

    //Setter prestamoId
    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    //Getter libroId
    public int getLibroId() {
        return libroId;
    }

    //Setter libroId
    public void setLibroId(int libroId) {
        this.libroId = libroId;
    }

    //Getter nombreLibro
    public String getNombreLibro() {
        return nombreLibro;
    }

    //Setter nombreLibro
    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    //Getter autorLibro
    public String getAutorLibro() {
        return autorLibro;
    }

    //Setter autorLibro
    public void setAutorLibro(String autorLibro) {
        this.autorLibro = autorLibro;
    }

    //Getter cantidad
    public int getCantidad() {
        return cantidad;
    }

    //Setter cantidad
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    //Getter precioUnitario
    public float getPrecioUnitario() {
        return precioUnitario;
    }

    //Setter precioUnitario
    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    //Getter precioTotal
    public float getPrecioTotal() {
        return precioTotal;
    }

    //Setter precioTotal
    public void setPrecioTotal(float precioTotal) {
        this.precioTotal = precioTotal;
    }
    
    
    //Método para conectar a la base de datos
    public void Conectar(){
        Datos dt = new Datos();

        dt.Conectar();
    }
    
    //Método para agregar un nuevo detallePrestamo
    public void Agregar(){
        Datos dt = new Datos();

        String nuevoDetalle = ("INSERT INTO DetallePrestamos (PrestamoID,LibroID,NombreLibro,AutorLibro,Cantidad,PrecioUnitario,PrecioTotal) VALUES ("+prestamoId+","+libroId+",'"+nombreLibro+"','"+autorLibro+"',"+cantidad+","+precioUnitario+","+precioTotal+")");
        dt.Agregar(nuevoDetalle);
    }

    //Método para modificar un detallePrestamo
    public void Modificar(){
        Datos dt = new Datos();

        String modificarDetallePrestamo = ("UPDATE DetallePrestamos SET PrestamoID = "+prestamoId+", LibroID = "+libroId+", NombreLibro = '"+nombreLibro+"', AutorLibro = '"+autorLibro+"', Cantidad = "+cantidad+", PrecioUnitario = "+precioUnitario+", PrecioTotal = "+precioTotal+" WHERE ID = "+id+"");
        dt.Modificar(modificarDetallePrestamo);
    }
    
    //Método para eliminar un detallePrestamo
    public void Eliminar(String idEliminar){
        Datos dt = new Datos();

        String eliminarDetallePrestamo = ("DELETE FROM DetallePrestamos WHERE id = " + idEliminar);
        dt.Eliminar(eliminarDetallePrestamo);
    }

    //Método para buscar un Id
    public void Buscar(DefaultTableModel model){
        Datos dt = new Datos();
        
        String buscarDetallePrestamo = ("SELECT * FROM DetallePrestamos WHERE PrestamoID = " + prestamoId);

        model.setRowCount(0);
        ResultSet result = null;

        try {
            result = dt.Buscar(model, buscarDetallePrestamo, result);

            while (result.next()) {
                model.addRow(
                        new Object[]{
                            this.id = result.getInt("ID"),
                            this.prestamoId = result.getInt("PrestamoID"),
                            this.libroId = result.getInt("LibroID"),
                            this.nombreLibro = result.getString("NombreLibro"),
                            this.autorLibro = result.getString("AutorLibro"),
                            this.cantidad = result.getInt("Cantidad"),
                            this.precioUnitario = result.getFloat("PrecioUnitario"),
                            this.precioTotal = result.getFloat("PrecioTotal")
                        }
                );
            }

        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, x.getMessage().toString());
        }
    }
    
}
