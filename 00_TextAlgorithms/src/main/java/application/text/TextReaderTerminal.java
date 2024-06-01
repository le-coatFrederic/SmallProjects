package application.text;

import java.util.Scanner;
import java.util.UUID;

import domains.entities.text.ITextDataManager;
import domains.entities.text.Text;
import domains.usecase.text.ITextReader;

public class TextReaderTerminal implements ITextReader {

	@Override
	public String getText() {
		Scanner scanner = new Scanner(System.in);		
		return scanner.next();
	}

	@Override
	public Text createText() {
		Text text = new Text(UUID.randomUUID().toString(), null);
		text.setValue(getText());
		return text;
	}

}
