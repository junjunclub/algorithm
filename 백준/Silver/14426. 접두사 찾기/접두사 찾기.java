import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Trie head = new Trie();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            Trie idxTrie = head;
            for (int j = 0; j < word.length(); j++) {
                char alphabet = word.charAt(j);
                if (!idxTrie.children.containsKey(alphabet)) {
                    idxTrie.children.put(alphabet, new Trie(alphabet));
                }
                idxTrie = idxTrie.children.get(alphabet);
            }
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            String word = br.readLine();
            Trie idxTrie = head;

            for (int j = 0; j < word.length(); j++) {
                char alphabet = word.charAt(j);

                if (!idxTrie.children.containsKey(alphabet)) {
                    break;
                } else {
                    idxTrie = idxTrie.children.get(alphabet);
                    if (j == word.length() - 1) {
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);

    }
    static class Trie {
        char alphabet;
        Map<Character, Trie> children = new HashMap<>();

        public Trie(char alphabet) {
            this.alphabet = alphabet;
        }

        public Trie() {

        }
    }
}
