package domain.value;

public class FoundMotif {
    //private Text motif;
    //private Text target;
    private int index;
    
    public FoundMotif(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }

        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FoundMotif{");
        sb.append("index=").append(index);
        sb.append('}');
        return sb.toString();
    }
}
