package application;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

import application.Main.Algo;

public class Main {

    private enum Algo {
        BRUT,
        KMP,
        KMP_IMPROVED,
    };

    private class ResultatAlgo {
        public ArrayList<Integer> positions = new ArrayList<>();
        public int nbOccurenceNonTestee = 0;
        public int nbComparaisonNonTestee = 0;
        public ResultatAlgo(){}

        public String toString() {
            String retour = "";
            retour = "RESULTATS :\b" + positions.forEach((position) -> {
                retour += position;
            });
        }
    }

    private ResultatAlgo startAlgo(Algo algo) {
        ResultatAlgo resultat = new ResultatAlgo();
        switch (algo) {
            case BRUT:
                break;
            case KMP:
                break;
            case KMP_IMPROVED:
                break;
            default:
                throw new AssertionError();
        }

        return resultat;
    }

    public void showResultats(ResultatAlgo resultats) {
        System.out.println(startAlgo(Algo.BRUT));
    }
    public static void main(String[] args) {

        // MORRIS PRATT

        System.out.println(showResultats(startAlgo(Algo.BRUT)));

        Instant start = Instant.now();
        Instant end = Instant.now();

        System.out.println("Time duration Morris Pratt : " + Duration.between(start, end).toMillis() + " ms\n" + foundForMorrisPratt.size() + " iteration of the motif has been found");
    }
}