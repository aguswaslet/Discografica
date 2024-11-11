/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Cancion;
import Modelos.Sencillo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.TreeMap;
import javax.swing.JOptionPane;

/**
 *
 * @author agust
 */
public class ControladorCancion {
    private  TreeMap<Integer,Cancion> canciones;
    private String ruta = "src/Data/Serialisados/Canciones.ser";
    
    public ControladorCancion(){
        this.canciones = new TreeMap<Integer,Cancion>();
    }
    
    
    public float Liquidar(String ow){
        float total = 0;
        for(Cancion act:cargar().values()){
            if(act.getOwner().equals(ow)){
                total+= act.Regalias();
            }
        }
        return total;
    }
    
    
    public TreeMap<Integer,Cancion> cargar(){
        File archivoSerializado;
        archivoSerializado = new File(ruta);
        TreeMap<Integer,Cancion> arbol = new TreeMap<Integer,Cancion>();
      
        if (archivoSerializado.exists())/*el archivo existe*/ {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoSerializado))) {
                arbol = (TreeMap<Integer,Cancion>) ois.readObject();
                ois.close();
                System.out.println("Canciones deserializado correctamente.");
            } catch (IOException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
        return arbol;
    }
    
    public void guardar() {
        File archivoSerializado;
        archivoSerializado = new File(ruta);
        if (!archivoSerializado.exists())/*el archivo no existe*/ {
            try {
                if (archivoSerializado.createNewFile()) {
                    System.out.println("Archivo Canciones.ser creado correctamente.");
                    try {
                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoSerializado));
                        oos.writeObject(canciones);
                        oos.close();
                        System.out.println("Canciones serializado correctamente.");
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, e.toString());
                    }

                } else {
                    System.out.println("No se pudo crear el archivo Canciones.ser!");
                }
            } catch (IOException e) {
                System.out.println("Error al crear el archivo: " + e.getMessage());
                JOptionPane.showMessageDialog(null, e.toString());
            }
        } else {//el archivo ya existe
            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoSerializado));
                oos.writeObject(canciones);
                oos.close();
                System.out.println("Canciones serializado correctamente.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }

        }
    }
    
    public void nuevaCancion(String owner,String nombre,int duracion,int reproducciones,int disco,boolean sensillo){
        Cancion nuevo;
        
        if(sensillo){
            nuevo = new Sencillo();
        }else{
            nuevo = new Cancion();
        }
        nuevo.setNombre(nombre);
        nuevo.setDuracion(duracion);
        nuevo.setOwner(owner);
        nuevo.setReproducciones(reproducciones);
        nuevo.setDisco(disco);
       this.canciones = cargar();
       
       if(!canciones.containsKey(nuevo.getId())){
           canciones.put(nuevo.getId(), nuevo);
           System.out.println("Nueva Cancion Agregada!");
       }else{
           System.out.println("Cancion Existe!");
       }
       
       guardar();
    }
    
    public void nuevaCancion(int id, String owner,String nombre,int duracion,int reproducciones,int disco,boolean sensillo){
        Cancion nuevo;
        
        if(sensillo){
            nuevo = new Sencillo(id);
        }else{
            nuevo = new Cancion(id);
        }
        nuevo.setNombre(nombre);
        nuevo.setDuracion(duracion);
        nuevo.setOwner(owner);
        nuevo.setReproducciones(reproducciones);
        nuevo.setDisco(disco);
       this.canciones = cargar();
       
       if(!canciones.containsKey(nuevo.getId())){
           canciones.put(nuevo.getId(), nuevo);
           System.out.println("Nueva Cancion Agregada!");
       }else{
           System.out.println("Cancion Existe!");
       }
       
       guardar();
    }
    
    public TreeMap<Integer,Cancion> getCanciones(){
        return cargar();
    }
}
