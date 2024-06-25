package application.textSearch;

import java.util.ArrayList;

import domain.value.FoundMotif;

public class BrutAlgo implements IAlgoResolver {
    
    @Override
    public ArrayList<FoundMotif> search(String motif, String target) {
        if (motif == null || target == null) {
            throw new IllegalArgumentException();
        }

        ArrayList<FoundMotif> founds = new ArrayList<>();

        int longMotif = motif.length();
        int longText = target.length();
        int scannedCharacter = 0;
        boolean isId;

        if (longMotif > longText) {
            return founds;
        }

        for (int i = 0; i < longText - longMotif + 1; i++) {
            scannedCharacter = 0;
            isId = true;

            while (scannedCharacter < longMotif && isId) {
                if (target.charAt(i + scannedCharacter) == motif.charAt(scannedCharacter)) {
                    scannedCharacter++;
                } else {
                    isId = false;
                }
            }

            if (scannedCharacter >= longMotif) {
                founds.add(new FoundMotif(i));
            }
        }

        return founds;
    }
}
