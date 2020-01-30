public class ArrayDeque<T> {
    private T[] items;
    private int rear;
    private int front;
    private int size;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        rear = 0;
        front = items.length - 1;
        size = 0;
    }

    //add an item at the first position
    public void addFirst(T item) {
        items[front] = item;
        if (--front == -1) {
            front = items.length - 1;
        }
        size += 1;
        if (size == items.length) {
            resize(items.length * 2);
        }
    }

    //add an item at the last position
    public void addLast(T item) {
        items[rear] = item;
        size += 1;
        rear = (rear + 1) % items.length;
        if (size == items.length) {
            resize(items.length * 2);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int temp = (front + 1) % items.length;
        for (int i = 0; i < size; i++) {
            System.out.print(items[temp]);
            System.out.print(" ");
            temp = (temp + 1) % items.length;
        }
    }

    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        size -= 1;
        front = (front + 1) % items.length;
        T temp = items[front];
        items[front] = null;
        if (size < items.length / 4) {
            resize(items.length / 2);
        }
        return temp;
    }

    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        size -= 1;
        rear = rear - 1;
        if (rear == -1) {
            rear = items.length - 1;
        }
        T temp = items[rear];
        items[rear] = null;
        if (size < items.length / 4) {
            resize(items.length / 2);
        }
        return temp;
    }

    public T get(int index) {
        int temp = (front + 1) % items.length;
        temp = (temp + index) % items.length;
        return items[temp];
    }

    private void resize(int capacity) {
        if (capacity < 8) {
            return;
        }
        T[] a = (T[]) new Object[capacity];
        int temp = (front + 1) % items.length;
        for (int i = 0; i < size; i++) {
            a[i] = items[temp];
            temp = (temp + 1) % items.length;
        }
        items = a;
        front = items.length - 1;
        rear = size;
    }


}
