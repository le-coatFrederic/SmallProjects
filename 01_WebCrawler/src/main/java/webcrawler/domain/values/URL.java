package webcrawler.domain.values;

public class URL {
	private String urlString;
	public URL() {
		urlString = "";
	}
	
	public URL setUrl(String url) {
		if (url == null) {
			throw new IllegalArgumentException();
		}
		
		this.urlString = url;
		return this;
	}
	
	public String getUrl() {
		return urlString;
	}
}
