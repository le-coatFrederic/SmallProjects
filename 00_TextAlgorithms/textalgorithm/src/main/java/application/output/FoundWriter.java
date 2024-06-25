package application.output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import domain.usecase.IWriterOutput;

public class FoundWriter implements IWriterOutput{
    File file;
    BufferedWriter writer;

    public FoundWriter(final String filepath) {
        if (filepath == null || filepath.isBlank()) {
            throw new IllegalArgumentException();
        }

        try {
            this.file = new File(filepath);
            this.file.delete();
            this.writer = new BufferedWriter(new FileWriter(this.file));   
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        
        System.out.println("Vous pouvez voir le retour dans ce fichier : " + file.getAbsolutePath());
    }

    @Override
    public void writeFound(String toWrite) {
        try {
            this.writer.write(toWrite);
            this.writer.flush();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    
}
