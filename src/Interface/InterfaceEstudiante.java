/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import Entidad.ClsEntEstudiante;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author usuario
 */
public interface InterfaceEstudiante {
     void AgregarEstudiante(ClsEntEstudiante Estuddiante);
     
    //void ModificarCliente(String codigo, clsEntidadCliente Cliente);
    void EliminarEstudiante(int IdEstudiante);
    public ArrayList ListarEstudiante();
    //public ArrayList BuscarCliente(String IdCliente);
    //public ResultSet ConsultaCliente(String IdCliente) throws Exception;
    
    public ResultSet ConsultarEstudiante(int IdEstudiante) throws Exception;
     public ResultSet ConsultarEstudiante2(int IdEstudiante) throws Exception;
    
}
