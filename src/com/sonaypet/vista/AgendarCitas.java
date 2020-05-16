
package com.sonaypet.vista;


import com.sonaypet.modelo.dao.CitaDAO;
import com.sonaypet.modelo.entidades.AgendarCita;
import com.sonaypet.modelo.entidades.Cita;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class AgendarCitas extends javax.swing.JInternalFrame {
    AgendarCita agendarCita = new AgendarCita();
    CitaDAO dao = new CitaDAO();
    Cita cita = new Cita();
    DefaultTableModel modelo = new DefaultTableModel();
    int id;
    int idCliente;
    
    public AgendarCitas() {
        initComponents();
        listar();
    }
    public AgendarCitas(int id,int idM){
    initComponents();
    idCliente = id;
    listar();
    }
    
    void listar(){
        
        List<AgendarCita> lista = dao.custom(idCliente);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        txtFechaCita = new com.toedter.calendar.JDateChooser();
        txtHoraCita = new com.github.lgooddatepicker.components.TimePicker();
        jPanel2 = new javax.swing.JPanel();
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
        setTitle("Agendar Cita");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Fecha Cita:");

        jLabel2.setText("Hora Cita:");

        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFechaCita, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addComponent(txtHoraCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(btnAgregar))
                    .addComponent(txtFechaCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnActualizar)
                    .addComponent(txtHoraCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNuevo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        agregar();
        limpiarTabla();
        listar();
        nuevo();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizar();
        limpiarTabla();
        listar();
        nuevo();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminar();
        limpiarTabla();
        listar();
        nuevo();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        nuevo();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked
        int fila = tbl1.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        
        }else{
            try{
            id = Integer.parseInt(tbl1.getValueAt(fila, 0).toString());
            String fechaCita = tbl1.getValueAt(fila, 3).toString();
            String horaCita = tbl1.getValueAt(fila, 4).toString();
            String fecha = fechaCita;
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);     
            txtFechaCita.setDate(date1);
            txtHoraCita.setText(horaCita);
            }catch (ParseException ex) {
                 Logger.getLogger(ClientesVeterinaria.class.getName()).log(Level.SEVERE, null, ex);
             }
            
        }
    }//GEN-LAST:event_tbl1MouseClicked

    void agregar(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = txtFechaCita.getDate();
        String strDate = dateFormat.format(date);
        String fechaCita = strDate;
        String horaCita = txtHoraCita.getText();
       
        Object[] ob = new Object[3];
        ob[3] = fechaCita;
        ob[4] = horaCita;
        dao.agregar(ob);
    }
    
    void actualizar(){
        
        int fila = tbl1.getSelectedRow();
        if(fila == -1){
        JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para actualizar sus datos");
        }else{
         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = txtFechaCita.getDate();
        String strDate = dateFormat.format(date);
        String fechaCita = strDate;
        String horaCita = txtHoraCita.getText();

        Object[] obj = new Object[5];
        
        obj[3]=fechaCita;
        obj[4]=horaCita;
        obj[5]=id;
        dao.actualizar(obj);
        }
    }
    
    void eliminar(){
        
        int fila = tbl1.getSelectedRow();
        int ids = Integer.parseInt(tbl1.getValueAt(fila, 0).toString());
        if(fila == -1){  
        JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para eliminar sus datos");
        
        }else{
            dao.eliminar(ids);
            
        }
    }
    
    void nuevo(){
       
        
        
    }
    
    void limpiarTabla(){
        for(int i = 0; i < modelo.getRowCount(); i++){
            modelo.removeRow(i);
            i = i-1;
        }
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tbl1;
    private com.toedter.calendar.JDateChooser txtFechaCita;
    private com.github.lgooddatepicker.components.TimePicker txtHoraCita;
    // End of variables declaration//GEN-END:variables
}
