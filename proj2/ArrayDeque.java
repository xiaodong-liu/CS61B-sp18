public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = items.length / 2;
        nextLast = nextFirst + 1;
    }

    public void resizebig(int cap) {
        T[] a = (T[]) new Object[cap];
        System.arraycopy(items, nextLast, a, a.length / 2, items.length - nextLast);
        System.arraycopy(items, 0, a, a.length / 2 + items.length - nextLast, nextLast);
        nextFirst = a.length / 2 - 1;
        nextLast = a.length + items.length;
        items = a;
    }

    public void addFirst(T item) {
        if (items.length == size) {
            resizebig(size * 4);
        }
        items[nextFirst] = item;
        size += 1;
        if (nextFirst == 0) {
            nextFirst = items.length - 1;
        } else {
            nextFirst -= 1;
        }
    }

    public void addLast(T item) {
        if (items.length == size) {
            resizebig(size * 4);
        }
        items[nextLast] = item;
        size += 1;
        if (nextLast == items.length - 1) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
