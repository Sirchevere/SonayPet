
package com.sonaypet.vista;



import com.sonaypet.modelo.dao.MascotaDAO;
import com.sonaypet.modelo.entidades.AgregarMascota;
import com.sonaypet.modelo.entidades.ClienteVeterinaria;
import com.sonaypet.modelo.entidades.Mascota;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Mascotas extends javax.swing.JInternalFrame {
    
    MascotaDAO dao = new MascotaDAO();
    Mascota masc = new Mascota();
    DefaultTableModel modelo = new DefaultTableModel();
    ClienteVeterinaria cv = new ClienteVeterinaria();
    int id;
    int idCliente;
   
    public Mascotas() {
        initComponents();
        /*frmPrincipal fp = new frmPrincipal();
        idCliente = fp.getIdPrincipal();
        txtIdCliente.setText(String.valueOf(idCliente));*/
        
        int prueba = cv.getId();
        System.out.println(id);
        txtIdCliente.setText(String.valueOf(prueba));
        System.out.println(idCliente);
        System.out.println(cv.getId());
        
        listar();
    }
    
    public Mascotas(int id){
    initComponents();
    txtIdCliente.setText(String.valueOf(id));
    listar();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    void listar(){
        List<AgregarMascota> lista = dao.custom(Integer.parseInt(txtIdCliente.getText()));
        modelo = (DefaultTableModel)tbl3.getModel();
        Object[]ob = new Object[10];
        for(int i = 0; i < lista.size(); i++){
            ob[0] = lista.get(i).getId();
            ob[1] = lista.get(i).getCliNombre();
            ob[2] = lista.get(i).getCliApellido();
            ob[3] = lista.get(i).getNombre();
            ob[4] = lista.get(i).getFechaNac();
            ob[5] = lista.get(i).getEspecie();
            ob[6] = lista.get(i).getRaza();
            ob[7] = lista.get(i).getGenero();
            ob[8] = lista.get(i).getColor();
            ob[9] = lista.get(i).getPelaje();
            modelo.addRow(ob);
             
              
        }
        
        tbl3.setModel(modelo);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        txtRaza = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        txtPelaje = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbxSexo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtEspecie = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        FechaNac = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl3 = new javax.swing.JTable();

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

        setTitle("Agregar Mascota");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("ID CLIENTE:");

        jLabel2.setText("RAZA:");

        jLabel3.setText("COLOR:");

        jLabel4.setText("PELAJE:");

        txtIdCliente.setEditable(false);

        txtRaza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRazaActionPerformed(evt);
            }
        });

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

        jLabel5.setText("SEXO:");

        cbxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "MACHO", "HEMBRA" }));
        cbxSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSexoActionPerformed(evt);
            }
        });

        jLabel6.setText("ESPECIE:");

        jLabel7.setText("FECHA DE NACIMIENTO:");

        jLabel8.setText("NOMBRE:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel2))
                                        .addGap(79, 79, 79))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(89, 89, 89)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(85, 85, 85)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(85, 85, 85)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPelaje, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRaza, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(302, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(FechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnActualizar)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(111, 111, 111))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(FechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPelaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbl3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "APELLIDOS", "MASCOTA", "FECHA DE NACIMIENTO", "ESPECIE", "RAZA", "SEXO", "COLOR", "PELAJE"
            }
        ));
        tbl3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl3MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl3);
        if (tbl3.getColumnModel().getColumnCount() > 0) {
            tbl3.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRazaActionPerformed

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

    private void tbl3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl3MouseClicked
         int fila = tbl3.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        
        }else{
             try {
                 id = Integer.parseInt(tbl3.getValueAt(fila, 0).toString());
                 String nombre = tbl3.getValueAt(fila, 3).toString();
                 String fechaNac = tbl3.getValueAt(fila, 4).toString();
                 String especie = tbl3.getValueAt(fila, 5).toString();
                 String raza = tbl3.getValueAt(fila, 6).toString();
                 String genero = tbl3.getValueAt(fila, 7).toString();
                 String color = tbl3.getValueAt(fila, 8).toString();
                 String pelaje = tbl3.getValueAt(fila, 9).toString();
                 txtNombre.setText(nombre);
                 String fecha = fechaNac;
                 Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
                 FechaNac.setDate(date1);
                 txtEspecie.setText(especie);
                 txtRaza.setText(raza);
                 cbxSexo.setSelectedItem(genero);
                 txtColor.setText(color);
                 txtPelaje.setText(pelaje);
             } catch (ParseException ex) {
                 Logger.getLogger(Mascotas.class.getName()).log(Level.SEVERE, null, ex);
             }
            
    
        }
    }//GEN-LAST:event_tbl3MouseClicked

    private void cbxSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxSexoActionPerformed

    
    void agregar(){
        String idCliente = txtIdCliente.getText();
        String nombre = txtNombre.getText();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = FechaNac.getDate();
        String strDate = dateFormat.format(date);
        String fechaNac = strDate;
        String especie = txtEspecie.getText();
        String raza = txtRaza.getText();
        String genero = cbxSexo.getSelectedItem().toString();
        String color = txtColor.getText();
        String pelaje = txtPelaje.getText();
        Object[] ob = new Object[8];
        ob[0] = idCliente;
        ob[1] = nombre;
        ob[2] = fechaNac;
        ob[3] = especie;
        ob[4] = raza;
        ob[5] = genero;
        ob[6] = color;
        ob[7] = pelaje;
        dao.agregar(ob);
        

    }
    
    void actualizar(){
        
        int fila = tbl3.getSelectedRow();
        if(fila == -1){
        JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para actualizar sus datos");
        }else{
        String idCliente = txtIdCliente.getText();
        String nombre = txtNombre.getText();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = FechaNac.getDate();
        String strDate = dateFormat.format(date);
        String fechaNac = strDate;
        String especie = txtEspecie.getText();
        String raza = txtRaza.getText();
        String genero = cbxSexo.getSelectedItem().toString();
        String color = txtColor.getText();
        String pelaje = txtPelaje.getText();
        Object[] obj = new Object[9];
        obj[0] = idCliente;
        obj[1] = nombre;
        obj[2] = fechaNac;
        obj[3] = especie;
        obj[4] = raza;
        obj[5] = genero;
        obj[6] = color;
        obj[7] = pelaje;
        obj[8]=id;
        dao.actualizar(obj);
        }
    }
    
    void eliminar(){
        
        int fila = tbl3.getSelectedRow();
        int ids = Integer.parseInt(tbl3.getValueAt(fila, 0).toString());
        if(fila == -1){  
        JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para eliminar sus datos");
        
        }else{
            dao.eliminar(ids);
            
        }
    }
    
    void nuevo(){
        
        
        txtNombre.setText("");
        txtEspecie.setText("");
        txtRaza.setText("");
        txtColor.setText("");
        txtPelaje.setText("");
        txtNombre.requestFocus();
        
    }
    
    void limpiarTabla(){
        for(int i = 0; i < modelo.getRowCount(); i++){
            modelo.removeRow(i);
            i = i-1;
        }
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser FechaNac;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cbxSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tbl3;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtEspecie;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPelaje;
    private javax.swing.JTextField txtRaza;
    // End of variables declaration//GEN-END:variables
}
