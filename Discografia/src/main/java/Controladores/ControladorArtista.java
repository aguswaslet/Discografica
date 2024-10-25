/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Artista;
import Modelos.Disco;
import Modelos.Recital;
import java.util.ArrayList;

/**
 *
 * @author agust
 */
public class ControladorArtista {
    Artista artista = new Artista();
    
    ControladorArtista(Artista obj){
        artista = obj;
    }
    
    public float regalias(){
        ArrayList<Disco> Disc_aux;
        ArrayList<Recital> Rec_aux;
        float Total=0,unidades,reproducciones;
        
        Disc_aux = (ArrayList)artista.getDiscos().values();
        
        unidades = 0;
        reproducciones=0;
        for(Disco n:Disc_aux){
            unidades += n.getUnidadesVendidas();
            reproducciones += n.TotalReproducciones();
        }
        
        Total = (unidades*artista.get$UVendidas()) + (reproducciones*artista.get$rep());
        
        Rec_aux = (ArrayList)artista.getRecitales().values();
        reproducciones=0;
        for(Recital n:Rec_aux){
            unidades += n.getNeto();
        }
            
        Total += (float)(unidades*artista.get$GananciasRecital());
        
        return Total;
    }    
    
}
