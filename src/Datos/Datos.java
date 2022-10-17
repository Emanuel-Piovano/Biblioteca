package Datos;

import Negocio.Lector;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Datos {
    //Atributos
    //Constantes de conexión a la Base de Datos
    private final String baseDeDatos = "org.sqlite.JDBC";
    private final String direccion = "jdbc:sqlite:D:/Documents/BaseDeDatos/Biblioteca.s3db";
    
    public static Connection connect ;
    
    public void Conectar(){
        try{
        Class.forName(baseDeDatos);
        connect = DriverManager.getConnection(direccion);
        
        }catch(Exception x){
            JOptionPane.showMessageDialog(null, x.getMessage());
        }   
    }
    
    public void Refrescar (DefaultTableModel model, String refrescar){
        model.setRowCount(0);
        ResultSet result = null;
        
        try {
            PreparedStatement st = connect.prepareStatement(refrescar);
            result = st.executeQuery();
            
            while (result.next()) {                
                model.addRow(
                        new Object[]{
                            result.getInt("ID"),
                            result.getString("Nombre"),
                            result.getString("Apellido"), 
                            result.getString("DNI"), 
                            result.getString("FechaNacimiento"), 
                            result.getString("Direccion"), 
                            result.getInt("Localidad"), 
                            result.getInt("Provincia"), 
                            result.getString("Telefono"), 
                            result.getBoolean("Socio"), 
                            result.getFloat("Deuda")
                        }
                );
            }
            
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, x.getMessage().toString());
        }
    }
    
    public void Agregar(String nuevoLector){
        
        try {            
            PreparedStatement st = connect.prepareStatement(nuevoLector);
            st.execute();
            JOptionPane.showMessageDialog(null, "Datos guardados");
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, x.getMessage().toString());
        }
    }
    
    public void Eliminar(String eliminarLector){
        try {            
            //PreparedStatement st = connect.prepareStatement("DELETE FROM Lectores WHERE id = " + idEliminar);
            PreparedStatement st = connect.prepareStatement(eliminarLector);
            st.execute();
            JOptionPane.showMessageDialog(null, "El registro ha sido eliminado correctamente.");
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, x.getMessage().toString());
            JOptionPane.showMessageDialog(null, "Error al eliminar el registro. Volver a intentar nuevamente.");
        }
    }
    
    public void Buscar(DefaultTableModel model, String buscarLector){
        model.setRowCount(0);
        ResultSet result = null;
        
        try {
            //System.out.println("idBuscar: " + idBuscar);
            PreparedStatement st = connect.prepareStatement(buscarLector);
            result = st.executeQuery();
            
            while (result.next()) {                
                model.addRow(
                        new Object[]{
                            result.getInt("ID"),
                            result.getString("Nombre"),
                            result.getString("Apellido"), 
                            result.getString("DNI"), 
                            result.getString("FechaNacimiento"), 
                            result.getString("Direccion"), 
                            result.getInt("Localidad"), 
                            result.getInt("Provincia"), 
                            result.getString("Telefono"), 
                            result.getBoolean("Socio"), 
                            result.getFloat("Deuda")
                        }
                );
            }
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, x.getMessage().toString());
        }
    }
    
    public void Modificar(String modificarLector){
        
        try {            
            PreparedStatement st = connect.prepareStatement(modificarLector);
            st.execute();
            JOptionPane.showMessageDialog(null, "Datos modificados");
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, x.getMessage().toString());
        }
    }
}