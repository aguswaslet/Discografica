/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author agust
 */
public class Cancion {
    String Nombre;
    int Reproducciones;
    int Minutos;
    int Segundos;

    public Cancion() {
        Nombre = "";
        Reproducciones = 0;
        Minutos = 0;
        Segundos = 0;
    }
    

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getReproducciones() {
        return Reproducciones;
    }

    public void setReproducciones(int Reproducciones) {
        this.Reproducciones = Reproducciones;
    }

    public int getMinutos() {
        return Minutos;
    }

    public void setMinutos(int Minutos) {
        this.Minutos = Minutos;
    }

    public int getSegundos() {
        return Segundos;
    }

    public void setSegundos(int Segundos) {
        this.Segundos = Segundos;
    }
    
    public void setDuracion(int n){
        int min,seg;
        
        seg = n%60;
        min = n/60;
        setMinutos(min);
        setSegundos(seg);
    }
    
    public String getDuracion(){
        return getMinutos()+":"+getSegundos()+"";
    }
    
    public float Regalias(){
        return (float)getReproducciones();
    }
    
    
    @Override
    public String toString(){
        return "Nombre: "+getNombre()+" / Reproducciones: "+getReproducciones()+" / Duracion: "+getDuracion();
    }
}
