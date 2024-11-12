/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author agust
 */
public class Consagrado extends Artista{
    public Consagrado(){
        super();
        set$rep((float)0.12);
        set$UVendidas((float)0.5575);
        set$GananciasRecital((float)0.275);
    }
    public Consagrado(String id){
        super(id);
        set$rep((float)0.12);
        set$UVendidas((float)0.5575);
        set$GananciasRecital((float)0.275);
    }
    
    
    @Override
    public String toString(){
        return "Nombre: "+getNombre()+" / Consagrado / Nro. Integrantes: "+getIntegrantes();
    }
    
    @Override
    public String getRango(){
        return "Consagrado";
    }
}
