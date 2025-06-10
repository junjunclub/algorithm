import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static BigInteger end, start, N;
    static String input;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        start = BigInteger.ONE;
        end = N;
        BigInteger mid;
        while (true) {
            mid = start.add(end);
            mid = mid.divide(new BigInteger("2"));

            int result = (mid.multiply(mid)).compareTo(N);

            if (result == 0) {
                break;
            } else if (result == 1) {
                end = mid.subtract(new BigInteger("1"));
            } else {
                start = mid.add(new BigInteger("1"));
            }
        }
        System.out.println(mid);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = new BigInteger(br.readLine());
    }
}
