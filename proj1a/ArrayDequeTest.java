public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> test = new ArrayDeque<>();
        for (int i = 0; i < 16; i++) {
            test.addFirst(i);
        }
        for (int i = 0; i < 10; i++) {
            test.removeLast();
        }
    }
}
