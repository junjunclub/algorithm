import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br;
    static int n, m;
    static Map<String, List<String>> map;
    public static void main(String[] args) throws Exception {
        init();
        solve();
        /**
         * 1. Map에 다 집어넣고 확인하기
         */
    }

    private static void solve() throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String quiz = br.readLine();
            int quizN = Integer.parseInt(br.readLine());

            if (quizN == 1) {
                // 팀 이름 맞추기
                for (String tName : map.keySet()) {
                    if (map.get(tName).contains(quiz)) {
                        sb.append(tName).append("\n");
                        break;
                    }
                }
            } else {
                // 멤버 이름 출력하기
                List<String> list = map.get(quiz);
                for (String name : list) {
                    sb.append(name).append("\n");
                }
            }
        }
        System.out.println(sb);
    }

    private static void init() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String teamName = br.readLine();
            List<String> list = new ArrayList<>();
            int num = Integer.parseInt(br.readLine());
            for (int j = 0; j < num; j++) {
                list.add(br.readLine());
            }
            Collections.sort(list);
            map.put(teamName, list);
        }
    }
}
