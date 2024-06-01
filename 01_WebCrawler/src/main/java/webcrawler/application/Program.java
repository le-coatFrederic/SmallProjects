package webcrawler.application;

import webcrawler.application.crawler.URLInArray;
import webcrawler.application.crawler.WebCrawlerJSoup;
import webcrawler.application.site.SiteDbArray;
import webcrawler.domain.usecase.crawler.Crawler;
import webcrawler.domain.values.URL;

public class Program {
    public static void main(String[] args) {
        Crawler listOfCrawler[] = new Crawler[100];
        SiteDbArray siteDB = new SiteDbArray();
        URLInArray urls = new URLInArray();

        urls.addUrl(new URL().setUrl(new String("https://docs.docker.com/network/drivers/ipvlan/")));

        for (int i = 0; i < 100; i++) {
            listOfCrawler[i] = new Crawler(new WebCrawlerJSoup(), urls, siteDB, siteDB);
            listOfCrawler[i].run();
        }

        for (URL url : urls.getVisitedUrls().values()) {
            System.out.println("Visited : " + url.getUrl());
        }
    }
}
