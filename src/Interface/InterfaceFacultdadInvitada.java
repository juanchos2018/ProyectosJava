/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import Entidad.ClsEntFacultadInvitada;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public interface InterfaceFacultdadInvitada {
    void AgregarFacultadInvitada(ClsEntFacultadInvitada FacultdadInvi);
     
    //void ModificarCliente(String codigo, clsEntidadCliente Cliente);
    void EliminarFacultadInvitada(int IdFacultad);
    public ArrayList ListarFacultadInvitada();
    //public ArrayList BuscarCliente(String IdCliente);
    //public ResultSet ConsultaCliente(String IdCliente) throws Exception;
    
    public ResultSet ConsultarFacultadaInvitada(int IdFacultdad) throws Exception;
}
