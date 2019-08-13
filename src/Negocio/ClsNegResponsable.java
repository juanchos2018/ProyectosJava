/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Conexion.clsConexion;
import Entidad.ClsEntModalidad;
import Entidad.ClsEntResponsable;
import Interface.InterfaceResponsable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author usuario
 */
public class ClsNegResponsable  implements InterfaceResponsable{
 private Connection conexion= new clsConexion().getConnection();
    @Override
    public void AgregarResponable(ClsEntResponsable Responable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList ListarResponsable() {
        ArrayList <ClsEntResponsable> Rsponable=new ArrayList<ClsEntResponsable>();
        try {
            CallableStatement cst=conexion.prepareCall("{CALL SP_Responsable_S()}");
            ResultSet rs=cst.executeQuery();
            while (rs.next()) {
                ClsEntResponsable Respo = new ClsEntResponsable();
                Respo.setId_respo(rs.getInt("id_respo"));
                Respo.setNombre_respo(rs.getString("nombre_respo"));
                Respo.setApellido_respo(rs.getString("apellido_respo"));   
                 Respo.setId_cargo(rs.getInt("id_cargo"));  
                         
                Rsponable.add(Respo);
            }
            return Rsponable;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        
        
        
        
        
        //        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet ConsultarResponsable(int IdResponsable) throws Exception {
          ResultSet rs =null;
        try{
            CallableStatement cst = conexion.prepareCall("{call USP_B_BuscarResposable(?)}");
            cst.setInt("id",IdResponsable );

            rs = cst.executeQuery();
            return rs;
        }catch(SQLException ex){
            throw ex;
        }
        
        
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList ListarResponsable2(int Idcargo) {
         ArrayList <ClsEntResponsable> Responsable=new ArrayList<ClsEntResponsable>();
        try {
            CallableStatement cst=conexion.prepareCall("{CALL SP_Listar_Responsable_Cargo(?)}");
            ResultSet rs=cst.executeQuery();
            while (rs.next()) {
                ClsEntResponsable Respo = new ClsEntResponsable();               
                
                     Respo.setId_respo(rs.getInt("id_respo"));
                Respo.setNombre_respo(rs.getString("nombre_respo"));
                    Respo.setCargo(rs.getString("nombre_cargo"));              
                         
                           
                Responsable.add(Respo);                                           
                          
            }
            return Responsable;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
       
    }

    @Override
    public ResultSet ConsultarResponsable2(int IdCaro) throws Exception {
       

        ResultSet rs =null;
        try{
            CallableStatement cst = conexion.prepareCall("{call USP_B_BuscarCargo(?)}");
            cst.setInt("id",IdCaro );
            rs = cst.executeQuery();
            return rs;
        }catch(SQLException ex){
            throw ex;
        }
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
