/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Conexion.clsConexion;
import Entidad.ClsEntUsuarios;
import Interface.InterfaceUsuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author usuario
 */
public class ClsNegUsuario implements InterfaceUsuario {
private Connection conexion= new clsConexion().getConnection();
    @Override
    public void AgregarUsuarii(ClsEntUsuarios Usuario) {
         try {
               CallableStatement cst =conexion.prepareCall("{CALL SP_Usuario_I(?,?,?,?,?,?,?,?,?,?,?,?)}");
               cst.setInt("pcodigo_usu", Usuario.getCodigo_usu());
               cst.setString("pdni_usu", Usuario.getDni_usu());
               cst.setString("pnombre_usu", Usuario.getNombre_usu());   
                cst.setString("papellidos_usu", Usuario.getApellidos_usu());
               cst.setString("psexo_usu", Usuario.getSexo_usu());
               cst.setString("pfechanaci_usu", Usuario.getFechanaci_usu()); 
                 cst.setString("pdireccion_usu", Usuario.getDireccion_usu());
               cst.setString("ptelefono_usu", Usuario.getTelefono_usu());
               cst.setString("pemail_usu", Usuario.getEmail_usu()); 
                 cst.setString("pusuario_usu", Usuario.getUsuario_usu());
               cst.setString("pclave_usu", Usuario.getClave_usu());
               cst.setString("pestado_usu", Usuario.getEstado_usu()); 
       
       
               cst.execute();//agregar
               

 
      
           } catch (Exception ex) {
               ex.printStackTrace();
           }
        
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList ListarUsuario() {
       
             ArrayList <ClsEntUsuarios> Usuario=new ArrayList<ClsEntUsuarios>();
        try {
            CallableStatement cst=conexion.prepareCall("{CALL SP_Usuario_S()}");
            ResultSet rs=cst.executeQuery();
            while (rs.next()) {
                ClsEntUsuarios usu = new ClsEntUsuarios();
                usu.setCodigo_usu(rs.getInt("codigo_usu"));
                usu.setDni_usu(rs.getString("dni_usu"));
                usu.setNombre_usu(rs.getString("nombre_usu"));    
                 usu.setApellidos_usu(rs.getString("apellidos_usu"));
                usu.setSexo_usu(rs.getString("sexo_usu"));  
                 usu.setFechanaci_usu(rs.getString("fechanaci_usu"));
                usu.setDireccion_usu(rs.getString("direccion_usu"));  
                 usu.setTelefono_usu(rs.getString("telefono_usu"));  
                 usu.setEmail_usu(rs.getString("email_usu"));
                usu.setUsuario_usu(rs.getString("usuario_usu"));  
                     usu.setEstado_usu(rs.getString("estado_usu"));
              
               // codigo_usu,dni_usu,nombre_usu,apellidos_usu,sexo_usu,fechanaci_usu,direccion_usu,telefono_usu,email_usu,usuario_usu,estado_usu
                            
                Usuario.add(usu);
            }
            return Usuario;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        

// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet LoginUsuario(String Usuario, String Password) throws Exception {
       ResultSet rs=null;
        try {
            CallableStatement cst=conexion.prepareCall("{CALL SP_Usuario_Login(?,?)}");//examen estudiar ()listar
            cst.setString("pusuario", Usuario);
            cst.setString("pclave", Password);
            rs=cst.executeQuery();
            return rs;
        } catch (SQLException ex) {
            throw ex;
        }
        
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet ConsultarUsuario(int IdUsuario) throws Exception {
          ResultSet rs =null;
        try{
            CallableStatement cst = conexion.prepareCall("{call USP_B_BuscarUsuario(?)}");
            cst.setInt("id",IdUsuario );

            rs = cst.executeQuery();
            return rs;
        }catch(SQLException ex){
            throw ex;
        }


// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
