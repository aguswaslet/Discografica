/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author agust
 */
public class main {
    public static void main(String[] args) {
        Cancion[] songs = new Cancion[2];
        songs[0] = new Cancion();
        songs[0].setNombre("Nothing else matters");
        songs[0].setDuracion(173);
        songs[0].setReproducciones(300000);
        System.out.println(songs[0]);
        songs[1] = new Sencillo();
        songs[1].setNombre("Llorona");
        songs[1].setDuracion(372);
        songs[1].setReproducciones(42400);
        System.out.println(songs[1]);
        
    }
}
