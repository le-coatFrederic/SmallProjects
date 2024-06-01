package application.text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.UUID;

import domains.entities.text.Text;
import domains.usecase.text.ITextReader;

public class TextReaderFile implements ITextReader {
	private String fileUrl;
	
	public TextReaderFile(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	
	public String getFileUrl() {
		return fileUrl;
	}
	
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	
	@Override
	public String getText() {
		String text = "";
		String tampon = "";
		
		try {
			File document = new File(fileUrl);
			BufferedReader reader = new BufferedReader(new FileReader(document));
		
			while ((tampon = reader.readLine()) != null) {
				text += tampon;
			}
				
			reader.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			throw new IllegalArgumentException();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			throw new IllegalArgumentException();
		}
		
		return text;
	}

	@Override
	public Text createText() {
		Text text = new Text(UUID.randomUUID().toString(), null);
		text.setValue(getText());
		return text;
	}

}
