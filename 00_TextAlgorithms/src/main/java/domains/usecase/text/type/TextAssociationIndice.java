package domains.usecase.text.type;

import domains.entities.text.Text;

public class TextAssociationIndice {
	private int start;
	private Text text;
	private Text motif;
	
	public TextAssociationIndice(int start, Text text, Text motif) {
		this.start = start;
		this.text = text;
		this.motif = motif;
	}
	
	public int getStart() {
		return this.start;
	}
	
	public Text getText() {
		return text;
	}
	
	public Text getMotif() {
		return motif;
	}
	
	public String toString() {
		return "Found " + motif + " at position " + start;
	}
}
