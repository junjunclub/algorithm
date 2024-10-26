import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        System.out.println(canCalculate(list));
    }

    private static Integer canCalculate(int[] list) {
        int target = 1;
        for (int i = 0; i < list.length; i++) {
            if (list[i] <= target) {
                target += list[i];
            } else {
                break;
            }
        }
        return target;
    }
}
