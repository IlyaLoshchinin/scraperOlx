package com.scraperJava.site;

import com.scraperJava.elements.QueryOption;
import org.apache.poi.ss.formula.functions.T;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Ilya Loshchinin on 22.09.2017.
 */
public interface Parse<T> {
    void start(T queryOption);
}
