package domains.usecase.text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import domains.entities.text.ITextDataManager;
import domains.entities.text.Text;

public class TextHashMapDataManager implements ITextDataManager {
	private HashMap<String,Text> texts;
	private ITextOperation operations;
	private ITextReader reader;
	
	public TextHashMapDataManager(ITextOperation operationManager, ITextReader readerManager) {
		texts = new HashMap<String, Text>();
		this.operations = operationManager;
		this.reader = readerManager;
	}
	
	public ITextOperation getOperation() {
		return operations;
	}
	
	public ITextReader getReader() {
		return reader;
	}
	
	@Override
	public Text createText(String id) {
		Text newText = reader.createText().setId(id);
		texts.put(newText.getId(), newText);
		return newText;
	}

	@Override
	public Text updateText(String id, String newText) {
		Text text = texts.get(id);
		
		if (text == null) {
			throw new IllegalArgumentException();
		}
		
		text.setValue(newText);
		return text;
	}

	@Override
	public void removeText(String id) {
		texts.remove(id);
	}

	@Override
	public Text detailText(String id) {
		Text text = texts.get(id);
		
		if (text == null) {
			throw new IllegalArgumentException();
		}
		
		return text;
	}

}
