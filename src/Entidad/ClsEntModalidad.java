/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author usuario
 */
public class ClsEntModalidad {
    
        private int id_mod;   
    private String modalidad_mod;
    private String descripcion_mod;
     private int cantidad;   

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
     

    public int getId_mod() {
        return id_mod;
    }

    public void setId_mod(int id_mod) {
        this.id_mod = id_mod;
    }

    public String getModalidad_mod() {
        return modalidad_mod;
    }

    public void setModalidad_mod(String modalidad_mod) {
        this.modalidad_mod = modalidad_mod;
    }

    public String getDescripcion_mod() {
        return descripcion_mod;
    }

    public void setDescripcion_mod(String descripcion_mod) {
        this.descripcion_mod = descripcion_mod;
    }
    


}
