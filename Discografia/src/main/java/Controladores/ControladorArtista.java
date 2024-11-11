/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Artista;
import Modelos.Consagrado;
import Modelos.Emergente;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;
import javax.swing.JOptionPane;

/**
 *
 * @author agust
 */
public class ControladorArtista {
    private  TreeMap<String,Artista> artistas;
    private String ruta = "src/Data/Serialisados/Artistas.ser";
    
    public ControladorArtista(){
        this.artistas = new TreeMap<String,Artista>();
    }
    
    public String Liquidar(String id){
        ControladorDisco discoC = new ControladorDisco();
        ControladorCancion cancionC = new ControladorCancion(); 
        ControladorRecital recitalC = new ControladorRecital();
        Artista act = new Artista();
        float total = 1,vendidas=1,reproducciones=1,neto=1;
        
        act = cargar().get(id);
        
        vendidas = discoC.Liquidar(act.getId());
        reproducciones = cancionC.Liquidar(act.getId());
        neto = recitalC.Liquidar(act.getId());
        total += reproducciones*act.get$rep() + vendidas*act.get$UVendidas() + neto*act.get$GananciasRecital();
        String informe = "   LIQUIDACION TOTAL DEL MES\n"
                        +"   ----------------------------"
                +"\n Artista: "+act.getNombre() + "         Categoria: "+act.getRango()
                +"\n\n     $ x Reproducciones -> $"+reproducciones*act.get$rep()
                +"\n     $ x Discos Vendidos -> $"+vendidas*act.get$UVendidas()
                +"\n     $ x Recitales -> $"+neto*act.get$GananciasRecital()
                +"\n\n    Total: $"+total;
        
        return informe;
    }
    
    public TreeMap<String,Artista> cargar(){
        File archivoSerializado;
        archivoSerializado = new File(ruta);
        TreeMap<String,Artista> arbol = new TreeMap<String,Artista>();
     
        if (archivoSerializado.exists())/*el archivo existe*/ {
             
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoSerializado))) {
                arbol = (TreeMap<String,Artista>) ois.readObject();
                ois.close();
                System.out.println("Administrador deserializado correctamente.");
            } catch (IOException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }else{
            System.out.println("No existe Artistas.ser!");
        }System.out.println("hola");
        return arbol;
    }
    
    public void guardar() {
        File archivoSerializado;
        archivoSerializado = new File(ruta);
        if (!archivoSerializado.exists())/*el archivo no existe*/ {
            try {
                if (archivoSerializado.createNewFile()) {
                    System.out.println("Archivo Artista.ser creado correctamente.");
                    try {
                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoSerializado));
                        oos.writeObject(artistas);
                        oos.close();
                        System.out.println("Administrador serializado correctamente.");
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, e.toString());
                    }

                } else {
                    System.out.println("No se pudo crear el archivo Artista.ser!");
                }
            } catch (IOException e) {
                System.out.println("Error al crear el archivo: " + e.getMessage());
                JOptionPane.showMessageDialog(null, e.toString());
            }
        } else {//el archivo ya existe
            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoSerializado));
                oos.writeObject(artistas);
                oos.close();
                System.out.println("Administrador serializado correctamente.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }

        }
    }
    
    public void nuevoArtista(String nombre,int integrantes,String genero,boolean consagrado){
        Artista nuevo;
        
        if(consagrado){
            nuevo = new Consagrado();
        }else{
            nuevo = new Emergente();
        }
        nuevo.setNombre(nombre);
        nuevo.setIntegrantes(integrantes);
        nuevo.setGeneroMusical(genero);
        
       this.artistas = cargar();
       
       if(!artistas.containsKey(nuevo.getId())){
           artistas.put(nuevo.getId(), nuevo);
           System.out.println("Nuevo Artista Agregado!");
       }else{
           System.out.println("Artista Ya Existe!");
       }
       
       guardar();
    }
    
    public TreeMap<String,Artista> getArtistas(){
        return cargar();
    }
    
    /*public float regalias(){
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
    }    */
    
}
