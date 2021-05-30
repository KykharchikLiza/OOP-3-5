package com.oop.lab4.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Serialization {

    public static final String STORAGE_DIR = "storage/";
    private static final String FILENAME_TXT = "vehicles.txt";
    private static final String FILENAME_XML = "vehicles.xml";
    private static final String FILENAME_JSON = "vehicles.json";

    public static void createDirectory() throws IOException {
        Path directory = Paths.get(STORAGE_DIR);
        if (!Files.isDirectory(directory)) {
            Files.createDirectory(directory);
        }
    }

    public static void serialize(Object object) {
        try {
            createDirectory();
            FileOutputStream fileOutputStream = new FileOutputStream(STORAGE_DIR + FILENAME_TXT);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object deserialize() {
        try {
            FileInputStream fileInputStream = new FileInputStream(STORAGE_DIR + FILENAME_TXT);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            objectInputStream.close();
            return object;
        } catch (IOException | ClassNotFoundException e) {
            //e.printStackTrace();
            return null;
        }
    }

    public static void serializeXML(Object object) {
        try {
            createDirectory();
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(new File(STORAGE_DIR + FILENAME_XML), object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T deserializeXML(Class<T> valueType) {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.readValue(new File(STORAGE_DIR + FILENAME_XML), valueType);
        } catch (IOException e) {
            //e.printStackTrace();
            return null;
        }
    }

    public static void serializeJson(Object value) {
        try {
            createDirectory();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(STORAGE_DIR + FILENAME_JSON), value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T deserializeJson(Class<T> valueType) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(new File(STORAGE_DIR + FILENAME_JSON), valueType);
        } catch (IOException e) {
            //e.printStackTrace();
            return null;
        }
    }

}
