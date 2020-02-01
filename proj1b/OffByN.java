public class OffByN implements CharacterComparator {
    private int N;

    public OffByN(int N) {
        this.N = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int off = x - y;

        if (off == N || -off == N) {
            return true;
        } else {
            return false;
        }
    }
}
