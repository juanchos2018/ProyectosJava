/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Conexion.clsConexion;
import Entidad.ClsEntConvocatoria;
import  Interface.InterfaceConvocatoria;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class ClsNegConvocatoria implements InterfaceConvocatoria {

    
    
      private Connection conexion= new clsConexion().getConnection();
    @Override
    public void AgregarConvocatoria(ClsEntConvocatoria Convocatoria) {
        
        
        try {
               CallableStatement cst =conexion.prepareCall("{CALL SP_Convocatoria_I(?,?,?)}");
               cst.setInt("pid_convo", Convocatoria.getId_convo());
               cst.setString("paño_convo", Convocatoria.getAño_convo());
               cst.setString("pobservacion_convo", Convocatoria.getObservacion_convo());                    
               cst.execute();//agregar
               
      
           } catch (Exception ex) {
               ex.printStackTrace();
           }
        
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList ListarConvocatoria() {
      ArrayList <ClsEntConvocatoria> Convocatoria=new ArrayList<ClsEntConvocatoria>();
        try {
            CallableStatement cst=conexion.prepareCall("{CALL SP_Convocatoria_S()}");
            ResultSet rs=cst.executeQuery();
            while (rs.next()) {
                ClsEntConvocatoria convo = new ClsEntConvocatoria();
                
                convo.setId_convo(rs.getInt("id_convo"));
                convo.setAño_convo(rs.getString("año_convo"));
                convo.setObservacion_convo(rs.getString("observacion_convo"));    
                           
                Convocatoria.add(convo);
                
                
                
                
                //id_escu,iniciales_escu,nombre_escu
            }
            return Convocatoria;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet ConsultarConvocatoria(int IdConvocatoria) throws Exception {
     
          ResultSet rs =null;
        try{
            CallableStatement cst = conexion.prepareCall("{call USP_B_BuscarConvocatoria(?)}");
            cst.setInt("id",IdConvocatoria );

            rs = cst.executeQuery();
            return rs;
        }catch(SQLException ex){
            throw ex;
        }
    
    }
    public ArrayList ListarConvocatoria2() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     ArrayList <ClsEntConvocatoria> Escuela=new ArrayList<ClsEntConvocatoria>();
        try {
            CallableStatement cst=conexion.prepareCall("{CALL SP_Comvocatoria_Consulta()}");
            ResultSet rs=cst.executeQuery();
            while (rs.next()) {
                ClsEntConvocatoria facu = new ClsEntConvocatoria();
                
                facu.setId_convo(rs.getInt("id_convo"));
                facu.setAño_convo(rs.getString("año_convo"));
                facu.setCan6tidad(rs.getInt("cantidad"));   
                            
                Escuela.add(facu);
                
                //id_escu,iniciales_escu,nombre_escu
            }
            return Escuela;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    
    }
    
    
}
