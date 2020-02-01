public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        int x_ascii = Integer.valueOf(x);
        int y_ascii = Integer.valueOf(y);
        if (x_ascii - y_ascii == 1 || x_ascii - y_ascii == -1) {
            return true;
        }
        return false;
    }
}
