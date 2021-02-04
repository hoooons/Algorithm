package Java;

import java.util.Scanner;
import java.util.Stack;

public class A_0204_D4_1218_°ýÈ£Â¦Áþ±â {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(sc.next());
			char[] arr = new char[n];
			String str = sc.next();
			int result = 1;
			// ÀÔ·Â
			for (int i = 0; i < n; i++) {
				arr[i] = str.charAt(i);
			}
			for (int i = 0; i < n; i++) {
				if (arr[i] == ')') {
					for (int j = 0; j < n; j++) {
						if (arr[j] == '(') {
							arr[j] = 0;
							arr[i] = 0;
							break;
						}
					}
				} else if (arr[i] == '}') {
					for (int j = 0; j < n; j++) {
						if (arr[j] == '{') {
							arr[j] = 0;
							arr[i] = 0;
							break;
						}
					}
				} else if (arr[i] == ']') {
					for (int j = 0; j < n; j++) {
						if (arr[j] == '[') {
							arr[j] = 0;
							arr[i] = 0;
							break;
						}
					}
				} else if (arr[i] == '>') {
					for (int j = 0; j < n; j++) {
						if (arr[j] == '<') {
							arr[j] = 0;
							arr[i] = 0;
							break;
						}
					}
				}
			}
			for (int i = 0; i < n; i++) {
				if (arr[i] != 0) {
					result--;
					break;
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}
}
