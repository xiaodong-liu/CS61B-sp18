public class LinkedListDeque<T> implements Deque<T> {
    private class TNode {
        private T item;
        private TNode next;
        private TNode prev;

        private TNode(T value, TNode prev, TNode next) {
            item = value;
            this.next = next;
            this.prev = prev;
        }
    }

    private TNode sentinel;
    private TNode last;
    private int size;

    public LinkedListDeque() {
        sentinel = new TNode(null, null, null);
        last = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        size += 1;
        TNode temp = new TNode(item, sentinel, sentinel.next);
        if (sentinel.next != null) {
            sentinel.next.prev = temp;
        }
        sentinel.next = temp;
        if (this.size() == 1) {
            last = sentinel.next;
        }
    }

    @Override
    public void addLast(T item) {
        size += 1;
        last.next = new TNode(item, last, null);
        last = last.next;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        TNode p = sentinel.next;
        while (p != null) {
            System.out.print(p.item);
            System.out.print(" ");
            p = p.next;
        }
    }

    @Override
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        size -= 1;
        TNode p = sentinel.next;
        if (p.next == null) {
            sentinel.next = null;
            last = sentinel;
            p.prev = null;
            p.next = null;
        } else {
            p.next.prev = sentinel;
            sentinel.next = p.next;
            p.prev = null;
            p.next = null;
        }
        return p.item;
    }

    @Override
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        size -= 1;
        TNode p = last;
        last = last.prev;
        last.next = null;
        p.prev = null;

        return p.item;
    }

    @Override
    public T get(int index) {
        TNode p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        if (size < index + 1) {
            return null;
        }
        return getRecursive(sentinel.next, index);
    }

    private T getRecursive(TNode p, int index) {
        if (index == 0) {
            return p.item;
        }
        return getRecursive(p.next, index - 1);
    }
}
