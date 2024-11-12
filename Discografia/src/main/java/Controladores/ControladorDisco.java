/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Modelos.Cancion;
import Modelos.Disco;
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
public class ControladorDisco {
    private  TreeMap<Integer,Disco> discos;
    private String ruta = "src/Data/Serialisados/Discos.ser";
    
    public ControladorDisco(){
        this.discos = new TreeMap<Integer,Disco>();
    }
    
    public float Liquidar(String ow){
           float total = 0;
        for(Disco act:cargar().values()){
            if(act.getOwner().equals(ow)){
                total += act.getUnidadesVendidas();
            }
        }
        return total;
    }
   
    
    public TreeMap<Integer,Disco> cargar(){
        File archivoSerializado;
        archivoSerializado = new File(ruta);
        TreeMap<Integer,Disco> arbol = new TreeMap<Integer,Disco>();
      
        if (archivoSerializado.exists())/*el archivo existe*/ {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoSerializado))) {
                arbol = (TreeMap<Integer,Disco>) ois.readObject();
                ois.close();
                System.out.println("Discos deserializado correctamente.");
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
                    System.out.println("Archivo Discos.ser creado correctamente.");
                    try {
                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoSerializado));
                        oos.writeObject(discos);
                        oos.close();
                        System.out.println("Discos serializado correctamente.");
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, e.toString());
                    }

                } else {
                    System.out.println("No se pudo crear el archivo Discos.ser!");
                }
            } catch (IOException e) {
                System.out.println("Error al crear el archivo: " + e.getMessage());
                JOptionPane.showMessageDialog(null, e.toString());
            }
        } else {//el archivo ya existe
            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoSerializado));
                oos.writeObject(discos);
                oos.close();
                System.out.println("Discos serializado correctamente.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }

        }
    }
    
    public void nuevoDisco(String owner,String nombre,int UVendidas){
        Disco nuevo = new Disco();
        
        nuevo.setNombre(nombre);
        nuevo.setOwner(owner);
        nuevo.setUnidadesVendidas(UVendidas);
       this.discos = cargar();
       
       if(!discos.containsKey(nuevo.getId())){
           discos.put(nuevo.getId(), nuevo);
           System.out.println("Nuevo Disco Agregado!");
       }else{
           System.out.println("Disco Existe!");
       }
       
       guardar();
    }
    
    public void bajaDiscos(String ow){
        this.discos = cargar();
        for(Disco act:discos.values()){
            if(act.getOwner().equals(ow)){
                discos.remove(act.getId());
            }
        }
        guardar();
    }
    
    public String Detalle(String owner){
        String detalle="";
        int uvendidas = 0;
        int i = 0;
        discos = cargar();
        for(Disco act:discos.values()){
            if(act.getOwner().equals(owner)){
                i++;
                uvendidas+= act.getUnidadesVendidas();
                detalle += "\nDisco "+i+" : "+act.getNombre()+"  Vendidos: "+act.getUnidadesVendidas();
            }
        }
        
        if(i>0){
            detalle += "\n\n Promedio de discos vendidos: "+uvendidas/i;
        }
        
        
        return detalle;
    }
    
    public TreeMap<Integer,Disco> getDiscos(){
        return cargar();
    }
    
    public void nuevoDisco(int id,String owner,String nombre,int UVendidas){
        Disco nuevo = new Disco(id);
        
        
        nuevo.setNombre(nombre);
        nuevo.setOwner(owner);
        nuevo.setUnidadesVendidas(UVendidas);
       this.discos = cargar();
       
       if(!discos.containsKey(nuevo.getId())){
           discos.put(nuevo.getId(), nuevo);
           System.out.println("Nuevo Disco Agregado!");
       }else{
           System.out.println("Disco Existe!");
       }
       
       guardar();
    }
}
