/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entidad.ClsEntCArgo;
import Entidad.ClsEntConvocatoria;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author usuario
 */
public interface InterfaceCargo {
    void AgregarCargo(ClsEntCArgo Cargo);
     
    //void ModificarCliente(String codigo, clsEntidadCliente Cliente);
    //void EliminarCliente(String IdCliente);
    public ArrayList ListarCargo();
    //public ArrayList BuscarCliente(String IdCliente);
    //public ResultSet ConsultaCliente(String IdCliente) throws Exception;
    
    public ResultSet ConsultarCargo(int IdCargo) throws Exception;
}
