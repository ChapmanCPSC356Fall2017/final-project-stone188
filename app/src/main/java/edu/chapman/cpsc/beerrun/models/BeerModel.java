package edu.chapman.cpsc.beerrun.models;

import java.util.UUID;

/**
 *
 * Created by fried on 12/11/2017.
 */

public class BeerModel {
    private String id;
    private String title;
    private String url;
    private String abv;
    private String ibu;
    private String description;
    private String brewery;

    public BeerModel(){
        this.id = UUID.randomUUID().toString();
    }

    public String getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public String getAbv(){
        return abv;
    }

    public void setAbv(String abv){
        this.abv = abv;
    }

    public String getIbu(){
        return ibu;
    }

    public void setIbu(String ibu){
        this.ibu = ibu;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getBrewery(){
        return brewery;
    }

    public void setBrewery(String brewery){
        this.brewery = brewery;
    }
}
