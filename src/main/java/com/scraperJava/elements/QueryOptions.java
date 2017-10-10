package com.scraperJava.elements;

import com.scraperJava.enamData.CurrencyType;
import com.scraperJava.enamData.ActionTypePropertyOlx;
import com.scraperJava.enamData.Relevance;
import com.sun.xml.internal.bind.v2.TODO;

import java.util.HashMap;

/**
 * Created by Ilya Loshchinin on 23.09.2017.
 */
public class QueryOptions {
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

    private InnerFilter filter;

    //only for test
    public void getQueryOptions() {


        QueryOptions q = new QueryOptions(
                ActionTypePropertyOlx.SALE_APARTMENT,
                true, "", 0L, 100000L,
                1, 2, 0, 60, 1, 12,
                true, 9,
                true, CurrencyType.USA
        );
        q.setInnerFilter();

    }

    //TODO delete empty constructor
    public QueryOptions() {

    }

    public QueryOptions(ActionTypePropertyOlx property, boolean isUsedProperty, String queryInSearchField, long priceFrom, long priceTo, int roomFrom, int roomTo, int livingAreaFrom, int livingAreaTo, int levelFrom, int levelTo, boolean isPrivateBusiness, int districtNumber, boolean withPhoto, CurrencyType currency) {
        this.property = property;
        this.isUsedProperty = isUsedProperty;
        this.queryInSearchField = queryInSearchField;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
        this.roomFrom = roomFrom;
        this.roomTo = roomTo;
        this.livingAreaFrom = livingAreaFrom;
        this.livingAreaTo = livingAreaTo;
        this.levelFrom = levelFrom;
        this.levelTo = levelTo;
        this.isPrivateBusiness = isPrivateBusiness;
        this.districtNumber = districtNumber;
        this.withPhoto = withPhoto;
        this.currency = currency;
    }

    //TODO setInnerFilter(Relevance searchUntil, HashMap<Integer, Integer> livingAreaFrom, HashMap<Integer, Long[]> priceFromTo)
    public InnerFilter setInnerFilter() {
        this.filter = new InnerFilter(Relevance.TODAY);
        return this.filter;
    }

    //TODO
    public InnerFilter getInnerFilter() {
        return this.filter;
    }

    class InnerFilter {
        // 1 room property - from - 16 m*m and itc.
        HashMap<Integer, Integer> livingAreaFrom = new HashMap<>(5);
        HashMap<Integer, Long[]> priceFromTo = new HashMap<>(5);

        Relevance searchUntil; //today,yesterday,3Day,week


        public InnerFilter(Relevance searchUntil) {
            this.searchUntil = searchUntil;

            //default data
            livingAreaFrom.put(1, 16);
            livingAreaFrom.put(2, 30);
            livingAreaFrom.put(3, 40);
            livingAreaFrom.put(4, 50);


            priceFromTo.put(1, new Long[]{20000L, 40000L});
            priceFromTo.put(2, new Long[]{50000L, 60000L});
            priceFromTo.put(3, new Long[]{70000L, 80000L});
            priceFromTo.put(4, new Long[]{90000L, 100000L});
        }
    }


}
