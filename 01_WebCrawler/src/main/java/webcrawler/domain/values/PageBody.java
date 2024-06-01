package webcrawler.domain.values;

import java.util.ArrayList;

public class PageBody {
	private ArrayList<String> body = new ArrayList<String>();

	public PageBody() {
	}

	public synchronized void addBody(String content) {
		if (content == null) {
			throw new IllegalArgumentException();
		}

		body.add(content);
	}

	public synchronized ArrayList<String> getBody() {
		return body;
	}
}
