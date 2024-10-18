/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author agust
 */
public class Disco {

    String Nombre;
    int UnidadesVendidas;
    TreeMap<String,Cancion> Canciones;
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getUnidadesVendidas() {
        return UnidadesVendidas;
    }

    public void setUnidadesVendidas(int UnidadesVendidas) {
        this.UnidadesVendidas = UnidadesVendidas;
    }

    public ArrayList<Cancion> getCanciones() {
        return (ArrayList)Canciones.values();
    }

    public void setCanciones(TreeMap<String, Cancion> Canciones) {
        this.Canciones = Canciones;
    }
    
    public void addCancion(Cancion obj){
        if(!Canciones.containsKey(obj.getNombre())){ 
            Canciones.put(obj.getNombre(), obj);
        }else{
            System.out.println("("+obj.getNombre()+") ya se encuentra en el disco!");
        }
    }
    
    public void deleteCacnion(String n){
        if(Canciones.containsKey(n)){
            Canciones.remove(n);
        }else{
            System.out.println("Cancion Inexistente! ("+n+")");
        }
    }    
    
    public float TotalReproducciones(){
        ArrayList<Cancion> aux;
        float total = 0;
        aux = getCanciones();
        for(Cancion n:aux){
            total += n.Regalias();
        }
        return total;
    }
    
}
