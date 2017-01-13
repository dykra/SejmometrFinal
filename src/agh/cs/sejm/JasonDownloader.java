package agh.cs.sejm;


import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by Joanna on 2016-12-16.
 */
public class JasonDownloader {
    public PoliticiansSet politiciansSet;

    public void initializePoliticians(Boolean a) throws IOException {

        File file = new File ("./Files");
        if(!file.exists() || a.equals(Boolean.TRUE))
            file.mkdir(); //Creates the directory named by this abstract pathname.

        URL url = new URL("https://api-v3.mojepanstwo.pl/dane/poslowie.json");
        int counter = 0;
        File pList = new File ("./Files/PoliticiansList" + counter + ".json");
        if(!pList.exists() || a.equals(Boolean.TRUE))
            FileUtils.copyURLToFile(url, pList);

        Gson gson = new Gson();
        this.politiciansSet = gson.fromJson(new FileReader(pList), PoliticiansSet.class);

        Links links = gson.fromJson(new FileReader(pList), Links.class);

        PoliticiansSet politiciansSetTmp = new PoliticiansSet();

        while(links.getLinks("last")!=null){
            counter ++;
            //pobieramy nowe url z lasta i dla niego pobieramy pliki
            url = new URL(links.getLinks("next"));
            pList = new File ("./Files/PoliticiansList" + counter + ".json");

            if(!pList.exists() || a.equals(Boolean.TRUE))
                FileUtils.copyURLToFile(url, pList);

            politiciansSetTmp= gson.fromJson(new FileReader(pList),PoliticiansSet.class);
            links =  gson.fromJson(new FileReader(pList), Links.class);

            politiciansSet.addNewPolitisians(politiciansSetTmp.getPolitisians());
        }
        downloadPolitisiansDetails(a);
    }



    private void downloadPolitisiansDetails(Boolean a) throws IOException {

        File file = new File ("./Files/Layers");
        if(!file.exists() || a.equals(Boolean.TRUE))
            file.mkdir();                            //Creates the directory named by this abstract pathname.

        Politicians politicianTmp;
        for(Politicians currentPolitician : this.politiciansSet.getPolitisians()) {
            URL url = new URL("https://api-v3.mojepanstwo.pl/dane/poslowie/" + currentPolitician.getId() + ".json?layers[]=wydatki&layers[]=wyjazdy");
            File politicianDetails = new File("./Files/Layers/" + currentPolitician.getId() + ".json");

            if(!politicianDetails.exists() || a.equals(Boolean.TRUE)){
                FileUtils.copyURLToFile(url, politicianDetails); //Copies bytes from the URL source to a file destination.
            }
            Gson gson = new Gson();
            politicianTmp = gson.fromJson(new FileReader(politicianDetails),Politicians.class); //myType nazwa = gson.from(String, MyType class)
            currentPolitician.setLayers(politicianTmp.getLayers());
            currentPolitician.getLayers().loadTravels();

        }
    }

    public void actualizePolitisians() throws IOException {

        initializePoliticians(Boolean.TRUE);
    }
}
