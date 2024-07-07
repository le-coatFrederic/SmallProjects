package webcrawler.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class Queue {
    private static Queue INSTANCE;
    List<String> urlsToVisit;

    private Queue() {
        this.urlsToVisit = new ArrayList<>();
    }

    public static Queue getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Queue();
        }

        return INSTANCE;
    }

    public String getNextUrl() {
        String url = this.urlsToVisit.getFirst();
        this.urlsToVisit.removeFirst();
        return url;
    }
    
}
