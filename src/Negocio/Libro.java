package Negocio;

import Datos.Datos;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;


public class Libro {
    //Atributos
    private int id;
    private String nombre;
    private String autor;
    private String editorial;
    private String genero;
    private String coleccion;
    private String isbn;
    private int paginas;
    private int anioPublicacion;
    private String descripcion;
    private Boolean estado;
    private float precio;

    //Métodos
    //Método constructor 1
    public Libro() {
        this.id = 0;
        this.nombre = "";
        this.autor = "";
        this.editorial = "";
        this.genero = "";
        this.coleccion = "";
        this.isbn = "";
        this.paginas = 0;
        this.anioPublicacion = 0;
        this.descripcion = "";
        this.estado = false;
        this.precio = 0;
    }
    
    //Método constructor 2
    public Libro(int id) {
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
    
    //Getter autor
    public String getAutor() {
        return autor;
    }

    //Setter autor
    public void setAutor(String autor) {
        this.autor = autor;
    }

    //Getter editorial
    public String getEditorial() {
        return editorial;
    }

    //Setter editorial
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    //Getter genero
    public String getGenero() {
        return genero;
    }

    //Setter genero
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    //Getter coleccion
    public String getColeccion() {
        return coleccion;
    }
    
    //Setter coleccion
    public void setColeccion(String coleccion) {
        this.coleccion = coleccion;
    }
    
    //Getter isbn
    public String getIsbn() {
        return isbn;
    }

    //Setter isbn
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    //Getter paginas
    public int getPaginas() {
        return paginas;
    }

    //Setter paginas
    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    //Getter anioPublicacion
    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    //Setter anioPublicacion
    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    //Getter descripcion
    public String getDescripcion() {
        return descripcion;
    }

    //Setter descripcion
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //Getter estado
    public Boolean getEstado() {
        return estado;
    }
    
    //Setter estado
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    //Getter precio
    public float getPrecio() {
        return precio;
    }

    //Setter precio
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
        //Método para conectar a la base de datos
    public void Conectar(){
        Datos dt = new Datos();

        dt.Conectar();
    }
    
    //Método para agregar un nuevo libro
    public void Agregar(){
        Datos dt = new Datos();

        int nuevoEstado = estado ? 1:0;
        String nuevoLibro = ("INSERT INTO Libros (Nombre,Autor,Editorial,Genero,Coleccion,ISBN,Paginas,AnioPublicacion,Descripcion,Estado,Precio) VALUES ('"+nombre+"','"+autor+"','"+editorial+"','"+genero+"','"+coleccion+"','"+isbn+"',"+paginas+","+anioPublicacion+",'"+descripcion+"',"+nuevoEstado+","+precio+")");
        dt.Agregar(nuevoLibro);
    }

    //Método para modificar un lector
    public void Modificar(){
        Datos dt = new Datos();

        int modificarEstado = estado ? 1:0;
        String modificarLibro = ("UPDATE Libros SET Nombre = '"+nombre+"', Autor = '"+autor+"', Editorial = '"+editorial+"', Genero = '"+genero+"', Coleccion = '"+coleccion+"', ISBN = '"+isbn+"', Paginas = "+paginas+", AnioPublicacion = "+anioPublicacion+", Descripcion = '"+descripcion+"', Estado = "+modificarEstado+", Precio = "+precio+" WHERE ID = "+id+"");
        dt.Modificar(modificarLibro);
    }
    
    //Método para eliminar un lector
    public void Eliminar(String idEliminar){
        Datos dt = new Datos();

        String eliminarLibro = ("DELETE FROM Libros WHERE id = " + idEliminar);
        dt.Eliminar(eliminarLibro);
    }
    
    //Método para refrescar
    public void Refrescar(DefaultTableModel model){
        Datos dt = new Datos();

        String refrescar = ("SELECT * FROM Libros");

        model.setRowCount(0);
        ResultSet result = null;

        try {
            result = dt.Refrescar(model, refrescar, result);

            while (result.next()) {
                model.addRow(
                        new Object[]{
                            result.getInt("ID"),
                            result.getString("Nombre"),
                            result.getString("Autor"),
                            result.getString("Editorial"),
                            result.getString("Genero"),
                            result.getString("Coleccion"),
                            result.getString("ISBN"),
                            result.getInt("Paginas"),
                            result.getInt("AnioPublicacion"),
                            result.getString("Descripcion"),
                            result.getBoolean("Estado"),
                            result.getFloat("Precio")
                        }
                );
            }

        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, x.getMessage().toString());
        }
    }
    
    //Método para buscar un Id
    public void Buscar(DefaultTableModel model){
        Datos dt = new Datos();
        
        String buscarLibro = ("SELECT * FROM Libros WHERE ID = " + id);

        model.setRowCount(0);
        ResultSet result = null;

        try {
            result = dt.Buscar(model, buscarLibro, result);

            while (result.next()) {
                model.addRow(
                        new Object[]{
                            this.id = result.getInt("ID"),
                            this.nombre = result.getString("Nombre"),
                            this.autor = result.getString("Autor"),
                            this.editorial = result.getString("Editorial"),
                            this.genero = result.getString("Genero"),
                            this.coleccion = result.getString("Coleccion"),
                            this.isbn = result.getString("ISBN"),
                            this.paginas = result.getInt("Paginas"),
                            this.anioPublicacion = result.getInt("AnioPublicacion"),
                            this.descripcion = result.getString("Descripcion"),
                            this.estado = result.getBoolean("Estado"),
                            this.precio = result.getFloat("Precio")
                        }
                );
            }

        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, x.getMessage().toString());
        }
    }
    
    //Método para buscar un Id
    public void BuscarLibros(DefaultTableModel model, int idLibro1, int idLibro2, int idLibro3, int idLibro4, int idLibro5){
        Datos dt = new Datos();
        
        String buscarLibro = ("SELECT * FROM Libros WHERE ID = " + idLibro1 + " OR ID = " + idLibro2 + " OR ID = " + idLibro3 + " OR ID = " + idLibro4 + " OR ID = " + idLibro5);

        model.setRowCount(0);
        ResultSet result = null;

        try {
            result = dt.Buscar(model, buscarLibro, result);

            while (result.next()) {
                model.addRow(
                        new Object[]{
                            this.id = result.getInt("ID"),
                            this.nombre = result.getString("Nombre"),
                            this.autor = result.getString("Autor"),
                            this.editorial = result.getString("Editorial"),
                            this.genero = result.getString("Genero"),
                            this.coleccion = result.getString("Coleccion"),
                            this.isbn = result.getString("ISBN"),
                            this.paginas = result.getInt("Paginas"),
                            this.anioPublicacion = result.getInt("AnioPublicacion"),
                            this.descripcion = result.getString("Descripcion"),
                            this.estado = result.getBoolean("Estado"),
                            this.precio = result.getFloat("Precio")
                        }
                );
            }

        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, x.getMessage().toString());
        }
    }
    
    //Método para listar los autores de los libros un JComboBox
    public void ListadoAutoresLibros(JComboBox autorLibros){
        Datos dt = new Datos();
        
        String autorLibro = ("SELECT DISTINCT Autor FROM Libros");

        ResultSet resultListadoAutoresLibros = null;

        try {
            //dt.Conectar();
            
            resultListadoAutoresLibros = dt.Buscar(autorLibro, resultListadoAutoresLibros);
            autorLibros.addItem("Seleccione autor");
            
            while (resultListadoAutoresLibros.next()) {
                autorLibros.addItem(resultListadoAutoresLibros.getString("Autor"));
            }
            
            //resultListadoAutoresLibros.close();
            
            //dt.Desconectar(resultListadoAutoresLibros);
            
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, x.getMessage());
        }
    }
    
    //Método para listar los nombres de los libros un JComboBox
    public void ListadoNombresLibros(JComboBox nombreLibros){
        Datos dt = new Datos();
        
        nombreLibros.removeAllItems();
        
        String nombreLibro = ("SELECT DISTINCT Nombre FROM Libros WHERE Autor = \"" + autor + "\"");

        ResultSet resultListadoNombresLibros = null;

        try {
            //dt.Conectar();
            
            resultListadoNombresLibros = dt.Buscar(nombreLibro, resultListadoNombresLibros);

            while (resultListadoNombresLibros.next()) {
                nombreLibros.addItem(resultListadoNombresLibros.getString("Nombre"));
            }
            //resultListadoNombresLibros.close();
            
            //dt.Desconectar(resultListadoNombresLibros);
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, x.getMessage());
        }
    }
    
    //Método para obtener el ID del libro seleccionado
    public void IdLibro(){
        Datos dt = new Datos();
        
        String idLibroSeleccionado = ("SELECT ID FROM Libros WHERE Autor = \"" + autor + "\" AND Nombre = \"" + nombre + "\"");

        ResultSet resultIdLibro = null;

        try {
            //dt.Conectar();
            
            resultIdLibro = dt.Buscar(idLibroSeleccionado, resultIdLibro);
            
            this.id = resultIdLibro.getInt("ID");
            
            //resultIdLibro.close();
            //dt.Desconectar(resultIdLibro);
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, x.getMessage());
        }
    }
    
    //Método para obtener el precio del libro seleccionado
    public void PrecioLibro(){
        Datos dt = new Datos();
        
        String precioLibroSeleccionado = ("SELECT Precio FROM Libros WHERE Autor = \"" + autor + "\" AND Nombre = \"" + nombre + "\"");

        ResultSet resultPrecioLibro = null;

        try {
            //dt.Conectar();
            resultPrecioLibro = dt.Buscar(precioLibroSeleccionado, resultPrecioLibro);
            
            this.precio = resultPrecioLibro.getFloat("Precio");
            
            //resultPrecioLibro.close();    
            
            //dt.Desconectar(resultPrecioLibro);
        } catch (SQLException x) {
            JOptionPane.showMessageDialog(null, x.getMessage());
        }
    }
}
