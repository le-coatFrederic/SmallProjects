package domain.usecase;

import java.util.ArrayList;

import domain.entity.Text;

public class TextReaderUse {
    ArrayList<Text> texts;

    public TextReaderUse() {
        this.texts = new ArrayList<>();
    }

    public void addText(Text text) {
        if (text == null) {
            throw new IllegalArgumentException();
        }

        texts.add(text);
    }

    public ArrayList<Text> getTexts() {
        return texts;
    }
}
