/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author agust
 */
public class Disco {
    int id_disco;
    String Nombre;
    int UnidadesVendidas;
    TreeMap<Integer,Cancion> Canciones;
    
    public Disco(int id_disco, String Nombre, int UnidadesVendidas, TreeMap<Integer,Cancion> Canciones) {
        this.id_disco = id_disco;
        this.Nombre = Nombre;
        this.UnidadesVendidas = UnidadesVendidas;
        this.Canciones = Canciones;
    }
    
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

    public void setCanciones(TreeMap<Integer, Cancion> Canciones) {
        this.Canciones = Canciones;
    }
    
    public void addCancion(Cancion obj){
        if(!Canciones.containsKey(obj.getNombre())){ 
            Canciones.put(obj.getId(), obj);
        }else{
            System.out.println("("+obj.getNombre()+") ya se encuentra en el disco!");
        }
    }
    
    public void deleteCacnion(int id){
        if(Canciones.containsKey(id)){
            Canciones.remove(id);
        }else{
            System.out.println("Cancion Inexistente! ("+id+")");
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
    
    public void info(){
        for(Cancion n: Canciones.values()){
            System.out.println(n);
        }
    }
    
}
