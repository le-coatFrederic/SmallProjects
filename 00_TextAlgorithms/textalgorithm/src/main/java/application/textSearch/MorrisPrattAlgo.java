package application.textSearch;

import java.util.ArrayList;

import domain.value.FoundMotif;

public class MorrisPrattAlgo implements IAlgoResolver {
    
    @Override
    public ArrayList<FoundMotif> search(String motif, String target) {
        ArrayList<FoundMotif> founds = new ArrayList<>();

        int indexInTarget = 0;
        int indexInMotif = 0;

        int[] prefix = tableauDeBord(motif);

        while (indexInTarget < target.length()) {
            if (motif.charAt(indexInMotif) == target.charAt(indexInTarget)) {
                indexInMotif++;
                indexInTarget++;

                if (indexInMotif == motif.length()) {
                    founds.add(new FoundMotif(indexInTarget - indexInMotif));
                    indexInMotif = prefix[indexInMotif];
                }
            } else {
                indexInMotif = prefix[indexInMotif];
                if (indexInMotif < 0) {
                    indexInMotif++;
                    indexInTarget++;
                }
            }
        }

       return founds;
    }
    
    private int[] tableauDeBord(String motif) {
        int[] aRetourner = new int[motif.length() + 2];

        aRetourner[0] = -1;
        aRetourner[1] = 0;

        int prefix = 0;

        for (int i = 1; i < motif.length(); i++) {
            if (motif.charAt(prefix) == motif.charAt(i)) {
                prefix++;
                aRetourner[i + 2] = prefix;
            } else if (prefix > 0) {
                prefix = aRetourner[prefix];
            } else {
                aRetourner[i + 2] = 0;
            }
        }

        return aRetourner;
    }
}
