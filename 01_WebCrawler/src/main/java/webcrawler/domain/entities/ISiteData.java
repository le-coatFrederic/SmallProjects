package webcrawler.domain.entities;

import webcrawler.domain.values.PageBody;
import webcrawler.domain.values.PageHead;
import webcrawler.domain.values.URL;

public interface ISiteData {
	public Site createSite(URL id, PageHead head, PageBody body);
	public Site updateSite(URL id, PageHead head, PageBody body);
	public Site detailSite(URL id);
}
