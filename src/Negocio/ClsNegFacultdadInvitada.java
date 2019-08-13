/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Conexion.clsConexion;
import Entidad.ClsEntFacultadInvitada;
import Interface.InterfaceFacultdadInvitada;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author usuario
 */
public class ClsNegFacultdadInvitada implements InterfaceFacultdadInvitada {
  private Connection conexion= new clsConexion().getConnection();
  
    @Override
    public void AgregarFacultadInvitada(ClsEntFacultadInvitada FacultdadInvi) {
         try {
               CallableStatement cst =conexion.prepareCall("{CALL SP_FacultadInvitadas_I(?,?,?,?,?)}");
               cst.setInt("pid_eve", FacultdadInvi.getId_eve());
               cst.setInt("pid_facu", FacultdadInvi.getId_facu());
               cst.setString("pnombre_Facu", FacultdadInvi.getNombre_facu());
               cst.setInt("pid_escu", FacultdadInvi.getId_escu());  
                 cst.setString("pnombre_escu", FacultdadInvi.getNombre_escu());               
           

               cst.execute();//agregar
           } catch (Exception ex) {
               ex.printStackTrace();
           }

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void EliminarFacultadInvitada(int IdFacultad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList ListarFacultadInvitada() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet ConsultarFacultadaInvitada(int IdFacultdad) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public ArrayList ListarFacultadInvitadaEvento(int CodigoEvento) {
        ArrayList <ClsEntFacultadInvitada> Estudiantes=new ArrayList<ClsEntFacultadInvitada>();
        try {
            CallableStatement cst=conexion.prepareCall("{CALL SP_Listar_InvitadosDeFAcultad_PorEvento(?)}");
            cst.setInt("id_eve",CodigoEvento);
          
            ResultSet rs=cst.executeQuery();
            while (rs.next()) 
            {
                ClsEntFacultadInvitada Eve = new ClsEntFacultadInvitada();
               Eve.setNombre_facu(rs.getString("nombre_facu"));           
                Eve.setNombre_escu(rs.getString("nomnre_escu"));
                Estudiantes.add(Eve);
            }
            return Estudiantes;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
