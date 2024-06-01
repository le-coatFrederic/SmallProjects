package webcrawler.domain.usecase.link;

import java.util.HashMap;

import webcrawler.domain.entities.ILinkData;
import webcrawler.domain.entities.Link;
import webcrawler.domain.values.URL;

public class CRUDLink implements ILinkData{
	private HashMap<Integer, Link> links;
	private ILinkDbInput dbInput;
	private ILinkDbOutput dbOutput;

	public CRUDLink(ILinkDbInput dbInput, ILinkDbOutput dbOutput) {
		if (dbInput == null ||dbOutput == null) {
			throw new IllegalArgumentException();
		}

		links = new HashMap<Integer, Link>();
		this.dbInput = dbInput;
		this.dbOutput = dbOutput;
	}

	public ILinkDbInput getDbInput() {
		return this.dbInput;
	}

	public ILinkDbOutput geDbOutput() {
		return this.dbOutput;
	}

	public CRUDLink setDbInput(ILinkDbInput dbInput) {
		if (dbInput == null) {
			throw new IllegalArgumentException();
		}

		this.dbInput = dbInput;
		return this;
	}

	public CRUDLink setDbOutput(ILinkDbOutput dbOutput) {
		if (dbOutput == null) {
			throw new IllegalArgumentException();
		}

		this.dbOutput = dbOutput;
		return this;
	}

	@Override
	public Link createLink(int id, URL site1, URL site2) {
		if (site1 == null || site2 == null) {
			throw new NullPointerException();
		}
		
		if (links.containsKey(id)) {
			throw new IllegalArgumentException();
		}
		
		Link newLink = new Link(id, site1, site2);
		links.put(id, newLink);
		
		return newLink;
	}

	@Override
	public Link updateLink(int id, URL site1, URL site2) {
		if (links.containsKey(id)) {
			throw new IllegalArgumentException();
		}
		
		Link updatedLink = links.get(id);
		
		if (site1 != null) {
			updatedLink.setSite1(site1);
		}
		
		if (site2 != null) {
			updatedLink.setSite2(site2);
		}
		
		return updatedLink;
	}

	@Override
	public Link detailLink(int id) {
		if (!links.containsKey(id)) {
			throw new IllegalArgumentException();
		}
		
		return links.get(id);
	}

}
