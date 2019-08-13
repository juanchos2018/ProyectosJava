/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Conexion.clsConexion;
import Entidad.ClsEntEstudiante;
import Interface.InterfaceEstudiante;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author usuario
 */
public class ClsNegEstudiante  implements InterfaceEstudiante{

     private Connection conexion= new clsConexion().getConnection();
    
    @Override
    public void AgregarEstudiante(ClsEntEstudiante Estuddiante) {
     
        
    try {
               CallableStatement cst =conexion.prepareCall("{CALL SP_Estudiante_I(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
               cst.setInt("pcodigo_estu", Estuddiante.getCodigo_estu());
               cst.setString("pdni_estu", Estuddiante.getDni_estu());
               cst.setString("pnombre_estu", Estuddiante.getNombre_estu());   
                cst.setString("papellidos_estu", Estuddiante.getApellidos_estu());
               cst.setString("psexo_estu", Estuddiante.getSexo_estu());
               cst.setString("pfechanaci_estu", Estuddiante.getFechanaci_estu()); 
                 cst.setString("pdireccion_estu", Estuddiante.getDireccion_estu());
               cst.setString("ptelefono_estu", Estuddiante.getTelefono_estu());
               cst.setString("pemail_estu", Estuddiante.getEmail_estu()); 
                cst.setInt("pid_facu", Estuddiante.getId_facu());
                cst.setInt("pid_escu", Estuddiante.getId_escu());
                cst.setInt("pid_convo", Estuddiante.getId_convo());
                cst.setInt("pid_mod", Estuddiante.getId_mod());
               cst.execute();//agregar
               

      
           } catch (Exception ex) {
               ex.printStackTrace();
           }
        
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList ListarEstudiante() {
       
         ArrayList <ClsEntEstudiante> Estudiante=new ArrayList<ClsEntEstudiante>();
        try {
            CallableStatement cst=conexion.prepareCall("{CALL SP_Estudiante_S_2()}");
            ResultSet rs=cst.executeQuery();
            while (rs.next()) {
                ClsEntEstudiante estu = new ClsEntEstudiante();               
                
                estu.setCodigo_estu(rs.getInt("codigo_estu"));
                estu.setDni_estu(rs.getString("dni_estu"));
                estu.setNombre_estu(rs.getString("nombre_estu"));
                 estu.setApellidos_estu(rs.getString("apellidos_estu"));
                estu.setSexo_estu(rs.getString("sexo_estu"));
                estu.setDireccion_estu(rs.getString("direccion_estu"));
                estu.setTelefono_estu(rs.getString("telefono_estu"));
                 estu.setEmail_estu(rs.getString("email_estu"));
                 estu.setIniciles_facu(rs.getString("iniciales_facu"));
                 estu.setIniciales_escu(rs.getString("iniciales_escu"));              
                           
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
    public ResultSet ConsultarEstudiante(int IdEstudiante) throws Exception {
       
           ResultSet rs =null;
        try{
            CallableStatement cst = conexion.prepareCall("{call USP_B_BuscarEstudiante(?)}");
            cst.setInt("id",IdEstudiante );

            rs = cst.executeQuery();
            return rs;
        }catch(SQLException ex){
            throw ex;
        }
        
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public ArrayList ListarEstudiate2() 
    {
           ArrayList <ClsEntEstudiante> Estudiante1=new ArrayList<ClsEntEstudiante>();
        try {
            CallableStatement cst=conexion.prepareCall("{CALL SP_Estudiante_S()}");
            ResultSet rs=cst.executeQuery();
            while (rs.next()) {
                ClsEntEstudiante estu = new ClsEntEstudiante();               
                
                estu.setCodigo_estu(rs.getInt("codigo_estu"));
                estu.setDni_estu(rs.getString("dni_estu"));
                estu.setNombre_estu(rs.getString("nombre_estu"));
                 estu.setApellidos_estu(rs.getString("apellidos_estu"));
              //  estu.setSexo_estu(rs.getString("sexo_estu"));
               // estu.setDireccion_estu(rs.getString("direccion_estu"));
                estu.setTelefono_estu(rs.getString("telefono_estu"));
                 estu.setEmail_estu(rs.getString("email_estu"));
                            
                           
                Estudiante1.add(estu);
                                             
                
                //id_escu,iniciales_escu,nombre_escu
            }
            return Estudiante1;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        
        
    }

    @Override
    public void EliminarEstudiante(int IdEstudiante) {
        
           try {
            CallableStatement cst =conexion.prepareCall("{call SP_Estudiante_D(?)}");
            cst.setInt("id", IdEstudiante);
            cst.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     
    }
    public ArrayList ListarEstudiantesPorEscuela(int id_escu) {
        ArrayList <ClsEntEstudiante> Estudiantes=new ArrayList<ClsEntEstudiante>();
        try {
            CallableStatement cst=conexion.prepareCall("{CALL SP_Consulta_EstudiatesPorEscuela(?)}");
            cst.setInt("id_escuela",id_escu);           
            ResultSet rs=cst.executeQuery();
            while (rs.next()) 
            {
                ClsEntEstudiante Estu = new ClsEntEstudiante();
                 //Estu.setId_escu(rs.getInt("id_escu"));
                  Estu.setId_escu(rs.getInt("id_escu"));
                Estu.setCodigo_estu(rs.getInt("codigo_estu"));
                Estu.setNombre_estu(rs.getString("nombre_estu")); 
                 Estu.setId_facu(rs.getInt("id_facu"));
                            
                Estudiantes.add(Estu);
            }
            return Estudiantes;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public ResultSet ConsultarEstudiante2(int IdEstudiante) throws Exception {
        ResultSet rs =null;
        try{
            CallableStatement cst = conexion.prepareCall("{call USP_B_BuscarEstudiante2(?)}");
            cst.setInt("id",IdEstudiante);

            rs = cst.executeQuery();
            return rs;
        }catch(SQLException ex){
            throw ex;
        }


    }
    
     public ArrayList ListarEstudiantesFechas(String fecha_inicio, String fecha_final) {
        ArrayList <ClsEntEstudiante> Estudiantes=new ArrayList<ClsEntEstudiante>();
        try {
            CallableStatement cst=conexion.prepareCall("{CALL SP_Ingresos_Fecha(?,?)}");
            cst.setString("pfecha_inicio",fecha_inicio);
            cst.setString("pfecha_final",fecha_final);
            ResultSet rs=cst.executeQuery();
            while (rs.next()) 
            {
                ClsEntEstudiante Estu = new ClsEntEstudiante();
                Estu.setCodigo_estu(rs.getInt("codigo_estu"));
                Estu.setNombre_estu(rs.getString("nombre_estu"));
               
                Estudiantes.add(Estu);
            }
            return Estudiantes;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
     
     public ArrayList ListarIvitadosAEvento(int CodigoEvento) {
        ArrayList <ClsEntEstudiante> Estudiantes=new ArrayList<ClsEntEstudiante>();
        try {
            CallableStatement cst=conexion.prepareCall("{CALL SP_Listar_Invitados_PorEvento2(?)}");
            cst.setInt("id_eve",CodigoEvento);
          
            ResultSet rs=cst.executeQuery();
            while (rs.next()) 
            {
                ClsEntEstudiante Eve = new ClsEntEstudiante();
               Eve.setCodigo_estu(rs.getInt("codigo_estu"));
                Eve.setNombre_estu(rs.getString("nombre_estu"));
                Eve.setApellidos_estu(rs.getString("apellidos_estu"));
                 Eve.setEmail_estu(rs.getString("email_estu"));
                 Eve.setNombre_escu(rs.getString("nombre_escu"));
               // Eve.setCodigo_estu(rs.getInt("codigo_estu"));
                
               
                Estudiantes.add(Eve);
            }
            return Estudiantes;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
