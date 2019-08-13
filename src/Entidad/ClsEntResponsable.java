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
public class ClsEntResponsable {
    private int id_respo;   
    private String nombre_respo;
    private String apellido_respo;
     private int id_cargo;  
 private String cargo;

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
 
    public int getId_respo() {
        return id_respo;
    }

    public void setId_respo(int id_respo) {
        this.id_respo = id_respo;
    }

    public String getNombre_respo() {
        return nombre_respo;
    }

    public void setNombre_respo(String nombre_respo) {
        this.nombre_respo = nombre_respo;
    }

    public String getApellido_respo() {
        return apellido_respo;
    }

    public void setApellido_respo(String apellido_respo) {
        this.apellido_respo = apellido_respo;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }
    
    

    
}
