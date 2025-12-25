import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int N, l, result;
    static Set<String> check;
    static String[] students;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        students = new String[N];
        result = 0;

        for(int i = 0; i < N; i++){
            students[i] = br.readLine();
        }
        l = students[0].length();

        for(int i = 1; i <= l; i++) {
            check = new HashSet<>();    // Set 초기화하면서 중복 체크
            for (String student : students) {
                String tmp = student.substring(l - i, l);
                check.add(tmp);
            }
            if(check.size() == N){  // Set 크기가 N과 같으면 중복 번호 없다는 뜻
                result = i;
                break;
            }
        }

        System.out.print(result);
    }
}