/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Recital;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Date;
import java.util.TreeMap;
import javax.swing.JOptionPane;

/**
 *
 * @author agust
 */
public class ControladorRecital {
    private  TreeMap<Integer,Recital> recitales;
    private String ruta = "src/Data/Serialisados/Recitales.ser";
    
    public ControladorRecital(){
        this.recitales = new TreeMap<Integer,Recital>();
    }
    
    public float Liquidar(String ow){
        float total=0;
        
        for(Recital act:cargar().values()){
            if(act.getOwner().equals(ow)){
                total+= act.getNeto();
            }
        }
        
        return total;
    }
    
    public TreeMap<Integer,Recital> cargar(){
        File archivoSerializado;
        archivoSerializado = new File(ruta);
        TreeMap<Integer,Recital> arbol = new TreeMap<Integer,Recital>();
      
        if (archivoSerializado.exists())/*el archivo existe*/ {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoSerializado))) {
                arbol = (TreeMap<Integer,Recital>) ois.readObject();
                ois.close();
                System.out.println("Recitales deserializado correctamente.");
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
                    System.out.println("Archivo Recitales.ser creado correctamente.");
                    try {
                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoSerializado));
                        oos.writeObject(recitales);
                        oos.close();
                        System.out.println("Recitales serializado correctamente.");
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, e.toString());
                    }

                } else {
                    System.out.println("No se pudo crear el archivo Recitales.ser!");
                }
            } catch (IOException e) {
                System.out.println("Error al crear el archivo: " + e.getMessage());
                JOptionPane.showMessageDialog(null, e.toString());
            }
        } else {//el archivo ya existe
            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoSerializado));
                oos.writeObject(recitales);
                oos.close();
                System.out.println("Recitales serializado correctamente.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }

        }
    }
    
    public void nuevoRecital(float recaudacion,float costo,String owner,Date fecha){
        Recital nuevo = new Recital();
        
        nuevo.setRecaudacion(recaudacion);
        nuevo.setOwner(owner);
        nuevo.setCosto(costo);
        nuevo.setFecha(fecha);
       this.recitales = cargar();
       
       if(!recitales.containsKey(nuevo.getId())){
           recitales.put(nuevo.getId(), nuevo);
           System.out.println("Nuevo Recital Agregado!");
       }else{
           System.out.println("Recital Existe!");
       }
       
       guardar();
    }
    
    public TreeMap<Integer,Recital> getRecitales(){
        return cargar();
    }
}
