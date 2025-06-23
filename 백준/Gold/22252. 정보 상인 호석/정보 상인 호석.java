import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long answer;
    static Map<String, PriorityQueue<Integer>> map;
    public static void main(String[] args) throws Exception{
            init();
        }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new HashMap<>();
        N = Integer.parseInt(br.readLine());
        answer = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if (command == 1) {
                // 정보를 추가하는 경우
                String name = st.nextToken();

                int cnt = Integer.parseInt(st.nextToken());
                PriorityQueue<Integer> temp = map.getOrDefault(name, new PriorityQueue<>((a, b) -> b - a));
                for (int j = 0; j < cnt; j++) {
                    temp.add(Integer.parseInt(st.nextToken()));
                }
                map.put(name, temp);
            } else {
                String name = st.nextToken();
                int cnt = Integer.parseInt(st.nextToken());
                if (map.containsKey(name)) {
                    while (!map.get(name).isEmpty() && cnt != 0) {
                        cnt--;
                        answer += map.get(name).poll();
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
