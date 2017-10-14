package com.scraperJava.site;

import com.scraperJava.elements.FlatQO;
import com.scraperJava.elements.Node;
import com.scraperJava.elements.QueryOption;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.PatternSyntaxException;

/**
 * Created by Ilya Loshchinin on 22.09.2017.
 */
public final class SiteOlx extends Site<Node> implements Parse<QueryOption> {


    public SiteOlx(String baseURL) {
            this.baseURL = baseURL;
    }

    @Override
    public void parseAdvert(){

    }


    @Override
    public void start(QueryOption queryOption) {
        Document mainDoc = null;
        Element userAgentLines;
        String userAgent = null;

        //Get USER AGENT from site (common user agents (up to date) by https://techblog.willshouse.com)
        try {
            userAgentLines = Jsoup.parse(new URL("https://techblog.willshouse.com/2012/01/03/most-common-user-agents"),30000).select("textarea.get-the-list").first();

           int randomRow = ThreadLocalRandom.current().nextInt(10); // TOP 10
            try {
                userAgent = userAgentLines.text().split("\\n")[randomRow];
            }catch (PatternSyntaxException | ArrayIndexOutOfBoundsException e){
                //default
                userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        queryOption.getPathConnect();
       /* try {




            //TODO flatQO.getQueryOptions()
            mainDoc = Jsoup.connect(getBaseURL())
                    .userAgent(userAgent)
                    .referrer("http://www.google.com")
                    .timeout(20000)
                    .followRedirects(true)
                    .get();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/

       List<String> links =  getUrlListOfNodes(mainDoc);

        for (String link : links){
            System.out.println(link);
        }

    }

    @Override
    public ArrayList<String> getUrlListOfNodes(Document document) {
        //System.out.println(document.select("#offers_table .wrap table h3 > a").eachAttr("href").size());

        return (ArrayList<String>) document.select("#offers_table .wrap table h3 > a").eachAttr("href");
    }



    @Override
    public boolean isSuit() {
        return false;
    }

    @Override
    public URL nextPage() {
        return null;
    }





}
