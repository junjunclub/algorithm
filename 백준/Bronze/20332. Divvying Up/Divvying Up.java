import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int v = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			v += Integer.parseInt(st.nextToken());
		}
		
		if (v % 3 == 0) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
	}
}
