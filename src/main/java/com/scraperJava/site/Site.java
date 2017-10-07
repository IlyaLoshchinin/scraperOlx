package com.scraperJava.site;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Ilya Loshchinin on 22.09.2017.
 */
interface Site {


    ArrayList<URL> getUrlListOfNodes();
    void addToResultSet();
    boolean isSuit();
    URL nextPage();

    URL getBaseURL();

}
