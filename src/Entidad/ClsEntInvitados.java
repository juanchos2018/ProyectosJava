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
public class ClsEntInvitados {
     private int id_eve;
     private String  nombre_escu;
     private int  id_escu;
    private int  id_estu;
    private String nombre_estu;  
     private int  cantidad;
     private String estado;  
    private String horaE;  
        private String horaS;  
            private int  id_facu;

    public int getId_facu() {
        return id_facu;
    }

    public void setId_facu(int id_facu) {
        this.id_facu = id_facu;
    }
            

    public String getHoraE() {
        return horaE;
    }

    public void setHoraE(String horaE) {
        this.horaE = horaE;
    }

    public String getHoraS() {
        return horaS;
    }

    public void setHoraS(String horaS) {
        this.horaS = horaS;
    }
        
    public int getId_escu() {
        return id_escu;
    }

    public void setId_escu(int id_escu) {
        this.id_escu = id_escu;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_eve() {
        return id_eve;
    }

    public void setId_eve(int id_eve) {
        this.id_eve = id_eve;
    }

    public String getNombre_escu() {
        return nombre_escu;
    }

    public void setNombre_escu(String nombre_escu) {
        this.nombre_escu = nombre_escu;
    }

    public int getId_estu() {
        return id_estu;
    }

    public void setId_estu(int id_estu) {
        this.id_estu = id_estu;
    }

    public String getNombre_estu() {
        return nombre_estu;
    }

    public void setNombre_estu(String nombre_estu) {
        this.nombre_estu = nombre_estu;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
     
}
