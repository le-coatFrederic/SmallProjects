package application.textSearch;

import java.util.ArrayList;

import domain.usecase.ITextSearchPattern;
import domain.value.FoundMotif;

public class AlgoResolver implements ITextSearchPattern {
    private IAlgoResolver resolver;

    public AlgoResolver(IAlgoResolver resolver) {
        if (resolver == null) {
            throw new IllegalArgumentException();
        }

        this.resolver = resolver;
    }

    @Override
    public ArrayList<FoundMotif> searchPattern(String motif, String target) {
        ArrayList<FoundMotif> founds = new ArrayList<>();
        founds = resolver.search(motif, target);

        return founds;
    }
    
}
