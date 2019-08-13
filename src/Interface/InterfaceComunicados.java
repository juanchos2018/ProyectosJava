/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import Entidad.ClsEntComunicados;


import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public interface InterfaceComunicados {
    void AgregarComunicado(ClsEntComunicados Comunicado);
    void ModificarComunicado(String codigo, ClsEntComunicados Comunicado);
    void EliminarComunicado(String codigo);
    public ArrayList ListarComunicado();
    public ArrayList BuscarComunicado(String codigo);
    
}
