package com.example.javavkt9;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {

    Context context = null;
    Spinner areaspinner, datespinner;
    ListView listView;

    AllTheaters allTheaters = AllTheaters.getInstance();
    MovieTheatre theatre = new MovieTheatre();
    List<String> dates = new ArrayList<>();



    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;

        areaspinner = findViewById(R.id.areaspinner);
        datespinner = findViewById(R.id.datespinner);
        listView = (ListView) findViewById(R.id.listview);


        List<MovieTheatre> theatreList = AllTheaters.getInstance().getList();
        List<String> locations = allTheaters.getNames();
        List<Integer> IDs = allTheaters.getMovieIDs();



        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, locations);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        areaspinner.setAdapter(adapter);


        areaspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String location = adapterView.getSelectedItem().toString();
                int ID = allTheaters.findID(location);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        getDays();

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dates);

        // Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        datespinner.setAdapter(adapter2);

        datespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String date = (String) adapterView.getSelectedItem();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void getDays()
    {

        LocalDateTime now = LocalDateTime.now();

        dates.add(String.valueOf(now.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))));

        for(int i = 0; i < 29; i++){
            now = now.plusDays(1);
            dates.add(String.valueOf(now.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))));
        }

    }

    public void getMovies(View v){


        ArrayList<String> movies = new ArrayList<String>();

        // Change the format of dates, in data format is 2021-03-22'T'21:00:00
        SimpleDateFormat format_in = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat format_out = new SimpleDateFormat("HH:mm dd.MM.yyyy");

        Date dt = null;

        String location = areaspinner.getSelectedItem().toString();
        int ID = allTheaters.findID(location);

        String date = datespinner.getSelectedItem().toString();

        try {
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String urlString = "https://www.finnkino.fi/xml/Schedule/?area="+ID+"&dt="+date;
            Document doc = dBuilder.parse(urlString);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getDocumentElement().getElementsByTagName("Show");
            System.out.println(nList.getLength());

            for (int i = 0; i < nList.getLength() ; i++) {
                Node node = nList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String Title = element.getElementsByTagName("Title").item(0).getTextContent();
                    String start = element.getElementsByTagName("dttmShowStart").item(0).getTextContent();
                    try {
                        dt = format_in.parse(start);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    String start_time = format_out.format(dt);
                    String line = Title + "\nElokuva alkaa: " + start_time;

                    movies.add(line);
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("###########YEET###########");
        }


        ArrayAdapter<String> linesAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, movies);
        listView.setAdapter(linesAdapter);

    }
}

