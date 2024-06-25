package webcrawler.domain.usecase.link;

import webcrawler.domain.entities.Link;

public interface ILinkDbInput {
    public Link getLink(int id);
    public int getNumberOfLink();
}
