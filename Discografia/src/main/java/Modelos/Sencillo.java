/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author agust
 */
public class Sencillo extends Cancion{
    public Sencillo(){
        super();
    }

    public Sencillo(int id_cancion) {
        super(id_cancion);
    }
    
    
    
    public String getTipo(){
        return "Sencillo";
    }
    
    @Override
    public float Regalias(){
        return (float)(getReproducciones()*1.5);
    }
    
    @Override
    public String toString(){
        return "(Sencillo) / Nombre: "+getNombre()+" / Reproducciones: "+getReproducciones()+" / Duracion: "+getDuracion();
    }
    
    
}
