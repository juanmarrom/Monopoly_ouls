/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iniciadores;

import Contenedores.Casilla;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author User
 */
public class Parsear_tablero {
       /**
     * @param args the command line arguments
     */
    public ArrayList parsear_xml_casillas(String carpeta) {
        // TODO code application logic here
        File miDir = new File (".");
        ArrayList ret = new ArrayList();
        
        try {
            System.out.println ("Directorio actual: " + miDir.getCanonicalPath());
            System.out.println ("Directorio actual: " + miDir.getAbsolutePath());
            System.out.println ("Directorio actual: " + miDir.getPath());
            System.out.println ("Fichero: " + miDir.getCanonicalPath() + "\\src\\java\\Datos\\casillas.xml"); 
        }
        catch(Exception e) {
            e.printStackTrace();
        }
                    
        try {	
            //File inputFile = new File(miDir.getCanonicalPath() + "\\src\\java\\Datos\\casillas.xml");
            File inputFile = new File(carpeta + "\\casillas.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" 
               + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("casilla");
            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
               Node nNode = nList.item(temp);
               System.out.println("\nCurrent Element :" + nNode.getNodeName());
               if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                  Element eElement = (Element) nNode;
                  
                  System.out.println("id : " + eElement.getElementsByTagName("id").item(0).getTextContent());
                  System.out.println("nombre : " + eElement.getElementsByTagName("nombre").item(0).getTextContent());
                  System.out.println("es_comprable : " + eElement.getElementsByTagName("es_comprable").item(0).getTextContent());
                  System.out.println("precio : " + eElement.getElementsByTagName("precio").item(0).getTextContent());
                  System.out.println("color : " + eElement.getElementsByTagName("color").item(0).getTextContent());
                  System.out.println("grupo : " + eElement.getElementsByTagName("grupo").item(0).getTextContent());
                  System.out.println("total_grupo : " + eElement.getElementsByTagName("total_grupo").item(0).getTextContent());
                  System.out.println("tipo : " + eElement.getElementsByTagName("tipo").item(0).getTextContent());
                  System.out.println("alquiler : " + eElement.getElementsByTagName("alquiler").item(0).getTextContent());
                  System.out.println("alquiler_1 : " + eElement.getElementsByTagName("alquiler_1").item(0).getTextContent());
                  System.out.println("alquiler_2 : " + eElement.getElementsByTagName("alquiler_2").item(0).getTextContent());
                  System.out.println("alquiler_3 : " + eElement.getElementsByTagName("alquiler_3").item(0).getTextContent());
                  System.out.println("alquiler_4 : " + eElement.getElementsByTagName("alquiler_4").item(0).getTextContent());
                  System.out.println("alquiler_hotel : " + eElement.getElementsByTagName("alquiler_hotel").item(0).getTextContent());        
                  System.out.println("hipoteca : " + eElement.getElementsByTagName("hipoteca").item(0).getTextContent());
                  System.out.println("precio_casa : " + eElement.getElementsByTagName("precio_casa").item(0).getTextContent());
                  System.out.println("precio_hotel : " + eElement.getElementsByTagName("precio_hotel").item(0).getTextContent());
                  
                  int id = Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent());
                  String nombre = eElement.getElementsByTagName("nombre").item(0).getTextContent();
                  int es_comprable = Integer.parseInt(eElement.getElementsByTagName("es_comprable").item(0).getTextContent());
                  int precio = Integer.parseInt(eElement.getElementsByTagName("precio").item(0).getTextContent());
                  String color = eElement.getElementsByTagName("color").item(0).getTextContent();
                  int grupo = Integer.parseInt(eElement.getElementsByTagName("grupo").item(0).getTextContent());
                  int total_grupo = Integer.parseInt(eElement.getElementsByTagName("total_grupo").item(0).getTextContent());
                  int tipo = Integer.parseInt(eElement.getElementsByTagName("tipo").item(0).getTextContent());
                  int alquiler = Integer.parseInt(eElement.getElementsByTagName("alquiler").item(0).getTextContent());
                  int alquiler_1 = Integer.parseInt(eElement.getElementsByTagName("alquiler_1").item(0).getTextContent());
                  int alquiler_2 = Integer.parseInt(eElement.getElementsByTagName("alquiler_2").item(0).getTextContent());
                  int alquiler_3 = Integer.parseInt(eElement.getElementsByTagName("alquiler_3").item(0).getTextContent());
                  int alquiler_4 = Integer.parseInt(eElement.getElementsByTagName("alquiler_4").item(0).getTextContent());
                  int alquiler_hotel = Integer.parseInt(eElement.getElementsByTagName("alquiler_hotel").item(0).getTextContent());        
                  int hipoteca = Integer.parseInt(eElement.getElementsByTagName("hipoteca").item(0).getTextContent());
                  int precio_casa = Integer.parseInt(eElement.getElementsByTagName("precio_casa").item(0).getTextContent());
                  int precio_hotel = Integer.parseInt(eElement.getElementsByTagName("precio_hotel").item(0).getTextContent());
                  Casilla casilla = new Casilla(id, nombre, es_comprable, precio, color, grupo, total_grupo, tipo, alquiler, alquiler_1, alquiler_2, alquiler_3, alquiler_4, alquiler_hotel, hipoteca, precio_casa, precio_hotel);
                  ret.add(casilla);
               }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
   }
}
