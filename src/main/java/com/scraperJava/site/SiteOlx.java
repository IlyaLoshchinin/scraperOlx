package com.scraperJava.site;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Ilya Loshchinin on 22.09.2017.
 */
public class SiteOlx implements Site {

    private URL baseURL = null;


    public SiteOlx(URL baseURL) {
        this.baseURL = baseURL;
    }


    public void start(){


    };


    @Override
    public ArrayList<URL> getUrlListOfNodes() {
        return null;
    }

    @Override
    public void addToResultSet() {

    }

    @Override
    public boolean isSuit() {
        return false;
    }

    @Override
    public URL nextPage() {
        return null;
    }

    @Override
    public URL getBaseURL() {
        return baseURL;
    }
}
