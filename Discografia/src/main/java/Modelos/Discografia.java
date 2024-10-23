/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Modelos;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author agust
 */
public class Discografia {

    String Nombre;
    TreeMap<Integer,Artista> Artistas;

    public Discografia(String Nombre, TreeMap<Integer, Artista> Artistas) {
        this.Nombre = Nombre;
        this.Artistas = Artistas;
    }
    public Discografia() {
    }
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public ArrayList<Artista> getArtistas() {
        return (ArrayList)Artistas.values();
    }
    
    public Artista getArtista(int n){
        if(Artistas.containsKey(n)){
            return Artistas.get(n);
        }else{
            return null;
        }
    }

    public void setArtistas(TreeMap<Integer,Artista> Artistas) {
        this.Artistas = Artistas;
    }
    
    public void addArtista(Artista obj){
        if(!Artistas.containsKey(obj.getId())){
            Artistas.put(obj.getId(), obj);
        }else{
            System.out.println("Id Repetido, No se agrego el Artista!");
        }
    }
    
    public void deleteArtista(Artista obj){
        if(Artistas.containsKey(obj.getId())){
            Artistas.remove(obj.getId());
        }else{
            System.out.println("El Artista no pertenese a la Discografica!");
        }
    }
        
    }
    
    
    
    

