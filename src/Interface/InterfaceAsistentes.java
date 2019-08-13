/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import Entidad.ClsEntAsistentes;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author usuario
 */
public interface InterfaceAsistentes {
    
     void AgregarAsistentes(ClsEntAsistentes Asistentes);
     
    //void ModificarCliente(String codigo, clsEntidadCliente Cliente);
    //void EliminarCliente(String IdCliente);
    public ArrayList ListarAsistentes();
    //public ArrayList BuscarCliente(String IdCliente);
    //public ResultSet ConsultaCliente(String IdCliente) throws Exception;
    
    public ResultSet ConsultarAsistente(int idAsistente) throws Exception;
}
