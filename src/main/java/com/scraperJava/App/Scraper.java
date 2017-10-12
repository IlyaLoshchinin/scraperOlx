package com.scraperJava.App;

import com.scraperJava.elements.QueryOption;
import com.scraperJava.site.Parse;
import com.scraperJava.site.SiteOlx;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by Ilya Loshchinin on 22.09.2017.
 */
public class Scraper implements Runnable {

   private final static Scraper instance = new Scraper();
   private final static ExecutorService es = Executors.newSingleThreadExecutor(); //пока в расположении один поток
   private static ArrayList<Future> tasks = new ArrayList<>(); //можем запускать несколько запросов

    private Scraper() {}

    public static Scraper getInstance(){
        return instance;
    }

    static void startScraping(){
         tasks.add(es.submit(Scraper.getInstance()));
    }

    static void executorShoutdown(){
        es.shutdown(); //закроется только после того как все будет завершено
    };



    public void run() {
        Thread.currentThread().setName("Scraper "+ Thread.currentThread().getId() );
        System.out.println("Start! " + Thread.currentThread().getName() );

        //get data from GUI
        QueryOption queryOption = new QueryOption();
        queryOption.getQueryOption();
        //start parsing
        Parse<QueryOption> olx = new SiteOlx("https://www.olx.ua/");
        olx.start(queryOption);
        // get and export data to Excel



        System.out.println("End! " + Thread.currentThread().getName() );
    }
}
