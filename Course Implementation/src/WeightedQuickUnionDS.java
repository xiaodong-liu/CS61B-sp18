public class WeightedQuickUnionDS implements DisjointSets {
    private int[] parent;
    private int[] size;

    public WeightedQuickUnionDS(int N) {
        parent = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    private int find(int q) {
        if (q == parent[q]) {
            return q;
        } else {
            parent[q] = find(parent[q]);
            return parent[q];
        }
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void connect(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) {
            return;
        }
        if (size[i] > size[j]) {
            parent[j] = i;
            size[i] += size[j]
        } else {
            parent[i] = j;
            size[j] += size[i];
        }
    }
}
