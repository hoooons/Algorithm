package Java;

import java.util.Scanner;

public class A_0203_D3_1873_상호의배틀필드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int height = sc.nextInt();
			int width = sc.nextInt();
			char[][] map = new char[height][width];
			// 맵 입력받기
			for (int i = 0; i < height; i++) {
				map[i] = sc.next().toCharArray();
			}
			int count = sc.nextInt();
			int[] act = new int[count];
			// 탱크의 행동 입력받기
			char[] temp = sc.next().toCharArray();
			for (int i = 0; i < count; i++) {
				act[i] = temp[i];
			}
			// 탱크 좌표
			int r = 0, c = 0;
			for (int i = 0; i < count; i++) {
				// 탱크의 위치 찾기
				for (int a = 0; a < height; a++) {
					for (int b = 0; b < width; b++) {
						if (map[a][b] == '^' | map[a][b] == 'v' | map[a][b] == '<' | map[a][b] == '>') {
							r = a;
							c = b;
						}
					}
				}
				if (act[i] == 'S') {		//대포발사
					if (map[r][c] == '^') {
						while (true) {
							if(r==0)
								break;
							
							r--;
							
							if (map[r][c] == '#')
								break;
							else if (map[r][c] == '*') {
								map[r][c] = '.';
								break;
							}
						}
					}
					
					if (map[r][c] == 'v') {
						while (r < height) {
							if(r+1==height)
								break;
							
							r++;
							
							if (map[r][c] == '#')
								break;
							else if (map[r][c] == '*') {
								map[r][c] = '.';
								break;
							}
						}
					}
					if (map[r][c] == '<') {
						while (c >= 0) {
							if(c==0)
								break;
							
							c--;
							
							if (map[r][c] == '#')
								break;
							else if (map[r][c] == '*') {
								map[r][c] = '.';
								break;
							}
						}
					}
					if (map[r][c] == '>') {
						while (c < width) {
							if(c+1==width)
								break;
							
							c++;							
							
							if (map[r][c] == '#')
								break;
							else if (map[r][c] == '*') {
								map[r][c] = '.';
								break;
							}
						}
					}
				}// S 끝
				
				//위로가기
				else if(act[i]=='U') {
					if(map[r][c]=='v') map[r][c]='^';
					else if(map[r][c]=='<') map[r][c]='^';
					else if(map[r][c]=='>') map[r][c]='^';
					
					if(r-1>=0 && map[r-1][c]=='.') {
						map[r-1][c]='^';
						map[r][c]='.';
					}	
				}
				else if(act[i]=='D') {
					if(map[r][c]=='^') map[r][c]='v';
					else if(map[r][c]=='<') map[r][c]='v';
					else if(map[r][c]=='>') map[r][c]='v';
					
					if(r+1<height && map[r+1][c]=='.') {
						map[r+1][c]='v';
						map[r][c]='.';
					}	
				}
				else if(act[i]=='L') {
					if(map[r][c]=='v') map[r][c]='<';
					else if(map[r][c]=='^') map[r][c]='<';
					else if(map[r][c]=='>') map[r][c]='<';
					
					if(c-1>=0 && map[r][c-1]=='.') {
						map[r][c-1]='<';
						map[r][c]='.';
					}	
				}
				else if(act[i]=='R') {
					if(map[r][c]=='v') map[r][c]='>';
					else if(map[r][c]=='<') map[r][c]='>';
					else if(map[r][c]=='^') map[r][c]='>';
					
					if(c+1<width && map[r][c+1]=='.') {
						map[r][c+1]='>';
						map[r][c]='.';
					}	
				}

			}
			System.out.print("#"+t+" ");
			for(int i=0;i<height;i++) {
				for(int j=0;j<width;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

		}
	}
}
