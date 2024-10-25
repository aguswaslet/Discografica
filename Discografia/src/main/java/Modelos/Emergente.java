/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.util.TreeMap;

/**
 *
 * @author agust
 */
public class Emergente extends Artista{
    public Emergente(){
        super();
        set$rep((float)0.20);
        set$UVendidas((float)23.15);
    }

    public Emergente(String id_artista) {
        super(id_artista);
    }
    
    @Override
    public String toString(){
        return "Nombre: "+getNombre()+" / Emergente / N° Integrantes: "+getIntegrantes();
    }
}
