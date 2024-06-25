package application;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

import application.input.TextFileReader;
import application.output.FoundWriter;
import application.textSearch.AlgoResolver;
import application.textSearch.BrutAlgo;
import application.textSearch.MorrisPrattAlgo;
import domain.usecase.ITextReaderInput;
import domain.usecase.IWriterOutput;
import domain.usecase.TextReaderUse;
import domain.value.FoundMotif;

public class Main {
    public static void main(String[] args) {
        ITextReaderInput reader1 = new TextFileReader("test.txt");
        TextReaderUse textRepository = new TextReaderUse();
        IWriterOutput brutWriter = new FoundWriter("output_brut.txt");
        IWriterOutput morrisPrattWriter = new FoundWriter("output_morris_pratt.txt");
        AlgoResolver brutResolver = new AlgoResolver(new BrutAlgo());
        AlgoResolver morrisPrattResolver = new AlgoResolver(new MorrisPrattAlgo());

        reader1.readText(textRepository);

        // BRUT

        Instant start = Instant.now();
        ArrayList<FoundMotif> foundForBrut = brutResolver.searchPattern("ATAATATA", textRepository.getTexts().get(0).getValue().get(0));
        Instant end = Instant.now();
        
        for (FoundMotif found : foundForBrut) {
            brutWriter.writeFound(found.toString() + "\n");
        }

        System.out.println("Time duration Brut force : " + Duration.between(start, end).toMillis() + " ms\n" + foundForBrut.size() + " iteration of the motif has been found");
        brutWriter.writeFound("Time duration Brut force : " + Duration.between(start, end).toMillis() + " ms\n");
        brutWriter.writeFound(foundForBrut.size() + " iteration of the motif has been found");

        // MORRIS PRATT

        start = Instant.now();
        ArrayList<FoundMotif> foundForMorrisPratt = morrisPrattResolver.searchPattern("ATAATATA", textRepository.getTexts().get(0).getValue().get(0));
        end = Instant.now();

        for (FoundMotif found : foundForMorrisPratt) {
            morrisPrattWriter.writeFound(found.toString() + "\n");
        }

        System.out.println("Time duration Morris Pratt : " + Duration.between(start, end).toMillis() + " ms\n" + foundForMorrisPratt.size() + " iteration of the motif has been found");
        morrisPrattWriter.writeFound("Time duration Morris Pratt : " + Duration.between(start, end).toMillis() + " ms\n");
        morrisPrattWriter.writeFound(foundForMorrisPratt.size() + " iteration of the motif has been found");
    }
}