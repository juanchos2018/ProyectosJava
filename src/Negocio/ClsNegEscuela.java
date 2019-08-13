/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Conexion.clsConexion;
import Entidad.ClsEntEscuela;
import Interface.InterfaceEscuela;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author usuario
 */
public class ClsNegEscuela  implements InterfaceEscuela {

    
    
     private Connection conexion= new clsConexion().getConnection();
       
    @Override
    public void AgregarEscuela(ClsEntEscuela Escuela) {
       
  
    try {
               CallableStatement cst =conexion.prepareCall("{CALL SP_Escuela_I(?,?,?,?)}");
               cst.setInt("pid_escu", Escuela.getId_escu());
               cst.setInt("pid_facu", Escuela.getId_facu());
               cst.setString("piniciales_escu", Escuela.getIniciales_escu());
               cst.setString("pnombre_escu", Escuela.getNombre_escu());              


               cst.execute();//agregar
           } catch (Exception ex) {
               ex.printStackTrace();
           }
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList ListarEscuela() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     ArrayList <ClsEntEscuela> Escuela=new ArrayList<ClsEntEscuela>();
        try {
            CallableStatement cst=conexion.prepareCall("{CALL SP_Escuela_S()}");
            ResultSet rs=cst.executeQuery();
            while (rs.next()) {
                ClsEntEscuela facu = new ClsEntEscuela();
                
                facu.setId_escu(rs.getInt("id_escu"));
                facu.setIniciales_escu(rs.getString("iniciales_escu"));
                facu.setNombre_escu(rs.getString("nombre_escu"));    
                            
                Escuela.add(facu);
                
                //id_escu,iniciales_escu,nombre_escu
            }
            return Escuela;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    
    
    }

    @Override
    public ResultSet ConsultarEcuela(int IdEscuela) throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    ResultSet rs =null;
        try{
            CallableStatement cst = conexion.prepareCall("{call USP_B_BuscarESCUELA(?)}");
            cst.setInt("id",IdEscuela );

            rs = cst.executeQuery();
            return rs;
        }catch(SQLException ex){
            throw ex;
        }
    
    
    }
    
    
    
    
    public ArrayList ListarPorEscuela(int  id_facu) {
        ArrayList <ClsEntEscuela> Dispositivo=new ArrayList<ClsEntEscuela>();
        try {
            CallableStatement cst=conexion.prepareCall("{CALL USP_B_BuscarPorFacultad(?)}");
            cst.setInt("id",id_facu);
           
            ResultSet rs=cst.executeQuery();
            while (rs.next()) 
            {
                ClsEntEscuela facu = new ClsEntEscuela();
             facu.setId_escu(rs.getInt("id_escu"));
                facu.setIniciales_escu(rs.getString("iniciales_escu"));
                facu.setNombre_escu(rs.getString("nombre_escu"));    
                            
                Dispositivo.add(facu);
            }
            return Dispositivo;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
     public ArrayList ListarEscuela2() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     ArrayList <ClsEntEscuela> Escuela=new ArrayList<ClsEntEscuela>();
        try {
            CallableStatement cst=conexion.prepareCall("{CALL SP_Escuela_Consulta()}");
            ResultSet rs=cst.executeQuery();
            while (rs.next()) {
                ClsEntEscuela facu = new ClsEntEscuela();
                
                facu.setId_escu(rs.getInt("id_escu"));
                facu.setIniciales_escu(rs.getString("iniciales_escu"));
                facu.setCantidad(rs.getInt("cantidad"));   
                            
                Escuela.add(facu);
                
                //id_escu,iniciales_escu,nombre_escu
            }
            return Escuela;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    
    }
    
     //RECIEN PUSE ESTO VOY AVER SI FUNCIONA OK
     
      public ArrayList ListarCantidadEstudiantesEnEscuela(int  id_escu) {
        ArrayList <ClsEntEscuela> Dispositivo=new ArrayList<ClsEntEscuela>();
        try {
            CallableStatement cst=conexion.prepareCall("{CALL SP_Consulta_Cantidad_Estudiantes(?)}");
            cst.setInt("id_escuela",id_escu);
           
            ResultSet rs=cst.executeQuery();
            while (rs.next()) 
            {
                ClsEntEscuela facu = new ClsEntEscuela();
             facu.setCantidad(rs.getInt("cantidad"));                 
                            
                Dispositivo.add(facu);
            }
            return Dispositivo;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}
