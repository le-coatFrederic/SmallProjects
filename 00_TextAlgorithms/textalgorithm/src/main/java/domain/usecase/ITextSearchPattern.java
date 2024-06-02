package domain.usecase;

import java.util.ArrayList;

import domain.value.FoundMotif;

public interface ITextSearchPattern {
    public ArrayList<FoundMotif> searchPattern(String motif, String target);
}
