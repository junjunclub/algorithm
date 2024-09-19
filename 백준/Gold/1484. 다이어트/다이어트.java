import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int s = 1;
        int e = 2;
        boolean flag = false;

        while (e < 100000) {
            int ss = s * s;
            int ee = e * e;

            int diff = ee - ss;

            if (diff == N) {
                System.out.println(e);
                flag = true;
            }
            if (diff > N) {
                s++;
            } else {
                e++;
            }
        }

        if (!flag) {
            System.out.println(-1);
        }
    }
}
