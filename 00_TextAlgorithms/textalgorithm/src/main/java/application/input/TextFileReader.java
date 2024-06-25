package application.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import domain.entity.Text;
import domain.usecase.ITextReaderInput;
import domain.usecase.TextReaderUse;

public class TextFileReader implements ITextReaderInput {
    private String filepath;

    public TextFileReader(String filepath) {
        if (filepath == null || filepath.isBlank()) {
            throw new IllegalArgumentException();
        }

        this.filepath = filepath;
    }

    @Override
    public void readText(TextReaderUse reader) {
        Text textToRead = new Text();
        try {
            Stream<String> lignes = Files.lines(Paths.get(this.filepath));
            lignes.forEach(param -> textToRead.addString(param));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        reader.addText(textToRead);
    }
}
