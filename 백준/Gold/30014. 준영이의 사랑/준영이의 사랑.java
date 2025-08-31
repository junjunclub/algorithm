import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] pearls = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pearls[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pearls);
        reverseArray(pearls);

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                deque.addFirst(pearls[i]);
            } else {
                deque.addLast(pearls[i]);
            }
        }

        int[] lst = new int[N];
        int idx = 0;
        for (int num : deque) {
            lst[idx++] = num;
        }

        long ans = 0;
        for (int i = 0; i < N; i++) {
            ans += (long) lst[i] * lst[(i + 1) % N];
        }

        System.out.println(ans);
        for (int i = 0; i < N; i++) {
            System.out.print(lst[i] + " ");
        }
        System.out.println();
    }

    private static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}
