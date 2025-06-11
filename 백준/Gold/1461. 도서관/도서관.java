import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.LinkedList;

public class Main {
    static int N, M, result;
    static Queue<Integer> minus, plus, answer;
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        while (!minus.isEmpty()) {
            int temp = 0;
            int cnt = 0;
            while(cnt != M) {
                temp = Math.max(temp, minus.poll());
                cnt++;
                if (minus.isEmpty()) {
                    break;
                }
            }
            answer.add(temp);
        }

        while (!plus.isEmpty()) {
            int temp = 0;
            int cnt = 0;
            while(cnt != M) {
                temp = Math.max(temp, plus.poll());
                cnt++;
                if (plus.isEmpty()) {
                    break;
                }
            }
            answer.add(temp);
        }
        
        result = 0;
        
        while (!answer.isEmpty()) {
            if (answer.size() == 1) {
                result += answer.poll();
            } else {
                result += answer.poll() * 2;
            }
        }
        System.out.println(result);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        minus = new PriorityQueue<>((a, b) -> b-a);
        plus = new PriorityQueue<>((a, b) -> b-a);
        answer = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num > 0) {
                plus.add(num);
            } else {
                minus.add(Math.abs(num));
            }
        }
    }
}
