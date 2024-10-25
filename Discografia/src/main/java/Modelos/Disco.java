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
    private int id_disco;
    private String Nombre;
    private int UnidadesVendidas;
    private TreeMap<Integer,Cancion> Canciones;
    
    public Disco(int id_disco, String Nombre, int UnidadesVendidas, TreeMap<Integer,Cancion> Canciones) {
        this.id_disco = id_disco;
        this.Nombre = Nombre;
        this.UnidadesVendidas = UnidadesVendidas;
        this.Canciones = Canciones;
    }

    public Disco() {

        id_disco = GeneradorIDDisco.generarId();

    }

    public int getId_disco() {
        return id_disco;
    }

    public void setId_disco(int id_disco) {
        this.id_disco = id_disco;

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


    public TreeMap<Integer,Cancion> getCanciones() {
        return Canciones;
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

        aux = (ArrayList)getCanciones().values();
        for(Cancion n:aux){
            total += n.Regalias();
        }
        return total;
    }
    
    public void info(){
        ArrayList<Cancion> aux;
        aux = (ArrayList)Canciones.values();
        for(Cancion n: aux){
            System.out.println(n);
        }
    }
    
}
