/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Conexion.clsConexion;
import Entidad.ClsEntEvento;
import Interface.InterfaceEvento;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author usuario
 */
public class ClsNegEvento  implements InterfaceEvento{
     private Connection conexion= new clsConexion().getConnection();
     
    @Override
    public void AgregarEvento(ClsEntEvento Evento) {
        
         try {
               CallableStatement cst =conexion.prepareCall("{CALL SP_Evento_I(?,?,?,?,?,?,?,?,?)}");
               cst.setInt("pid_eve", Evento.getId_eve());
               cst.setString("ptitulo_eve", Evento.getTitulo_eve());
               cst.setString("pdescripcion_eve", Evento.getDescripcion_eve());   
                cst.setString("pestado_eve", Evento.getEstado_eve());
               cst.setInt("pid_ubi", Evento.getId_ubi());
               cst.setString("pfecha_eve", Evento.getFecha_eve()); 
                 cst.setString("phorainicio_eve", Evento.getHorainicio_eve());
               cst.setString("phorafin_eve", Evento.getHorafin_eve());
               cst.setInt("pid_respo", Evento.getId_respo()); 
               
        
               cst.execute();//agregar
               

      
           } catch (Exception ex) {
               ex.printStackTrace();
           }
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList ListarEvento() {
   ArrayList <ClsEntEvento> Estudiante=new ArrayList<ClsEntEvento>();
        try {
            CallableStatement cst=conexion.prepareCall("{CALL SP_Evento_S()}");
            ResultSet rs=cst.executeQuery();
            while (rs.next()) {
                ClsEntEvento estu = new ClsEntEvento();               
                
                estu.setId_eve(rs.getInt("id_eve"));
                estu.setTitulo_eve(rs.getString("titulo_eve"));
                estu.setDescripcion_eve(rs.getString("descripcion_eve"));
                 estu.setEstado_eve(rs.getString("estado_eve"));
                    estu.setId_ubi(rs.getInt("id_ubi"));
                estu.setFecha_eve(rs.getString("fecha_eve"));
                estu.setHorainicio_eve(rs.getString("horainicio_eve"));
                estu.setHorafin_eve(rs.getString("horafin_eve"));
             //    estu.setLugar(rs.getString("lugar_ubi"));
                 estu.setId_respo(rs.getInt("id_respo"));
                                           
                Estudiante.add(estu);
                                             
                
                //id_escu,iniciales_escu,nombre_escu
            }
            return Estudiante;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet ConsultarEvento(int IdEvento) throws Exception {
        ResultSet rs =null;
        try{
            CallableStatement cst = conexion.prepareCall("{call USP_B_BuscarEvento(?)}");
            cst.setInt("id",IdEvento );

            rs = cst.executeQuery();
            return rs;
        }catch(SQLException ex){
            throw ex;
        }
        
        
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
