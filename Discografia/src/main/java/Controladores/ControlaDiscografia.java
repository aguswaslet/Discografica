/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;
import Modelos.*;
import Vistas.FormularioArtista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Usuario PC
 */
public class ControlaDiscografia implements ActionListener{
    Discografia discografia;
    
    
    public ControlaDiscografia(){
        discografia = new Discografia();
    }
    
    public void CargaDiscografia(){
        //discografia.setArtistas(ControladorXML.leer());
    }
    
    public void nuevoArtista(){      
        Artista art;
        FormularioArtista FArt = new FormularioArtista();
        FArt.setActionListener(this);
        
        FArt.setVisible(true);
        
        if(FArt.getConsagrado()){art = new Consagrado();}else{art = new Emergente();}
        
        art.setNombre(FArt.getNombreArtista());
        art.setGeneroMusical(FArt.getGeneroMusical());
        art.setIntegrantes(FArt.getCantidadIntegrantes());
        
        discografia.addArtista(art);
    }
    
   

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        
        switch(comando){
            case "Crear" : {
                nuevoArtista();
                break;
            } 
            default: {
                System.out.println("Evento Desconocido!");
                break;
            }
        }
    }
}
