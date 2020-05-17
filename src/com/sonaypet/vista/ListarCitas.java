
package com.sonaypet.vista;


import com.sonaypet.modelo.dao.CitaDAO;
import com.sonaypet.modelo.dao.ClienteVeterinariaDAO;
import com.sonaypet.modelo.dao.MascotaDAO;
import com.sonaypet.modelo.entidades.AgendarCita;
import com.sonaypet.modelo.entidades.Cita;
import com.sonaypet.modelo.entidades.ClienteVeterinaria;
import com.sonaypet.modelo.entidades.Mascota;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ListarCitas extends javax.swing.JInternalFrame {
    AgendarCita agendarCita = new AgendarCita();
    ClienteVeterinariaDAO cvdao = new ClienteVeterinariaDAO();
    ClienteVeterinaria cv = new ClienteVeterinaria();
    MascotaDAO mdao = new MascotaDAO();
    Mascota mascota = new Mascota();
    CitaDAO dao = new CitaDAO();
    Cita cita = new Cita();
    DefaultTableModel modelo = new DefaultTableModel();
    
    
    int id;
    int idCliente;
    int idMascota;
    String nombreCli;
    String apellido;
    String nombreM;
    
    public ListarCitas() {
        initComponents();
        listar();
    }
    public ListarCitas(int id,int idM){
    initComponents();
    idCliente = id;
    idMascota = idM;
    
    mascota = mdao.listarID(idM);
 
    cv = cvdao.listarID(id);
    
    
    
    listar();
        
    }

    public String getNombreCli() {
        return nombreCli;
    }

    public void setNombreCli(String nombreCli) {
        this.nombreCli = nombreCli;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreM() {
        return nombreM;
    }

    public void setNombreM(String nombreM) {
        this.nombreM = nombreM;
    }

    
    
    
    
    void listar(){
        
        List<AgendarCita> lista = dao.custom2();
        modelo = (DefaultTableModel)tbl1.getModel();
        Object[]ob = new Object[6];
        for(int i = 0; i < lista.size(); i++){
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getNombre();
            ob[2] = lista.get(i).getApellido();
            ob[3] = lista.get(i).getNombreM();
            ob[4] = lista.get(i).getFecha();
            ob[5] = lista.get(i).getHora();
            modelo.addRow(ob);
        }
        
        tbl1.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setBorder(null);
        setTitle("Ver Citas");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnEliminar.setText("CULMINAR CITA");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "APELLIDO", "MASCOTA", "FECHA", "HORA"
            }
        ));
        tbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tbl1.getSelectedRow();
        if(fila == -1){  
        JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para culminar la cita");
        
        }else{
        eliminar();
        limpiarTabla();
        listar();
        }    
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked
        int fila = tbl1.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        
        }else{
            try{
            id = Integer.parseInt(tbl1.getValueAt(fila, 0).toString());
            String fechaCita = tbl1.getValueAt(fila, 4).toString();
            String horaCita = tbl1.getValueAt(fila, 5).toString();
            String fecha = fechaCita;
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);     
            
            }catch (ParseException ex) {
                 Logger.getLogger(ClientesVeterinaria.class.getName()).log(Level.SEVERE, null, ex);
             }
            
        }
    }//GEN-LAST:event_tbl1MouseClicked

   
    
   
    void eliminar(){
        
        int fila = tbl1.getSelectedRow();
        int ids = Integer.parseInt(tbl1.getValueAt(fila, 0).toString());
        if(fila == -1){  
        JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para eliminar sus datos");
        
        }else{
            dao.eliminar(ids);
            
        }
    }
    
   
    
    void limpiarTabla(){
        for(int i = 0; i < modelo.getRowCount(); i++){
            modelo.removeRow(i);
            i = i-1;
        }
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tbl1;
    // End of variables declaration//GEN-END:variables
}
