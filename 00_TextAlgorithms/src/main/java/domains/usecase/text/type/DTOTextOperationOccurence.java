package domains.usecase.text.type;

import java.util.ArrayList;

public class DTOTextOperationOccurence {
	private ArrayList<TextAssociationIndice> occurences;
	
	public DTOTextOperationOccurence() {
		occurences = new ArrayList<TextAssociationIndice>();
	}
	
	public ArrayList<TextAssociationIndice> getOccurences() {
		return occurences;
	}
	
	public void addOccurence(TextAssociationIndice occurence) {
		if (occurence == null) {
			throw new IllegalArgumentException();
		}
		
		this.occurences.add(occurence);
	}
	
	public String toString() {
		String exit = "";
		
		for (TextAssociationIndice occurence : occurences) {
			exit += "{" + occurence.toString() + "}\n";
		}
		
		return exit;
	}
}
