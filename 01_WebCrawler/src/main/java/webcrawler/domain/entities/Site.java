package webcrawler.domain.entities;

import webcrawler.domain.values.PageBody;
import webcrawler.domain.values.PageHead;
import webcrawler.domain.values.URL;

public class Site {
	private URL url;
	private PageHead head;
	private PageBody body;
	
	public Site(URL url) {
		this.url = url;
	}

	public synchronized URL getUrl() {
		return url;
	}

	public synchronized PageHead getHead() {
		return head;
	}

	public synchronized PageBody getBody() {
		return body;
	}

	public synchronized Site setUrl(URL url) {
		if (url == null) {
			throw new IllegalArgumentException();
		}
	
		this.url = url;
		return this;
	}

	public synchronized Site setHead(PageHead head) {
		if (head == null) {
			throw new IllegalArgumentException();
		}
	
		this.head = head;
		return this;
	}

	public synchronized Site setBody(PageBody body) {
		if (body == null) {
			throw new IllegalArgumentException();
		}
	
		this.body = body;
		return this;
	}
	
	
}
