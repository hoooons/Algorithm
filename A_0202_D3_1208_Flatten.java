package Java;

import java.util.Scanner;

public class A_0202_D3_1208_Flatten {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int n = sc.nextInt();
			int[] arr = new int[100];
			int result = 0;
			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(sc.next());
			}
			int max = 0, min = 101;
			int index = 0, index2 = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 100; j++) {
					if (max < arr[j]) {
						max = arr[j];
						index = j;
					}
					if (min > arr[j]) {
						min = arr[j];
						index2 = j;
					}
				}
				max--;
				arr[index]--;
				min++;
				arr[index2]++;
				if(max-min <= 1)
					break;
			}
			for (int i = 0; i < 100; i++) {
				if (max < arr[i])
					max = arr[i];
				if (min > arr[i])
					min = arr[i];
			}
			result = max - min;
			System.out.println("#" + t + " " + result);
		}
	}
}

//sort이용해서도 해보기.

/*
	for(int i=0;i<n;++){
		Arrays.sort(arr);
		res = arr[99] - arr[0];
		arr[99]--; arr[99]++;
	}
*/