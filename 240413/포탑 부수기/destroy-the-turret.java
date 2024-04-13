import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static int[][] map; // 포탑의 공격력을 저장하는 배열
    static int[][] attack; // 포탑의 공격시점을 저장하는 배열
    static boolean[][] effect; // 포탑의 영향여부를 저장하는 배열
    
    // 레이저 공격에 사용할 방향 배열(우하좌상)
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0};
    
    // 포탑 공격에 사용할 방향 배열(8방향, 우선순위 없음)
    static int[] bdx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] bdy = {1, 0, -1, 0, -1, 1, -1, 1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        // 첫 번째 줄에 입력된 N, M, K 값을 입력받는다.
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        attack = new int[N][M];

        // 두 번째 줄부터 N개의 줄에 걸쳐서 N * M 격자에 대한 정보를 입력받는다.
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int m=0; m<M; m++){
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        // 최초 시간을 0으로 설정했기에, 진행 시점은 1부터 시작한다.
        for(int time=1; time<=K; time++){
        	// 하나의 턴은 다음의 4가지 액션을 순서대로 수행하며, 총 K번 반복한다.
            // 부서지지 않은 포탑이 1개가 된다면 즉시 반복을 중단한다.
        	if(isFinish()) {
        		break;
        	}
        	effect = new boolean[N][M];
        	
        	// STEP1. 공격자 선정
        	// 공격자를 선정하기 위해, 각 포탑을 객체로 만들어서 리스트에 집어넣는다.
            ArrayList<Turret> list = new ArrayList<>();
        	for(int n=0; n<N; n++) {
            	for(int m=0; m<M; m++) {
            		if(map[n][m] != 0) {
            			list.add(new Turret(n, m, map[n][m], attack[n][m]));
            		}
            	}
            }
        	Collections.sort(list);
        	Turret start = list.get(0); //공격자
        	Turret target = list.get(list.size()-1); // 공격대상
        	
        	map[start.x][start.y] += (N+M); // 공격자의 공격력 증가
        	attack[start.x][start.y] = time; // 공격자의 공격시점을 현재로 변경
        	effect[start.x][start.y] = true; // 공격자이거나 공격대상 혹은 공격 경로에 해당하는 포탑인 경우 상태를 변경한다.
        	
        	// STEP2. 공격자의 공격
        	// 공격을 할 때에는 레이저 공격을 먼저 시도하고, 만약 그게 안 된다면 포탄 공격을 한다.
        	if(!laser(start, target)) {
        		bomb(start, target);
        	}
        	
        	// STEP3. 포탑 부서짐
        	// 공격자의 공격에 의해 공격력이 0 이하로 떨어진 포탑은 0으로 변경한다.
        	for(int n=0; n<N; n++) {
        		for(int m=0; m<M; m++) {
        			if(map[n][m] < 0) {
        				map[n][m] = 0;
        			}
        		}
        	}
        	
        	// STEP4. 포탑 정비
        	// 공격자, 공격대상, 경로상의 포탑이 아닌 공격과 무곤한 포탑은 공격력이 1씩 증가한다.
        	for(int n=0; n<N; n++) {
        		for(int m=0; m<M; m++) {
        			if(map[n][m] != 0 && !effect[n][m]) {
        				map[n][m]++;
        			}
        		}
        	}
        }
        
        // STEP5. 전체 과정 종료 후, 가장 강한 포탑의 공격력을 출력한다.
        int max = Integer.MIN_VALUE;
        for(int n=0; n<N; n++) {
        	for(int m=0; m<M; m++) {
        		max = Math.max(max, map[n][m]);
        	}
        }

        System.out.println(max);
    }
    
    // 레이저 공격을 수행하는 함수로, 공격 가능한 경로가 존재하지 않으면 false를 반환한다.
    public static boolean laser(Turret start, Turret target) {
    	// 역추적에 사용할 이동 경로를 저장할 배열
    	// route[N][M]이면, route[N][M]에 도달하기 전의 포탑 위치를 기록한다.
    	Turret[][] route = new Turret[N][M];
    	
    	// BFS에 사용할 큐
    	// 시작점 -> 도착점으로 BFS를 진행하여 최단 경로이자 진행 경로를 route에 담은 후,
    	// 역추적으로 도착점에서 시작점까지에 해당하는 포탑들에 대해 공격을 진행한다.
    	Queue<Turret> q = new LinkedList<>();
    	
    	// 방문 이력을 기록할 배열
    	boolean[][] visited = new boolean[N][M];
    	
    	q.add(new Turret(start.x, start.y));
    	visited[start.x][start.y] = true;
    	
    	while(!q.isEmpty()) {
    		Turret turret = q.poll();
    		
    		for(int i=0; i<4; i++) {
    			// x,y 값이 0인 경우 dx, dy를 더했을 때 -1이 나올 수 있으므로
    			// ArrayIndexOutOfBoundsException을 예방하기 위해 N과 M을 더해 인접한 칸으로 순환시킨다.
    			int nx = (N + turret.x + dx[i]) % N;
    			int ny = (M + turret.y + dy[i]) % M;
    			
    			// 아직 방문하지 않았으며, 부서지지 않은 포탑인 경우 큐에 추가하고 루트에 이전 위치를 기록한다.
    			if(!visited[nx][ny] && map[nx][ny] != 0) {
    				q.add(new Turret(nx, ny));
    				visited[nx][ny] = true;
    				route[nx][ny] = new Turret(turret.x, turret.y);
    			}
    		}
    	}
    			
    			// BFS를 통해 공격 대상까지 도달하지 못한 경우 false를 반환한다.
    			if(!visited[target.x][target.y]) {
    				return false;
    			}
    			
    			// 도착점에서부터 역추적을 통해 시작점까지의 공격 경로상의 포탑들을 공격한다.
    			int x = target.x;
    			int y = target.y;
    			while(x!=start.x || y != start.y) {
    				// 경로상의 포탑은 공격자 공격력의 50%만을 공격받는다.
    				int power = map[start.x][start.y]/2 ;
    				
    				// 공격 대상은 공격자 공격력의 100%를 공격받는다.
    				if(x == target.x && y == target.y) {
    					power = map[start.x][start.y];
    				}
    				
    				map[x][y] -= power;
    				effect[x][y] = true;
    				
    				// 현 위치에 도달하기 이전 위치의 포탑을 불러온다.
    				Turret turret = route[x][y];
    				x = turret.x;
    				y = turret.y;
    			}
    			
    			return true;
 }
    
    // 포탄 공격을 수행하는 함수
    public static void bomb(Turret start, Turret target) {
    	int power = map[start.x][start.y];
    	
    	// 공격 대상은 공격자 공격력의 100%를 공격받는다.
    	map[target.x][target.y] -= power;
    	effect[target.x][target.y] = true;
    	
    	// 주위 8개 방향에 있는 포탑은 공격자 공격력의 50%를 공격받는다.
    	power /= 2;
    	
    	// 공격 대상의 상하좌우 및 대각선 위치의 포탑을 공격한다.
    	for(int i=0; i<8; i++) {
    		int nx = (N + target.x + bdx[i]) % N;
    		int ny = (M + target.y + bdy[i]) % M;
    		
    		// 공격자는 공격 받지 않으므로, 공격자의 위치가 아닌 경우에 대해서만 진행한다.
    		if(nx != start.x || ny != start.y) {
    			map[nx][ny] -= power;
    			effect[nx][ny] = true;
    		}
    	}
    }
    
    // 남아있는 포탑의 개수가 1개인지 검사하는 함수
    public static boolean isFinish() {
    	int count = 0;
    	
    	for(int n=0; n<N; n++) {
    		for(int m=0; m<M; m++) {
    			if(map[n][m] != 0) {
    				count++;
    			}
    		}
    	}
    
    	if(count == 1) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
}

// STEP1. 공격자 선정
// 공격자 선정과 공격대상 선정의 우선순위가 정반대이므로,
// 하나의 프로세스로 공격자와 공격대상을 모두 선정할 수 있다.
class Turret implements Comparable<Turret>{
	int x; // 포탑의 행, X좌표 (X,Y)
	int y; // 포탑의 열, Y좌표 (X,Y)
	int atk; // 포탑의 공격력
	int time; // 포탑의 공격시점
	
	public Turret(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Turret(int x, int y, int atk, int time) {
		this.x = x;
		this.y = y;
		this.atk = atk;
		this.time = time;
	}
	
	@Override
	public int compareTo(Turret o) {
		if(this.atk == o.atk) { // 공격력 오름차순 정렬
			if(this.time == o.time) { // 공격시점 내림차순 정렬
				if(this.x + this.y == o.x + o.y) { // 행과 열의 합 내림차순 정렬
					return o.y - this.y; // 열 값 내림차순 정렬
				}
				return (o.x + o.y) - (this.x + this.y);
			}
			return o.time - this.time;
		}
		return this.atk - o.atk;
	}

	@Override
	public String toString() {
		return "Turret [x=" + x + ", y=" + y + ", atk=" + atk + ", time=" + time + "]";
	}
}