/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Conexion.clsConexion;
import Entidad.ClsEntModalidad;
import Entidad.ClsEntUbicacion;
import Interface.InterfaceUbicacion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author usuario
 */
public class ClsNegUbicacion implements  InterfaceUbicacion{

    
     private Connection conexion= new clsConexion().getConnection();
    
    @Override
    public void AgregarUbicacion(ClsEntUbicacion Ubicacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
     
    @Override
    public ArrayList ListarUbicacion() {
       
        ArrayList <ClsEntUbicacion> Ubicacion=new ArrayList<ClsEntUbicacion>();
        try {
            CallableStatement cst=conexion.prepareCall("{CALL SP_Ubicacion_S()}");
            ResultSet rs=cst.executeQuery();
            while (rs.next()) {
                ClsEntUbicacion Ubi = new ClsEntUbicacion();
                Ubi.setId_ubi(rs.getInt("id_ubi"));
                Ubi.setLugar_ubi(rs.getString("lugar_ubi"));
                Ubi.setDireccion_ubi(rs.getString("direccion_ubi"));    
                 Ubi.setReferencia_ubi(rs.getString("referencia_ubi"));  
                         
                Ubicacion.add(Ubi);
            }
            return Ubicacion;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet ConsultarUbicacion(int IdUbicacion) throws Exception {
         ResultSet rs =null;
        try{
            CallableStatement cst = conexion.prepareCall("{call USP_B_BuscarUbicacion(?)}");
            cst.setInt("id",IdUbicacion );

            rs = cst.executeQuery();
            return rs;
        }catch(SQLException ex){
            throw ex;
        }
        
        
        
        
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    

}
