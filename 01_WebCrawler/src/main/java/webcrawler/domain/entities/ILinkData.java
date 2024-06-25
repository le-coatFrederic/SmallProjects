package webcrawler.domain.entities;

import webcrawler.domain.values.URL;

public interface ILinkData {
	public Link createLink(int id, URL site1, URL site2);
	public Link updateLink(int id, URL site1, URL site2);
	public Link detailLink(int id);
}
