/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;
import Modelos.*;
import Vistas.BajaArtistaPanel;
import Vistas.AltaArtistaPanel;
import Vistas.MainFrame;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author Usuario PC
 */
public class ControlaDiscografia{
    private Discografia discografia;
    
    
    public ControlaDiscografia(Discografia obj){
        discografia = obj;
    }
    
    public void CargaDiscografia(){
        //discografia.setArtistas(ControladorXML.leer());
    }
    
    public void nuevoArtista(String nombre,int integrantes,String generoMusical,boolean tipo){      
        Artista art;
        if(tipo){art = new Consagrado();}else{art = new Emergente();}
        
        art.setNombre(nombre);
        art.setGeneroMusical(generoMusical);
        art.setIntegrantes(integrantes);
        
        discografia.addArtista(art);
    }
    
    public void bajaArtista(String id){
        discografia.deleteArtista(id);
    }
    
    public TreeMap<String,Artista> getArtistas(){
        return discografia.getArtistas();
    }
}
