/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;
import Entidad.ClsEntCArgo;
import Interface.InterfaceCargo;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author usuario
 */
public class ClsNegCargo  implements InterfaceCargo{

    @Override
    public void AgregarCargo(ClsEntCArgo Cargo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList ListarCargo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet ConsultarCargo(int IdCargo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
