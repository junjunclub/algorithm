import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[] answer;
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        // 1. 현재 칸이 방문했던 칸일 경우에 기록하고 break
        // 2. 순회
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        answer = new int[n];
        String str = br.readLine();

        for (int i = 0; i < n; i++) {
            visited = new int[n];
            move(str, i);
        }

        int sum = 0;
        for (int i: answer)
            sum += i;
//        System.out.println("answer : "+Arrays.toString(answer));
        System.out.println(sum);
    }

    public static void move(String str, int i) {
        if (answer[i] == 1) {
            return;
        }

        if (visited[i] == 1) {
            answer[i] = 1;
            return;
        }

        if (str.charAt(i) == 'E') {
            visited[i] = 1;
            move(str, i+1);
        } else {
            visited[i] = 1;
            move(str, i-1);
        }
    }
}
