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
    Discografia discografia = new Discografia();
    FormularioArtista FArt = new FormularioArtista();
    
    public ControlaDiscografia(){
        FArt.setActionListener(this);
    }
    
    public void nuevoArtista(){      
        Artista art;
        
        if(FArt.getCheckConsagrado()){art = new Consagrado();}else{art = new Emergente();}
        
        art.setNombre(FArt.getNombre());
        art.setGeneroMusical(FArt.getGeneroMusical());
        art.setIntegrantes(FArt.getCantidadIntgrantes());
        
        discografia.addArtista(art);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        
        switch(comando){
            case "Crear":{
                nuevoArtista();
                break;
            }
        }
        FArt.getNombre();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
