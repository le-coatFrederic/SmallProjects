package webcrawler.domain.usecase.site;

import java.util.HashMap;

import webcrawler.domain.entities.ISiteData;
import webcrawler.domain.entities.Site;
import webcrawler.domain.values.PageBody;
import webcrawler.domain.values.PageHead;
import webcrawler.domain.values.URL;

public class CRUDSite implements ISiteData {
	private HashMap<URL, Site> sites;
	private ISiteDbInput dbInput;
	private ISiteDbOutput dbOutput;
	
	public CRUDSite(ISiteDbInput dbInput, ISiteDbOutput dbOutput) {
		this.dbInput = dbInput;
		this.dbOutput = dbOutput;
		sites = new HashMap<URL, Site>();
	}

	public ISiteDbInput getDbInput() {
		return dbInput;
	}

	public ISiteDbOutput getDbOutput() {
		return dbOutput;
	}

	public CRUDSite setDbInput(ISiteDbInput dbInput) {
		if (dbInput == null) {
			throw new IllegalArgumentException();
		}

		this.dbInput = dbInput;
		return this;
	}

	public CRUDSite setDbOutput(ISiteDbOutput dbOutput) {
		if  (dbOutput == null) {
			throw new IllegalArgumentException();
		}

		this.dbOutput = dbOutput;
		return this;
	}
	
	@Override
	public synchronized Site createSite(URL id, PageHead head, PageBody body) {
		if (id == null || head == null || body == null) {
			throw new NullPointerException();
		}
		
		if (sites.containsKey(id)) {
			throw new IllegalArgumentException();
		}
		
		return new Site(id).setHead(head).setBody(body);
	}

	@Override
	public synchronized Site updateSite(URL id, PageHead head, PageBody body) {
		if (id == null) {
			throw new NullPointerException();
		}
		
		Site site = null;
		site = sites.get(id);
		
		if (site == null) {
			throw new IllegalArgumentException();
		}
		
		if (head != null) {
			site.setHead(head);
		}
		
		if (body != null) {
			site.setBody(body);
		}
		
		return site;
	}

	@Override
	public synchronized Site detailSite(URL id) {
		if (id == null) {
			throw new NullPointerException();
		}
		
		Site site = null;
		site = sites.get(id);
		
		if (site == null) {
			throw new NullPointerException();
		}
		
		return site;
	}

}
