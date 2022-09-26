package Presentacion;

import Datos.Datos;
import Negocio.Lector;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Lectores extends javax.swing.JFrame {
    //Atributos
    //protected boolean direccion;
    
    /**
     * Creates new form Ventana
     */
    public Lectores() {
        initComponents();
        setTitle("Lectores");
        setLocationRelativeTo(null);
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        model = (DefaultTableModel) this.jTable1.getModel();
    }
    
    DefaultTableModel model;
    String url = "jdbc:sqlite:D:/Documents/BaseDeDatos/Biblioteca.s3db";
    //Connection connect;
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        textId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jButton2.setText("Refrescar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido", "DNI", "Fecha Nacimiento", "Dirección", "Localidad", "Provincia", "Teléfono", "Socio", "Deuda"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setText("Salir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setText("Modificar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Buscar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1908, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton6)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton7)
                            .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /*
    public boolean isDireccion() {
        return direccion;
    }*/
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Datos dt = new Datos();                             //Se crea el objeto dt correspondiente a la clase Datos
        dt.Refrescar(model);                                //Se llama al método Refrescar del objeto dt de la clase Datos
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        Datos dt = new Datos();                                                 //Se crea el objecto dt en la clase Datos   
        dt.Conectar(url);                                                       //Se llama al método Conectar perteneciente al objeto dt de la clase Datos
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //Al oprimir el botón "Agregar", nos dirige a la ventana "AgregarLector"
        AgregarLector obj = new AgregarLector();
        obj.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Menu obj = new Menu();
        obj.setVisible(true);
        dispose();   
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Datos dt = new Datos();
        
        int filaSeleccionada = jTable1.getSelectedRow();
        
        if(filaSeleccionada >= 0){
            String idEliminar = jTable1.getValueAt(filaSeleccionada, 0).toString();
            
            //System.out.println("Id a eliminar:" + idEliminar);
            model.removeRow(filaSeleccionada);
            dt.Eliminar(idEliminar);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No se selecciono ninguna fila o no existen datos cargados en la tabla.");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        //Al oprimir el botón "Modificar", nos dirige a la ventana "AgregarLector"
        AgregarLector obj = new AgregarLector();
        
        int filaSeleccionada = jTable1.getSelectedRow();
        
        if(filaSeleccionada >= 0){
            int idModificar = Integer.parseInt(jTable1.getValueAt(filaSeleccionada, 0).toString());
            //nuevo.setId(Integer.parseInt(idModificar));
            //nuevo.setId(idModificar);
            String nombreModificar = jTable1.getValueAt(filaSeleccionada, 1).toString();
            //nuevo.setNombre(nombreModificar);
            String apellidoModificar = jTable1.getValueAt(filaSeleccionada, 2).toString();
            String dniModificar = jTable1.getValueAt(filaSeleccionada, 3).toString();
            String fechaNacimientoModificar = jTable1.getValueAt(filaSeleccionada, 4).toString();
            String direccionModificar = jTable1.getValueAt(filaSeleccionada, 5).toString();
            int localidadModificar = Integer.parseInt(jTable1.getValueAt(filaSeleccionada, 6).toString());
            int provinciaModificar = Integer.parseInt(jTable1.getValueAt(filaSeleccionada, 7).toString());
            String telefonoModificar = jTable1.getValueAt(filaSeleccionada, 8).toString();
            Boolean socioModificar = Boolean.parseBoolean(jTable1.getValueAt(filaSeleccionada, 9).toString());
            float deudaModificar = Float.parseFloat(jTable1.getValueAt(filaSeleccionada, 10).toString());
            
            /*
            System.out.println("ID: " + idModificar);
            System.out.println("Nombre: " + nombreModificar);
            System.out.println("Apellido: " + apellidoModificar);
            System.out.println("DNI: " + dniModificar);
            System.out.println("Fecha Nacimiento: " + fechaNacimientoModificar);
            System.out.println("Direccion: " + direccionModificar);
            System.out.println("Localidad: " + localidadModificar);
            System.out.println("Provincia: " + provinciaModificar);
            System.out.println("Telefono: " + telefonoModificar);
            System.out.println("Socio: " + socioModificar);
            System.out.println("Deuda: " + deudaModificar);
            */
            
            obj.setVisible(true);
            obj.Cargar(idModificar, nombreModificar, apellidoModificar, dniModificar, fechaNacimientoModificar, direccionModificar, localidadModificar, provinciaModificar, telefonoModificar, socioModificar, deudaModificar, true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No se selecciono ninguna fila o no existen datos cargados en la tabla.");
        }
      
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        Datos dt = new Datos();                             //Se crea el objeto dt correspondiente a la clase Datos
        
        String idBuscar = textId.getText();
        dt.Buscar(model, idBuscar);                                //Se llama al método Refrescar del objeto dt de la clase Datos
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(Lectores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lectores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lectores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lectores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lectores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField textId;
    // End of variables declaration//GEN-END:variables
}
