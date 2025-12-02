import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        str = br.readLine();

        Map<Integer, String> map = new HashMap<>();


        String temp = str;

        int cycle = 0;

        for (int i = 0; i <= N; i++) {
            if (i > 0 && temp.equals(str)) {
                cycle = i;
                break;
            }

            map.put(i, temp);
            temp = change(temp);
        }

        if (cycle == 0) {
        System.out.println(map.get(N));
            return;
        }

        int count = N % cycle;

        System.out.println(map.get(count));
    }

    private static String change(String str) {
        StringBuilder sb = new StringBuilder();

        int length = str.length();

        for (int i = 0; i < length; i += 2) {
            sb.append(str.charAt(i));
        }

        int start = (length % 2 == 0) ? length - 1 : length - 2;
        for (int i = start; i >= 1; i -= 2) {
            sb.append(str.charAt(i));
        }
//        System.out.println(sb);
        return sb.toString();
    }
}