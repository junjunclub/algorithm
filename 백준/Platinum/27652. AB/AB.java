import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static class Trie {
		Trienode root;
		public Trie () {
			this.root = new Trienode();
		}
		
		public void insert (String input) {
			Trienode trienode = this.root;
			
			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				
				trienode.childNode.putIfAbsent(c, new Trienode());
				trienode = trienode.childNode.get(c);
				
				trienode.cnt++;
			}
			trienode.lastCnt++;
		}
		
		public void insertReverse (String input) {
			Trienode trienode = this.root;
			
			for (int i = input.length() - 1; i >= 0; i--) {
				char c = input.charAt(i);
				
				trienode.childNode.putIfAbsent(c, new Trienode());
				trienode = trienode.childNode.get(c);
				
				trienode.cnt++;
			}
			trienode.lastCnt++;
		}
		
		public boolean delete (String input) {
			boolean result = delete(this.root, input, 0);
			return result;
		}
		
		public boolean deleteReverse (String input) {
			
			StringBuilder sb = new StringBuilder();
			sb.append(input);
			sb.reverse();
			
			boolean result = delete(this.root, sb.toString(), 0);
			return result;
		}
		
		public boolean delete (Trienode trienode, String input, int idx) {
			char c = input.charAt(idx);
			
			if (!trienode.childNode.containsKey(c)) return false;
			
			Trienode cur = trienode.childNode.get(c);
			
			if (idx == input.length() - 1) {
				if (cur.lastCnt == 0) return false;
				cur.cnt--;
				cur.lastCnt--;
				
				if (cur.cnt == 0 && cur.lastCnt == 0 && cur.childNode.isEmpty()) {
					trienode.childNode.remove(c);
				}
				return true;
			}
			
			if (!this.delete(cur, input, idx + 1)) {
				return false;
			}
			
			cur.cnt--;
			
			if (cur.cnt == 0 && cur.lastCnt == 0 && cur.childNode.isEmpty()) {
				trienode.childNode.remove(c);
			}
			
			return true;
		}
		
		public int[] search (String input, boolean isReverse) {
			int[] arr = new int[input.length()];
			Trienode trienode = this.root;
			StringBuilder str = new StringBuilder(input);
			
			if (isReverse) {
				str.reverse();
			}
			
			for (int i = 0; i < input.length(); i++) {
				char c = str.charAt(i);
				trienode = trienode.childNode.get(c);
				if (trienode == null) break;
				arr[i] = trienode.cnt;
			}
			
			return arr;
		}
		
	}
	
	static class Trienode {
		Map<Character, Trienode> childNode = new HashMap<>();
		int lastCnt;
		int cnt;
		
		public Trienode() {
		}
	}
	
    static int N;
    static Trie trieA;
    static Trie trieB;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        System.out.println(sb);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        
        trieA = new Trie();
        trieB = new Trie();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            String target;
            String input;
            int temp = 0;
            switch (command) {
            case "add":
            	
            	target = st.nextToken();
            	input = st.nextToken();
            	
            	if (target.equals("A")) {
            		trieA.insert(input);
            	} else {
            		trieB.insertReverse(input);
            	}
            		
            	break;
            case "delete":
            	target = st.nextToken();
            	input = st.nextToken();
            	
        		if (target.equals("A")) {
            		trieA.delete(input);
            	} else {
            		trieB.deleteReverse(input);
            	}
            	break;
            	
            case "find":
            	target = st.nextToken();
            	
            	if (target.length() <= 1) {
            		sb.append(0).append("\n");
            		continue;
            	}
            	
            	int[] arr1 = trieA.search(target, false);
            	int[] arr2 = trieB.search(target, true);
            	
            	for (int j = 1; j <= target.length() - 1; j++) {
            		int left = arr1[j - 1];
            		int right = arr2[target.length() - 1 - j];
            		temp += left * right;
            	}
            	
            	sb.append(temp).append("\n");
            	break;
            	
            	default:
            		break;
            }
        }
    }
}
