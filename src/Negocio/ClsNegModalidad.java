/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Conexion.clsConexion;
import Entidad.ClsEntModalidad;
import Interface.InterfaceModalidad;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author usuario
 */
public class ClsNegModalidad implements InterfaceModalidad {

    
      private Connection conexion= new clsConexion().getConnection();
    
    @Override
    public void AgregarModalidad(ClsEntModalidad Modalidad) {
       try {
               CallableStatement cst =conexion.prepareCall("{CALL SP_Modalidad_I(?,?,?)}");
               cst.setInt("pid_mod", Modalidad.getId_mod());
               cst.setString("pmodalidad_mod", Modalidad.getModalidad_mod());
               cst.setString("pdescripcion_mod", Modalidad.getDescripcion_mod());
          

               cst.execute();//agregar
           } catch (Exception ex) {
               ex.printStackTrace();
           }
        
        
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList ListarModalidad() {
   
        ArrayList <ClsEntModalidad> Modalidad=new ArrayList<ClsEntModalidad>();
        try {
            CallableStatement cst=conexion.prepareCall("{CALL SP_Modalidad_S()}");
            ResultSet rs=cst.executeQuery();
            while (rs.next()) {
                ClsEntModalidad Moda = new ClsEntModalidad();
                Moda.setId_mod(rs.getInt("id_mod"));
                Moda.setModalidad_mod(rs.getString("modalidad_mod"));
                Moda.setDescripcion_mod(rs.getString("descripcion_mod"));    
                           
                Modalidad.add(Moda);
            }
            return Modalidad;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet ConsultarModalidad(int IdModalidad) throws Exception {
      
        ResultSet rs =null;
        try{
            CallableStatement cst = conexion.prepareCall("{call USP_B_BuscarModalidad(?)}");
            cst.setInt("id",IdModalidad );

            rs = cst.executeQuery();
            return rs;
        }catch(SQLException ex){
            throw ex;
        }
        
        
      //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public ArrayList ListarModalidadConsulta() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     ArrayList <ClsEntModalidad> Escuela=new ArrayList<ClsEntModalidad>();
        try {
            CallableStatement cst=conexion.prepareCall("{CALL SP_Modalidad_Consulta()}");
            ResultSet rs=cst.executeQuery();
            while (rs.next()) {
                ClsEntModalidad moda = new ClsEntModalidad();
                
                moda.setId_mod(rs.getInt("id_mod"));
                moda.setModalidad_mod(rs.getString("modalidad_mod"));
                moda.setCantidad(rs.getInt("cantidad"));   
                            
                Escuela.add(moda);
                
                //id_escu,iniciales_escu,nombre_escu
            }
            return Escuela;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }   
}
