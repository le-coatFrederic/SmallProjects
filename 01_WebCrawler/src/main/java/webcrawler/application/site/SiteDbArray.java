package webcrawler.application.site;

import java.util.HashMap;

import webcrawler.domain.entities.Site;
import webcrawler.domain.usecase.site.ISiteDbInput;
import webcrawler.domain.usecase.site.ISiteDbOutput;
import webcrawler.domain.values.URL;

public class SiteDbArray implements ISiteDbInput, ISiteDbOutput {
    private HashMap<URL, Site> siteList = new HashMap<>();

    @Override
    public void saveSite(Site siteToSave) {
        if (siteToSave == null) {
            throw new IllegalArgumentException();
        }

        siteList.put(siteToSave.getUrl(), siteToSave);
    }

    @Override
    public synchronized void updateSite(URL oldSiteId, Site newSite) {
        if (oldSiteId == null || newSite == null) {
            throw new NullPointerException();
        }

        Site oldSite = siteList.get(oldSiteId);
        if (oldSite == null) {
            throw new NullPointerException();
        }

        oldSite.setHead(newSite.getHead());
        oldSite.setBody(newSite.getBody());
    }

    @Override
    public Site getSite(URL id) {
        if (id == null) {
            throw new NullPointerException();
        }

        Site site = siteList.get(id);

        if (site == null) {
            throw new NullPointerException();
        }

        return site;
    }

    @Override
    public boolean containSite(Site site) {
        return containSite(site.getUrl());
    }

    @Override
    public boolean containSite(URL siteUrl) {
        if (siteUrl == null) {
            throw new NullPointerException();
        }

        return siteList.containsKey(siteUrl);
    }

    @Override
    public int getNumberOfSite() {
        return siteList.size();
    }
    
}
