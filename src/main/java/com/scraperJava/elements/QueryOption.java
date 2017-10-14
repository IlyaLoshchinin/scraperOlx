package com.scraperJava.elements;

import com.scraperJava.enamData.ActionTypePropertyOlx;
import com.scraperJava.enamData.CurrencyType;
import com.scraperJava.enamData.Relevance;

import java.util.HashMap;

/**
 * Created by Ilya Loshchinin on 14.10.2017.
 */
public abstract class QueryOption {
    //order is NOT important in request url

    //GENERAL
    ActionTypePropertyOlx property; //sell_apartment itc.
    ActionTypePropertyOlx propertySubcategory; //child of property itc.

    String city = "Kiev/"; //default = Kiev
    String queryInSearchField; //q-'value'/
    //?
    long priceFrom; //search%5Bfilter_float_price%3Afrom%5D=1000 {13*N}
    long priceTo;   //search%5Bfilter_float_price%3Ato%5D=1000   {13*N}
    //GENERAL


    //SELL|RENT FLAT -> (priceFrom|To) + below
    int roomFrom; //search%5Bfilter_float_number_of_rooms%3Afrom%5D=1 {3*N}
    int roomTo;     //search%5Bfilter_float_number_of_rooms%3Ato%5D=1   {3*N}

    int livingAreaFrom; //search%5Bfilter_float_total_living_area%3Afrom%5D=20
    int livingAreaTo; //search%5Bfilter_float_total_living_area%3Ato%5D=20

    int levelFrom; //search%5Bfilter_float_floor%3Afrom%5D=1 {2*N} - этаж
    int levelTo; //search%5Bfilter_float_floor%3Ato%5D=1 {2*N}

    boolean isPrivateBusiness; //search%5Bprivate_business%5D=private - {private,business}
    int districtNumber; //&search%5Bdistrict_id%5D=9 - районы
    boolean withPhoto; //search%5Bphotos%5D=1 - c фото или none;

    // SELL HOUSE -> (priceFrom|To) + below
     long floatHouseAreaFrom; //search%5Bfilter_float_house_area%3Afrom%5D=150 {6*N}
     long floatHouseAreaTo; //search%5Bfilter_float_house_area%3Ato%5D=175 {6*N}

    //SALE LAND -> (priceFrom|To) + below
     long floatLandAreaFrom;  //search%5Bfilter_float_land_area%3Afrom%5D=6& {6*N}
     long floatLandAreaTo;  //search%5Bfilter_float_land_area%3Ato%5D=20& {6*N}

    //SALE PREMISES -> (priceFrom|To) + below
    long floatAreaFrom; //search%5Bfilter_float_area%3Afrom%5D=2000
    long floatAreaTo;  //search%5Bfilter_float_area%3Ato%5D=2500

     //page=2 (1 - none)

    CurrencyType currency; //currency=USD - {none (UA),USA,EUR}

   //OTHER
    Relevance searchUntil;

     public String getPathConnect(){
        return ActionTypePropertyOlx.MAIN_CATEGORY + "";
    }

    public void getDataFields(){
        //extract data fields form the GUI
    }

}
