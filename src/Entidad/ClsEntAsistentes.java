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
public class ClsEntAsistentes {
     private int id_eve;
    private int  codigo_estu;
    private int id_escu;
    private String observacion_asis;
    private int  cantidad;
    
        private String hora_entrada;
            private String hora_salida0;

    public String getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public String getHora_salida0() {
        return hora_salida0;
    }

    public void setHora_salida0(String hora_salida0) {
        this.hora_salida0 = hora_salida0;
    }
            
    
    private String nombre_estu;
    private String nombre_escu;

    public String getNombre_estu() {
        return nombre_estu;
    }

    public void setNombre_estu(String nombre_estu) {
        this.nombre_estu = nombre_estu;
    }

    public String getNombre_escu() {
        return nombre_escu;
    }

    public void setNombre_escu(String nombre_escu) {
        this.nombre_escu = nombre_escu;
    }
    

    public int getId_eve() {
        return id_eve;
    }

    public void setId_eve(int id_eve) {
        this.id_eve = id_eve;
    }

    public int getCodigo_estu() {
        return codigo_estu;
    }

    public void setCodigo_estu(int codigo_estu) {
        this.codigo_estu = codigo_estu;
    }

    public int getId_escu() {
        return id_escu;
    }

    public void setId_escu(int id_escu) {
        this.id_escu = id_escu;
    }

    public String getObservacion_asis() {
        return observacion_asis;
    }

    public void setObservacion_asis(String observacion_asis) {
        this.observacion_asis = observacion_asis;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    

}
