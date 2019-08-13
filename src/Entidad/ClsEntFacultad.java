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
public class ClsEntFacultad {
    
    private int id_facu;
    private String iniciales_facu;
    private String nombre_facu;
    private int id_uni;
     private int cantidad;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
     
    public int getId_facu() {
        return id_facu;
    }

    public void setId_facu(int id_facu) {
        this.id_facu = id_facu;
    }

    public String getIniciales_facu() {
        return iniciales_facu;
    }

    public void setIniciales_facu(String iniciales_facu) {
        this.iniciales_facu = iniciales_facu;
    }

    public String getNombre_facu() {
        return nombre_facu;
    }

    public void setNombre_facu(String nombre_facu) {
        this.nombre_facu = nombre_facu;
    }

    public int getId_uni() {
        return id_uni;
    }

    public void setId_uni(int id_uni) {
        this.id_uni = id_uni;
    }
   
    
    
    
}
