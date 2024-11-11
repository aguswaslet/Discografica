/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.io.Serializable;

/**
 *
 * @author agust
 */
public class Cancion implements Serializable{
    private int id_cancion;
    private String Nombre;
    private int Reproducciones;
    private int Minutos;
    private int Segundos;
    private String Owner;
    private int Disco;

  

    public Cancion(int id_cancion) {
        this.id_cancion = id_cancion;
        GeneradorIDCancion.Actualiza(id_cancion);
    }
    
    
    public Cancion() {
        id_cancion = GeneradorIDCancion.generarId();
        Nombre = "";
        Reproducciones = 0;
        Minutos = 0;
        Segundos = 0;
        Owner= "";
        Disco = 0;
    }
    
    public int getDisco(){
        return Disco;
    }
    
    public void setDisco(int disco){
        Disco = disco;
    }
    
    public void setOwner(String o){
        
        this.Owner = o.toUpperCase();
    }
    
    public String getOwner(){
        return this.Owner;
    }
    
    public String getTipo(){
        return "Cancion";
    }

    public int getId() {
        return id_cancion;
    }

    public void setId(int id_cancion) {
        this.id_cancion = id_cancion;
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
        int segundos = getSegundos();
        if(segundos<10){
            return getMinutos()+":0"+segundos+"";
        }else{
            return getMinutos()+":"+segundos+"";
        }
    }
    
    public float Regalias(){
        return (float)getReproducciones();
    }
    
    
    @Override
    public String toString(){
        return "Nombre: "+getNombre()+" / Reproducciones: "+getReproducciones()+" / Duracion: "+getDuracion();
    }
}
