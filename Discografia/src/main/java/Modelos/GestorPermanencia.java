/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author agust
 */
public class GestorPermanencia {
    private static final File archivoSerializado = new File("src/Data/Serialisados/Permanencia.ser");
    
    public static void guardar(Discografia adm) {
        if (!archivoSerializado.exists())/*el archivo no existe*/ {
            try {
                if (archivoSerializado.createNewFile()) {
                    System.out.println("Archivo Permanencia.ser creado correctamente.");
                    try {
                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoSerializado));
                        oos.writeObject(adm);
                        oos.close();
                        System.out.println("Administrador serializado correctamente.");
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, e.toString());
                    }

                } else {
                    System.out.println("No se pudo crear el archivo Permanencia.ser!");
                }
            } catch (IOException e) {
                System.out.println("Error al crear el archivo: " + e.getMessage());
                JOptionPane.showMessageDialog(null, e.toString());
            }
        } else {//el archivo ya existe
            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoSerializado));
                oos.writeObject(adm);
                oos.close();
                System.out.println("Administrador serializado correctamente.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }

        }
    }
    
    public static Discografia cargar(){
        Discografia adm =  new Discografia();
        if (archivoSerializado.exists())/*el archivo existe*/ {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoSerializado))) {
                adm = (Discografia) ois.readObject();
                ois.close();
                System.out.println("Administrador deserializado correctamente.");
            } catch (IOException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
        return adm;
    }
}
