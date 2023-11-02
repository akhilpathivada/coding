package dp;

public class SuperEggDrop {

    private int f(int k, int n) {
        // base case
        if (n == 1) {
            return k;
        }
        if (k == 0 || k == 1) {
            return k;
        }
        int min = Integer.MAX_VALUE;
        for (int x = 1; x <= k; ++x) {
            min = Math.min(min, Math.max(f(x - 1, n - 1), 1 + f(n, k - x)));
        }
        return min;
    }

    private int superEggDrop(int k, int n) {
        System.out.println(f(k, n));
        return 1;
    }

    public static void main(String[] args) {
        int k = 2, n = 6;
        System.out.println(new SuperEggDrop().superEggDrop(k, n));
    }
}
