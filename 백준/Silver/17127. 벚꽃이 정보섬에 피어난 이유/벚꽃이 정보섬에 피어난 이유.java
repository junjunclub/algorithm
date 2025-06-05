import java.util.Scanner;

public class Main {

    static int[] p = new int[20];
    static int n;

    static int go(int l, int r) {
        int x = 1;
        for (int i = l; i <= r; i++) {
            x *= p[i];
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
        }

        int ans = 0;
        int val;

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    val = go(1, i) + go(i + 1, j) + go(j + 1, k) + go(k + 1, n);
                    ans = Math.max(ans, val);
                }
            }
        }

        System.out.println(ans);
    }
}
