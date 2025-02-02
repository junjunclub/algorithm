import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class TrieNode {
        Map<String, TrieNode> childNode = new HashMap<>();
    }

    static int n;
    static TrieNode root;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        print(root, "");
        System.out.println(sb);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        sb = new StringBuilder();
        root = new TrieNode();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            TrieNode cur = root;
            for (int j = 0; j < k; j++) {
                String s = st.nextToken();

                if (!cur.childNode.containsKey(s)) {
                    cur.childNode.put(s, new TrieNode());
                }
                cur = cur.childNode.get(s);
            }
        }
    }

    private static void print(TrieNode node, String str) {
        ArrayList<String> list = new ArrayList<>(node.childNode.keySet());
        Collections.sort(list);

        for (String s : list) {
            sb.append(str).append(s).append("\n");
            print(node.childNode.get(s), str+"--");
        }
    }
}
