package webcrawler.domain.usecase.crawler;

import webcrawler.domain.entities.Site;
import webcrawler.domain.values.URL;

public interface IWebCrawler {
    public Site getSite(URL url);
}
