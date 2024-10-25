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
public class Artista {
    String id_artista;
    String Nombre;
    int Integrantes;
    String GeneroMusical;
    TreeMap<Integer,Disco> Discos;
    TreeMap<Integer,Recital> Recitales;
    float $rep=0;
    float $UVendidas=0;
    float $GananciasRecital=0;


    public Artista(String id_artista, String Nombre, int Integrantes, String GeneroMusical, TreeMap<Integer, Disco> Discos, TreeMap<Integer, Recital> Recitales)
        {
        this.id_artista = id_artista;
        this.Nombre = Nombre;
        this.Integrantes = Integrantes;
        this.GeneroMusical = GeneroMusical;
        this.Discos = Discos;
        this.Recitales = Recitales;
    }
    
    public Artista() {

        id_artista = GeneradorIDArtista.generarId();

        //id_artista = GeneradorID.generarId();
    }

    public Artista(String id_artista) {
        this.id_artista = id_artista;
        GeneradorIDArtista.generarId();
    }

    public float get$rep() {
        return $rep;
    }

    public void set$rep(float $rep) {
        this.$rep = $rep;
    }

    public float get$UVendidas() {
        return $UVendidas;
    }

    public void set$UVendidas(float $UVendidas) {
        this.$UVendidas = $UVendidas;
    }

    public float get$GananciasRecital() {
        return $GananciasRecital;
    }

    public void set$GananciasRecital(float $GananciasRecital) {
        this.$GananciasRecital = $GananciasRecital;
    }

    public String getId() {
        return id_artista;
    }

    public void setId(String id) {
        this.id_artista = id;
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


    public TreeMap<Integer, Disco> getDiscos() {
        return Discos;
    }

    public void setDiscos(TreeMap<Integer, Disco> Discos) {
        this.Discos = Discos;
    }

    public TreeMap<Integer,Recital> getRecitales() {
        return Recitales;
    }

    public void setRecitales(TreeMap<Integer, Recital> Recitales) {
        this.Recitales = Recitales;
    }
    
    public float regalias(){
        ArrayList<Disco> Disc_aux;
        ArrayList<Recital> Rec_aux;
        float Total=0,unidades,reproducciones;
        
        Disc_aux = (ArrayList)getDiscos().values();
        
        unidades = 0;
        reproducciones=0;
        for(Disco n:Disc_aux){
            unidades += n.getUnidadesVendidas();
            reproducciones += n.TotalReproducciones();
        }
        
        Total = (unidades*$UVendidas) + (reproducciones*$rep);
        
        Rec_aux = (ArrayList)getRecitales().values();
        reproducciones=0;

        for(Recital n:Rec_aux){
            unidades += n.getNeto();
        }
            
        Total += (float)(unidades*$GananciasRecital);
        
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
