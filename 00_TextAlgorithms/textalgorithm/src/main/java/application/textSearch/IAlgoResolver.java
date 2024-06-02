package application.textSearch;

import java.util.ArrayList;

import domain.value.FoundMotif;

public interface IAlgoResolver {
    public ArrayList<FoundMotif> search(String motif, String target);
}
