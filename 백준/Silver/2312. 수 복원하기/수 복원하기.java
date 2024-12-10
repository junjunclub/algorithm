import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int num = n;
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 2; j <= num; j++) {
                if (n % j == 0) {
                    while (n % j == 0) {
                        n /= j;
                        map.put(j, map.getOrDefault(j, 0)+1);
                    }
                }
            }
            List<Integer> list = new ArrayList<>(map.keySet());
            Collections.sort(list);
            for (int k = 0; k < list.size(); k++) {
                sb.append(list.get(k)).append(" ").append(map.get(list.get(k))).append("\n");
            }
        }
        System.out.println(sb);
    }
}
