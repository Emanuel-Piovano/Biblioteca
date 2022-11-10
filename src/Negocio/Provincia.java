package Negocio;

import Datos.Datos;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Provincia {
    //Atributos
    private int id;
    private String nombre;

    
    //Métodos
    //Método constructor 1
    public Provincia() {
        this.id = 0;
        this.nombre = "";
    }
    
    //Método constructor 2
    public Provincia(int id) {
        this.id = id;
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
    
    //Getter nombre
    public String getNombre() {
        return nombre;
    }

    //Setter nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    
    //Método para refrescar
    public void Refrescar(DefaultTableModel model){
        Datos dt = new Datos();

        String refrescar = ("SELECT * FROM Provincias");

        model.setRowCount(0);
        ResultSet result = null;

        try {
            result = dt.Refrescar(model, refrescar, result);

            while (result.next()) {
                model.addRow(
                        new Object[]{
                            result.getInt("ID"),
                            result.getString("NombreProvincia")
                        }
                );
            }

        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, x.getMessage().toString());
        }
    }
    
    public void Buscar(DefaultTableModel model){
        Datos dt = new Datos();
        
        String buscarProvincia = ("SELECT * FROM Provincias WHERE ID = " + id);

        model.setRowCount(0);
        ResultSet result = null;

        try {
            result = dt.Buscar(model, buscarProvincia, result);
            
            while (result.next()) {
                model.addRow(
                        new Object[]{
                            this.id = result.getInt("ID"),
                            this.nombre = result.getString("NombreProvincia")
                        }
                );
            }

        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, x.getMessage().toString());
        }
    }
    
}
