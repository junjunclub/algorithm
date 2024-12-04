import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int s = Integer.parseInt(br.readLine());
        Map<Integer, Integer> repre = new LinkedHashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) {
            int num = Integer.parseInt(st.nextToken());
            // 이미 존재하는 경우
            if (repre.containsKey(num)) {
                repre.put(num, repre.get(num) + 1); // 값을 1 증가
            } else {
                // 존재하지 않는 경우
                if (repre.size() == n) {
                    // 사진을 교체해야 하는 경우
                    int minId = repre.entrySet().stream()
                            .min(Map.Entry.comparingByValue())
                            .get()
                            .getKey();
                    repre.remove(minId);
                }
                // 새로운 사진 추가
                repre.put(num, 1);
            }
        }
        repre.keySet().stream().sorted().forEach(id -> System.out.print(id + " "));
    }
}
