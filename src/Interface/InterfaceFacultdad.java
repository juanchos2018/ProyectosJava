/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.sql.ResultSet;
import java.util.ArrayList;
import Entidad.ClsEntFacultad;

/**
 *
 * @author usuario
 */
public interface InterfaceFacultdad {
    
     void AgregarFacultdad(ClsEntFacultad Facultdad);
     
    //void ModificarCliente(String codigo, clsEntidadCliente Cliente);
    void EliminarFacultdad(int IdFacultdad);
    public ArrayList ListarFacultdad();
    //public ArrayList BuscarCliente(String IdCliente);
    //public ResultSet ConsultaCliente(String IdCliente) throws Exception;
    
    public ResultSet ConsultarFacultdad(int IdFacultdad) throws Exception;
    
}
