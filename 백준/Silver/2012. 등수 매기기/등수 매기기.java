import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long answer = 0;
//        System.out.println(n);
        int[] arr = new int[n+1];
        arr[0] = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        for (int i = 1; i <= n; i++) {
            answer += Math.abs(arr[i]-i);
        }
        System.out.println(answer);
    }
}
