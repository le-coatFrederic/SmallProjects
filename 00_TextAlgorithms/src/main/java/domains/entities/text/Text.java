package domains.entities.text;

import java.util.UUID;

public class Text {
	private String id;
	private String textValue;
	
	public Text(String id, ITextDataManager dataManager) {
		this.id = id;
	}
	
	public Text setId(final String id) {
		if(id == null) {
			throw new IllegalArgumentException();
		}
		
		this.id = id;
		return this;
	}
	
	public Text setValue(final String value) {
		if (value == null) {
			throw new IllegalArgumentException();
		}
		
		this.textValue = value;
		return this;
	}
	
	public String getId() {
		return id;
	}
	
	public String getValue() {
		return textValue;
	}
	
	@Override
	public String toString() {
		return id + " : " + textValue;
	}
}
