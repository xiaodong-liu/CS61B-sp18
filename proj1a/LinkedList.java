public class LinkedList {
    public static void main(String[] args) {
        LinkedListDeque<Integer> T = new LinkedListDeque<>();
        T.addLast(0);
        T.addFirst(1);
        T.printDeque();
        boolean a = T.isEmpty();
        boolean b = T.isEmpty();
        Integer c = T.removeLast();
        T.addFirst(5);
        T.addFirst(6);
        T.addLast(7);
        T.printDeque();
        Integer d = T.removeLast();
        T.printDeque();
    }
}
