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
public class Artista implements Serializable{
    String id_artista;
    String Nombre;
    int Integrantes;
    String GeneroMusical;
    float $rep=0;
    float $UVendidas=0;
    float $GananciasRecital=0;


    public Artista(String id_artista, String Nombre, int Integrantes, String GeneroMusical)
        {
        this.id_artista = id_artista;
        this.Nombre = Nombre.toUpperCase();
        this.Integrantes = Integrantes;
        this.GeneroMusical = GeneroMusical.toUpperCase();
    }
    
    public Artista() {

        id_artista = GeneradorIDArtista.generarId();

        //id_artista = GeneradorID.generarId();
    }
    public Artista(String id) {

        id_artista = id;

        //id_artista = GeneradorID.generarId();
    }

    public String getRango(){
        return "";
    }
    
    public void Artista(String id_artista) {
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
        this.Nombre = Nombre.toUpperCase();
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
        this.GeneroMusical = GeneroMusical.toUpperCase();
    }
    
    /*
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
*/
}
