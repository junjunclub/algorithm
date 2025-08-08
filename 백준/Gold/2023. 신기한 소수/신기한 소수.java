import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < 4; i++) {
        	backtracking(0, arr[i]);
        }
        
        System.out.println(sb);
    }
    
    private static void backtracking (int depth, int num) {
    	if (depth == N - 1) {
    		sb.append(num).append("\n");
    		return;
    	}
    	
    	for (int i = 1; i <= 9; i++) {
    		int nextNum = num * 10 + i;
    		
    		if (isPrimeNum(nextNum)) {
    			backtracking(depth + 1, nextNum);
    		}
    	}
    }
    
    private static boolean isPrimeNum (int n) {
    	int rootNum = (int) Math.sqrt(n);
    	
    	for (int i = 2; i < rootNum + 1; i++) {
    		if (n % i == 0) return false;
    	}
    	return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        arr = new int[4];
        arr[0] = 2;
        arr[1] = 3;
        arr[2] = 5;
        arr[3] = 7;
    }
}
