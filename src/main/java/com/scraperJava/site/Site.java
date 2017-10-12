package com.scraperJava.site;

import com.scraperJava.elements.Node;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ilya Loshchinin on 12.10.2017.
 */
abstract class  Site<T> {
    URL baseURL;
    private Set<T> resultSet = new HashSet<>();

    abstract ArrayList<URL> getUrlListOfNodes();

    abstract boolean isSuit();
    abstract URL nextPage();
    abstract void parseAdvert();

    Set<T> getResultSet() {
        return resultSet;
    }

    void addToResultSet(T node) {
        if(node != null)
            resultSet.add(node);
        else System.out.println("Node is null!");
    }

    URL getBaseURL(){
        return this.baseURL;
     }
}
