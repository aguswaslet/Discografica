/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author agust
 */
public class Artista {
    int id;
    String Nombre;
    int Integrantes;
    String GeneroMusical;
    TreeMap<String,Disco> Discos;
    TreeMap<LocalDate,Recital> Recitales;
    float $rep=0;
    float $UVendidas=0;
    float $GananciasRecital=0;

    public Artista() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getIntegrantes() {
        return Integrantes;
    }

    public void setIntegrantes(int Integrantes) {
        this.Integrantes = Integrantes;
    }

    public String getGeneroMusical() {
        return GeneroMusical;
    }

    public void setGeneroMusical(String GeneroMusical) {
        this.GeneroMusical = GeneroMusical;
    }

    public ArrayList<Disco> getDiscos() {
        return (ArrayList)Discos.values();
    }

    public void setDiscos(TreeMap<String, Disco> Discos) {
        this.Discos = Discos;
    }

    public ArrayList<Recital> getRecitales() {
        return (ArrayList)Recitales.values();
    }

    public void setRecitales(TreeMap<LocalDate, Recital> Recitales) {
        this.Recitales = Recitales;
    }
    
    public float regalias(){
        ArrayList<Disco> Disc_aux;
        ArrayList<Recital> Rec_aux;
        float Total=0,unidades,reproducciones;
        
        Disc_aux = getDiscos();
        
        unidades = 0;
        reproducciones=0;
        for(Disco n:Disc_aux){
            unidades += n.getUnidadesVendidas();
            reproducciones += n.TotalReproducciones();
        }
        
        unidades = 0;
        reproducciones=0;
        for(Disco n:Disc_aux){
            unidades += n.getUnidadesVendidas();
            reproducciones += n.TotalReproducciones();
        }
            
        Total = (unidades*$UVendidas) + (reproducciones*$rep);
        
        return Total;
    }    
    
    public void info(){
        ArrayList<Disco> Disc_aux = (ArrayList)Discos.values();
        ArrayList<Recital> Rec_aux = (ArrayList)Recitales.values();
        
        for(Recital n: Rec_aux){
            System.out.println(n);
        }
        for(Disco n: Disc_aux){
            System.out.println(n);
            n.info();
        }
    }
}
