import java.io.*;
import java.util.*;

public class Main {

    // 체스판 정보
    static int[][] map;

    // 기사 정보
    static ArrayList<Knight> knights;

    // 명령 정보
    static int[][] command;

    // 명령에 의해 영향을 받은 인접 기사들의 정보
    static boolean[] affect;

    // 방향벡터 : 위쪽(0), 오른쪽(1), 아래쪽(2), 왼쪽(3)
    static int[][] delta = {{-1,0},{0,1},{1,0},{0,-1}};
    
    // 체스판의 크기(L), 기사의 수(N), 명령의 수(Q)
    static int L, N, Q;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        L = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        // 체스판의 좌측 상단을 (1,1)로 간주하므로, (1,1)~(L,L)로 선언한다.
        map = new int[L+1][L+1];
        knights = new ArrayList<Knight>();
        command = new int[Q][2];

        int answer = 0;

        // 1. 체스판의 정보 초기화(함정, 벽)
        for(int i=1; i<=L; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=L; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. 기사 정보 초기화(행 r, 열 c, 세로 h, 가로 w, 체력 k)
        knights.add(new Knight(0,0,0,0,0,0));
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            knights.add(new Knight(r,c,h,w,k,0));
        }

        // 3. 명령 정보 초기화(명령을 수행할 기사번호, 이동방향)
        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine(), " ");

            command[i][0] = Integer.parseInt(st.nextToken());
            command[i][1] = Integer.parseInt(st.nextToken());
        }

        // 4. 명령 수행
        for(int i=0; i<Q; i++){
            // (1). 명령을 수행할 기사가 생존해있고, 이동시 모든 기사들이 체스판을 벗어나지 않고 벽이 존재하지 않아야한다.
            if(!wallCheck(command[i][0], command[i][1])){
                move(command[i][0], command[i][1]);
            }
        }

        // 5. 생존한 기사들이 총 받은 데미지의 합 출력
        for(int i=1; i<knights.size(); i++){
        	if(!knights.get(i).isDead) {
        		answer += knights.get(i).damage;
        	}
        }

        System.out.println(answer);
    }

    /**
     * @param i
     * @param d
     * @return
     */
    static boolean wallCheck(int i, int d){
    	// 1. 명령을 수행할 기사가 생존해있는지 확인한다.
    	Knight k = knights.get(i);
    	
    	if(k.isDead) {
    		return true;
    	}
    	else {
    		// 각 기사들이 현재 점령중인 영역을 표시한 배열
    		int[][] kmap = new int[L+1][L+1];
    		
    		// 현재 기사들이 점령중인 영역을 반영한다.
    		for(int n=1; n<knights.size(); n++) {
    			k = knights.get(n);
    			
    			if(k.isDead) {
    				continue;
    			}
    			else {
    				for(int r=k.r; r<k.r+k.h; r++) {
    					for(int c=k.c; c<k.c+k.w; c++) {
    						kmap[r][c] = n;
    					}
    				}
    			}
    		}
    		
    		// 이동에 영향을 받는 기사들을 표시한 배열 초기화
    		affect = new boolean[knights.size()+1];
    		
    		// 기사들이 점령중인 좌표를 받아, 이동 방향으로 이동했을시 이동 가능 여부를 조사하기 위한 큐
    		Queue<int[]> queue = new ArrayDeque<>();
    		boolean[][] visited = new boolean[L+1][L+1];
    		
    		// 명령을 받은 기사가 생존해있고, 현재 점령중인 영역을 표시한다.
    		k = knights.get(i);
    		for(int r=k.r; r<k.r+k.h; r++) {
    			for(int c=k.c; c<k.c+k.w; c++) {
    				queue.offer(new int[] {r,c});
    				visited[r][c] = true;
    			}
    		}
    		affect[i] = true;
    		
    		while(!queue.isEmpty()) {
    			int[] cur = queue.poll();

    			int nx = cur[0] + delta[d][0];
    			int ny = cur[1] + delta[d][1];
    			
    			// 이동 목표 지점이 체스판을 벗어나거나, 벽이어서 이동이 불가한 경우
    			if(nx<1 || nx>L || ny<1 || ny>L || map[nx][ny] == 2) {
    				return true;
    			}
    			// 목표 지점을 방문한 적이 없고, 새로운 기사를 마주한 경우
    			else if(kmap[nx][ny] != i && !visited[nx][ny]) {
    				k = knights.get(kmap[nx][ny]);
    				
    				for(int r=k.r; r<k.r+k.h; r++) {
    					for(int c=k.c; c<k.c+k.w; c++) {
    						queue.add(new int[] {r,c});
    						visited[r][c] = true;
    					}
    				}
    				
    				affect[kmap[nx][ny]] = true;
    			}
    		}
    	}
    	
        return false;
    }

    static void move(int i, int d){
    	// 함정 개수에 따른 이동 데미지 적용
    	for(int n=1; n<affect.length; n++) {
    		// 이동하지 않는 기사이거나, 명령을 받은 기사인 경우 데미지를 받지 않는다.
    		if(!affect[n] || n==i) {
    			continue;
    		}
    		else {
    			Knight k = knights.get(n);
    			
    			// 현재 기사가 점령중인 영역에서 이동 방향으로 이동한 경우, 목표 지점에 함정이 있는지 확인한다.
    			for(int r=k.r; r<k.r+k.h; r++) {
    				for(int c=k.c; c<k.c+k.w; c++) {
    					int nx = r + delta[d][0];
    					int ny = c + delta[d][1];

    					if(map[nx][ny] == 1) {
    						k.damage += 1;
    					}
    				}
    			}
    		}
    	}
		
		// 기사 위치 및 생존 여부 갱신
		for(int n=1; n<affect.length; n++) {
			// 이동한 기사들만 갱신한다.
			if(affect[n]) {
				Knight k = knights.get(n);
				
				k.r += delta[d][0];
				k.c += delta[d][1];
				
				if(k.k <= k.damage) {
					k.isDead = true;
				}
			}
		}
    	
        return;
    }
}

class Knight{
    int r,c,h,w,k,damage;
    boolean isDead;

    public Knight(int r, int c, int h, int w, int k, int damage){
        this.r = r;
        this.c = c;
        this.h = h;
        this.w = w;
        this.k = k;
        this.damage = damage;
        this.isDead = false;
    }

	@Override
	public String toString() {
		return "Knight [r=" + r + ", c=" + c + ", h=" + h + ", w=" + w + ", k=" + k + ", damage=" + damage + ", isDead="
				+ isDead + "]";
	}
}