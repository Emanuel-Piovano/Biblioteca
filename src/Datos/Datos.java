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
    public static Connection connect ;
    
    public void Conectar(String url){
        try{
        Class.forName("org.sqlite.JDBC");
        connect = DriverManager.getConnection(url);
        
        if(connect != null){                                                    //Muestra un mensaje que se conectó correctamente a la base de datos
            JOptionPane.showMessageDialog(null, "Conectado");
        }
        
        }catch(Exception x){
            JOptionPane.showMessageDialog(null, x.getMessage());
        }   
    }
    
    public void Refrescar (DefaultTableModel model){
        model.setRowCount(0);
        ResultSet result = null;
        
        try {
            PreparedStatement st = connect.prepareStatement("SELECT * FROM Lectores");
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
    
    public void Eliminar(String idEliminar){
        try {            
            PreparedStatement st = connect.prepareStatement("DELETE FROM Lectores WHERE id = " + idEliminar);
            st.execute();
            JOptionPane.showMessageDialog(null, "El registro ha sido eliminado correctamente.");
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, x.getMessage().toString());
            JOptionPane.showMessageDialog(null, "Error al eliminar el registro. Volver a intentar nuevamente.");
        }
    }
    
    /*
    public void Buscar(DefaultTableModel model, String idBuscar){
        model.setRowCount(0);
        ResultSet result = null;
        
        try {
            System.out.println("idBuscar: " + idBuscar);
            PreparedStatement st = connect.prepareStatement("SELECT * FROM Lectores WHERE ID = " + idBuscar);
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
    */
    
    public void Buscar(DefaultTableModel model, String idBuscar){
        model.setRowCount(0);
        ResultSet result = null;
        
        try {
            //System.out.println("idBuscar: " + idBuscar);
            PreparedStatement st = connect.prepareStatement("SELECT * FROM Lectores WHERE ID = " + idBuscar);
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
