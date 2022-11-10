package Datos;

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

    public static Connection connect;

    public void Conectar() {
        try {
            Class.forName(baseDeDatos);
            connect = DriverManager.getConnection(direccion);

        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, x.getMessage());
        }
    }
    
    public void Desconectar(ResultSet resulset) {
        try {
            resulset.close();
            connect.close();

        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, x.getMessage());
        }
    }
    
    public ResultSet Refrescar(DefaultTableModel model, String refrescar, ResultSet result) {
        try {
            PreparedStatement st = connect.prepareStatement(refrescar);
            result = st.executeQuery();
       
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, x.getMessage().toString());
        }
        
        return result;
    }

    public void Agregar(String agregar) {

        try {
            PreparedStatement st = connect.prepareStatement(agregar);
            st.execute();
            JOptionPane.showMessageDialog(null, "Datos guardados");
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, x.getMessage().toString());
        }
    }

    public void Eliminar(String eliminar) {
        try {
            PreparedStatement st = connect.prepareStatement(eliminar);
            st.execute();
            JOptionPane.showMessageDialog(null, "El registro ha sido eliminado correctamente.");
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, x.getMessage().toString());
            JOptionPane.showMessageDialog(null, "Error al eliminar el registro. Volver a intentar nuevamente.");
        }
    }

    public ResultSet Buscar(DefaultTableModel model, String buscar, ResultSet result) {
        try {
            PreparedStatement st = connect.prepareStatement(buscar);
            result = st.executeQuery();
       
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, x.getMessage().toString());
        }
        
        return result;
    }
    
    public ResultSet Buscar(String buscar, ResultSet result) {
        try {
            PreparedStatement st = connect.prepareStatement(buscar);
            result = st.executeQuery();
       
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, x.getMessage());
        }
        
        return result;
    }
    
    public void Modificar(String modificar) {

        try {
            PreparedStatement st = connect.prepareStatement(modificar);
            st.execute();
            JOptionPane.showMessageDialog(null, "Datos modificados");
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, x.getMessage().toString());
        }
    }
}
