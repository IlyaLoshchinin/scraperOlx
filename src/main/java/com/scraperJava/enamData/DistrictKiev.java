package com.scraperJava.enamData;

/**
 * Created by Ilya Loshchinin on 07.10.2017.
 */
public enum DistrictKiev {
    HOLOSIIVSKYI(1,"Голосеевский"),
    DARNITSKIY(3,"Дарницкий"),
    DESNYANSKIY(5,"Деснянский"),
    DNIEPROWSKI(7,"Днепровский"),
    OBOLONSKY(9,"Оболонский"),
    PECHERSKY(11,"Печерский"),
    PODOLSKY(13,"Подольский"),
    SVYATOSHINSKY(15,"Святошинский"),
    SOLOMENSKY(17,"Соломенский"),
    SHEVCHENKOVSKIY(19,"Шевченковский");

    private String name;
    private int number;

    DistrictKiev(int number,String name) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);

    }
}
