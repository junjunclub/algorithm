import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static String[] arr;
    static StringBuilder sb;
    static int[] visited;
    static Stack<Character> stack = new Stack<>();
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws Exception{
            init();
            solve();
        }

    private static void solve() {
        sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            visited = new int[26];
            list = new ArrayList<>();
            for (int j = 0; j < arr[i].length(); j++) {
                visited[arr[i].charAt(j) - 'a']++;
            }
            backTracking(arr[i].length(), 0);
            Collections.sort(list);
            for (String s : list) {
                sb.append(s).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void backTracking(int n, int depth) {
        if (depth == n) {
            StringBuilder stb = new StringBuilder();
            for (char c : stack) {
                stb.append(c);
            }
            list.add(stb.toString());
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (visited[i] > 0) {
                visited[i]--;
                stack.push((char) (i + 'a'));
                backTracking(n, depth+1);
                stack.pop();
                visited[i]++;
            }
        }
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
    }
}
