package webcrawler.application.crawler;

import java.io.IOException;

import javax.swing.text.html.parser.Element;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import webcrawler.domain.entities.Site;
import webcrawler.domain.usecase.crawler.IWebCrawler;
import webcrawler.domain.values.PageBody;
import webcrawler.domain.values.PageHead;
import webcrawler.domain.values.URL;

public class WebCrawlerJSoup implements IWebCrawler {
    private Connection connection;
    private Document document;

    @Override
    public Site getSite(URL url) {
        Site siteToVisit = new Site(url);
        request(url.getUrl());
        siteToVisit = createSite(url, document);

        return siteToVisit;
    }

    public void request(String url) {
        try {
            connection = Jsoup.connect(url);
            if (connection.response().statusCode() == 200) {
                document = connection.get();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public Site createSite(URL url, Document document) {
        Site siteToSend = new Site(url);
        PageHead head = new PageHead();
        PageBody body = new PageBody();

        if (url == null || document == null) {
            throw new IllegalArgumentException();
        }

        head.setAuthor(document.select("meta[author]").attr("author"));
        head.setCharset(document.select("html").attr("lang"));
        head.setKeywords(document.select("meta[name]").attr("keywords"));
        head.setLanguage(document.select("meta[name]").attr("author"));
        head.setTitle(document.select("title").text());

        for (org.jsoup.nodes.Element element : document.select("body")) {
            if (element != null) {
                body.addBody(element.html());
            }
        }

        siteToSend.setHead(head).setBody(body);
        return siteToSend;
    }
}
