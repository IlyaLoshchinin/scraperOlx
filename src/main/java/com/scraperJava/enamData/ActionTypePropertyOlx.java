package com.scraperJava.enamData;

/**
 * Created by Ilya Loshchinin on 22.09.2017.
 */
public enum ActionTypePropertyOlx {
    MAIN_CATEGORY("/nedvizhimost/","Недвижимость"),

    //Subcategory
    RENT_APARTMENT("/arenda-kvartir/","Аренда квартир"),
    RENT_HOUSE("/arenda-domov/","Аренда домов"),
    RENT_LEASE("/arenda-zemli/","Аренда земли"),
    RENT_GARAGE("/arenda-garazhey-stoyanok/","Аренда гаражей"),
    RENT_PREMISE("/arenda-pomescheniy/","Аренда помещений"),
    SALE_APARTMENT("/prodazha-kvartir/","Продажа квартир"),
    SALE_ROOM("/prodazha-komnat/","Продажа комнат"),
    SALE_HOUSE("/prodazha-zemli/","Продажа земли"),
    SALE_GARAGE("/prodazha-garazhey-stoyanok/","Продажа гаражей"),
    SALE_PREMISES("/prodazha-pomescheniy/","Продажа помещений"),
    EXCHANGE_PROPERTY("/obmen-nedvizhimosti/","Обмен недвижимости"),
    OTHER_PROPERTY("/prochaja-nedvizimost/","Прочая недвижимость"),
    LOOKING_FOR_COMPANION("/ischu-kompanona/","Ищу компаньона"),
    PROPERTY_ABROAD("/nedvizhimost-za-rubezhom/","Недвижимость за рубежом");


    private String partOfUrl;
    private String humanName;

    ActionTypePropertyOlx(String partOfUrl, String humanName) {
        this.partOfUrl = partOfUrl;
        this.humanName = humanName;
    }

    @Override
    public String toString() {
        return partOfUrl;
    }

    public String getName() {
        return humanName;
    }
}
