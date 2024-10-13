import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static class Trienode {
        Map<Character, Trienode> childNode = new HashMap<>();
        boolean isLast;

        Trienode() {
        }

        public void insert (String word) {
            Trienode trieNode = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                trieNode.childNode.putIfAbsent(c, new Trienode());
                trieNode = trieNode.childNode.get(c);

                if (i == word.length()-1) {
                    trieNode.isLast = true;
                    return;
                }
            }
        }

        public boolean contains (String word) {
            Trienode trieNode = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                Trienode node = trieNode.childNode.get(c);

                if (node == null) {
                    return false;
                }
                trieNode = node;
            }

            if (trieNode.isLast) {
                if (trieNode.childNode.isEmpty()) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Trienode trie = new Trienode();
            boolean isConsistent = true;

            List<String> keyList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                String str = br.readLine();
                trie.insert(str);
                keyList.add(str);
            }

            for (String key : keyList) {
                if (trie.contains(key)) {
                    isConsistent = false;
                    break;
                }
            }

            if (isConsistent) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
