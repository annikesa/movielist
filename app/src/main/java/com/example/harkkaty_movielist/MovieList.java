package com.example.harkkaty_movielist;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MovieList {

    ArrayList<Movie> movieList;
    ArrayList<String >movies = null;
    int llength;

    public MovieList() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        movieList = new ArrayList<Movie>();

        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        String url = "https://www.finnkino.fi/xml/Events";
        Document doc = null;
        try {
            doc = db.parse(url);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        doc.getDocumentElement().normalize();
        NodeList list = doc.getDocumentElement().getElementsByTagName("Event");
        for (int temp = 0; temp < list.getLength(); temp++) {

            Node node = list.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                String title = element.getElementsByTagName("Title").item(0).getTextContent();
                String genre = element.getElementsByTagName("Genres").item(0).getTextContent();
                String length = element.getElementsByTagName("LengthInMinutes").item(0).getTextContent();
                String year = element.getElementsByTagName("ProductionYear").item(0).getTextContent();

                movieList.add(new Movie(title,length,year,genre));
                System.out.println();
                System.out.println(title + length);
            }
        }
    }


    public void addMovie(String name, String length, String year,String genre) {
        movieList.add(new Movie(name,length,year,genre));
        llength++;
    }

    public ArrayList getNames() {
        ArrayList names = new ArrayList();
        for (int position = 0; position < llength; position++) {
            String a = movieList.get(position).getMovName();
            names.add(a);
        }
        System.out.println("moi");
        return names;
    }

    public String getLength(String movie) {
        String length = null;
        for (int i = 0; i < llength; i++) {
            if (movie.contains(movieList.get(i).getMovName())) {
                length = movieList.get(i).length;
            }
        }
        return length;
    }

    public String getYear(String movie) {
        String year = null;
        for (int i = 0; i < llength; i++) {
            if (movie.contains(movieList.get(i).getMovName())) {
                year = movieList.get(i).year;
            }
        }
        return year;
    }

    public String  getGenre(String movie) {
        String genre = null;
        for (int i = 0; i < llength; i++) {
            if (movie.contains(movieList.get(i).getMovName())) {
                genre = movieList.get(i).genre;
            }
        }
        return genre;
    }
}