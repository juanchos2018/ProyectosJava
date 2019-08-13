/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entidad.ClsEntUsuarios;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public interface InterfaceUsuario {
    void AgregarUsuarii(ClsEntUsuarios Usuario);
     
    //void ModificarCliente(String codigo, clsEntidadCliente Cliente);
    //void EliminarCliente(String IdCliente);
    public ArrayList ListarUsuario();
    //public ArrayList BuscarCliente(String IdCliente);
    //public ResultSet ConsultaCliente(String IdCliente) throws Exception;
     public ResultSet LoginUsuario(String Usuario, String Password) throws Exception;
    public ResultSet ConsultarUsuario(int IdUsuario) throws Exception;
}
