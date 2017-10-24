package com.scraperJava.enamData;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ilya Loshchinin on 22.09.2017.
 */
public enum ActionTypePropertyOlx {
  MAIN_CATEGORY("nedvizhimost/", "Недвижимость"),

  //Subcategory
  SALE_APARTMENT("prodazha-kvartir/", "Продажа квартир",
      //category of parent
      new String[][]{{"Вторичный рынок", "vtorichnyy-rynok/"},
          {"Новостройки", "novostroyki/"},
          {"Все", ""}}),

  RENT_APARTMENT("arenda-kvartir/", "Аренда квартир",
      new String[][]{{"Посуточно", "kvartiry-posutochno/"},
          {"Долгострочная", "dolgosrochnaya-arenda-kvartir/"},
          {"Без посредников", "bez-posrednikov/"},
          {"Все", ""}}),

  SALE_HOUSE("prodazha-domov/", "Продажа домов",
      new String[][]{{"Коттеджи", "prodazha-kottedzhey/"},
          {"Дома за городом", "prodazha-domov-v-derevne/"}, {"Дачи", "prodazha-dach/"},
          {"Все", ""}}),

  SALE_LAND("prodazha-zemli/", "Продажа земли",
      new String[][]{{"Под индв.строительство", "prodazha-zemli-pod-individualnoe-stroitelstvo/"},
          {"Под огород|сад", "prodazha-zemli-pod-sad-ogorod/"},
          {"Сельхоз назначение", "prodazha-zemli-selskohozyaystvennogo-naznacheniya/"},
          {"Промышленного назначение", "prodazha-zemli-promyshlennogo-naznacheniya/"},
          {"Все", ""}}),

  SALE_PREMISES("prodazha-pomescheniy/", "Продажа помещений",
      new String[][]{{"Магазины/Салоны", "prodazha-magazinov-salonov/"},
          {"Рестораны/Бары", "prodazha-restoranov-barov/"},
          {"Офисы", "prodazha-ofisov/"},
          {"Рестораны/Бары", "prodazha-restoranov-barov/"},
          {"Склады", "prodazha-skladov/"},
          {"Отдельно стоящие здания", "prodazha-otdelno-stoyaschih-zdaniy/"},
          {"Промышленное назначение", "prodazha-pomescheniy-promyshlennogo-naznacheniya/"},
          {"Свободного назначение", "prodazha-pomescheniy-svobodnogo-naznacheniya/"},
          {"Все", ""}});


    /*RENT_HOUSE("arenda-domov/","Аренда домов"),
    RENT_LAND("arenda-zemli/","Аренда земли"),
    RENT_GARAGE("arenda-garazhey-stoyanok/","Аренда гаражей"),
    RENT_PREMISE("arenda-pomescheniy/","Аренда помещений"),
    SALE_ROOM("prodazha-komnat/","Продажа комнат"),
    SALE_GARAGE("prodazha-garazhey-stoyanok/","Продажа гаражей"),
    EXCHANGE_PROPERTY("obmen-nedvizhimosti/","Обмен недвижимости"),
    OTHER_PROPERTY("prochaja-nedvizimost/","Прочая недвижимость"),
    LOOKING_FOR_COMPANION("ischu-kompanona/","Ищу компаньона"),
    PROPERTY_ABROAD("nedvizhimost-za-rubezhom/","Недвижимость за рубежом");*/


  private String partOfUrl;
  private String humanName;

  private HashMap<String, String> mapOfCategory = new HashMap<>();

  ActionTypePropertyOlx(String partOfUrl, String humanName, String[][] category) {
    this.partOfUrl = partOfUrl;
    this.humanName = humanName;
    for (String[] mapping : category) {
      mapOfCategory.put(mapping[0], mapping[1]);
    }
  }

  //main category
  ActionTypePropertyOlx(String partOfUrl, String humanName) {
    this.partOfUrl = partOfUrl;
    this.humanName = humanName;
  }

  @Override
  public String toString() {
    return partOfUrl;
  }

  public String getCategoryByKey(String key) {
    return mapOfCategory.get(key);
  }

  public String getName() {
    return humanName;
  }
}
