package com.example.javavkt9;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MovieTheatre {

    private String location;
    private int ID;

    public MovieTheatre(){
        location = "Pääkaupunkiseutu";
        ID = 1014;
    }

    public MovieTheatre(String location, int ID) throws IOException, ParserConfigurationException, SAXException {
        this.location = location;
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getLocation() {
        return location;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}