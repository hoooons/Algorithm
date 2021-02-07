package Java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A_0207_D3_9280_진용이네주차타워 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] arr = new int[n];			// 주차공간 금액
			int[] park = new int[n];		// 주차되있는 차의 번호
			int[] car = new int[m];			// 차량의 무게
			int cars = 0;					// 주차되있는 차의 수
			Queue<Integer> q1 = new LinkedList<>(); // 대기 차 무게
			Queue<Integer> q2 = new LinkedList<>(); // 대기 차 번호
			for (int i = 0; i < n; i++) 
				arr[i] = sc.nextInt();
			for (int i = 0; i < m; i++) 
				car[i] = sc.nextInt();
			int result = 0;
			for (int i = 0; i < m * 2; i++) {
				int k = sc.nextInt();
				if (k > 0) {				// 주차함
					for (int j = 0; j < n; j++) {
						if (park[j] == 0) {
							park[j] = k;
							result += arr[j] * car[k - 1];
							cars++;
							break;
						}
						if (cars==n) { // 주차공간없음
							q1.offer(car[k - 1]); // 대기열 무게
							q2.offer(k);		  // 대기열 차번호
							break;
						}
					}
				} else {					// 차뺌
					for (int j = 0; j < n; j++) {
						if (park[j] == Math.abs(k)) {
							if (!q1.isEmpty()) {
								result += arr[j] * q1.poll();
								park[j] = q2.poll();
								break;
							} else {
								park[j] = 0;
								cars--;
								break;
							}
						}
					}
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}
}
