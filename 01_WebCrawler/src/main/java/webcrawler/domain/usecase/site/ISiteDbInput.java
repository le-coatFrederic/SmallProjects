package webcrawler.domain.usecase.site;

import webcrawler.domain.entities.Site;
import webcrawler.domain.values.URL;

public interface ISiteDbInput {
    public Site getSite(URL id);
    public boolean containSite(Site site);
    public boolean containSite(URL siteUrl);
    public int getNumberOfSite();
}
