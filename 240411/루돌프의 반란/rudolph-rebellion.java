import java.io.*;
import java.util.*;

// 중요! 산타를 담는 리스트로 ArrayList를 쓰면 안되는 이유 -> 인덱스 순으로 산타를 찾도록 HashMap을 이용해야한다.
// 산타의 이동은 1번부터 P번까지 이뤄져야한다. 하지만 입력값으로 리스트에 담을때 뒷번호에 해당하는 산타가
// 앞번호에 해당하는 산타보다 먼저 담길 수 있다. 그렇게 되면 2번이 1번보다 먼저 움직여 문제에서 요구하는 로직이 꼬이게 되고, 오답처리된다.
// HashMap은 ArrayList처럼 변경된 객체에 대한 동기화가 지원되지 않기 때문에, Santa 객체에 변동사항이 생기면 put() 메소드를 호출해 다시 업데이트 해줘야한다.

public class Main {
	// 게임판의 크기(N), 게임턴수(M), 산타의수(P), 루돌프의힘(C), 산타의힘(D)
	static int N, M, P, C, D;
	static Rudolph rudolph;
	static HashMap<Integer, Santa> santas;
	
	// 방향벡터 : 상[0], 우[1], 하[2], 좌[3], 좌상[4], 우상[5], 우하[6], 좌하[7]
	static int[][] delta = {{-1,0},{0,1},{1,0},{0,-1},{-1,-1},{-1,1},{1,1},{1,-1}};
	
	public static void main(String[] args) throws IOException{
		// System.setIn(new FileInputStream("src/Solution/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		// 1. 입력값 초기화
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		// 2. 루돌프 초기 위치 초기화
		st = new StringTokenizer(br.readLine(), " ");
		rudolph = new Rudolph(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		
		// 3. 산타 초기 위치 초기화
		santas = new HashMap<>();
		for(int i=0; i<P; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			santas.put(n, new Santa(n, r, c));
		}
		
		// 4. 게임 턴 수만큼 진행
		for(int i=0; i<M; i++) {
			
			// 5. 루돌프 이동 및 충돌
			moveRudolph();
			
			// 6. 산타 이동 및 충돌
			for(int j=1; j<=P; j++) {
				// 생존한 산타 및 기절하지 않은 산타만 이동할 수 있다.
				if(!santas.get(j).isDead) {
					if(santas.get(j).t==0) {
						moveSanta(santas.get(j));
					}
					else {
						santas.get(j).t -= 1;
					}
				}
			}
			
			// 7. 모든 산타가 탈락한 경우, 게임 즉시 종료
			int cnt = 0;
			for(int j=1; j<=P; j++) {
				if(santas.get(j).isDead) {
					cnt += 1;
				}
			}
			if(cnt == P) {
				break;
			}
			
			// 8. 생존한 산타가 있을 경우, 추가점수를 부여하고 다음 턴을 진행한다.
			for(int j=1; j<=P; j++) {
				if(!santas.get(j).isDead) {
					santas.get(j).s += 1;
				}
			}
		}
		
		// 9. 게임이 끝났을 때 각 산타가 얻은 최종 점수를 출력
		for(int i=1; i<=P; i++) {
			System.out.print(santas.get(i).s + " ");
		}
	}
	
	static void moveRudolph(){
		int min = Integer.MAX_VALUE;
		ArrayList<Santa> dSantas = new ArrayList<>();
		
		// (1). 루돌프와의 거리가 최소에 해당하는 생존 및 기절 산타를 찾아 리스트에 담는다.
		for(int i=1; i<=P; i++) {
			Santa s = santas.get(i);
			
			// 탈락한 산타는 루돌프의 돌진 대상이 되지 않지만, 기절한 산타로는 돌진할 수 있다.
			if(s.isDead) {
				continue;
			}
			else {
				int d = getDistance(s);
				
				// 현재 선택한 산타와 루돌프의 거리가 최솟값보다 큰 경우 무시한다.
				if(min < d) {
					continue;
				}
				// 현재 선택한 산타와 루돌프의 거리가 최솟값보다 작은 경우, 최솟값을 갱신하고 리스트를 새로 만든다.
				else if(min > d) {
					dSantas = new ArrayList<>();
					dSantas.add(s);
					min = d;
				}
				// 현재 선택한 산타와 루돌프의 거리가 최솟값과 같은 경우 후보 리스트에 넣는다.
				else {
					dSantas.add(s);
				}
			}	
		}
		
		// (2). 루돌프의 돌진 대상이 될 산타는, 최소 거리이면서 R값과 C값이 가장 높은 산타이다.
		Collections.sort(dSantas);
		Santa s = dSantas.get(0);
		
		// (3). 돌진 대상이 될 산타가 결정됐으니, 해당 산타로 향하는 방향을 결정해야한다.
		// 이때, 루돌프의 돌진 방향은 루돌프와 산타의 상대적 좌표 차이로 계산할 수 있다.		
		int d = getDirection(s);
		
		// (4). 결정된 방향을 토대로, 루돌프의 위치를 돌진 방향대로 갱신한다.
		rudolph.r += delta[d][0];
		rudolph.c += delta[d][1];
		
		// (5). 돌진한 루돌프의 위치가 산타의 위치와 동일한 경우 충돌이 발생한다.
		if(rudolph.r==s.r && rudolph.c==s.c) {
			// 1). 산타는 루돌프의 힘 C만큼 점수를 획득한다.
			s.s += C; 
			
			// 2). 산타는 루돌프의 돌진 방향에 C를 곱한 값만큼 밀려난다.
			s.r += delta[d][0] * C; 
			s.c += delta[d][1] * C;
			
			// 3). 산타가 밀려난 위치가 게임판을 벗어난 경우 탈락처리한다.
			if(isOut(s)) {
				s.isDead = true;
			}
			// 4). 탈락처리 되지 않았다면, 기절시간 부여후 연쇄 충돌 메소드를 호출한다.
			else {
				s.t = 2; // 루돌프가 돌진한 턴(K턴)과 이후 1턴(K+1)턴까지 기절한다.
				collision(s, d);
			}
		}
		
		santas.put(s.n, s);
	}
	
	// 매개변수 : 이동하는 산타 객체
	static void moveSanta(Santa s) {
		// 산타는 4방향(상,우,하,좌)으로만 이동 가능하므로, 4방향 순서대로 루돌프와의 거리를 계산한다.
		int min = Integer.MAX_VALUE;
		
		// 산타가 4방향으로 이동했다고 가정할 때, 루돌프와의 거리를 담는다.
		int[] distance = new int[4];
		
		for(int i=0; i<4; i++) {		
			// 산타가 해당 방향으로 이동할 경우, 이동할 수는 있는지, 루돌프와의 거리는 얼마나 되는지를 판단한다.
			Santa t = new Santa(s.n, s.r, s.c);
			
			t.r += delta[i][0];
			t.c += delta[i][1];
			
			distance[i] = getDistance(t);
			
			if(isOut(t)) {
				distance[i] = Integer.MAX_VALUE;
			}
			
			for(int j=1; j<=P; j++) {
				// 비교 대상이 자신이거나, 이미 탈락한 산타는 고려 대상이 아니다.
				Santa temp = santas.get(j);
				if(j==t.n || temp.isDead) {
					continue;
				}
				else {
					// 이동하려는 목표 위치에 다른 산타가 있는 경우 이동할 수 없다.
					if(t.r==temp.r && t.c==temp.c) {
						distance[i] = Integer.MAX_VALUE;
						break;
					}
				}
			}
		}
		
		// 산타와 루돌프와의 거리가 최소가 되는 방향을 결정한다.
		int d = -1;
		for(int i=0; i<4; i++) {
			if(min > distance[i]) {
				d = i;
				min = distance[i];
			}
		}
		
		// 결정된 방향에 따라 산타가 이동했을 때, 현재보다 거리가 멀어진다면 이동하지 않는다.
		if(min > getDistance(s)) {
			return;
		}
		
		// 산타의 위치를 갱신한다.
		if(d != -1) {
			s.r += delta[d][0];
			s.c += delta[d][1];
		}
		
		// 갱신한 산타의 위치가 루돌프와 충돌하는지 판단한다.
		if(s.r==rudolph.r && s.c==rudolph.c) {
			// 1). 산타는 산타의 힘 D만큼 점수를 획득한다.
			s.s += D; 
						
			// 2). 산타는 자신이 이동한 반대 방향에 D를 곱한 값만큼 밀려난다.
			// 0(상), 1(우), 2(하), 3(좌)
			s.r += delta[(d+2)%4][0] * D; 
			s.c += delta[(d+2)%4][1] * D;
						
			// 3). 산타가 밀려난 위치가 게임판을 벗어난 경우 탈락처리한다.
			if(isOut(s)) {
				s.isDead = true;
			}
			
			// 4). 탈락처리 되지 않았다면, 기절시간 부여후 연쇄 충돌 메소드를 호출한다.
			else {
				s.t = 1; // 산타가 이동한 턴(K턴) 이후 1턴(K+1)턴까지 기절한다.
				collision(s, (d+2)%4);
			}
		}
		santas.put(s.n, s);
	}
	
	// 매개변수 : 충돌로 날아가는 산타 객체, 산타가 날아온 방향
	// 루돌프와의 충돌로 날아가는 산타 객체가 추가적인 충돌을 발생시킬 수 있는지에 대해 판단한다.
	static void collision(Santa s, int d) {
		for(int i=1; i<=P; i++) {
			// 날아온 산타와 비교 대상인 산타가 같은 경우는 비교하지 않는다.
			// 비교 대상인 산타가 탈락한 경우도 비교하지 않는다.
			if(i==s.n || s.isDead) {
				continue;
			}
			else {
				Santa t = santas.get(i);
					
				// 날아온 산타와 비교 대상인 산타가 또 충돌할 경우, 새롭게 충돌한 산타의 위치를 변경한다.
				if(s.r==t.r && s.c==t.c) {
					t.r += delta[d][0];
					t.c += delta[d][1];
						
					// 새롭게 충돌한 산타의 탈락 여부를 판단한다.
					if(isOut(t)) {
						t.isDead = true;
						santas.put(t.n, t);
					}
					
					else {
						// 날아온 산타를 갱신하고, 다시 처음부터 반복을 수행한다.
						s = t;
						i = 0;
					}
				}
			}
		}
	}	
	
	// 매개변수 : 루돌프와의 거리를 계산할 산타 객체
	static int getDistance(Santa s) {
		return (int)(Math.pow((s.r - rudolph.r), 2) + Math.pow((s.c - rudolph.c), 2));
	}
	
	// 매개변수 : 루돌프가 돌진할 산타 객체
	static int getDirection(Santa s) {
		int direction = -1; // 루돌프가 돌진할 방향(방향배열과 동기화된 방향)
		
		int diffR = s.r - rudolph.r; // (산타의 행 위치) - (루돌프의 행 위치)		
		int diffC = s.c - rudolph.c; // (산타의 열 위치) - (루돌프의 열 위치)
		
		if(diffR<0 && diffC==0) {
			direction = 0;
		}
		else if(diffR==0 && diffC>0) {
			direction = 1;
		}
		else if(diffR>0 && diffC==0) {
			direction = 2;
		}
		else if(diffR==0 && diffC<0) {
			direction = 3;
		}
		else if(diffR<0 && diffC<0) {
			direction = 4;
		}
		else if(diffR<0 && diffC>0) {
			direction = 5;
		}
		else if(diffR>0 && diffC>0) {
			direction = 6;
		}
		else if(diffR>0 && diffC<0) {
			direction = 7;
		}
		
		return direction;
	}
	
	static boolean isOut(Santa s) {
		if(s.r<1 || s.r>N || s.c<1 || s.c>N) {
			return true;
		}
		else {
			return false;
		}
	}
}

class Santa implements Comparable<Santa>{
	int n;
	int r;
	int c;
	int t;
	int s;
	boolean isDead;
	
	public Santa(int n, int r, int c){
		this.n = n;
		this.r = r;
		this.c = c;
	}

	// 거리순은 제외하고, 행,열 내림차순 정렬
	@Override
	public int compareTo(Santa o) {
		if(this.r == o.r) {
			return o.c - this.c;
		}
		else {
			return o.r - this.r;
		}
	}

	@Override
	public String toString() {
		return "Santa [n=" + n + ", r=" + r + ", c=" + c + ", t=" + t + ", s=" + s + ", isDead=" + isDead + "]";
	}
}

class Rudolph{
	int r;
	int c;
	
	public Rudolph(int r, int c) {
		this.r = r;
		this.c = c;
	}

	@Override
	public String toString() {
		return "Rudolph [r=" + r + ", c=" + c + "]";
	}
}