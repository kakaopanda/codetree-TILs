import java.io.*;
import java.util.*;

public class Main {
	static int N; // 미로의 크기(N*N)
	static int M; // 참가자 수
	static int K; // 게임 시간(게임 시간이 끝나기 전, 모든 참가자가 탈출하면 게임이 종료된다.)
	static int R; // 탈출구의 행 위치
	static int C; // 탈출구의 열 위치
	static int answer; // 모든 참가자들의 이동 거리 합
	static int[][] map; // 벽이 포함된 미로 맵 배열 (1,1) ~ (N,N)
	static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}}; // 방향벡터 : 상,하,좌,우 4방향을 우선순위로 이동한다.
	static ArrayList<Man> manList; // 생존한 참가자들로 구성된 리스트(참가자별 순서는 고려하지 않는다.)
	
	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("src/Solution/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 1. 미로 정보 초기화
		map = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 2. 참가자 정보 초기화
		manList = new ArrayList<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			manList.add(new Man(r, c, 0));
		}
		
		// 3. 출구 정보 초기화
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		// 4. 게임 진행
		for(int k=0; k<K; k++) {
			
			// 5. 참가자 이동
			moveMan();
			
			// 6. 회전시킬 정사각형 영역 탐색
			decideSquare();
			
			// 게임 시간이 종료되기 전, 모든 참가자가 탈출한 경우 게임을 종료한다.
			if(manList.size() == 0) {
				break;
			}			
		}
		
		// 게임 시간이 종료되기 전까지 탈출하지 못한 참가자들의 이동 거리도 더해준다.
		for(int i=0; i<manList.size(); i++) {
			answer += manList.get(i).m;
		}
		sb.append(answer + "\n");
		sb.append(R + " " + C);
		
		// 정답 출력
		System.out.println(sb);
	}
	
	// 조건에 부합하는 참가자를 이동시킨다.
	static void moveMan() {
		// 현재 리스트에서 꺼낸 참가자는 모두 탈출하지 못한 참가자이다.
		for(int i=0; i<manList.size(); i++) {
			Man m = manList.get(i);
			
			// 참가자의 이동 전 현 위치에서 탈출구와의 거리를 계산한다.
			int currentDistance = getDistance(m.r, m.c, R, C);
			int minDistance = Integer.MAX_VALUE;
			int directionIndex = -1;
			
			// 참가자의 이동 후 위치에서 탈출구와의 거리를 계산하여 현 위치에서의 거리와 비교한다.
			for(int d=0; d<4; d++) {
				int nr = m.r + delta[d][0];
				int nc = m.c + delta[d][1];
				
				// 이동 후 위치가 미로를 안벗어나는지, 빈칸으로 이동할 수 있는지 확인한다.
				if(nr>0 && nr<=N && nc>0 && nc<=N && map[nr][nc]<=0) {
					int nextDistance = getDistance(nr, nc, R, C);
					
					if(nextDistance<minDistance && nextDistance<currentDistance) {
						minDistance = nextDistance;
						directionIndex = d;
					}
				}
			}
			
			// 방향 인덱스가 변화하지 않은 경우, 참가자는 이동하지 않는다.
			if(directionIndex != -1) {
				m.r += delta[directionIndex][0];
				m.c += delta[directionIndex][1];
				m.m += 1;
			}
			
			// 참가자가 탈출구에 도달한 경우, 이동 횟수를 정답에 더해주고 리스트에서 제거한다.
			if(m.r==R && m.c==C) {
				answer += m.m;
				manList.remove(m);
				i -= 1;
			}
		}
	}
	
	// 회전시킬 정사각형 영역을 결정한다.
	static void decideSquare() {
		int minDiff = Integer.MAX_VALUE; // 참가자와 탈출구의 위치차 중 최솟값
		ArrayList<Man> minDiffList = new ArrayList<>(); // 동일한 최솟값을 가진 참가자들의 리스트
		
		int squareR = 0; // 정사각형을 구성할 초기 행 위치
		int squareC = 0; // 정사각형을 구성할 초기 열 위치
		
		for(int i=0; i<manList.size(); i++) {
			Man m = manList.get(i);
			
			// 참가자의 위치와 탈출구의 위치차 중, 더 큰쪽을 가져온다.
			// 더 큰쪽을 가져와야 정사각형 안에 참가자와 탈출구를 모두 포함시킬 수 있다.
			int currentDiff = Math.max(Math.abs(m.r-R), Math.abs(m.c-C));
			
			if(currentDiff < minDiff) {
				minDiff = currentDiff;
				minDiffList = new ArrayList<>();
				minDiffList.add(m);
			}
			else if(currentDiff == minDiff) {
				minDiffList.add(m);
			}
		}
		
		int D = minDiff;

		Loop:
		for(int i=1; i<N-D; i++) {
			for(int j=1; j<N-D; j++) {
				for(int k=0; k<minDiffList.size(); k++) {
					Man m = minDiffList.get(k);

					// 정사각형 영역안에 참가자와 탈출구가 모두 포함되는 경우
					if(m.r<=i+D && m.c<=j+D && R<=i+D && C<=i+D) {
						// 해당 위치를 정사각형의 시작 위치로 지정한다.
						// 탐색을 좌상단부터 시작하므로, 조건을 만족하는 정사각형을 찾으면 바로 종료한다.(탐색 우선순위 반영)
						squareR = i;
						squareC = j;
						break Loop;
					}
				}
			}
		}
		
		// minDiff+1은 회전시킬 정사각형 영역의 크기로 사용한다.
		rotateMap(squareR, squareC, minDiff+1, minDiffList);
	}
	
	// 정사각형 영역을 시계 방향으로 90도 회전시킨다.
	static void rotateMap(int sr, int sc, int n, ArrayList<Man> list) {
		int[][] square = new int[n][n];
		boolean exitChange = false;
		boolean[] manChange = new boolean[list.size()];
		
		// 정사각형 영역을 시계방향으로 90도 돌린 뒤, 벽의 내구도를 감소시킨다.
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				square[i][j] = map[sr+n-j-1][sc+i];
				
				// 현재 위치가 탈출구인 경우, 1번만 돌려준다.
				if(!exitChange && i+sr==R && j+sc==C) {
					R = sr+j;
					C = sc+n-i-1;
					exitChange = true;
				}
				
				// 현재 위치가 참가자인 경우, 1번만 돌려준다.
				for(int k=0; k<list.size(); k++) {
					// 아직 돌리지 않은 참가자만 확인한다.
					if(!manChange[k]) {
						Man m = list.get(k);
						
						if(i+sr==m.r && j+sc==m.c) {
							m.r = sr+j;
							m.c = sc+n-i-1;
							manChange[k] = true;
						}
					}
				}
				
				// 벽의 내구도가 1이상인 경우, 1 감소시킨다.
				if(square[i][j] > 0) {
					square[i][j] -= 1;
				}
			}
		}
		
		// 90도 돌린 정사각형 영역을 미로에 반영한다.
		for(int i=sr; i<sr+n; i++) {
			for(int j=sc; j<sc+n; j++) {
				map[i][j] = square[i-sr][j-sc];
			}
		}
	}
	
	// 두 좌표(참가자와 탈출구)간 최소 거리를 계산한다.
	static int getDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1-x2) + Math.abs(y1-y2);
	}
	
	static void print() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}

class Man{
	int r; // 참가자의 행 위치
	int c; // 참가자의 열 위치
	int m; // 참가자의 이동 횟수
	
	public Man(int r, int c, int m) {
		this.r = r;
		this.c = c;
		this.m = m;
	}

	@Override
	public String toString() {
		return "Man [r=" + r + ", c=" + c + "]";
	}
}