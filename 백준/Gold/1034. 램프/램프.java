import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] lamp = new String[n];
        for (int i = 0; i < n; i++) {
            lamp[i] = br.readLine();
        }

        HashMap<String, Integer> map = new HashMap<>();
        int k = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j< m; j++) {
                if (lamp[i].charAt(j) == '0') {
                    count++;
                }
            }

            if (count <= k && count % 2 == k % 2) {
                map.put(lamp[i], map.getOrDefault(lamp[i], 0)+1);
                if (map.get(lamp[i]) > answer) {
                    answer = map.get(lamp[i]);
                }
            }
        }
        System.out.println(answer);
    }
}
