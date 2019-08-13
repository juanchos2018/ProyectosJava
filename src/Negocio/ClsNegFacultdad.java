/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Conexion.clsConexion;
import Entidad.ClsEntFacultad;
import Interface.InterfaceFacultdad;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class ClsNegFacultdad  implements InterfaceFacultdad {

    private Connection conexion= new clsConexion().getConnection();
    
    
    @Override
    public void AgregarFacultdad(ClsEntFacultad Facultdad) {
        
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     try {
            CallableStatement cst =conexion.prepareCall("{CALL SP_Facultdad_I(?,?,?,?)}");
            cst.setInt("pid_facu", Facultdad.getId_facu());
            cst.setString("piniciales_facu", Facultdad.getIniciales_facu());
            cst.setString("pnombre_facu", Facultdad.getNombre_facu());
            cst.setInt("pid_uni", Facultdad.getId_uni());
            
            cst.execute();//agregar
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ArrayList ListarFacultdad() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      ArrayList <ClsEntFacultad> Facultdad=new ArrayList<ClsEntFacultad>();
        try {
            CallableStatement cst=conexion.prepareCall("{CALL SP_Facultad_S()}");
            ResultSet rs=cst.executeQuery();
            while (rs.next()) {
                ClsEntFacultad facu = new ClsEntFacultad();
                facu.setId_facu(rs.getInt("id_facu"));
                facu.setIniciales_facu(rs.getString("iniciales_facu"));
                facu.setNombre_facu(rs.getString("nombre_facu"));    
                            
                Facultdad.add(facu);
            }
            return Facultdad;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    
    }
    
    
    
    
     public ArrayList BuscarRepetidos(int codigo) {
        ArrayList <ClsEntFacultad> Facultad=new ArrayList<ClsEntFacultad>();
        try {
            CallableStatement cst=conexion.prepareCall("{CALL USP_B_BuscarFacultdad(?)}");
            cst.setInt("id",codigo);
           
            ResultSet rs=cst.executeQuery();
            while (rs.next()) 
            {
                ClsEntFacultad usu = new ClsEntFacultad();
                usu.setId_facu(rs.getInt("id_facu"));
               usu.setIniciales_facu(rs.getString("iniciales_facu"));

                Facultad.add(usu);
            }
            return Facultad;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
     }

    @Override
    public ResultSet ConsultarFacultdad(int IdFacultdad) throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  ResultSet rs =null;
        try{
            CallableStatement cst = conexion.prepareCall("{call USP_B_BuscarFacultdad(?)}");
            cst.setInt("id",IdFacultdad );

            rs = cst.executeQuery();
            return rs;
        }catch(SQLException ex){
            throw ex;
        }
    
    }

    @Override
    public void EliminarFacultdad(int IdFacultdad) {
       
         try {
            CallableStatement cst =conexion.prepareCall("{call SP_Facultad_D(?)}");
            cst.setInt("id", IdFacultdad);
            cst.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public ArrayList ListarFacultdad2() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      ArrayList <ClsEntFacultad> Facultdad=new ArrayList<ClsEntFacultad>();
        try {
            CallableStatement cst=conexion.prepareCall("{CALL SP_Facultad_Consulta()}");
            ResultSet rs=cst.executeQuery();
            while (rs.next()) {
                ClsEntFacultad facu = new ClsEntFacultad();
               
                facu.setNombre_facu(rs.getString("nombre_facu"));
                facu.setId_facu(rs.getInt("id_facu"));    
                facu.setCantidad(rs.getInt("cantidad"));
                            
                
                Facultdad.add(facu);
            }
            return Facultdad;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
     }
}
