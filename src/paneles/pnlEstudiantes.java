/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import principal.Principal;

import Entidad.ClsEntEstudiante;
import Negocio.ClsNegEstudiante;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author RojeruSan
 */
public class pnlEstudiantes extends javax.swing.JPanel {
    
    public static String VCodigo,VDni,VNombre,VApellidos,VSexo,VDireccion,VTelefono,VEmail,VFacultad,VEscuela;
    
    
 String titulo[]={"codigo","Dni","Nombre","Apellidos","sexo","Direccion","telefono","email","facultad","Escuela"};
   DefaultTableModel dtm=new DefaultTableModel(null,titulo);
    /**
     * Creates new form pnlHome
     */
    public pnlEstudiantes() {
        initComponents();
        Listar();
    }
     static  ResultSet rs=null;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblEstudiante = new javax.swing.JTable();
        btnAgregar = new rscomponentshade.RSButtonShade();
        txtFiltro = new rscomponentshade.RSFormatFieldShade();
        btnActualizar = new rscomponentshade.RSButtonShade();
        btnEliminar = new rscomponentshade.RSButtonShade();
        btnVer = new rscomponentshade.RSButtonShade();

        setBackground(new java.awt.Color(204, 204, 204));

        tblEstudiante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblEstudiante.setForeground(new java.awt.Color(52, 73, 94));
        tblEstudiante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblEstudiante.setGridColor(new java.awt.Color(204, 204, 204));
        tblEstudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEstudianteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEstudiante);

        btnAgregar.setBackground(new java.awt.Color(6, 20, 51));
        btnAgregar.setText("Agregar");
        btnAgregar.setBgHover(new java.awt.Color(10, 36, 95));
        btnAgregar.setBgShade(new java.awt.Color(255, 255, 255));
        btnAgregar.setBgShadeHover(new java.awt.Color(242, 187, 10));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtFiltro.setPlaceholder("Filtrar Estudiante");
        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFiltroKeyTyped(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(6, 20, 51));
        btnActualizar.setText("Actualizar");
        btnActualizar.setBgHover(new java.awt.Color(10, 36, 95));
        btnActualizar.setBgShade(new java.awt.Color(255, 255, 255));
        btnActualizar.setBgShadeHover(new java.awt.Color(242, 187, 10));

        btnEliminar.setBackground(new java.awt.Color(6, 20, 51));
        btnEliminar.setText("Eliminar");
        btnEliminar.setBgHover(new java.awt.Color(10, 36, 95));
        btnEliminar.setBgShade(new java.awt.Color(255, 255, 255));
        btnEliminar.setBgShadeHover(new java.awt.Color(242, 187, 10));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnVer.setBackground(new java.awt.Color(6, 20, 51));
        btnVer.setText("Ver");
        btnVer.setBgHover(new java.awt.Color(10, 36, 95));
        btnVer.setBgShade(new java.awt.Color(255, 255, 255));
        btnVer.setBgShadeHover(new java.awt.Color(242, 187, 10));
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    
    public void  Listar()

    {
        
         
      
        ClsNegEstudiante Estudiante=new ClsNegEstudiante();
        ArrayList<ClsEntEstudiante> Escu=Estudiante.ListarEstudiante();
        Iterator iterator=Escu.iterator();
      
        
        String columna[]=new String[10];
        while (iterator.hasNext()) {
            ClsEntEstudiante Estu=new ClsEntEstudiante();
            Estu=(ClsEntEstudiante) iterator.next();
            columna[0]=String.valueOf(Estu.getCodigo_estu());
            columna[1]=Estu.getDni_estu();
            columna[2]=Estu.getNombre_estu();
             columna[3]=Estu.getApellidos_estu();
            columna[4]=Estu.getSexo_estu();
             columna[5]=Estu.getDireccion_estu();
            columna[6]=Estu.getTelefono_estu();
              columna[7]=Estu.getEmail_estu();
             columna[8]=Estu.getIniciles_facu();
            columna[9]=Estu.getIniciales_escu();         
                
            
               
     
            dtm.addRow(columna);
        }
        tblEstudiante.setModel(dtm);   
        
    }
    
    
    
          int registro;
        String codigo;
     void Selecionartabla()
     {
         DefaultTableModel dtm1=new DefaultTableModel();
         registro=tblEstudiante.getSelectedRow();
         if(registro==-1)
         {
             JOptionPane.showMessageDialog(null,"Se debe selecionar regsitro","Tabla Usuario",0);
          }
         else{
             dtm1=(DefaultTableModel) tblEstudiante.getModel();
           codigo=(String)dtm1.getValueAt(registro,0);
           //JOptionPane.showMessageDialog(null,codigo);
           // txtcodigo.setText((String)dtm.getValueAt(registro,0));
           // txtnombre.setText((String)dtm.getValueAt(registro,2));
//            txtpassword.setText((String)dtm.getValueAt(registro,4));
//            cbonivel.setSelectedItem((String)dtm.getValueAt(registro,5));
//            cboestado.setSelectedItem((String)dtm.getValueAt(registro,6));
       
            
         }
     }
     
     
     void LimpiarTabla(){
        try{
            dtm=(DefaultTableModel) tblEstudiante.getModel();
            int x= dtm.getRowCount()-1;
            for (int i=0; i<=x; i++)
                dtm.removeRow(0);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    private void tblEstudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEstudianteMouseClicked
            Selecionartabla();
    }//GEN-LAST:event_tblEstudianteMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        new CambiaPanel(Principal.pnlPrincipal, new paneles.pnlAgregarEstudiante());
        Principal.lblTitulo.setText("Registro de Nuevo Estudiante");
    }//GEN-LAST:event_btnAgregarActionPerformed
 TableRowSorter trs;
    public String leerBusqueda(){
        String busca=txtFiltro.getText().trim().replace("", "");
        return busca;
    }
    private void txtFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyTyped
        // TODO add your handling code here:
        
         txtFiltro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+leerBusqueda(), 0,1,2,3,4,5,6)); //Filtra datos
            }
        });
        trs=new TableRowSorter(dtm);
        tblEstudiante.setRowSorter(trs);
    }//GEN-LAST:event_txtFiltroKeyTyped

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
          int rpta;
       rpta=JOptionPane.showConfirmDialog(null,"¿Estas seguro de eliminar registro?","Eliminar registro",0);
       if(rpta==0)
       {
           ClsNegEstudiante Facu=new ClsNegEstudiante();
           Facu.EliminarEstudiante(Integer.parseInt(codigo));
           LimpiarTabla();
           Listar();
       }
       
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
         int filaseleccionada;

     try{
     
         filaseleccionada= tblEstudiante.getSelectedRow();
         
         if (filaseleccionada==-1){
         
             JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");

         }else{

             DefaultTableModel modelotabla=(DefaultTableModel) tblEstudiante.getModel();
           
             String codigo=(String)modelotabla.getValueAt(filaseleccionada, 0);
             String dni=(String)modelotabla.getValueAt(filaseleccionada, 1);
             String nombres=(String) modelotabla.getValueAt(filaseleccionada, 2);
             String apellidos=(String)modelotabla.getValueAt(filaseleccionada, 3);
//             String sexo=(String)modelotabla.getValueAt(filaseleccionada, 4);
//             String direccion=(String)modelotabla.getValueAt(filaseleccionada, 5);
//             String telefono=(String)modelotabla.getValueAt(filaseleccionada, 6);
//             String email=(String)modelotabla.getValueAt(filaseleccionada, 7);
             String facultad=(String)modelotabla.getValueAt(filaseleccionada, 8);
             String escuela=(String)modelotabla.getValueAt(filaseleccionada, 9);

          
          
          
          
          //instanciar MDI
                        VCodigo=codigo;
                        VDni=dni;
                        VNombre=nombres;
                        VApellidos=apellidos;
                        VFacultad=facultad;
                        VEscuela=escuela;
//                        FrmVerEstudiante frm=new FrmVerEstudiante();
//                        frm.qr();
//                        frm.setVisible(true);
                        CarnetBecario frm=new CarnetBecario();
                        frm.qr();
                        frm.setVisible(true);
          
          
             
//            


          }

       }catch (HeadlessException ex){

             JOptionPane.showMessageDialog(null, "Error: "+ex+"\nInténtelo nuevamente", " .::Error En la Operacion::." ,JOptionPane.ERROR_MESSAGE);

       } 
    }//GEN-LAST:event_btnVerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rscomponentshade.RSButtonShade btnActualizar;
    private rscomponentshade.RSButtonShade btnAgregar;
    private rscomponentshade.RSButtonShade btnEliminar;
    private rscomponentshade.RSButtonShade btnVer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEstudiante;
    private rscomponentshade.RSFormatFieldShade txtFiltro;
    // End of variables declaration//GEN-END:variables
}
