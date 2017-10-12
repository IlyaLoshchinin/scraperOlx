package com.scraperJava.site;

import com.scraperJava.elements.Node;
import com.scraperJava.elements.QueryOption;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Ilya Loshchinin on 22.09.2017.
 */
public final class SiteOlx extends Site<Node> implements Parse<QueryOption> {


    public SiteOlx(String baseURL) {
        try {
            this.baseURL = new URL(baseURL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void parseAdvert(){

    }


    @Override
    public void start(QueryOption queryOption) {

    }

    @Override
    public ArrayList<URL> getUrlListOfNodes() {
        return null;
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
