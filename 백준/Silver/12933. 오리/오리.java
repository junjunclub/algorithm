import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] duck = {'q', 'u', 'a', 'c', 'k'};
        char[] ch = br.readLine().toCharArray();
        boolean[] visited = new boolean[ch.length];
        int idx = 0;
        int cnt = 0;
        if (ch[0] != 'q' || ch.length % 5 != 0) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < ch.length; i++) {
            List<Character> list = new ArrayList<>();
            for (int j = i; j < ch.length; j++) {
                if (!visited[j] && ch[j] == duck[idx]) {
                    idx++;
                    visited[j] = true;
                    list.add(ch[j]);

                    if (idx == 5) {
                        idx = 0;
                    }
                }
            }

            if (list.size() != 0) {
                if (list.get(list.size() - 1) != 'k') {
                    System.out.println(-1);
                    return;
                }
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
