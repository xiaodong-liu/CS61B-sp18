package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[][] site;
    private int N;
    private int count;
    private WeightedQuickUnionUF DS;
    private int up;
    private int bottom;


    //create N-by-N grid, with all sites initiall
    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("Error argument");
        }
        DS = new WeightedQuickUnionUF(N * N + 2);
        up = N * N;
        bottom = N * N + 1;
        this.N = N;
        site = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                site[i][j] = false;
            }
        }
        count = 0;

    }

    //open the site(row, col) if it is not open;
    public void open(int row, int col) {
        isLegal(row, col);
        if (!isOpen(row, col)) {
            count += 1;
            site[row][col] = true;
            connectNeighbours(row, col);

            if (row == 0) {
                DS.union(col, up);
            }

        }
    }

    private void connectNeighbours(int row, int col) {
        int currentIndex = N * row + col;
        if ((row - 1 >= 0) && isOpen(row - 1, col)) {
            DS.union(currentIndex, N * (row - 1) + col);
        }
        if ((row + 1 < N) && isOpen(row + 1, col)) {
            DS.union(currentIndex, N * (row + 1) + col);
        }
        if ((col - 1 >= 0) && isOpen(row, col - 1)) {
            DS.union(currentIndex, N * row + col - 1);
        }
        if ((col + 1 < N) && isOpen(row, col + 1)) {
            DS.union(currentIndex, N * row + col + 1);
        }
    }

    //is the site(row, col) open
    public boolean isOpen(int row, int col) {
        isLegal(row, col);

        return site[row][col];
    }

    //is the site(row, col) full
    public boolean isFull(int row, int col) {
        isLegal(row, col);

        return DS.connected(N * row + col, up);
    }

    //number of open site
    public int numberOfOpenSites() {
        return count;
    }

    //does the system percolate
    public boolean percolates() {
        for (int i = 0; i < N; i++) {
            if (DS.connected(N * (N - 1) + i, up)) {
                return true;
            }
        }
        return false;
    }

    private void isLegal(int row, int col) {
        if (row < 0 || row >= N) {
            throw new IndexOutOfBoundsException("Argument row is out of bound");
        }
        if (col < 0 || col >= N) {
            throw new IndexOutOfBoundsException("Argument col is out of bound");
        }
    }

    public static void main(String[] args) {
        Percolation per = new Percolation(20);

    }
}
