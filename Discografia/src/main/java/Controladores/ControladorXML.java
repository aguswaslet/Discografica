
package Controladores;
import Modelos.*;
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
import javax.swing.JOptionPane;
import java.util.TreeMap;

public class ControladorXML {
    static String ruta= "data/artista.xml";

    public static String getRuta() {
        return ruta;
    }

    public static void setRuta(String ruta) {
        ControladorXML.ruta = ruta;
    }
    
    
    
    public static TreeMap<String, Artista> leer() {
        try {
            File archivo = new File(ruta);

            final DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
            final DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
            final Document doc = docBuilder.parse(archivo);
            Element nodoRaiz = doc.getDocumentElement();

            // Lista para almacenar todos los artistas
            TreeMap<String, Artista> artistas = new TreeMap<>();

            NodeList listaArtistas = nodoRaiz.getElementsByTagName("artista");

            // Iterar sobre cada artista
            for (int i = 0; i < listaArtistas.getLength(); i++) {
                Node nodoArtista = listaArtistas.item(i);
                if (nodoArtista.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoArtista = (Element) nodoArtista;

                    // Crear un objeto Artista
                    Artista artista = new Artista(String.valueOf(elementoArtista.getAttribute("id")));
                    //GeneradorID.actualizaID();
                    artista.setNombre(getTextValue(elementoArtista, "Nombre"));
                    artista.setIntegrantes(Integer.parseInt(getTextValue(elementoArtista, "Integrantes")));
                    artista.setGeneroMusical(getTextValue(elementoArtista, "GeneroMusical"));

                    // Leer los discos del artista 
                    NodeList listaDiscos = elementoArtista.getElementsByTagName("Disco");
                    TreeMap<Integer, Disco> discos = new TreeMap<>();
                    for (int j = 0; j < listaDiscos.getLength(); j++) {
                        Element elementoDisco = (Element) listaDiscos.item(j);

                        Disco disco = new Disco();
                        disco.setId_disco(Integer.parseInt(elementoDisco.getAttribute("id")));
                        disco.setNombre(getTextValue(elementoDisco, "Nombre"));
                        disco.setUnidadesVendidas(Integer.parseInt(getTextValue(elementoDisco, "UnidadesVendidas")));

                        // Leer las canciones del disco 
                        NodeList listaCanciones = elementoDisco.getElementsByTagName("Cancion");
                        TreeMap<Integer, Cancion> canciones = new TreeMap<>();
                        for (int k = 0; k < listaCanciones.getLength(); k++) {
                            Element elementoCancion = (Element) listaCanciones.item(k);

                            Cancion cancion = new Cancion();
                            cancion.setId(Integer.parseInt(elementoCancion.getAttribute("id")));
                            cancion.setNombre(getTextValue(elementoCancion, "Nombre"));
                            try {
                                cancion.setMinutos(Integer.parseInt(getTextValue(elementoCancion, "Minutos")));
                            } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Error: se colocaron caracteres en un campo que solo se admiten numeros\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
                            cancion.setSegundos(Integer.parseInt(getTextValue(elementoCancion, "Segundos")));
                            cancion.setReproducciones(Integer.parseInt(getTextValue(elementoCancion, "Reproducciones")));

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
                        recital.setFecha(LocalDate.parse(getTextValue(elementoRecital, "Fecha")));
                        recital.setRecaudacion(Integer.parseInt(getTextValue(elementoRecital, "Recaudacion")));
                        recital.setCosto(Integer.parseInt(getTextValue(elementoRecital, "Costos")));

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
                
            }*/
            return artistas;
        } catch (SAXException ex) { //Archivo que no es XML
            JOptionPane.showMessageDialog(null, "Error en la sintaxis del XML, errores de formato, o problemas durante la lectura del archivo\n" + ex.getMessage(),  "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex){
            JOptionPane.showMessageDialog(null, "Error: Archivo no encontrado o faltan permisos para acceder al archivo\n"+ ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ParserConfigurationException ex){
            JOptionPane.showMessageDialog(null, "Error: caracteristica de DocumenteBuilderFactory no valida\n"+ ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch(DateTimeParseException ex){
            JOptionPane.showMessageDialog(null, "Error: una fecha no cumple el formato aaaa-mm-dd\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Error: se colocaron caracteres en un campo que solo se admiten numeros\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch(NullPointerException ex){
            JOptionPane.showMessageDialog(null, "Error: falta un campo\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    // Método para obtener el valor de texto de un nodo
    private static String getTextValue(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        }
        return null;
    }
}