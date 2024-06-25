package webcrawler.domain.values;

public class PageHead {
	private String languageString = "";
	private String authorString = "";
	private String charsetString = "";
	private String titleString = "";
	private String keywordString = "";

	public PageHead() {}

	public synchronized PageHead setLanguage(String value) {
		if (value == null) {
			throw new IllegalArgumentException();
		}
		
		this.languageString = value;
		return this;
	}

	public synchronized PageHead setAuthor(String value) {
		if (value == null) {
			throw new IllegalArgumentException();
		}
		
		this.authorString = value;
		return this;
	}

	public synchronized PageHead setCharset(String value) {
		if (value == null) {
			throw new IllegalArgumentException();
		}
		
		this.charsetString = value;
		return this;
	}

	public synchronized PageHead setTitle(String value) {
		if (value == null) {
			throw new IllegalArgumentException();
		}
		
		this.titleString = value;
		return this;
	}

	public synchronized PageHead setKeywords(String value) {
		if (value == null) {
			throw new IllegalArgumentException();
		}

		this.keywordString = value;
		return this;
	}
	
	public String getLanguageString() {
		return languageString;
	}

	public String getAuthorString() {
		return authorString;
	}

	public String getCharsetString() {
		return charsetString;
	}

	public String getTitleString() {
		return titleString;
	}

	public String getKeywords() {
		return keywordString;
	}
	
	@Override
	public String toString() {
		return "PageHead [titleString=" + titleString + ", languageString=" + languageString + ", authorString="
				+ authorString + ", charsetString=" + charsetString + ", keywordsString=" + keywordString+ "]";
	}
}
