import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static StringBuilder sb;
	
	static class Trienode {
		Map<Character, Trienode> childNode = new HashMap<>();
		boolean isLast;
		
		public void insert (String str) {
			Trienode trieNode = this;
			
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				
				trieNode.childNode.putIfAbsent(c, new Trienode());
				trieNode = trieNode.childNode.get(c);
				
				if (i == str.length() - 1) {
					trieNode.isLast = true;
				}
			}
		}		
		
		public int search (String str) {
			int cnt = 0;
			
			Trienode trieNode = this;
			
			for (int i = 0; i < str.length(); i++) {
				Trienode node = trieNode.childNode.get(str.charAt(i));
				
				if (i == 0) {
					cnt++;
				} else if (trieNode.isLast || trieNode.childNode.size() > 1) {
					cnt++;
				}
				
				
				trieNode = node;
			}
			
			return cnt;
		}
	}
	
	public static void main (String[] args) throws Exception{
		init();
		solve();
	}
	
	private static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		String input;
		
		
		while ((input = br.readLine()) != null) {
			N = Integer.parseInt(input);
			
			Trienode trieNode = new Trienode();
			List<String> list = new ArrayList<>();
			
			double ans = 0;
			
			for (int i = 0; i < N; i++) {
				String word = br.readLine();
				trieNode.insert(word);
				list.add(word);
			}
			
			for (int i = 0; i < N; i++) {
				ans += trieNode.search(list.get(i));
			}
			
			sb.append(String.format("%.2f\n", ans / N));
		}
	}
	
	private static void solve() {
		System.out.println(sb);
	}
}
