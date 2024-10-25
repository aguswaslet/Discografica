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
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author agust
 */
public class GeneradorIDArtista implements Serializable{
    private static String ultimoId = "AAAAAA";
    private static final String fileName = "C:\\Users\\Alumno\\Desktop\\Discografica\\Discografia\\Data\\Serialisados\\GeneradorIDArtista.ser";

    // Método para generar un nuevo ID
    public static String generarId() {
        cargarEstado();
        String id = ultimoId;
        nuevoId();
        guardarEstado();
        return id;
    }
    
    public static void nuevoId(){ // Desde AAAAAA hasta ZZZZZZ
        char[] chars = ultimoId.toCharArray();
        int i;
        
        i = ultimoId.length() - 1;
        
        if(chars[0]!='Z'){// si no se acabaron las convinaciones, entramos a buscar una nueva
            while(i >= 0){
                if (chars[i] < 'Z') {
                    chars[i]++;  
                    i = 0;
                }else{
                    chars[i] = 'A';
                    i--;
                } 
            }
        }
        ultimoId = String.valueOf(chars);// Convertimos el char[] a String y retornamos
    }
    
    public static void Actualiza(String id){
        ultimoId = id;
        guardarEstado();
    }
    
    public static void guardarEstado() {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                oos.writeObject(ultimoId);
                System.out.println("Estado guardado exitosamente.");
            } catch (IOException e) {
               JOptionPane.showMessageDialog(null, e.toString());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    public static void cargarEstado() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            ultimoId = (String) ois.readObject();
            System.out.println("Estado cargado exitosamente.");
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            System.out.println("El archivo de estados no existe. Creando nuevo archivo.");
            guardarEstado(); // Crear nuevo archivo y guardar estado inicial
        }
    }
}
