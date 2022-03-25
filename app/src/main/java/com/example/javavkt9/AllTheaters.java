package com.example.javavkt9;

import android.os.StrictMode;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class AllTheaters {

    private ArrayList<MovieTheatre> movieList;
    ArrayList<String> movieLocations = new ArrayList<>();
    ArrayList<Integer> movieIDs = new ArrayList<>();

    private static AllTheaters allTheaters = new AllTheaters();

        private AllTheaters(){
            movieList = new ArrayList();

            //get theater location data from XML file
            DocumentBuilder builder = null;

            try{
                //put on a new policy regarding security and allow all
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                String urlString = "https://www.finnkino.fi/xml/TheatreAreas/";
                Document doc = builder.parse(urlString);
                doc.getDocumentElement().normalize();
                System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

                NodeList nodeList = doc.getDocumentElement().getElementsByTagName("TheatreArea");

                //add the name data to a list to use in spinner
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    System.out.println("Element is" + node.getNodeName());

                    if(node.getNodeType() == Node.ELEMENT_NODE){
                        Element element = (Element) node;
                        String location = element.getElementsByTagName("Name").item(0).getTextContent();
                        int movieID = Integer.valueOf(element.getElementsByTagName("ID").item(0).getTextContent());

                        movieLocations.add(location);
                        movieIDs.add(movieID);
                        movieList.add(new MovieTheatre(location, movieID));

                    }
                }
            }catch (
                    ParserConfigurationException e) {
                e.printStackTrace();
            } catch (
                    IOException e) {
                e.printStackTrace();
            } catch (
                    SAXException e) {
                e.printStackTrace();
            } finally {
                System.out.println("###############YEET################");
            }
        }

    public static AllTheaters getInstance() {
        return allTheaters;

    }

    public List<MovieTheatre> getList() {
        return movieList;
    }

    public List<String> getNames(){return movieLocations;}

    public List<Integer> getMovieIDs(){return movieIDs;}

    public int findID(String name){
            for(MovieTheatre M : movieList){
                if(M.getLocation() == name){
                    return M.getID();
                }
            }
        return 1029;
    }

}
