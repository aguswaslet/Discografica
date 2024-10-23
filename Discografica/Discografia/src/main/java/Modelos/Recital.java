/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.time.LocalDate;

/**
 *
 * @author agust
 */
public class Recital {
    int id_recital;
    LocalDate Fecha;
    float Recaudacion;
    float Costo;

    public Recital(int id,LocalDate Fecha, float Recaudacion, float Costo) {
        this.id_recital = id;
        this.Fecha = Fecha;
        this.Recaudacion = Recaudacion;
        this.Costo = Costo;
    }
    
    
    
    public Recital(){
        Fecha = LocalDate.now();
        Recaudacion = 0;
        Costo = 0;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate Fecha) {
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
