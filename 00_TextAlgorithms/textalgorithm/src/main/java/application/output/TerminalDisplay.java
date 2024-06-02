package application.output;

import domain.entity.Text;
import domain.usecase.ITextDisplay;

public class TerminalDisplay implements ITextDisplay {

    @Override
    public void display(Text textToDisplay) {
        for (String token : textToDisplay.getValue()) {
            System.out.println(token);
        }
        System.out.println("Text id : " + textToDisplay.getId() +
        "\nText lenght : " + textToDisplay.getLenght() +
        "\nNumber of String (Text is an array of String to allow big data) : " + textToDisplay.getValue().size());
    }
    
}
