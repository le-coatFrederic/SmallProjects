package webcrawler.domain.usecase.site;

import webcrawler.domain.entities.Site;
import webcrawler.domain.values.URL;

public interface ISiteDbOutput {
    public void saveSite(Site siteToSave);
    public void updateSite(URL oldSiteId, Site newSite);
}