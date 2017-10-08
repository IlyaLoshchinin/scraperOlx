package com.scraperJava.App;

import com.scraperJava.enamData.DistrictKiev;
import com.scraperJava.enamData.Relevance;

import java.util.concurrent.*;

/**
 * Created by Ilya Loshchinin on 22.09.2017.
 */
public class Scraper implements Runnable {

   private final static Scraper instance = new Scraper();
   private final static ExecutorService es = Executors.newSingleThreadExecutor();
   private static Future task = null;

    private Scraper() {}

    public static Scraper getInstance(){
        return instance;
    }

    static void startScraping(){
        task = es.submit(Scraper.getInstance());
    }

    static void executorShoutdown(){
        es.shutdown(); //закроется только после того как все будет завершено
    };



    public void run() {
        Thread.currentThread().setName("Scraper "+ Thread.currentThread().getId() );
        System.out.println("Start! " + Thread.currentThread().getName() );


        System.out.println(DistrictKiev.DARNITSKIY);



        System.out.println("End! " + Thread.currentThread().getName() );
    }
}
