/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import Modelos.Artista;
import Modelos.Cancion;
import Modelos.Disco;
import Modelos.Discografia;
import Modelos.GestorPermanencia;
import Modelos.Recital;
import Vistas.MainFrame;

import java.util.TreeMap;

/**
 *
 * @author Usuario PC
 */
public class Main {
    public static void main(String args[]) {
        
        /*Discografia discografia;
        discografia = GestorPermanencia.cargar();
        
        MainFrame mainf = new MainFrame(discografia);
        mainf.setVisible(true);
        System.out.println("hola mundo");
        
        TreeMap<String, Artista> artistas = new TreeMap<>();
        artistas= ControladorXML.leer();
        for (Artista artista : artistas.values()) {
            if(artista instanceof Emergente){
            System.out.println("Emergente: " + artista.getNombre());
        } else if (artista instanceof Consagrado){
            System.out.println("Consagrado: " + artista.getNombre());
        } else {
                System.out.println("Artista: " + artista.getNombre());
                }
                
                System.out.println("Integrantes: " + artista.getIntegrantes());
                System.out.println("Género Musical: " + artista.getGeneroMusical());

                System.out.println("Discos:");
                for (Disco disco : artista.getDiscos().values()) {
                    System.out.println("  Disco: " + disco.getNombre() + " (" + disco.getUnidadesVendidas() + " unidades vendidas)");
                    System.out.println("  Canciones:");
                    for (Cancion cancion : disco.getCanciones().values()) {
                        if(cancion instanceof Sencillo){
                            System.out.println("    Sencillo: " + cancion.getNombre() + " - " + cancion.getMinutos() + "m " + cancion.getSegundos() + "s");
                        } else {
                        System.out.println("    Cancion: " + cancion.getNombre() + " - " + cancion.getMinutos() + "m " + cancion.getSegundos() + "s");
                        }
                    }
                }

                System.out.println("Recitales:");
                for (Recital recital : artista.getRecitales().values()) {
                    System.out.println("  Recital: " + recital.getFecha() + " (Recaudación: " + recital.getRecaudacion() + ", Costos: " + recital.getCosto() + ")");
                }
                
    */
    }
}

