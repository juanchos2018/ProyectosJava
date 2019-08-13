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
public class ClsEntEscuela {
    
    private int id_escu;
    private int  id_facu;
    private String iniciales_escu;
    private String nombre_escu;
    private int  cantidad;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    

    public int getId_escu() {
        return id_escu;
    }

    public void setId_escu(int id_escu) {
        this.id_escu = id_escu;
    }

    public int getId_facu() {
        return id_facu;
    }

    public void setId_facu(int id_facu) {
        this.id_facu = id_facu;
    }

    public String getIniciales_escu() {
        return iniciales_escu;
    }

    public void setIniciales_escu(String iniciales_escu) {
        this.iniciales_escu = iniciales_escu;
    }

    public String getNombre_escu() {
        return nombre_escu;
    }

    public void setNombre_escu(String nombre_escu) {
        this.nombre_escu = nombre_escu;
    }
    
    

}
