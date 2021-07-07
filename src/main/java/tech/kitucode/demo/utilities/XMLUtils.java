package tech.kitucode.demo.utilities;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class XMLUtils {

    public static Document getXMLDocument(String fileName){

        Document document = null;

        try{
            File xmlFile = new File("src/main/resources/"+fileName);

            // create factory
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            document = documentBuilder.parse(xmlFile);

            document.getDocumentElement().normalize();


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return document;
    }

    public static Map<String,String> readByTagName(String filename, String tagName){

        Map<String, String> configMap = new HashMap<>();

        Document document = getXMLDocument(filename);

        NodeList nodeList = document.getElementsByTagName(tagName);

        for(int i = 0; i<nodeList.getLength(); i++){
            Node node = nodeList.item(i);

            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;

                configMap.put(element.getAttribute("name").toUpperCase(),element.getElementsByTagName("processorClass").item(0).getTextContent());
            }
        }

        return configMap;
    }

}
