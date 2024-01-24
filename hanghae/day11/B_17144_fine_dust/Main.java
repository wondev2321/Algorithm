package hanghae.day11.B_17144_fine_dust;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] FindCleaner(int[][] board){
        int[] point = new int[2];
        for(int i = 0; i < board.length - 2; i++){
            if(board[i][0] == -1){
                point[0] = i;
                point[1] = i+1;
                break;
            }
        }
        
        return point;
    }

    public static int[][] SpreadDust(int[][] board, int[] point){
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int[][] board2 = new int[board.length][board[0].length];
        board2[point[0]][0] = -1;
        board2[point[1]][0] = -1;

        int nx = 0;
        int ny = 0;

        for(int x = 0; x < board[0].length-1; x++){
            for(int y = 0; y < board.length-1; y++){
                if(board[x][y] > 0){
                    board2[x][y] += board[x][y];
                    for(int k = 0; k <4; k++){
                        nx = x + dx[k];
                        ny = y + dy[y];
                        if(nx > 0 && nx < board[0].length-1 && ny > 0 && ny < board.length-1 && board[nx][ny] != -1){
                            board2[nx][ny] += board[x][y] / 5;
                            board2[x][y] -= board[x][y]/ 5;
                        }
                    }
                }
            }
        }
        
        return board2;
    }

    public static void rotate(int[][] board, int[] point){
        //공기 순환 함수

        //공기 순화 위로
        // 1. 위에서 아래
        for(int x = point[0] - 1; x > 0; x--){
            board[x][0] = board[x - 1][0];
        }
        
        // 2. 우측에서 좌측
        for(int y = 0; y < board[0].length -2; y++){
            board[0][y] = board[0][y + 1];
        }
        
        // 3. 아래에서 위
        for(int x = 0; x < point[0] - 1; x++){
            board[x][board[0].length -1] = board[x+1][board[0].length -1];
        }
        // 4. 좌측에서 우측
        for(int y = 0; y < board[0].length - 2; y++){
            board[point[0]][y] = board[point[0]][y + 1];
        }


        //공기 순환 아래로
        //1. 아래에서 위로
        for(int x = point[1]; x < board.length - 2; x++){
            board[x][0] = board[x+1][0];
        }

        //2. 우측에서 좌측으로
        for(int y = 0; y < board.length - 2; y++){
            board[board.length - 1][y] = board[board.length - 1][y + 1];
        }

        //3. 위에서 아래로
        for(int x = board.length - 2; x > point[1]-1; x--){
            board[x][board[0].length-1] = board[x-1][board[0].length];
        }

        //4. 좌측에서 우측으로
        for(int y = board[0].length - 2; y > 0; y--){
            board[point[1]][y] = board[point[1]][y-1];
        }

        board[point[0]][1] = 0;
        board[point[1]][1] = 0;

    }

    


    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); //공백단위로 읽어드릴수 있는 라인 추가

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());
        int result = 0;

        int[][] board = new int[row][col];
        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< col; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[] point = new int[2];
        for(int j = 0; j < time; j++){
            point = FindCleaner(board);
            board = SpreadDust(board, point);
            rotate(board,point);
        }

        for( int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                result += board[r][c] + 2;
            }
        }
        System.out.println(result);
    }
}
