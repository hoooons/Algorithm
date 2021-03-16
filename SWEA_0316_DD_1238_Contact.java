package Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_0316_DD_1238_Contact {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<int[]> queue = new LinkedList<>();
		
		for(int t=1;t<=10;t++) {
			List<int[]> list = new ArrayList<>();
			List<Integer> list2 = new ArrayList<>();
			int[][] arr = new int[101][101];
			boolean[] visit = new boolean[101];
			int N = sc.nextInt();
			int st = sc.nextInt();
			
			for(int i=0;i<N/2;i++) arr[sc.nextInt()][sc.nextInt()]=1;
			
			int maxlev=1,res=0;
			
			queue.offer(new int[] {st,1});
			
			while(!queue.isEmpty()) {
				int[] tmp = queue.poll();
				int a = tmp[0];
				int lev = tmp[1];
				visit[tmp[0]]=true;
				maxlev = lev;
				for(int i=1;i<101;i++) {
					if(arr[a][i]==1 && visit[i]!=true) {
						visit[i]=true;	//방문처리를 큐에 넣을때 해줘야댐
						queue.offer(new int[] {i,lev+1});
						list.add(new int[] {i,lev+1});
					}
				}
			}
			for(int i=0;i<list.size();i++) {
				int[] a = list.get(i);
				if(a[1]==maxlev) {
					if(res<a[0]) res = a[0];
				}
			}
			System.out.println("#"+t+" "+res);
		}
	}
}
