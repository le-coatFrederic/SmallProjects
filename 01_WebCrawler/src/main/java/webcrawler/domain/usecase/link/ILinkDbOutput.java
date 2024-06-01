package webcrawler.domain.usecase.link;

import webcrawler.domain.entities.Link;

public interface ILinkDbOutput {
    public void saveLink(Link linkToSave);
    public void updateLink(int linkToUpdateId, Link newLink);
}