/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import Entidad.ClsEntInvitados;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author usuario
 */
public interface InterfaceInvitados {
    void AgregarInvitados(ClsEntInvitados Invitados);
     
    //void ModificarCliente(String codigo, clsEntidadCliente Cliente);
    void EliminarInvitado(int IdEstudiante);
    public ArrayList ListarInvitado();
    //public ArrayList BuscarCliente(String IdCliente);
    //public ResultSet ConsultaCliente(String IdCliente) throws Exception;
    
    public ResultSet ConsultarInvitados(int idevento,int Idestudiante) throws Exception;
}
