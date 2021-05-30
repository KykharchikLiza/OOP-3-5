package com.oop.lab4.serialization;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Transformation {

    public static void saveXML(Object object, String path) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveJson(Object object, String path) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T loadXml(String path, Class<T> valueType) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.readValue(new File(path), valueType);
        } catch (IOException e) {
            //e.printStackTrace();
            return null;
        }
    }

    public static <T> T loadJson(String path, Class<T> valueType) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(new File(path), valueType);
        } catch (IOException e) {
            //e.printStackTrace();
            return null;
        }
    }

    public static void saveTransformXml(Object object, String path) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            String xmlString = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);

            Document doc = parseXmlDoc(xmlString);
            NodeList nodeList = doc.getElementsByTagName("*");
            int length = nodeList.getLength();
            for (int i = 0; i < length; i++) {
                Element element = (Element) nodeList.item(i);
                if (element.getNodeType() == Node.ELEMENT_NODE) {
                    changeAttrOnTag(doc, element);
                }
            }
            writeXmlDoc(doc, path);
        } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private static Document parseXmlDoc(String xmlString) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        ByteArrayInputStream input = new ByteArrayInputStream(xmlString.getBytes(StandardCharsets.UTF_8));
        return dBuilder.parse(input);
    }

    private static void writeXmlDoc(Document doc, String pathname) throws TransformerException {
        removeEmptyText(doc.getDocumentElement());
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(pathname));
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.transform(source, result);
    }

    // create tag <attrName>attrValue</attrName>
    private static void changeAttrOnTag(Document doc, Element element) {
        if (element.hasAttributes()) {
            NamedNodeMap attrs = element.getAttributes();
            int attrsLength = attrs.getLength();
            for (int j = 0; j < attrsLength; j++) {
                Node attr = attrs.item(j);
                String attrName = attr.getNodeName();
                String attrValue = attr.getNodeValue();

                Element attrTag = doc.createElement(attrName);
                attrTag.appendChild(doc.createTextNode(attrValue));
                element.insertBefore(attrTag, element.getFirstChild());
                element.removeAttribute(attrName);
            }
        }
    }

    private static void removeEmptyText(Node node) {
        Node child = node.getFirstChild();
        while (child != null) {
            Node sibling = child.getNextSibling();
            if (child.getNodeType() == Node.TEXT_NODE) {
                if (child.getTextContent().trim().isEmpty()) {
                    node.removeChild(child);
                }
            } else {
                removeEmptyText(child);
            }
            child = sibling;
        }
    }

}
