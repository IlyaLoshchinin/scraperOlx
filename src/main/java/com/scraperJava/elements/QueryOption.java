package com.scraperJava.elements;

import com.scraperJava.enamData.ActionTypePropertyOlx;
import com.scraperJava.enamData.CurrencyType;
import com.scraperJava.enamData.DistrictKiev;
import com.scraperJava.enamData.Relevance;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/**
 * Created by Ilya Loshchinin on 14.10.2017.
 */
public abstract class QueryOption {
  //order is NOT important in request url
  //ArrayList<HashMap> bindFields;

  //GENERAL
  ActionTypePropertyOlx property; //sell_apartment itc.
  ActionTypePropertyOlx propertySubcategory; //child of property itc.

  String city = "kiev/"; //default = Kiev

  @Bind("q-'value'/")
  String queryInSearchField; //q-'value'/

  //?
  @Bind("search%5Bfilter_float_price%3Afrom%5D='value'/")
  long priceFrom; //search%5Bfilter_float_price%3Afrom%5D=1000 {13*N}
  @Bind("search%5Bfilter_float_price%3Ato%5D='value'/")
  long priceTo;   //search%5Bfilter_float_price%3Ato%5D=1000   {13*N}
  //GENERAL


  //SELL|RENT FLAT -> (priceFrom|To) + below
  @Bind("search%5Bfilter_float_number_of_rooms%3Afrom%5D=")
  int roomFrom; //search%5Bfilter_float_number_of_rooms%3Afrom%5D=1 {3*N}
  @Bind("search%5Bfilter_float_number_of_rooms%3Ato%5D=")
  int roomTo;     //search%5Bfilter_float_number_of_rooms%3Ato%5D=1   {3*N}

  @Bind("search%5Bfilter_float_total_living_area%3Afrom%5D=")
  int livingAreaFrom; //search%5Bfilter_float_total_living_area%3Afrom%5D=20
  @Bind("search%5Bfilter_float_total_living_area%3Ato%5D=")
  int livingAreaTo; //search%5Bfilter_float_total_living_area%3Ato%5D=20

  @Bind("search%5Bfilter_float_floor%3Afrom%5D=")
  int levelFrom; //search%5Bfilter_float_floor%3Afrom%5D=1 {2*N} - этаж
  @Bind("search%5Bfilter_float_floor%3Ato%5D=")
  int levelTo; //search%5Bfilter_float_floor%3Ato%5D=1 {2*N}

  @Bind("search%5Bprivate_business%5D=")
  InterestType interestType; //search%5Bprivate_business%5D=private - {private,business}
  @Bind("search%5Bdistrict_id%5D=")
  DistrictKiev district; //search%5Bdistrict_id%5D=9 - районы
  @Bind("search%5Bphotos%5D=")
  boolean withPhoto; //search%5Bphotos%5D=1 - c фото или none;

  // SELL HOUSE -> (priceFrom|To) + below
  @Bind("search%5Bfilter_float_house_area%3Afrom%5D=")
  long floatHouseAreaFrom; //search%5Bfilter_float_house_area%3Afrom%5D=150 {6*N}
  @Bind("search%5Bfilter_float_house_area%3Ato%5D=")
  long floatHouseAreaTo; //search%5Bfilter_float_house_area%3Ato%5D=175 {6*N}

  //SALE LAND -> (priceFrom|To) + below
  @Bind("search%5Bfilter_float_land_area%3Afrom%5D=")
  long floatLandAreaFrom;  //search%5Bfilter_float_land_area%3Afrom%5D=6 {6*N}
  @Bind("search%5Bfilter_float_land_area%3Ato%5D=")
  long floatLandAreaTo;  //search%5Bfilter_float_land_area%3Ato%5D=20 {6*N}

  //SALE PREMISES -> (priceFrom|To) + below
  @Bind("search%5Bfilter_float_area%3Afrom%5D=")
  long floatAreaFrom; //search%5Bfilter_float_area%3Afrom%5D=2000
  @Bind("search%5Bfilter_float_area%3Ato%5D=")
  long floatAreaTo;  //search%5Bfilter_float_area%3Ato%5D=2500

  //page=2 (1 - none)
  @Bind("currency=")
  CurrencyType currency; //currency=USD - {none (UA),USA,EUR}

  //OTHER
  Relevance searchUntil;


  public String getPathConnect() {
    StringBuilder options = new StringBuilder();
    options.append(ActionTypePropertyOlx.MAIN_CATEGORY);

    try {
      Field f = QueryOption.class.getDeclaredField("priceFrom");
      Bind annotation = f.getAnnotation(Bind.class);
      System.out.println(f.getName() + " value: " + annotation.value());
    } catch (NoSuchFieldException e) {
      e.printStackTrace();
    }

    Field[] fields = QueryOption.class.getDeclaredFields();
    System.out.println("getPath");
    System.out.println(fields.length);
    AccessibleObject.setAccessible(fields, true);
    for (Field field : fields) {
      if (field == null) {
        continue;
      }
      Bind annotation = field.getAnnotation(Bind.class);
      if (annotation != null) {
        Bind ann = annotation;
        System.out.println(field.getName() + " value: " + ann.value());
      }
    }

    return options.toString();
  }

  public void getDataFields() {
    //extract data fields form the GUI
  }

  protected enum InterestType {
    PRIVATE("private"), BUSINESS("business"), ALL("");

    String type;

    InterestType(String type) {
      this.type = type;
    }

    @Override
    public String toString() {
      return type;
    }

    public String getTypeUrlPart() {
      return "&search%5Bprivate_business%5D=" + type;
    }
  }

//    class BindFields<P> {
//        HashMap<P, String> bind;
//
//        public BindFields(P parameter, String urlPart) {
//            bind = new HashMap<>();
//            bind.put(parameter, urlPart);
//            bindFields.add(bind);
//        }
//
//        public BindFields(P param1,String param1UrlPart,P param2,String param2UrlPart) {
//            bind = new HashMap<>();
//            bind.put(param1, param1UrlPart);
//            bind.put(param2, param2UrlPart);
//            bindFields.add(bind);
//        }
//
//    }

}
