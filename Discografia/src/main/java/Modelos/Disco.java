/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author agust
 */
public class Disco implements Serializable{
    private int id_disco;
    private String Owner;
    private String Nombre;
    private int UnidadesVendidas;
    
    public Disco(int id_disco, String Nombre, String owner,int UnidadesVendidas) {
        this.id_disco = id_disco;
        this.Owner = owner.toUpperCase();
        this.Nombre = Nombre;
        this.UnidadesVendidas = UnidadesVendidas;
        
    }

    public Disco() {
        id_disco = GeneradorIDDisco.generarId();
    }

    public int getId() {
        return id_disco;
    }

    public void setId_disco(int id_disco) {
        this.id_disco = id_disco;
    }
    
    public void setOwner(String o){
        this.Owner = o.toUpperCase();
    }
    
    public String getOwner(){
        return this.Owner;
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
    
    public String toString(){
        return Nombre+" / Unidades Vendidas: $"+UnidadesVendidas;
    }
}
