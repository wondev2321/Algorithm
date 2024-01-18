// 아기상어문제

/**
 * 처음 아기 상어의 크기는 2
 * 아기 상어는 1초에 상하좌우 인접한 한칸씩 이동
 * 아기 상어는 자신의 크기보다 큰 물고기 칸은 지나갈수 없다.
 * 아기 상어는 자신의 크기보다 작은 물고기만 먹는다.
 * 크기가 같은 물고기는 먹을 수 없지만 그 물고기가 있는 칸은 지나갈수 있다.
 * 
 * <규칙>
 * 더이상 먹을수 있는 ㅁ루고기가 공간에 없다면 end
 * 아기상어가 먹을수 있는 물고기가 1개라면 그물고기를 먹는다.
 * 먹을수 있는 물고기 1이상이면 가장왼쪽에 있는 물고기를 먹는다
 * 
 * 상어의 이동 1초 먹는 시간은 소요되지 않는다. 
 * 자신의 크기와 같은 수의 물고기를 먹을때마다 크기 + 1
 * 엄마 상어의 도움을 요청하지 않고 물고기를 다 잡아먹고 걸리는 시간을 구하라
 * 
 * 입력값 
 * 공간의 크기 N (2 ~ 20)
 * 공간의 값 n*n (물고기의 크기 1~6까지, 9 아기상어 위치)
 */

//물고기의 위치 찾기
    // 물고기 개수가 1개면  그물고기 먹으러간다.
    // 물고기가 여러개이나 거리가 가까운 물고기를 먹는다.
        //거기는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할때 칸의 개수의 최솟값
        // 우선순위 1가장 위에있는 물고기 , 2. 가장 왼쪽인 물고기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int n = 0;
    private static int[][] sea;
    private static int sharkSize;
    
    private static int[] findFood(int[] sharkPos){
        
        /**
         * input : 상어의 초기 위치(x,y)
         * output: 먹을수 있는 물고기의 위치 + 걸린시간
         * 
         */
        int posX = sharkPos[0];
        int posY = sharkPos[1];

        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        boolean[][] visited = new boolean[n][n];
        List<int[]> start = new ArrayList<>();
        start.add(sharkPos);
        int time = 0;

        while(!start.isEmpty()){
            time++;
            List<int[]> newStart = new ArrayList<>();
            List<int[]> fishCanEat = new ArrayList<>();

            for(int[] pos: start){
                for(int j = 0; j<4; j++){
                    int nx = pos[0] + dx[j];
                    int ny = pos[1] + dy[j];

                    if(0 <= nx && nx < n && 0 <= ny && ny < n && !visited[nx][ny] && sea[nx][ny] < sharkSize){
                        if(0 < sea[nx][ny] && sea[nx][ny] < sharkSize){
                            fishCanEat.add(new int[]{nx, ny});
                        }
                        visited[nx][ny] =false;
                        newStart.add(new int[]{nx, ny});
                    }
                }
            }

            if(!fishCanEat.isEmpty()){
                //우선순위 거리>> 위 >> 왼쪽
                Comparator<int[]> comparator = (a, b) -> a[1] - b[1];
                fishCanEat.sort(comparator);
                int[] eatenfish = fishCanEat.get(0);
                int ex = eatenfish[0];
                int ey = eatenfish[1];
                sea[ex][ey] = 0;
                return new int[]{ex, ey, time};
            }
            start = newStart;
        }

        

        return sharkPos;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        sea = new int[n][n];

        int[] sharkPos = new int[2];
        sharkSize = 2;
        int timeTurn = 0;
        int eat = 0;

        //sea 입력값 넣기
        for(int i = 0; i < n; i++){
            br.readLine();
            for(int j = 0; j < n; j++){
                sea[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //아기 상어 위치 변수 등록
        for(int i =0 ; i< n; i++){
            for(int j = 0; j < n; j++){
                if(sea[i][j] == 9){
                    sharkPos[0] = i;
                    sharkPos[1] = j;
                    sea[i][j] = 0;
                }
            }
        }

        while(true){
            int[] food = findFood(sharkPos);
            if(food == null){
                break;
            }
            int x = food[0];
            int y = food[1];
            int time = food[2];

            timeTurn += time;
            eat++;

            if(eat == sharkSize){
                sharkSize++;
                eat = 0;
            }
            sharkPos[0] = x;
            sharkPos[1] = y;
                       
        }
        System.out.println(timeTurn);
    
    }
}