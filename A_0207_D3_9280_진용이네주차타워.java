package Java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A_0207_D3_9280_�����̳�����Ÿ�� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] arr = new int[n];			// �������� �ݾ�
			int[] park = new int[n];		// �������ִ� ���� ��ȣ
			int[] car = new int[m];			// ������ ����
			int cars = 0;					// �������ִ� ���� ��
			Queue<Integer> q1 = new LinkedList<>(); // ��� �� ����
			Queue<Integer> q2 = new LinkedList<>(); // ��� �� ��ȣ
			for (int i = 0; i < n; i++) 
				arr[i] = sc.nextInt();
			for (int i = 0; i < m; i++) 
				car[i] = sc.nextInt();
			int result = 0;
			for (int i = 0; i < m * 2; i++) {
				int k = sc.nextInt();
				if (k > 0) {				// ������
					for (int j = 0; j < n; j++) {
						if (park[j] == 0) {
							park[j] = k;
							result += arr[j] * car[k - 1];
							cars++;
							break;
						}
						if (cars==n) { // ������������
							q1.offer(car[k - 1]); // ��⿭ ����
							q2.offer(k);		  // ��⿭ ����ȣ
							break;
						}
					}
				} else {					// ����
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
