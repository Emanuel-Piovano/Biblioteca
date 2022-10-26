package Negocio;

import Datos.Datos;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Prestamo {
    //Atributos
    private int id;
    private int lectorId;
    private String nombreLector;
    private String apellidoLector;
    private int cantidadLibros;
    private float costoTotal;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private Boolean estado;
    
    //Métodos
    //Método constructor 1
    public Prestamo() {
        this.id = 0;
        this.lectorId = 0;
        this.nombreLector = "";
        this.apellidoLector = "";
        this.cantidadLibros = 0;
        this.costoTotal = 0;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = LocalDate.now();
        this.estado = false;
    }
    
    //Método constructor 2
    public Prestamo(int lectorId) {
        this.lectorId = lectorId;
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
    
    //Getter lectorId
    public int getLectorId() {
        return lectorId;
    }

    //Setter lectorId
    public void setLectorId(int lectorId) {
        this.lectorId = lectorId;
    }

    //Getter nombreLector
    public String getNombreLector() {
        return nombreLector;
    }

    //Setter nombreLector
    public void setNombreLector(String nombreLector) {
        this.nombreLector = nombreLector;
    }

    //Getter apellidoLector
    public String getApellidoLector() {
        return apellidoLector;
    }

    //Setter apellidoLector
    public void setApellidoLector(String apellidoLector) {
        this.apellidoLector = apellidoLector;
    }

    //Getter cantidadLibros
    public int getCantidadLibros() {
        return cantidadLibros;
    }

    //Setter cantidadLibros
    public void setCantidadLibros(int cantidadLibros) {
        this.cantidadLibros = cantidadLibros;
    }

    //Getter costoTotal
    public float getCostoTotal() {
        return costoTotal;
    }

    //Setter costoTotal
    public void setCostoTotal(float costoTotal) {
        this.costoTotal = costoTotal;
    }

    //Getter fechaPrestamo
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    //Setter fechaPrestamo
    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    //Getter fechaDevolucion
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    //Setter fechaDevolucion
    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    //Getter estado
    public Boolean getEstado() {
        return estado;
    }

    //Setter estado
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
    public void setFechaPrestamo(String text, DateTimeFormatter JEFormatter) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void setFechaDevolucion(String text, DateTimeFormatter JEFormatter) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //Método para conectar a la base de datos
    public void Conectar(){
        Datos dt = new Datos();

        dt.Conectar();
    }
    
    //Método para agregar un nuevo lector
    public void Agregar(){
        Datos dt = new Datos();

        int nuevoEstado = estado ? 1:0;
        String nuevoPrestamo = ("INSERT INTO Prestamos (LectorID,NombreLector,ApellidoLector,CantidadLibros,CostoTotal,FechaPrestamo,FechaDevolucion,Estado) VALUES ("+lectorId+",'"+nombreLector+"','"+apellidoLector+"',"+cantidadLibros+","+costoTotal+",'"+fechaPrestamo+"','"+fechaDevolucion+"',"+nuevoEstado+")");
        dt.Agregar(nuevoPrestamo);
    }

    //Método para modificar un lector
    public void Modificar(){
        Datos dt = new Datos();

        int modificarEstado = estado ? 1:0;
        String modificarPrestamo = ("UPDATE Prestamos SET LectorID = "+lectorId+", NombreLector = '"+nombreLector+"', ApellidoLector = '"+apellidoLector+"', CantidadLibros = "+cantidadLibros+", CostoTotal = "+costoTotal+", FechaPrestamo = '"+fechaPrestamo+"', FechaDevolucion = '"+fechaDevolucion+"', Estado = "+modificarEstado+" WHERE ID = "+id+"");
        dt.Modificar(modificarPrestamo);
    }
    
    //Método para eliminar un lector
    public void Eliminar(String idEliminar){
        Datos dt = new Datos();

        String eliminarPrestamo = ("DELETE FROM Prestamos WHERE id = " + idEliminar);
        dt.Eliminar(eliminarPrestamo);
    }

    //Método para buscar un Id
    public void Buscar(DefaultTableModel model){
        Datos dt = new Datos();
        
        String buscarPrestamo = ("SELECT * FROM Prestamos WHERE LectorID = " + lectorId);

        model.setRowCount(0);
        ResultSet result = null;

        try {
            result = dt.Buscar(model, buscarPrestamo, result);

            while (result.next()) {
                model.addRow(
                        new Object[]{
                            this.id = result.getInt("ID"),
                            this.lectorId = result.getInt("LectorID"),
                            this.nombreLector = result.getString("NombreLector"),
                            this.apellidoLector = result.getString("ApellidoLector"),
                            this.cantidadLibros = result.getInt("CantidadLibros"),
                            this.costoTotal = result.getFloat("CostoTotal"),
                            this.fechaPrestamo = result.getDate("FechaPrestamo").toLocalDate(),
                            this.fechaDevolucion = result.getDate("FechaDevolucion").toLocalDate(),
                            this.estado = result.getBoolean("Estado")
                        }
                );
            }

        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, x.getMessage().toString());
        }
    }
    
}