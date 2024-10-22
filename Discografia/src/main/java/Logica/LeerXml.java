/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Usuario PC
 */
public class LeerXml {
    public static void leer(String m){
        try {
            File archivo = new File(m);
            
            final DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
            final DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
            final Document doc;
                doc = docBuilder.parse(archivo);
                 Element nodoRaiz = doc.getDocumentElement();
            
            Element e = nodoRaiz;
            final NodeList children = e.getChildNodes(); //e es de tipo Element
            for (int i = 0; i < children.getLength(); i++) {
                final Node n = children.item(i);
                if (n.getNodeType() == Node.ELEMENT_NODE) {
                    System.out.print(n.getNodeName() + ": " + (!n.hasChildNodes() ? "" : n.getTextContent()));
                }
            }
        } 
            } catch (SAXException ex) {
                Logger.getLogger(LeerXml.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(LeerXml.class.getName()).log(Level.SEVERE, null, ex);
            }
}
           
           


    
    }
}
}

