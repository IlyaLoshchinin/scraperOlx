package com.scraperJava.site;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Ilya Loshchinin on 12.10.2017.
 */
public abstract class Site {

    abstract ArrayList<URL> getUrlListOfNodes();
    abstract void addToResultSet();
    abstract boolean isSuit();
    abstract URL nextPage();

    abstract void parseAdvert();
    abstract URL getBaseURL();
}
