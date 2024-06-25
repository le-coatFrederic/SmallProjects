package domain.entity;

import java.util.ArrayList;
import java.util.UUID;

public class Text {
    private final UUID id;
    private final ArrayList<String> value;
    private int lenght;

    public Text() {
        id = UUID.randomUUID();
        value = new ArrayList<>();
        lenght = 0;
    }

    public void addString(final String word) {
        if (word == null) {
            throw new IllegalArgumentException();
        }

        value.add(word);
        lenght += word.length();
    }

    public UUID getId() {
        return id;
    }

    public ArrayList<String> getValue() {
        return value;
    }

    public int getLenght() {
        return lenght;
    }
}
