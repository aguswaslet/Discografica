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
        set$UVendidas((float)0.2315);
        set$GananciasRecital((float)0.2105);
    }
    
    public Emergente(String id){
        super(id);
        set$rep((float)0.20);
        set$UVendidas((float)0.2315);
        set$GananciasRecital((float)0.2105);
    }
    
    @Override
    public String toString(){
        return "Nombre: "+getNombre()+" / Emergente / Nro. Integrantes: "+getIntegrantes();
    }
    
    @Override
    public String getRango(){
        return "Emergente";
    }
}
