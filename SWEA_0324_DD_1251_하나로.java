package Java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_0324_DD_1251_하나로 {
	
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1;t<=T;t++) {
			List<Node> list = new LinkedList<>();
			int N = sc.nextInt();
			
			int[] tmpx = new int[N];
			int[] tmpy = new int[N];
			long[][] arr = new long[N][N];
			long[] minDis = new long[N];
			boolean[] visit = new boolean[N];
			
			Arrays.fill(minDis, Long.MAX_VALUE);
			
			for(int i=0;i<N;i++) 
				tmpx[i] = sc.nextInt();
			for(int i=0;i<N;i++)
				tmpy[i] = sc.nextInt();
			
			StringTokenizer st = new StringTokenizer(sc.next());
			double E = Double.parseDouble(st.nextToken());
			
			for(int i=0;i<N;i++) 
				list.add(new Node(tmpx[i],tmpy[i]));

			// 일단 모두 연결 -> 인접행렬로 만듬
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++) {
					if(i==j) continue;
					arr[i][j] = (long)((Math.pow(list.get(i).x-list.get(j).x,2)+Math.pow(list.get(i).y-list.get(j).y,2)));
				}
			minDis[0] = 0;
			
			for(int i=0;i<N;i++) {
				long min = Long.MAX_VALUE;
				int minVertex = 0;
				for(int j=0;j<N;j++) {
					if(!visit[j] && min>minDis[j]) {
						min = minDis[j];
						minVertex = j;
					}
				}
				visit[minVertex] = true;
				
				for(int j=0;j<N;j++) {
					if(!visit[j] && arr[minVertex][j] != 0 && minDis[j] > arr[minVertex][j]) {
						minDis[j] = arr[minVertex][j];
					}
				}
			}
			
			double res = 0;
			
			for(int i=0;i<N;i++) {
				res += minDis[i] * E;
			}
			System.out.println("#"+t+" "+Math.round(res));
		}
	}
}
