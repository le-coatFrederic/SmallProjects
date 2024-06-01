package application.text;

import domains.entities.text.Text;
import domains.usecase.text.ITextOperation;
import domains.usecase.text.type.DTOTextOperationOccurence;
import domains.usecase.text.type.TextAssociationIndice;

public class TextOperationStupid implements ITextOperation {

	@Override
	public DTOTextOperationOccurence searchOccurence(Text toLookUp, Text toLookIn) {
		if (toLookIn == null || toLookUp == null) {
			throw new IllegalArgumentException();
		}
		
		DTOTextOperationOccurence dto = new DTOTextOperationOccurence();
		
		int longMotif = toLookUp.getValue().length();
		int longText = toLookIn.getValue().length();
		int scannedCharacter;
		boolean estId;
		
		System.out.println("Tester si " + toLookUp.getValue() + " est dans " + toLookIn.getValue());
		
		for (int i = 0; i < longText - longMotif + 1; i++) {
			scannedCharacter = 0;
			estId = true;
			
			while (scannedCharacter < longMotif && estId) {
				if (toLookIn.getValue().charAt(i + scannedCharacter) == toLookUp.getValue().charAt(scannedCharacter)) {
					scannedCharacter++;
				} else {
					estId = false;
				}
			}
			
			if (scannedCharacter >= longMotif) {
				dto.addOccurence(new TextAssociationIndice(i, toLookIn, toLookUp));
			}
		}
		
		return dto;
	}

}
