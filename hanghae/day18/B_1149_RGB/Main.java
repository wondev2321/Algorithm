package hanghae.day18.B_1149_RGB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    //RGB
    /**
     * 
     * @param args
     * @throws IOException
     * 
     * RGB 거리 집 N개 (2~1000)
     * N개의 줄에는 집을 빨강, 초록 파랑 칠하는 비용 최소값
     * 
     * 규칙 
     * 1집 2집 색이 같지 않아야한다.
     * N 집의 새은 N-1 집색과 같지 않아야 한다.
     * i 번 집의 색은  i -1 번, i + 1번 집과 같지 않아야한다.
     * 
     * 
     */
    static int minVal = 0;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[][] rgbHouse = new int[n][3];

        int result = 0;

        for(int i = 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                rgbHouse[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //초기값 rgbHouse[0][0] /rgbHouse[0][1] /rgbHouse[0][2]
        DP(0, 0, n, rgbHouse);
        DP(0, 1, n, rgbHouse);
        DP(0, 2, n, rgbHouse);
        
    }
    private static void DP(int idx,int idy, int n, int[][]rgbHouse){
       
        DP(idx + 1, idy + 1, n, rgbHouse);
        
    }

}
