package webcrawler.application.crawler;

import java.util.ArrayList;
import java.util.HashMap;

import webcrawler.domain.entities.Site;
import webcrawler.domain.usecase.crawler.ICrawlerURLGet;
import webcrawler.domain.values.URL;

public class URLInArray implements ICrawlerURLGet {
    private ArrayList<URL> urls = new ArrayList<>();
    private HashMap<String, URL> urlsVisited = new HashMap<>();

    public void addUrl(URL urlToAdd) {
        if (urlToAdd == null) {
            throw new IllegalArgumentException();
        }

        if (urlsVisited.containsKey(urlToAdd.getUrl())) {
            return;
        }

        urls.add(urlToAdd);
    }

    public ArrayList<URL> getUrls() {
        return urls;
    }

    public HashMap<String, URL> getVisitedUrls() {
        return urlsVisited;
    }

    @Override
    public synchronized URL getUrl() {
        if (urls.isEmpty()) {
            throw new NullPointerException();
        }

        URL url = urls.get(0);
        urls.remove(0);
        return url;
    }

    @Override
    public ArrayList<URL> saveUrlOfSite(Site site) {
        if (site == null) {
            throw new IllegalArgumentException();
        }

        if (urlsVisited.containsKey(site.getUrl().getUrl())) {
            throw new IllegalArgumentException();
        }

        urls.add(site.getUrl());
        return this.urls;
    }
    
}
