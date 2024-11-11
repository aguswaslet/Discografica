/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Alumno
 */
public class ControladorReporte {
    //private static LocalDateTime fecha;
    /*
    public static void agregarReporte(ArrayList<String> report){
        LocalDateTime fecha = new LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
        String fechaact = fecha.format(formato);
            try {
                
                File archivo = new File("Reportes/ReporteErrores"+ fechaact +".txt");
                if(archivo.exists()){
                    archivo.delete();
                archivo.createNewFile();
                System.out.println("Archivo creado");
                }
                FileWriter escribir = new FileWriter(archivo, true);
                for (String elemento : report){
                escribir.write("\n" + elemento + "\n");
                }
                escribir.close();
            } catch (IOException ex) {
                Logger.getLogger(ControladorReporte.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
    }
    public static void agregarReporte(String report){
        LocalDateTime fecha2 = new LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
        String fechaact = fecha2.format(formato);
            try {
                File archivo = new File("Reportes/ReporteErrores"+ fechaact +".txt");
                if(archivo.exists()){
                    archivo.delete();
                archivo.createNewFile();
                System.out.println("Archivo creado");
                }
                FileWriter escribir = new FileWriter(archivo, true);
                
                escribir.write(report + "\n");
                
                escribir.close();
            } catch (IOException ex) {
                Logger.getLogger(ControladorReporte.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
    }
    
    */
    
    
    
}
