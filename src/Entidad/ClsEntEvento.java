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
public class ClsEntEvento {
     private int id_eve;
    private String  titulo_eve;
    private String descripcion_eve;
     private String estado_eve;
    private int  id_ubi;
    private String fecha_eve;
     private String horainicio_eve;
    private String  horafin_eve; 
     private int id_respo;
      private String  lugar; 
       private String  responsable; 

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public int getId_eve() {
        return id_eve;
    }

    public void setId_eve(int id_eve) {
        this.id_eve = id_eve;
    }

    public String getTitulo_eve() {
        return titulo_eve;
    }

    public void setTitulo_eve(String titulo_eve) {
        this.titulo_eve = titulo_eve;
    }

    public String getDescripcion_eve() {
        return descripcion_eve;
    }

    public void setDescripcion_eve(String descripcion_eve) {
        this.descripcion_eve = descripcion_eve;
    }

    public String getEstado_eve() {
        return estado_eve;
    }

    public void setEstado_eve(String estado_eve) {
        this.estado_eve = estado_eve;
    }

    public int getId_ubi() {
        return id_ubi;
    }

    public void setId_ubi(int id_ubi) {
        this.id_ubi = id_ubi;
    }

    public String getFecha_eve() {
        return fecha_eve;
    }

    public void setFecha_eve(String fecha_eve) {
        this.fecha_eve = fecha_eve;
    }

    public String getHorainicio_eve() {
        return horainicio_eve;
    }

    public void setHorainicio_eve(String horainicio_eve) {
        this.horainicio_eve = horainicio_eve;
    }

    public String getHorafin_eve() {
        return horafin_eve;
    }

    public void setHorafin_eve(String horafin_eve) {
        this.horafin_eve = horafin_eve;
    }

    public int getId_respo() {
        return id_respo;
    }

    public void setId_respo(int id_respo) {
        this.id_respo = id_respo;
    }
    
     
     
     

}
