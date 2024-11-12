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
public class GeneradorID implements Serializable{
    private static int ultimoId = -1;
    private static final String fileName = "src/Data/Serialisados/GeneradorId.ser";

    // Método para generar un nuevo ID
    public static int generarId() {
        cargarEstado();
        int id = ultimoId++;
        guardarEstado();
        return id;
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
            System.out.println("Estado cargado exitosamente.");
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            System.out.println("El archivo GeneradorId no existe. Creando nuevo archivo.");
            guardarEstado(); // Crear nuevo archivo y guardar estado inicial
        }
    }
}
