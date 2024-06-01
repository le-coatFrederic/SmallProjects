package domains.entities.text;

import java.util.UUID;

public interface ITextDataManager {
	public Text createText(String id);
	public Text updateText(String id, String newText);
	public void removeText(String id);
	public Text detailText(String id);
}
