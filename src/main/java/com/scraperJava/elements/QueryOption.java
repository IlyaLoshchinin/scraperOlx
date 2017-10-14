package com.scraperJava.elements;

import com.scraperJava.enamData.ActionTypePropertyOlx;
import com.scraperJava.enamData.CurrencyType;
import com.scraperJava.enamData.Relevance;

import java.util.HashMap;

/**
 * Created by Ilya Loshchinin on 14.10.2017.
 */
public abstract class QueryOption {

    ActionTypePropertyOlx property;

    boolean isUsedProperty;
    String queryInSearchField;

    long priceFrom;
    long priceTo;

    int roomFrom;
    int roomTo;

    int livingAreaFrom;
    int livingAreaTo;

    int levelFrom;
    int levelTo;

    boolean isPrivateBusiness;
    int districtNumber;
    boolean withPhoto;
    //page option
    CurrencyType currency;

    Relevance searchUntil;

    abstract public String getPathConnect();
    public void getDataFields(){
        //extract data fields form the GUI
    }

}
