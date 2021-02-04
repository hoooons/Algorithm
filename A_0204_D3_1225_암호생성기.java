package Java;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A_0204_D3_1225_암호생성기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1;t<=10;t++) {
			int tc=sc.nextInt();
			Queue<Integer> q = new LinkedList<>();
			for(int i=0;i<8;i++) {
				q.add(sc.nextInt());
			}
			outer:while(true) {
				int r=1;
				for(int i=0;i<5;i++) {
					int tmp = q.poll()-r;
					if(tmp<=0) {
						tmp = 0;
						q.offer(tmp);
						break outer;
					}
					q.offer(tmp);
					r++;
				}
			}
			System.out.print("#"+t+" ");
			for(int i=0;i<8;i++) {
				System.out.print(q.poll()+" ");
			}
			System.out.println();
		}
	}
}
	
	
	
	//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		for (int t = 1; t <= 10; t++) {
//			int tc = sc.nextInt();
//			int[] arr = new int[8];
//			for (int i = 0; i < 8; i++) {
//				arr[i] = sc.nextInt();
//			}
//			outer : while (true) {
//				int r = 1;
//				for(int i=0;i<5;i++) {
//					int temp = arr[0]-r;
//					System.arraycopy(arr, 1, arr, 0, 7);
//					arr[7]=temp;
//					r++;
//					for(int j=0;j<8;j++) {
//						if(arr[j]<=0) {
//							arr[j]=0; break outer;
//						}
//					}
//				}
//			}
//			System.out.print("#"+t+" ");
//			for(int i=0;i<8;i++) {
//				System.out.print(arr[i]+" ");
//			}
//			System.out.println();
//		}
//	}
//}
