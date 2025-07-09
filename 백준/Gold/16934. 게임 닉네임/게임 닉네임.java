import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception{
            init();
        }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Trie16934 trie = new Trie16934();
        for (int i = 0; i < N; i++) {
            String input = trie.insert(br.readLine());
            System.out.println(input);
        }
    }
}

class Node16934 {
    Map<Character, Node16934> child = new HashMap<>();
    int isEndCnt = 0;
}

class Trie16934 {
    Node16934 root = new Node16934();

    public String insert (String in) {
        Node16934 node = root;
        StringBuilder sb = new StringBuilder();
        boolean endFlag = false;

        for (int i = 0; i < in.length(); i++) {
            if (node.child.get(in.charAt(i)) != null) {
                node = node.child.get(in.charAt(i));
                sb.append(in.charAt(i));
            } else {
                Node16934 next = new Node16934();
                node.child.put(in.charAt(i), next);
                node = next;

                if (!endFlag) {
                    endFlag = true;
                    sb.append(in.charAt(i));
                }
            }
        }

        if (node.isEndCnt == 0) {
            node.isEndCnt = 1;
            return sb.toString();
        } else {
            node.isEndCnt++;
            return sb.append(node.isEndCnt).toString();
        }
    }
}