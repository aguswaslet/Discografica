/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Modelos;

import java.io.Serializable;
import java.util.TreeMap;

/**
 *
 * @author agust
 */
public class Discografia implements Serializable{

    private String Nombre;
    private static TreeMap<String,Artista> Artistas;

    public Discografia(String Nombre, TreeMap<String,Artista> Artistas) {
        this.Nombre = Nombre;
        this.Artistas = Artistas;
    }
    public Discografia() {
        Nombre = "%%%%%%%%%";
        Artistas = new TreeMap<String,Artista>();
    }
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public TreeMap<String,Artista> getArtistas() {
        return Artistas;
    }
    
    public Artista getArtista(int n){
        if(Artistas.containsKey(n)){
            return Artistas.get(n);
        }else{
            return null;
        }
    }

    public void setArtistas(TreeMap<String,Artista> Artistas) {
        this.Artistas = Artistas;
    }
    
    public static void addArtista(Artista obj){
        if(Artistas.isEmpty()){
            Artistas.put(obj.getId(), obj);
        }else{
            if(!Artistas.containsKey(obj.getId())){
                Artistas.put(obj.getId(), obj);
            }else{
                System.out.println("Id Repetido, No se agrego el Artista!");
            }
        }
    }
    
    public void deleteArtista(String id){
        if(Artistas.isEmpty()){
            System.out.println("Lista de Artistas Vacia!");
        }else{
            if(Artistas.containsKey(id)){
                Artistas.remove(id);
            }else{
                System.out.println("El Artista no pertenese a la Discografica!");
            }
        }
    }
        
    }
    
    
    
    

