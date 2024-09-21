import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            String T = st.nextToken();
            String N = st.nextToken();
            int n = Integer.parseInt(N);

            char[] num = N.toCharArray();
            ArrayList<Integer> list = new ArrayList<>();

            int result;

            if (n == 1 || !isPrime(n)) {
                System.out.println(T+ " "+ N + " NO");
                continue;
            }

            while (true) {
                result = 0;

                for (int j = 0; j < num.length; j++) {
                    result += (num[j]-48) * (num[j]-48);
                }

                if (list.contains(result) || result == 1) {
                    break;
                }

                list.add(result);
                num = String.valueOf(result).toCharArray();
            }

            if (result == 1) {
                System.out.println(T+ " "+ N + " YES");
            } else {
                System.out.println(T+ " "+ N + " NO");
            }
        }
    }
    public static boolean isPrime(int n) {
        boolean b = true;
        for (int i = 2; i < Math.sqrt(n)+1; i++) {
            if (n % i == 0) {
                b = false;
            }
        }
        return b;
    }
}
