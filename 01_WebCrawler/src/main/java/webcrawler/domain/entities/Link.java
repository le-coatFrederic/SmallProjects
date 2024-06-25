package webcrawler.domain.entities;

import webcrawler.domain.values.URL;

public class Link {
	private int id;
	private URL site1;
	private URL site2;
	
	public Link(int id, URL site1, URL site2) {
		this.id = id;
		this.site1 = site1;
		this.site2 = site2;
	}
	
	public synchronized int getId() {
		return id;
	}
	
	public synchronized URL getSite1() {
		return site1;
	}
	
	public synchronized URL getSite2() {
		return site2;
	}
	
	public synchronized void setSite1(URL site1) {
		if (site1 == null) {
			throw new IllegalArgumentException();
		}
	
		this.site1 = site1;
	}
	public synchronized void setSite2(URL site2) {
		if (site2 == null) {
			throw new IllegalArgumentException();
		}
	
		this.site2 = site2;
	}
}
