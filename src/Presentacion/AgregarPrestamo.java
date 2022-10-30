package Presentacion;

import Negocio.Lector;
import Negocio.Libro;
import Negocio.Prestamo;
import java.awt.Graphics;
import java.awt.Image;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AgregarPrestamo extends javax.swing.JFrame {
    /**
     * Creates new form AgregarLector
     */
    Libro listado = new Libro();
    FondoPanel fondo = new FondoPanel();
    
    public AgregarPrestamo() {
        this.setContentPane(fondo);
        
        initComponents();
        setTitle("Agregar nuevo lector");
        setLocationRelativeTo(null);
        listado.ListadoAutoresLibros(AutorLibro);
        String autorLibro = AutorLibro.getSelectedItem().toString();
        listado.setAutor(autorLibro);
        listado.ListadoNombresLibros(NombreLibro);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonesSiNo = new javax.swing.ButtonGroup();
        calendarPanel1 = new com.github.lgooddatepicker.components.CalendarPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        textApellido = new javax.swing.JTextField();
        textFechaNacimiento = new javax.swing.JTextField();
        textDeuda = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        textId = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        textFechaNacimiento1 = new javax.swing.JTextField();
        NombreLibro = new javax.swing.JComboBox<>();
        AutorLibro = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel2.setText("Apellido");

        jLabel4.setText("Fecha prestamo");

        jLabel10.setText("Deuda");

        textNombre.setEditable(false);

        textApellido.setEditable(false);

        textFechaNacimiento.setText("dd/mm/aaaa");

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Salir");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Nuevo prestamo");
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jLabel12.setText("ID");

        textId.setEditable(false);

        jLabel13.setText("Fecha devolución");

        textFechaNacimiento1.setText("dd/mm/aaaa");

        AutorLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutorLibroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(textNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                    .addComponent(textFechaNacimiento))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(AutorLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(NombreLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textApellido)
                    .addComponent(textDeuda)
                    .addComponent(textId)
                    .addComponent(textFechaNacimiento1, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                .addGap(120, 120, 120))
            .addGroup(layout.createSequentialGroup()
                .addGap(272, 272, 272)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(textApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(textFechaNacimiento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AutorLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(textDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jToggleButton1))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        //Al oprimir el botón "Salir", nos regresa a la ventana "Lectores"
        dispose();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        /*
        Lector nuevo = new Lector();
        
        nuevo.setNombre(textNombre.getText());
        nuevo.setApellido(textApellido.getText());
        nuevo.setDni(textDni.getText());
        DateTimeFormatter JEFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        nuevo.setFechaNacimiento(LocalDate.parse(textFechaNacimiento.getText(), JEFormatter));
        nuevo.setDireccion(textDireccion.getText());
        nuevo.setLocalidad(Integer.parseInt(textLocalidad.getText()));
        nuevo.setProvincia(Integer.parseInt(textProvincia.getText()));
        nuevo.setTelefono(textTelefono.getText());
        nuevo.setDeuda(Float.parseFloat(textDeuda.getText()));
        
        if (botonSi.isSelected() == true)
        {
            nuevo.setSocio(true);
        }
        else
        {
            nuevo.setSocio(false);
        }
        */
        /*
        System.out.println("El id es: " + nuevo.getId());
        System.out.println("El nombre es: " + nuevo.getNombre());
        System.out.println("El apellido es: " + nuevo.getApellido());
        System.out.println("El dni es: " + nuevo.getDni());
        System.out.println("La fecha de nacimiento es: " + nuevo.getFechaNacimiento());
        System.out.println("La direccion es: " + nuevo.getDireccion());
        System.out.println("La localidad es: " + nuevo.getLocalidad());
        System.out.println("La provincia es: " + nuevo.getProvincia());
        System.out.println("El telefono es: " + nuevo.getTelefono());
        System.out.println("La deuda es: " + nuevo.getDeuda());
        */
        /*
        if (botonEstado.isSelected() == false){
            nuevo.Agregar();
        }
        else{
            nuevo.setId(Integer.parseInt(textId.getText()));
            nuevo.Modificar();
        }
        */
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void AutorLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutorLibroActionPerformed
        // TODO add your handling code here:
        if(AutorLibro.getSelectedIndex() > -1)
        {
            String autorLibro = AutorLibro.getSelectedItem().toString();
            listado.setAutor(autorLibro);
            System.out.println("El autor seleccionado es: " + autorLibro);
            NombreLibro.setSelectedIndex(0);
            listado.ListadoNombresLibros(NombreLibro);
        }
    }//GEN-LAST:event_AutorLibroActionPerformed
    
    public void Cargar(int idModificar, String nombreModificar, String apellidoModificar){
        textId.setText(String.valueOf(idModificar));
        textNombre.setText(nombreModificar);
        textApellido.setText(apellidoModificar);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgregarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarPrestamo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AutorLibro;
    private javax.swing.JComboBox<String> NombreLibro;
    private javax.swing.ButtonGroup botonesSiNo;
    private com.github.lgooddatepicker.components.CalendarPanel calendarPanel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField textApellido;
    private javax.swing.JTextField textDeuda;
    private javax.swing.JTextField textFechaNacimiento;
    private javax.swing.JTextField textFechaNacimiento1;
    private javax.swing.JTextField textId;
    private javax.swing.JTextField textNombre;
    // End of variables declaration//GEN-END:variables

    //Se le coloca una imagen como fondo de pantalla
    class FondoPanel extends JPanel{
        private Image imagen;
        
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("/Imagenes/Biblioteca.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
    /*
    private void cargarListado(JComboBox c){
        Libro completar = new Libro();
        
        completar.Listado(model);
        
    }*/
}
