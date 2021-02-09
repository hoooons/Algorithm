package Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_0209_D4_1233_사칙연산유효성검사 {
	static int N, count = 0;
	static char[] arr;
	static boolean ans = true;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			ans = true;
			arr = new char[N + 1];
			for (int i = 1; i < N + 1; i++) {
				st = new StringTokenizer(br.readLine());
				arr[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
			}
			dfs(1);
			System.out.println("#" + t + " " + (ans == true ? 1 : 0));
		}
	}

	public static void dfs(int current) {
		if (current > N)
			return;
		dfs(current * 2);
		dfs(current * 2 + 1);
		if (0 <= arr[current] - '0' && arr[current] - '0' <= 9) {
			if (current * 2 <= N && arr[current * 2] != 0)
				ans = false;
			if (current * 2 + 1 <= N && arr[current * 2 + 1] != 0)
				ans = false;
		}
	}
}
