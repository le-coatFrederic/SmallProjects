package webcrawler.domain.usecase.crawler;

import java.util.ArrayList;

import webcrawler.domain.entities.Site;
import webcrawler.domain.values.URL;

public interface ICrawlerURLGet {
    public URL getUrl();
    public ArrayList<URL> saveUrlOfSite(Site site);
}
