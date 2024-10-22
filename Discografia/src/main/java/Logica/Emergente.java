/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author agust
 */
public class Emergente extends Artista{
    public Emergente(){
        super();
        $rep = (float)0.20;
        $UVendidas = (float)23.15;
    }
    
    @Override
    public String toString(){
        return "Nombre: "+getNombre()+" / Emergente / N° Integrantes: "+getIntegrantes();
    }
}
