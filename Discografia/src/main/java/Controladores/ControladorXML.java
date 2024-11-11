package Controladores;

import Modelos.*;
import Vistas.Reporte;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.TreeMap;

public class ControladorXML {
/*
    static String ruta = "Data/XML/artistaerr.xml";
     
    
    public static String getRuta() {
        return ruta;
    }

    public static void setRuta(String ruta) {
        ControladorXML.ruta = ruta;
    }

    public static TreeMap<String, Artista> leer() {
        ArrayList<String> reporte = new ArrayList<>();

        try {
            File archivo = new File(ruta);

            final DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
            final DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
            final Document doc = docBuilder.parse(archivo);
            Element nodoRaiz = doc.getDocumentElement();

            // Lista para almacenar todos los artistas
           TreeMap<String, Artista> artistas = new TreeMap<>();

            NodeList listaArtistas = nodoRaiz.getChildNodes();
            // Iterar sobre cada artista
            for (int i = 0; i < listaArtistas.getLength(); i++) {
                Node nodoArtista = listaArtistas.item(i);
                if (nodoArtista.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoArtista = (Element) nodoArtista;

                    // Crear un objeto Artista
                    Artista artista;
                    String tipoArtista = elementoArtista.getNodeName();

                    // Crear objeto Artista dependiendo del tipo
                    if (tipoArtista.equals("emergente")) {
                        artista = new Emergente(elementoArtista.getAttribute("id"));
                    } else if (tipoArtista.equals("consagrado")) {
                        artista = new Consagrado(elementoArtista.getAttribute("id"));
                    } else {
                        reporte.add("Un artista no esta especificado como emergente o consagrado"); // Si no es un tipo válido, saltar
                        artista = new Artista();
                    }

                    try {
                        artista.setNombre(getTextValue(elementoArtista, "Nombre"));
                    } catch (NullPointerException ex) {
                        reporte.add("Error: falta el campo 'Nombre' del id " + artista.getId() + "\n" + ex.getMessage());
                    }
                    try {
                        artista.setIntegrantes(Integer.parseInt(getTextValue(elementoArtista, "Integrantes")));
                    } catch (NumberFormatException ex) {
                        reporte.add("Error: se colocaron caracteres en un campo que solo se admiten numeros (Integrantes de " + artista.getNombre() + ")\n" + ex.getMessage());
                    } catch (NullPointerException ex) {
                        reporte.add("Error: falta el campo 'Integrantes' del artista " + artista.getNombre() + "\n" + ex.getMessage());
                    }
                    try {
                        artista.setGeneroMusical(getTextValue(elementoArtista, "GeneroMusical"));
                    } catch (NullPointerException ex) {
                        reporte.add("Error: falta el campo 'GeneroMusical' del artista " + artista.getNombre() + "\n" + ex.getMessage());
                    }
                    // Leer los discos del artista 
                    NodeList listaDiscos = elementoArtista.getElementsByTagName("Disco");
                    TreeMap<Integer, Disco> discos = new TreeMap<>();
                    for (int j = 0; j < listaDiscos.getLength(); j++) {
                        Element elementoDisco = (Element) listaDiscos.item(j);

                        Disco disco = new Disco();
                        disco.setId_disco(Integer.parseInt(elementoDisco.getAttribute("id")));
                        try {
                            disco.setNombre(getTextValue(elementoDisco, "Nombre"));
                        } catch (NullPointerException ex) {
                            reporte.add("Error: falta el campo 'Nombre de Disco' del artista " + artista.getNombre() + "\n" + ex.getMessage());
                        }
                        try {
                            disco.setUnidadesVendidas(Integer.parseInt(getTextValue(elementoDisco, "UnidadesVendidas")));
                        } catch (NumberFormatException ex) {
                            reporte.add("Error: se colocaron caracteres en un campo que solo se admiten numeros (Unidades Vendidas de " + disco.getNombre() + " de " + artista.getNombre() + ")\n" + ex.getMessage());
                        } catch (NullPointerException ex) {
                            reporte.add("Error: falta el campo 'Unidades Vendidas' del disco " + disco.getNombre() + " del artista " + artista.getNombre() + "\n" + ex.getMessage());
                        }
                        // Leer las canciones del disco 
                        NodeList listaCanciones = elementoDisco.getElementsByTagName("Cancion");
                        TreeMap<Integer, Cancion> canciones = new TreeMap<>();
                        for (int k = 0; k < listaCanciones.getLength(); k++) {
                            Element elementoCancion = (Element) listaCanciones.item(k);

                            Cancion cancion = leerCancion(elementoCancion);
                        // Distinguir entre Sencillo y Cancion
                        
                            cancion.setId(Integer.parseInt(elementoCancion.getAttribute("id")));
                            try {
                                cancion.setNombre(getTextValue(elementoCancion, "Nombre"));
                            } catch (NullPointerException ex) {
                                reporte.add("Error: falta el campo 'Nombre de cancion' del disco " + disco.getNombre() + " del artista " + artista.getNombre() + "\n" + ex.getMessage());
                            }
                            try {
                                cancion.setMinutos(Integer.parseInt(getTextValue(elementoCancion, "Minutos")));
                            } catch (NumberFormatException ex) {
                                reporte.add("Error: se colocaron caracteres en un campo que solo se admiten numeros (Minutos en " + cancion.getNombre() + " de disco " + disco.getNombre() + " de artista " + artista.getNombre() + ")\n" + ex.getMessage());
                            } catch (NullPointerException ex) {
                                reporte.add("Error: falta el campo 'Minutos' del disco " + disco.getNombre() + " del artista " + artista.getNombre() + "\n" + ex.getMessage());
                            }
                            try {
                                cancion.setSegundos(Integer.parseInt(getTextValue(elementoCancion, "Segundos")));
                            } catch (NumberFormatException ex) {
                                reporte.add("Error: se colocaron caracteres en un campo que solo se admiten numeros (Segundos en " + cancion.getNombre() + " de disco " + disco.getNombre() + " de artista " + artista.getNombre() + ")\n" + ex.getMessage());
                            } catch (NullPointerException ex) {
                                reporte.add("Error: falta el campo 'Segundos' del disco " + disco.getNombre() + " del artista " + artista.getNombre() + "\n" + ex.getMessage());
                            }
                            try {
                                cancion.setReproducciones(Integer.parseInt(getTextValue(elementoCancion, "Reproducciones")));
                            } catch (NumberFormatException ex) {
                                reporte.add("Error: se colocaron caracteres en un campo que solo se admiten numeros (Reproducciones en " + cancion.getNombre() + " de disco " + disco.getNombre() + " de artista " + artista.getNombre() + ")\n" + ex.getMessage());
                            } catch (NullPointerException ex) {
                                reporte.add("Error: falta el campo 'Reproducciones' del disco " + disco.getNombre() + " del artista " + artista.getNombre() + "\n" + ex.getMessage());
                            }
                            canciones.put(cancion.getId(), cancion); // Agregar canción al TreeMap de canciones
                        }

                        disco.setCanciones(canciones);
                        discos.put(disco.getId_disco(), disco); // Agregar disco al TreeMap de discos
                    }

                    artista.setDiscos(discos);

                    // Leer los recitales del artista 
                    NodeList listaRecitales = elementoArtista.getElementsByTagName("Recital");
                    TreeMap<Integer, Recital> recitales = new TreeMap<>();
                    for (int j = 0; j < listaRecitales.getLength(); j++) {
                        Element elementoRecital = (Element) listaRecitales.item(j);

                        Recital recital = new Recital();
                        recital.setId_recital(Integer.parseInt(elementoRecital.getAttribute("id")));
                        try {
                            recital.setFecha(LocalDate.parse(getTextValue(elementoRecital, "Fecha")));
                        } catch (DateTimeParseException ex) {
                            reporte.add("Error: una fecha no cumple el formato aaaa-mm-dd (Recital de " + artista.getNombre() + ")\n" + ex.getMessage());
                        } catch (NullPointerException ex) {
                            reporte.add("Error: falta el campo 'Fecha' del recital del artista " + artista.getNombre() + "\n" + ex.getMessage());
                        }
                        try {
                            recital.setRecaudacion(Integer.parseInt(getTextValue(elementoRecital, "Recaudacion")));
                        } catch (NumberFormatException ex) {
                            reporte.add("Error: se colocaron caracteres en un campo que solo se admiten numeros (Recaudacion en recital de artista " + artista.getNombre() + ")\n" + ex.getMessage());
                        } catch (NullPointerException ex) {
                            reporte.add("Error: falta el campo 'Recaudacion' del recital con fecha: " + recital.getFecha() + " del artista " + artista.getNombre() + "\n" + ex.getMessage());
                        }
                        try {
                            recital.setCosto(Integer.parseInt(getTextValue(elementoRecital, "Costos")));
                        } catch (NumberFormatException ex) {
                            reporte.add("Error: se colocaron caracteres en un campo que solo se admiten numeros (Costos en recital de artista " + artista.getNombre() + ")\n" + ex.getMessage());
                        } catch (NullPointerException ex) {
                            reporte.add("Error: falta el campo 'Costos' del recital con fecha: " + recital.getFecha() + " del artista " + artista.getNombre() + "\n" + ex.getMessage());
                        }

                        recitales.put(recital.getId_recital(), recital); // Agregar recital al TreeMap de recitales
                    }

                    artista.setRecitales(recitales);

                    // Agregar el artista al TreeMap de artistas
                    artistas.put(artista.getId(), artista);

                }
            }
            

            // Lectura de artistas
            /*for (Artista artista : artistas.values()) {
                System.out.println("Artista: " + artista.getNombre());
                System.out.println("Integrantes: " + artista.getIntegrantes());
                System.out.println("Género Musical: " + artista.getGeneroMusical());

                System.out.println("Discos:");
                for (Disco disco : artista.getDiscos().values()) {
                    System.out.println("  Disco: " + disco.getNombre() + " (" + disco.getUnidadesVendidas() + " unidades vendidas)");

                    System.out.println("  Canciones:");
                    for (Cancion cancion : disco.getCanciones().values()) {
                        System.out.println("    " + cancion.getNombre() + " - " + cancion.getMinutos() + "m " + cancion.getSegundos() + "s");
                    }
                }

                System.out.println("Recitales:");
                for (Recital recital : artista.getRecitales().values()) {
                    System.out.println("  Recital: " + recital.getFecha() + " (Recaudación: " + recital.getRecaudacion() + ", Costos: " + recital.getCosto() + ")");
                }
                
            }
            return artistas;
        } catch (SAXException ex) {
            Reporte ventrep = new Reporte();
                ventrep.cargarReporte("Error en la sintaxis del XML, errores de formato, o problemas durante la lectura del archivo\n" + ex.getMessage());
                ventrep.setVisible(true);
            return new TreeMap<String, Artista>();
        } catch (IOException ex) {
            Reporte ventrep = new Reporte();
                ventrep.cargarReporte("Error: Archivo no encontrado o faltan permisos para acceder al archivo\n" + ex.getMessage());
            ventrep.setVisible(true);
                return new TreeMap<String, Artista>();
        } catch (ParserConfigurationException ex) {
           Reporte ventrep = new Reporte();
                ventrep.cargarReporte("Error: caracteristica de DocumenteBuilderFactory no valida\n" + ex.getMessage());
            ventrep.setVisible(true);
                return new TreeMap<String, Artista>();
        }
        
    }

    // Método para obtener el valor de texto de un nodo
    private static String getTextValue(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        }
        throw new NullPointerException("Falta el campo '" + tagName + "'");
    }

    private static Cancion leerCancion(Element elementoCancion) {
    Cancion cancion;
    if (elementoCancion.getNodeName().equals("Sencillo")) {
        cancion = new Sencillo();
    } else {
        cancion = new Cancion();
    }
    
    // Agregar el manejo de excepciones aquí

    return cancion;
}*/
}

