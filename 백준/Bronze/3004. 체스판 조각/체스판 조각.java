import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		
		//보통 for문에서 i는 0부터 시작하지만 여기선 좀 더 직관적으로 보고
		//연산하기 편하게 1부터 시작한다(1부터 하므로써 i는 자를때마다 자르는 번호가 된다)
		for(int i = 1; i <= N; i++) {
			//첫번째 자를때는 2로 나누고 1을 더하면 1이 되어버리기 때문에 if문으로 제한해준다.
			if(i == 1) {
				sum += 2;
			}else {
				sum += ((i / 2) + 1);
			}
		}
		System.out.println(sum);
	}

}