/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Conexion.clsConexion;
import Entidad.ClsEntAsistentes;
import Interface.InterfaceAsistentes;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class ClsNegAsistentes implements  InterfaceAsistentes{
 private Connection conexion= new clsConexion().getConnection();
 
    @Override
    public void AgregarAsistentes(ClsEntAsistentes Asistentes) {
     try {
            CallableStatement cst =conexion.prepareCall("{CALL SP_Asistencia_I(?,?,?,?)}");
            cst.setInt("id_eve", Asistentes.getId_eve());
            cst.setInt("codigo_estu", Asistentes.getCodigo_estu());
            cst.setInt("id_escu", Asistentes.getId_escu());
            cst.setString("observacion_asis", Asistentes.getObservacion_asis());
            
//            @id_eve int ,
//	@codigo_estu int ,
//	@id_escu int,
//	@observacion_asis varchar(50)
            
            cst.execute();//agregar
        } catch (Exception ex) {
            ex.printStackTrace();
        }



//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     public void AgregarAsistentes2(ClsEntAsistentes Asistentes) {
     try {
            CallableStatement cst =conexion.prepareCall("{CALL SP_Asistencia3_I(?,?,?,?,?)}");
            cst.setInt("id_eve", Asistentes.getId_eve());
            cst.setInt("codigo_estu", Asistentes.getCodigo_estu());
            cst.setInt("id_escu", Asistentes.getId_escu());
            cst.setString("hora_entrada", Asistentes.getHora_entrada());
             cst.setString("hora_salida", Asistentes.getHora_salida0());
            
            
//            @id_eve int ,
//	@codigo_estu int ,
//	@id_escu int,
//	@observacion_asis varchar(50)
            
            cst.execute();//agregar
        } catch (Exception ex) {
            ex.printStackTrace();
        }



//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public ArrayList ListarAsistentes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet ConsultarAsistente(int idAsistente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList ListarAsistenesPorEvento(int id_eve) {
        ArrayList <ClsEntAsistentes> Asistentes=new ArrayList<ClsEntAsistentes>();
        try {
            CallableStatement cst=conexion.prepareCall("{CALL SP_Listar_Asistentes_DeEvento(?)}");
            cst.setInt("id_eve",id_eve);           
            ResultSet rs=cst.executeQuery();
            while (rs.next()) 
            {
                ClsEntAsistentes Estu = new ClsEntAsistentes();
                 Estu.setCodigo_estu(rs.getInt("codigo_estu"));
                  Estu.setNombre_estu(rs.getString("nombre_estu"));    
                  Estu.setObservacion_asis(rs.getString("observacion_asis"));
                Estu.setNombre_escu(rs.getString("nombre_escu"));
                     
                            
                Asistentes.add(Estu);
            }
            return Asistentes;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public ArrayList ListarAsistenesPorEvento2(int id_eve) {
        ArrayList <ClsEntAsistentes> Asistentes=new ArrayList<ClsEntAsistentes>();
        try {
            CallableStatement cst=conexion.prepareCall("{CALL SP_Listar_Asistentes_DeEvento2(?)}");
            cst.setInt("id_eve",id_eve);           
            ResultSet rs=cst.executeQuery();
            while (rs.next()) 
            {
                ClsEntAsistentes Estu = new ClsEntAsistentes();
                 Estu.setCodigo_estu(rs.getInt("codigo_estu"));
                  Estu.setNombre_estu(rs.getString("nombre_estu"));    
                  Estu.setHora_entrada(rs.getString("hora_entrada"));
                  Estu.setHora_salida0(rs.getString("hora_salida"));
                Estu.setNombre_escu(rs.getString("nombre_escu"));
                     
                            
                Asistentes.add(Estu);
            }
            return Asistentes;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
