/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import Entidad.ClsEntResponsable;
import Entidad.ClsEntUbicacion;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public interface InterfaceResponsable {
     void AgregarResponable(ClsEntResponsable Responable);
     
    //void ModificarCliente(String codigo, clsEntidadCliente Cliente);
    //void EliminarCliente(String IdCliente);
    public ArrayList ListarResponsable();
     public ArrayList ListarResponsable2( int Idresposable);
    //public ArrayList BuscarCliente(String IdCliente);
    //public ResultSet ConsultaCliente(String IdCliente) throws Exception;
    
    public ResultSet ConsultarResponsable(int IdResponsable) throws Exception;
    public ResultSet ConsultarResponsable2(int IdCaro) throws Exception;
}
