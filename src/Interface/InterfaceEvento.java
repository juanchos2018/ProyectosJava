/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entidad.ClsEntEstudiante;
import java.sql.ResultSet;
import java.util.ArrayList;

import Entidad.ClsEntEvento;

/**
 *
 * @author usuario
 */
public interface InterfaceEvento {
     void AgregarEvento(ClsEntEvento Evento);
     
    //void ModificarCliente(String codigo, clsEntidadCliente Cliente);
    //void EliminarCliente(String IdCliente);
    public ArrayList ListarEvento();
    //public ArrayList BuscarCliente(String IdCliente);
    //public ResultSet ConsultaCliente(String IdCliente) throws Exception;
    
    public ResultSet ConsultarEvento(int IdEvento) throws Exception;
}
