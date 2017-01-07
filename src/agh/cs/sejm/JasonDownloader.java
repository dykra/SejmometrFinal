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

    public void initializePoliticians() throws IOException {

        //TODO metoda do aktualizacji plików

        File file = new File ("./Files");
        if(!file.exists())
            file.mkdir(); //Creates the directory named by this abstract pathname.

        URL url = new URL("https://api-v3.mojepanstwo.pl/dane/poslowie.json");
        int counter = 0;
        File pList = new File ("./Files/PoliticiansList" + counter + ".json");
        if(!pList.exists())
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

            //TODO ta częś jako metoda prywatna
            if(!pList.exists())
                FileUtils.copyURLToFile(url, pList);

            politiciansSetTmp= gson.fromJson(new FileReader(pList),PoliticiansSet.class);
            links =  gson.fromJson(new FileReader(pList), Links.class);

            this.politiciansSet.addNewPolitisians(politiciansSetTmp.getPolitisians());
        }
        this.downloadPolitisiansDetails();
    }



    private void downloadPolitisiansDetails() throws IOException {

        File file = new File ("./Files/Layers");
        if(!file.exists())
            file.mkdir();                            //Creates the directory named by this abstract pathname.

        Politicians politicianTmp;
        for(Politicians currentPolitician : this.politiciansSet.getPolitisians()) {
            URL url = new URL("https://api-v3.mojepanstwo.pl/dane/poslowie/" + currentPolitician.getId() + ".json?layers[]=wydatki&layers[]=wyjazdy");
            File politicianDetails = new File("./Files/Layers/" + currentPolitician.getId() + ".json");
            if(!politicianDetails.exists()){
                FileUtils.copyURLToFile(url, politicianDetails); //pobieramy z url do stworzonego pliku
            }

            Gson gson = new Gson();

            politicianTmp = gson.fromJson(new FileReader(politicianDetails),Politicians.class); //myType nazwa = gson.from(String, MyType class)
            currentPolitician.setLayers(politicianTmp.getLayers());
            currentPolitician.getLayers().loadTravels();

        }
    }





    //TODO korzystać z tej metody
    private URL getLASTurlfromLinks(Links links) throws MalformedURLException {
        return new URL(links.getLinks("last"));
    }

    }