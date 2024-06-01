package domains.usecase.text;

import domains.entities.text.Text;

public interface ITextReader {
	public String getText();
	public Text createText();
}
