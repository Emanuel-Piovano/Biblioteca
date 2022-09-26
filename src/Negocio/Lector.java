package Negocio;

import Datos.Datos;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Lector {
    //Atributos
    protected int id;
    protected String nombre;
    protected String apellido;
    protected String dni;
    protected LocalDate fechaNacimiento;
    protected String direccion;
    protected int localidad;
    protected int provincia;
    protected String telefono;
    protected boolean socio;
    protected float deuda;
    
    
    //Métodos
    //Método constructor 1
    public Lector() {
        this.id = 0;
        this.nombre = "";
        this.apellido = "";
        this.dni = "";
        this.fechaNacimiento = LocalDate.now();
        this.direccion = "";
        this.localidad = 0;
        this.provincia = 0;
        this.telefono = "";
        this.socio = false;
        this.deuda = 0;
        this.socio = false;
    }

    //Método constructor 2
    public Lector(int id) {
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
    
    //Getter apellido
    public String getApellido() {
        return apellido;
    }
    
    //Setter apellido
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    //Getter dni
    public String getDni() {
        return dni;
    }

    //Setter dni
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    //Getter fechaNacimiento
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    //Setter fechaNacimiento
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    //Getter direccion
    public String getDireccion() {
        return direccion;
    }

    //Setter direccion
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    //Getter localidad
    public int getLocalidad() {
        return localidad;
    }

    //Setter localidad
    public void setLocalidad(int localidad) {
        this.localidad = localidad;
    }
    
    //Getter provincia
    public int getProvincia() {
        return provincia;
    }

    //Setter provincia
    public void setProvincia(int provincia) {
        this.provincia = provincia;
    }
    
    //Getter telefono
    public String getTelefono() {
        return telefono;
    }

    //Setter telefono
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    //Getter socio
    public boolean isSocio() {
        return socio;
    }

    //Setter socio
    public void setSocio(boolean socio) {
        this.socio = socio;
    }
    
    //Getter deuda
    public float getDeuda() {
        return deuda;
    }

    //Setter deuda
    public void setDeuda(float deuda) {
        this.deuda = deuda;
    }
    
    public void setFechaNacimiento(String text, DateTimeFormatter JEFormatter) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //Método para agregar un nuevo lector
    public void Agregar(){
        Datos dt = new Datos();

        int nuevoSocio = socio ? 1:0;
        String nuevoLector = ("INSERT INTO Lectores (Nombre,Apellido,DNI,FechaNacimiento,Direccion,Localidad,Provincia,Telefono,Socio,Deuda) VALUES ('"+nombre+"','"+apellido+"','"+dni+"','"+fechaNacimiento+"','"+direccion+"',"+localidad+","+provincia+",'"+telefono+"',"+nuevoSocio+","+deuda+")");
        dt.Agregar(nuevoLector);
    }

    //Método para modificar un lector
    public void Modificar(){
        Datos dt = new Datos();

        int modificarSocio = socio ? 1:0;
        String modificarLector = ("UPDATE Lectores SET Nombre = '"+nombre+"', Apellido = '"+apellido+"', DNI = '"+dni+"', FechaNacimiento = '"+fechaNacimiento+"', Direccion = '"+direccion+"', Localidad = "+localidad+", Provincia = "+provincia+", Telefono = '"+telefono+"', Socio = "+modificarSocio+", Deuda = "+deuda+" WHERE ID = "+id+"");
        dt.Modificar(modificarLector);
    }
}
