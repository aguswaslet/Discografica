/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author agust
 */
public class Recital implements Serializable{
    private int id_recital;
    private Date Fecha;
    private String Owner;
    private float Recaudacion;
    private float Costo;

 

    public Recital(int id_recital) {
        this.id_recital = id_recital;
        GeneradorIDRecital.Actualiza(id_recital);
    }
    
    
    
    public Recital(){
        id_recital = GeneradorIDRecital.generarId();
        Owner = "";
        Recaudacion = 0;
        Costo = 0;
    }

    public int getId() {
        return id_recital;
    }
    
    public void setOwner(String o){
        this.Owner = o.toUpperCase();
    }
    
    public String getOwner(){
        return this.Owner;
    }

    public void setId_recital(int id_recital) {
        this.id_recital = id_recital;
    }

    
    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public float getRecaudacion() {
        return Recaudacion;
    }

    public void setRecaudacion(float Recaudacion) {
        this.Recaudacion = Recaudacion;
    }

    public float getCosto() {
        return Costo;
    }

    public void setCosto(float Costo) {
        this.Costo = Costo;
    }
    
    public float getNeto(){
        return Recaudacion-Costo;
    }
    
    public String toString(){
        return "Fecha:"+Fecha+" Ganancias: $"+getNeto();
    }
}
