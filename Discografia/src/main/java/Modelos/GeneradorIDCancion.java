/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author Alumno
 */
public class GeneradorIDCancion implements Serializable{
    private static int ultimoId = 0;
    private static final String fileName = "src/Data/Serialisados/GeneradorIDCancion.ser";

    // Método para generar un nuevo ID
    public static int generarId() {
        cargarEstado();
        int id = ultimoId++;
        guardarEstado();
        return id;
    }
    
    public static void Actualiza(int id){
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
                System.out.println("Estado GeneradosIdCancion guardado exitosamente.");
                oos.close();
            } catch (IOException e) {
               JOptionPane.showMessageDialog(null, e.toString());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    public static void cargarEstado() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            ultimoId = (int) ois.readObject();
            System.out.println("Estado GeneradosIdCancion cargado exitosamente.");
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            //JOptionPane.showMessageDialog(null, e.toString());
            System.out.println("El archivo de GeneradosIdCancion.ser no existe. Creando nuevo archivo.");
            guardarEstado(); // Crear nuevo archivo y guardar estado inicial
        }
    }
}
