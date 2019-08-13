/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Conexion.clsConexion;
import Entidad.ClsEntInvitados;
import Interface.InterfaceInvitados;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class ClsNegInvitados implements InterfaceInvitados {

     private Connection conexion= new clsConexion().getConnection();
    @Override
    public void AgregarInvitados(ClsEntInvitados Invitados) {
        
        try {
            CallableStatement cst =conexion.prepareCall("{CALL SP_Invitados_I(?,?,?,?,?,?,?,?,?)}");
            cst.setInt("id_eve", Invitados.getId_eve());
            cst.setString("nombre_escu", Invitados.getNombre_escu());
               cst.setInt("id_escu", Invitados.getId_escu());
            cst.setInt("codigo_estu", Invitados.getId_estu());
            cst.setString("nombre_estu", Invitados.getNombre_estu());
             cst.setString("estado_estu", Invitados.getEstado());
             cst.setString("hora_entrada", Invitados.getHoraE());
             cst.setString("hora_salida", Invitados.getHoraS());
              cst.setInt("id_facu", Invitados.getId_facu());
 
            cst.execute();//agregar
        } catch (Exception ex) {
            ex.printStackTrace();
        }

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void EliminarInvitado(int IdEstudiante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList ListarInvitado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet ConsultarInvitados(int idevento,int Idestudiante) throws Exception {
        
        ResultSet rs =null;
        try{
            CallableStatement cst = conexion.prepareCall("{call USP_B_BuscarEstudiante_EnInvitados(?,?)}");
            cst.setInt("id_eve",idevento );
            cst.setInt("id_estu",Idestudiante );
            rs = cst.executeQuery();
            return rs;
        }catch(SQLException ex){
            throw ex;
        }

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList ListarIvitadosAEvento(int CodigoEvento) {
        ArrayList <ClsEntInvitados> Estudiantes=new ArrayList<ClsEntInvitados>();
        try {
            CallableStatement cst=conexion.prepareCall("{CALL SP_Listar_Invitados_PorEvento3(?)}");
            cst.setInt("id_eve",CodigoEvento);
          
            ResultSet rs=cst.executeQuery();
            while (rs.next()) 
            {
                ClsEntInvitados Eve = new ClsEntInvitados();
             
                
                Eve.setId_estu(rs.getInt("codigo_estu"));
                Eve.setHoraE(rs.getString("hora_entrada"));
                 Eve.setHoraS(rs.getString("hora_salida"));
            
               // Eve.setCodigo_estu(rs.getInt("codigo_estu"));
                
               
                Estudiantes.add(Eve);
            }
            return Estudiantes;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
     public void ModificarAsistente(int codigoeve,int codigo, ClsEntInvitados Asis) {
        try {
            CallableStatement cst =conexion.prepareCall("{CALL SP_Inivitados_U(?,?,?)}");
             cst.setInt("codigo_eve", codigoeve); 
            cst.setInt("codigo_estu", codigo);       
            cst.setString("estado", Asis.getEstado());
            cst.executeUpdate();//modificar
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
     
      public void ModificarAsistenteEntrada(int codigoeve,int codigo, ClsEntInvitados Asis) {
        try {
            CallableStatement cst =conexion.prepareCall("{CALL SP_Inivitados_HoraE_U(?,?,?)}");
             cst.setInt("codigo_eve", codigoeve); 
            cst.setInt("codigo_estu", codigo);       
            cst.setString("horaE", Asis.getHoraE());
            cst.executeUpdate();//modificar
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
      public void ModificarAsistenteSalida(int codigoeve,int codigo, ClsEntInvitados Asis) {
        try {
            CallableStatement cst =conexion.prepareCall("{CALL SP_Inivitados_HoraS_U(?,?,?)}");
             cst.setInt("codigo_eve", codigoeve); 
            cst.setInt("codigo_estu", codigo);       
            cst.setString("horaS", Asis.getHoraS());
            cst.executeUpdate();//modificar
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
     public ArrayList ListarIvitadosAEvento3(int CodigoEvento) {
        ArrayList <ClsEntInvitados> Estudiantes=new ArrayList<ClsEntInvitados>();
        try {
            CallableStatement cst=conexion.prepareCall("{CALL SP_Listar_Invitados_PorEvento3(?)}");
            cst.setInt("id_eve",CodigoEvento);
          
            ResultSet rs=cst.executeQuery();
            while (rs.next()) 
            {
                ClsEntInvitados Eve = new ClsEntInvitados();
             
                Eve.setId_estu(rs.getInt("codigo_estu"));
                Eve.setHoraE(rs.getString("hora_entrada"));
                 Eve.setHoraS(rs.getString("hora_salida"));
              
               // Eve.setCodigo_estu(rs.getInt("codigo_estu"));
                
               
                Estudiantes.add(Eve);
            }
            return Estudiantes;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
     
     public ResultSet ConsultarInvitados2(int idevento,int Idestudiante) throws Exception {
        
        ResultSet rs =null;
        try{
            CallableStatement cst = conexion.prepareCall("{call USP_B_BuscarEstudiante_EnInvitados2(?,?)}");
            cst.setInt("id_eve",idevento );
            cst.setInt("id_estu",Idestudiante );
            rs = cst.executeQuery();
            return rs;
        }catch(SQLException ex){
            throw ex;
        }

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
