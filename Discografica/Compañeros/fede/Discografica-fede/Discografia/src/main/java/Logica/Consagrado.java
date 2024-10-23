/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author agust
 */
public class Consagrado extends Artista{
    public Consagrado(){
        super();
        $rep = (float)1.2;
        $UVendidas = (float)55.75;
    }
    
    @Override
    public String toString(){
        return "Nombre: "+getNombre()+" / Consagrado / N° Integrantes: "+getIntegrantes();
    }
}
