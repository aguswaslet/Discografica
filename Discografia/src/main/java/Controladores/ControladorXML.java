package Controladores;


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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;




public class ControladorXML {

    static String ruta = "src/Data/XML/artista.xml";


    public static String getRuta() {
        return ruta;
    }

    public static void setRuta(String ruta) {
        ControladorXML.ruta = ruta;
    }

    public static void leer() {
        ArrayList<String> reporte = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String idArtista = "", nombreArtista = "", nombreDisco="", nombreCancion="", genero="";
        Date fechaReci = new Date();
        int integrantes =0, min=0, seg=0, univend=0, idDisco=0, idCancion=0, reprod = 0, recaudacion = 0, costo = 0, idRecital=0;
        boolean esConsagrado=false, esSencillo= false;
        ControladorArtista controlArt = new ControladorArtista();
        ControladorCancion controlCan = new ControladorCancion();
        ControladorDisco controlDisc = new ControladorDisco();
        ControladorRecital controlRec = new ControladorRecital();
        
        try {
            File archivo = new File(ruta);

            final DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
            final DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
            final Document doc = docBuilder.parse(archivo);
            Element nodoRaiz = doc.getDocumentElement();


            NodeList listaArtistas = nodoRaiz.getChildNodes();
            // Iterar sobre cada artista
            for (int i = 0; i < listaArtistas.getLength(); i++) {
                Node nodoArtista = listaArtistas.item(i);
                if (nodoArtista.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoArtista = (Element) nodoArtista;
                    
                    // Crear un objeto Artista
                    String tipoArtista = elementoArtista.getNodeName();
                    
                    
                    // Crear objeto Artista dependiendo del tipo
                    if (tipoArtista.equals("emergente")) {
                        esConsagrado = false;
                    } else if (tipoArtista.equals("consagrado")) {
                        esConsagrado = true;
                    } else {
                        reporte.add("Un artista no esta especificado como emergente o consagrado"); // Si no es un tipo válido, saltar
                    }
                    try {
                        idArtista = elementoArtista.getAttribute("id");
                    } catch (NullPointerException ex) {
                        reporte.add("Error: falta el campo id \n" + ex.getMessage());
                    }

                    try {
                        nombreArtista = getTextValue(elementoArtista, "Nombre");
                    } catch (NullPointerException ex) {
                        reporte.add("Error: falta el campo 'Nombre' del id " + idArtista + "\n" + ex.getMessage());
                    }
                    try {
                        integrantes = Integer.parseInt(getTextValue(elementoArtista, "Integrantes"));
                    } catch (NumberFormatException ex) {
                        reporte.add("Error: se colocaron caracteres en un campo que solo se admiten numeros (Integrantes de " + nombreArtista + ")\n" + ex.getMessage());
                    } catch (NullPointerException ex) {
                        reporte.add("Error: falta el campo 'Integrantes' del artista " + nombreArtista + "\n" + ex.getMessage());
                    }
                    try {
                        genero = getTextValue(elementoArtista, "GeneroMusical");
                    } catch (NullPointerException ex) {
                        reporte.add("Error: falta el campo 'GeneroMusical' del artista " + nombreArtista + "\n" + ex.getMessage());
                    }
                    
                    if(reporte.isEmpty()){
                        controlArt.nuevoArtista(idArtista, nombreArtista, integrantes, genero, esConsagrado);
                    }
                    // Leer los discos del artista 
                    NodeList listaDiscos = elementoArtista.getElementsByTagName("Disco");
        
                    for (int j = 0; j < listaDiscos.getLength(); j++) {
                        Element elementoDisco = (Element) listaDiscos.item(j);
                        
                        idDisco= Integer.parseInt(elementoDisco.getAttribute("id"));
                   
                        try {
                            nombreDisco = getTextValue(elementoDisco, "Nombre");
                        } catch (NullPointerException ex) {
                            reporte.add("Error: falta el campo 'Nombre de Disco' del artista " + nombreArtista + "\n" + ex.getMessage());
                        }
                        try {
                            univend = Integer.parseInt(getTextValue(elementoDisco, "UnidadesVendidas"));
                        } catch (NumberFormatException ex) {
                            reporte.add("Error: se colocaron caracteres en un campo que solo se admiten numeros (Unidades Vendidas de " + nombreDisco + " de " + nombreArtista + ")\n" + ex.getMessage());
                        } catch (NullPointerException ex) {
                            reporte.add("Error: falta el campo 'Unidades Vendidas' del disco " + nombreDisco + " del artista " + nombreArtista + "\n" + ex.getMessage());
                        }
                        
                        if(reporte.isEmpty()){
                        controlDisc.nuevoDisco(idDisco, idArtista, nombreDisco, univend);
                    }
                        
                        
                        // Leer las canciones del disco 
                        NodeList listaCanciones = elementoDisco.getElementsByTagName("Canciones").item(0).getChildNodes();

                        
                        for (int k = 0; k < listaCanciones.getLength(); k++) {
                            Node nodo = listaCanciones.item(k);
    
    // Verificar si el nodo es un elemento (ignorar nodos de texto)
    if (nodo.getNodeType() == Node.ELEMENT_NODE) {
        Element elementoCancion = (Element) nodo;
        
        // Verificar el nombre del nodo
        esSencillo = elementoCancion.getNodeName().equals("Sencillo");
                           
                           
                        // Distinguir entre Sencillo y Cancion
                            
                           
                            idCancion = Integer.parseInt(elementoCancion.getAttribute("id"));
                            try {
                                nombreCancion = getTextValue(elementoCancion, "Nombre");
                            } catch (NullPointerException ex) {
                                reporte.add("Error: falta el campo 'Nombre de cancion' del disco " + nombreDisco + " del artista " + nombreArtista + "\n" + ex.getMessage());
                            }
                            try {
                                min = Integer.parseInt(getTextValue(elementoCancion, "Minutos"));
                            } catch (NumberFormatException ex) {
                                reporte.add("Error: se colocaron caracteres en un campo que solo se admiten numeros (Minutos en " + nombreCancion + " de disco " + nombreDisco + " de artista " + nombreArtista + ")\n" + ex.getMessage());
                            } catch (NullPointerException ex) {
                                reporte.add("Error: falta el campo 'Minutos' del disco " + nombreDisco + " del artista " + nombreArtista + "\n" + ex.getMessage());
                            }
                            try {
                                seg = Integer.parseInt(getTextValue(elementoCancion, "Segundos"));
                            } catch (NumberFormatException ex) {
                                reporte.add("Error: se colocaron caracteres en un campo que solo se admiten numeros (Segundos en " + nombreCancion + " de disco " + nombreDisco + " de artista " + nombreArtista + ")\n" + ex.getMessage());
                            } catch (NullPointerException ex) {
                                reporte.add("Error: falta el campo 'Segundos' del disco " + nombreDisco + " del artista " + nombreArtista + "\n" + ex.getMessage());
                            }
                            try {
                                reprod = Integer.parseInt(getTextValue(elementoCancion, "Reproducciones"));
                            } catch (NumberFormatException ex) {
                                reporte.add("Error: se colocaron caracteres en un campo que solo se admiten numeros (Reproducciones en " + nombreCancion + " de disco " + nombreDisco + " de artista " + nombreArtista + ")\n" + ex.getMessage());
                            } catch (NullPointerException ex) {
                                reporte.add("Error: falta el campo 'Reproducciones' del disco " + nombreDisco + " del artista " + nombreArtista + "\n" + ex.getMessage());
                            }
                           if(reporte.isEmpty()){
                        controlCan.nuevaCancion(idCancion, idArtista, nombreCancion, min*60+seg, reprod, idDisco, esSencillo);
                            
                    }
                            
                        }

                     
                    }
                    }

                 

                    // Leer los recitales del artista 
                    NodeList listaRecitales = elementoArtista.getElementsByTagName("Recital");
                    
                    for (int j = 0; j < listaRecitales.getLength(); j++) {
                        Element elementoRecital = (Element) listaRecitales.item(j);

                        
                        idRecital = Integer.parseInt(elementoRecital.getAttribute("id"));
                        try {
                            
                            fechaReci = formatter.parse(getTextValue(elementoRecital, "Fecha"));
                        } catch (ParseException ex) {
                            reporte.add("Error: una fecha no cumple el formato aaaa-mm-dd (Recital de " + nombreArtista + ")\n" + ex.getMessage());
                        } catch (NullPointerException ex) {
                            reporte.add("Error: falta el campo 'Fecha' del recital del artista " + nombreArtista + "\n" + ex.getMessage());
                        }
                        try {
                            recaudacion = Integer.parseInt(getTextValue(elementoRecital, "Recaudacion"));
                        } catch (NumberFormatException ex) {
                            reporte.add("Error: se colocaron caracteres en un campo que solo se admiten numeros (Recaudacion en recital de artista " + nombreArtista + ")\n" + ex.getMessage());
                        } catch (NullPointerException ex) {
                            reporte.add("Error: falta el campo 'Recaudacion' del recital con fecha: " + fechaReci + " del artista " + nombreArtista + "\n" + ex.getMessage());
                        }
                        try {
                            costo = Integer.parseInt(getTextValue(elementoRecital, "Costos"));
                        } catch (NumberFormatException ex) {
                            reporte.add("Error: se colocaron caracteres en un campo que solo se admiten numeros (Costos en recital de artista " + nombreArtista + ")\n" + ex.getMessage());
                        } catch (NullPointerException ex) {
                            reporte.add("Error: falta el campo 'Costos' del recital con fecha: " + fechaReci + " del artista " + nombreArtista + "\n" + ex.getMessage());
                        }
                        
                         if(reporte.isEmpty()){
                        controlRec.nuevoRecital(idRecital, recaudacion, costo, idArtista, fechaReci);
                            
                    }
                         // Agregar recital al TreeMap de recitales
                    }

                }
            }

            if (!reporte.isEmpty()) {
                Reporte ventrep = new Reporte();
                ventrep.cargarReporte(reporte);
                ventrep.setVisible(true);
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
*/
  
        } catch (SAXException ex) {

            Reporte ventrep = new Reporte();
                ventrep.cargarReporte("Error en la sintaxis del XML, errores de formato, o problemas durante la lectura del archivo\n" + ex.getMessage());
                ventrep.setVisible(true);
            
        } catch (IOException ex) {
            Reporte ventrep = new Reporte();
                ventrep.cargarReporte("Error: Archivo no encontrado o faltan permisos para acceder al archivo\n" + ex.getMessage());
            ventrep.setVisible(true);
               
        } catch (ParserConfigurationException ex) {
           Reporte ventrep = new Reporte();
                ventrep.cargarReporte("Error: caracteristica de DocumenteBuilderFactory no valida\n" + ex.getMessage());
            ventrep.setVisible(true);
                
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

  

}

