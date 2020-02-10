package hw2;

import java.util.Random;

public class PercolationStats {
    private int[] count;
    private Percolation per;
    private Random random;
    private int numbers;
    private int N;

    //perform T independent experiments on an N-by-N grid
    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException("Either N or T is illegal");
        }
        this.N = N;
        numbers = T;
        random = new Random();
        count = new int[T];
        int x = random.nextInt(N);
        int y = random.nextInt(N);

        for (int i = 0; i < T; i++) {
            per = pf.make(N);
            while (!per.percolates()) {
                while (per.isOpen(x, y)) {
                    x = random.nextInt(N);
                    y = random.nextInt(N);
                }
                per.open(x, y);
                count[i] += 1;
            }
        }

    }

    //sample mean of percolation threshold
    public double mean() {
        double sum = 0;
        for (int i = 0; i < numbers; i++) {
            sum += count[i];
        }

        return sum / numbers / (N * N);

    }

    //sample standard deviation of percolation threshold
    public double stddev() {
        double miu = mean();
        double sigma = 0;
        for (int i = 0; i < numbers; i++) {
            sigma += (count[i] - miu) * (count[i] - miu);
        }

        return Math.sqrt(sigma / (numbers - 1));

    }

    //low endpoint of 95% confidence interval
    public double confidenceLow() {
        double miu = mean();
        double sigma = stddev();

        return miu - 1.96 * sigma / Math.sqrt(numbers);
    }

    //high endpoint of 95% confidence interval
    public double confidenceHigh() {
        double miu = mean();
        double sigma = stddev();

        return miu + 1.96 * sigma / Math.sqrt(numbers);
    }
}
