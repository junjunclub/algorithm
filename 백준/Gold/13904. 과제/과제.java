import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<homework> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            list.add(new homework(day, score));
        }

        Collections.sort(list, Comparator.comparingInt(o -> o.day));
        Queue<Integer> q = new PriorityQueue<>();
        for (homework hw : list) {
            q.add(hw.score);
            if (q.size() > hw.day) {
                q.poll();
            }
        }

        answer = 0;
        while (!q.isEmpty()) {
            answer += q.poll();
        }
        System.out.println(answer);
    }
}
class homework {
    int day;
    int score;

    homework(int day, int score) {
        this.day = day;
        this.score = score;
    }
}
