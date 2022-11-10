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
    private int idLibro1;
    private int idLibro2;
    private int idLibro3;
    private int idLibro4;
    private int idLibro5;
    
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
        this.idLibro1 = 0;
        this.idLibro2 = 0;
        this.idLibro3 = 0;
        this.idLibro4 = 0;
        this.idLibro5 = 0;
    }
    
    //Método constructor 2
    public Prestamo(int lectorId) {
        this.lectorId = lectorId;
    }

    //Método constructor 3
    public Prestamo(int id, int lectorId) {
        this.id = id;
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

    //Getter idLibro1
    public int getIdLibro1() {
        return idLibro1;
    }

    //Setter idLibro1
    public void setIdLibro1(int idLibro1) {
        this.idLibro1 = idLibro1;
    }
    
    //Getter idLibro2
    public int getIdLibro2() {
        return idLibro2;
    }

    //Setter idLibro2
    public void setIdLibro2(int idLibro2) {
        this.idLibro2 = idLibro2;
    }

    //Getter idLibro3
    public int getIdLibro3() {
        return idLibro3;
    }

    //Setter idLibro3
    public void setIdLibro3(int idLibro3) {
        this.idLibro3 = idLibro3;
    }

    //Getter idLibro4
    public int getIdLibro4() {
        return idLibro4;
    }

    //Setter idLibro4
    public void setIdLibro4(int idLibro4) {
        this.idLibro4 = idLibro4;
    }

    //Getter idLibro5
    public int getIdLibro5() {
        return idLibro5;
    }

    //Setter idLibro5
    public void setIdLibro5(int idLibro5) {
        this.idLibro5 = idLibro5;
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
    
    //Método para desconectar a la base de datos
    public void Desconectar(){
        Datos dt = new Datos();
        //ResultSet result = null;
        
        //dt.Desconectar(result);
        dt.Desconectar();
    }
    
    //Método para agregar un nuevo lector
    public void Agregar(){
        Datos dt = new Datos();
        
        int nuevoEstado = estado ? 1:0;
        String nuevoPrestamo = ("INSERT INTO Prestamos (LectorID,NombreLector,ApellidoLector,CantidadLibros,CostoTotal,FechaPrestamo,FechaDevolucion,Estado,IDLibro1,IDLibro2,IDLibro3,IDLibro4,IDLibro5) VALUES ("+lectorId+",'"+nombreLector+"','"+apellidoLector+"',"+cantidadLibros+","+costoTotal+",'"+fechaPrestamo+"','"+fechaDevolucion+"',"+nuevoEstado+", "+idLibro1+", "+idLibro2+", "+idLibro3+", "+idLibro4+", "+idLibro5+")");
        dt.Agregar(nuevoPrestamo);        
    }

    //Método para modificar un lector
    public void Modificar(){
        Datos dt = new Datos();

        int modificarEstado = estado ? 1:0;
        String modificarPrestamo = ("UPDATE Prestamos SET LectorID = "+lectorId+", NombreLector = '"+nombreLector+"', ApellidoLector = '"+apellidoLector+"', CantidadLibros = "+cantidadLibros+", CostoTotal = "+costoTotal+", FechaPrestamo = '"+fechaPrestamo+"', FechaDevolucion = '"+fechaDevolucion+"', Estado = "+modificarEstado+", IDLibro1 = "+idLibro1+", IDLibro2 = "+idLibro2+", IDLibro3 = "+idLibro3+", IDLibro4 = "+idLibro4+", IDLibro5 = "+idLibro5+" WHERE ID = "+id+"");
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
            
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");  //Este es el formato que nos devuelve la base de datos
            
            while (result.next()) {
                model.addRow(
                        new Object[]{
                            this.id = result.getInt("ID"),
                            this.fechaPrestamo = LocalDate.parse(result.getString("FechaPrestamo"), formato),
                            this.fechaDevolucion = LocalDate.parse(result.getString("FechaDevolucion"), formato),
                            this.cantidadLibros = result.getInt("CantidadLibros"),
                            this.costoTotal = result.getFloat("CostoTotal"),
                            this.estado = result.getBoolean("Estado"),
                            this.idLibro1 = result.getInt("IDLibro1"),
                            this.idLibro2 = result.getInt("IDLibro2"),
                            this.idLibro3 = result.getInt("IDLibro3"),
                            this.idLibro4 = result.getInt("IDLibro4"),
                            this.idLibro5 = result.getInt("IDLibro5")
                        }
                );
            }
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, x.getMessage().toString());
        }
    }

    //Método para buscar un Id
    public void BuscarLibros(DefaultTableModel model){
        Datos dt = new Datos();
        
        String buscarPrestamo = ("SELECT * FROM Prestamos WHERE LectorID = " + lectorId + " AND ID = " + id);

        model.setRowCount(0);
        ResultSet result = null;

        try {
            result = dt.Buscar(model, buscarPrestamo, result);

            while (result.next()) {
                model.addRow(
                        new Object[]{
                            this.id = result.getInt("ID"),
                            this.fechaPrestamo = result.getDate("FechaPrestamo").toLocalDate(),
                            this.fechaDevolucion = result.getDate("FechaDevolucion").toLocalDate(),
                            this.cantidadLibros = result.getInt("CantidadLibros"),
                            this.costoTotal = result.getFloat("CostoTotal"),
                            this.estado = result.getBoolean("Estado"),
                            this.idLibro1 = result.getInt("IDLibro1"),
                            this.idLibro2 = result.getInt("IDLibro2"),
                            this.idLibro3 = result.getInt("IDLibro3"),
                            this.idLibro4 = result.getInt("IDLibro4"),
                            this.idLibro5 = result.getInt("IDLibro5")
                        }
                );
            }

        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, x.getMessage().toString());
        }
    }
}