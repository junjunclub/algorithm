import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 1 2 3 4 5 6 7 8 9       1*9
         * 10 11 12 13 14 ... 99   2*90
         * 100 101 .... 999        3*900
         *
         *
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());

        long numLen = 1;
        long numCount = 9;

        while (m > numLen*numCount) {
            long minus = numLen*numCount;
            m -= minus;
            numLen += 1;
            numCount *= 10;
        }

        m -= 1;

        long num = (long) Math.pow(10, (numLen - 1));
        num += m / numLen;

        if (num > n) {
            System.out.println(-1);
        } else {
            System.out.println(String.valueOf(num).charAt((int) (m % numLen)));
        }
    }
}
