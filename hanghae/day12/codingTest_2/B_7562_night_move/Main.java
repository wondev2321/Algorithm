package hanghae.day12.codingTest_2.B_7562_night_move;

/**
 * queue.offer() - 값추가
 * queue.poll() - 첫번째 값 반환 후 제거 (비어있다면 null 반환)
 * queue.remove() - 첫번째 값 제거
 * queue.clear() - 모든 요소 제거
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {    
    static int[] dx = new int[]{2, 2, 1, 1, -1, -1, -2, -2};
    static int[] dy = new int[]{1, -1, 2, -2, 2, -2, 1, -1};
    
    public static void main(String[] args)throws IOException{
        int[] nightPos = new int[2];
        int[] arrivePos = new int[2];
        int spaceNum;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcace = Integer.parseInt(br.readLine());

        for(int i = 0; i < testcace; i++){
            spaceNum = Integer.parseInt(br.readLine());

            String[] strs = br.readLine().split(" ");

            nightPos[0] = Integer.parseInt(strs[0]);
            nightPos[1] = Integer.parseInt(strs[1]);

            strs = br.readLine().split(" ");

            arrivePos[0] = Integer.parseInt(strs[0]);
            arrivePos[1] = Integer.parseInt(strs[1]);
            int result = MovementBfs(spaceNum, nightPos, arrivePos);
            System.out.println(result);
        }
    }
    private static int MovementBfs(int spaceNum,int[] nightPos, int[] arrivePos){
        Queue<int[]> que = new LinkedList<>();
        int nightXPos = nightPos[0];
        int nightYPos = nightPos[1];
        int arriveXPos = arrivePos[0];
        int arriveYPos = arrivePos[1];

        int[][]board = new int[spaceNum][spaceNum];
        for(int i = 0; i < spaceNum; i++){
            for(int j = 0; j< spaceNum; j++){
                board[i][j] = -1;
            }
        }

        que.offer(nightPos);
        board[nightXPos][nightYPos] = 0;

        while(!que.isEmpty()){
        
            int[] current = que.poll();
            int x = current[0];
            int y = current[1]; 

            if(x == arriveXPos && y == arriveYPos){
                return board[x][y];
            }
            
            for(int i = 0; i < 8; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(0<= nx && nx < spaceNum && 0<= ny && ny < spaceNum && board[nx][ny] == -1){
                    board[nx][ny] = board[x][y] + 1;
                    que.offer(new int[]{nx,ny});
                }
            }   
        }
        return -1;
    }
}