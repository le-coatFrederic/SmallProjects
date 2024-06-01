package webcrawler.domain.usecase.crawler;

import webcrawler.domain.entities.Site;
import webcrawler.domain.usecase.site.ISiteDbInput;
import webcrawler.domain.usecase.site.ISiteDbOutput;
import webcrawler.domain.values.URL;

public class Crawler implements Runnable {
    private IWebCrawler webCrawler;
    private ICrawlerURLGet urlGet;
    private ISiteDbOutput siteDbOutput;
    private ISiteDbInput siteDbInput;

    public Crawler(IWebCrawler webCrawler, ICrawlerURLGet urlGet, ISiteDbOutput siteDbOutput, ISiteDbInput siteDbInput) {
        if (webCrawler == null || urlGet == null || siteDbOutput == null || siteDbInput == null) {
            throw new IllegalArgumentException();
        }

        this.webCrawler = webCrawler;
        this.urlGet = urlGet;
        this.siteDbOutput = siteDbOutput;
        this.siteDbInput = siteDbInput;
    }

    @Override
    public void run() {
        URL urlToVisit = null;
        urlToVisit = urlGet.getUrl();

        while (urlToVisit != null) {
            Site site = webCrawler.getSite(urlToVisit);
            if (!siteDbInput.containSite(site)) {
                siteDbOutput.saveSite(site);
                urlGet.saveUrlOfSite(site);
            }

            urlToVisit = null;
            urlToVisit = urlGet.getUrl();
        }
    }
}
