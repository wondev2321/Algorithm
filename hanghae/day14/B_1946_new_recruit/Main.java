package hanghae.day14.B_1946_new_recruit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++){
            int n = Integer.parseInt(br.readLine());
            int[][] gradeRank = new int[n][2];
            
            for(int j = 0; j < n; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                gradeRank[i][0] = Integer.parseInt(st.nextToken());
                gradeRank[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(gradeRank, new Comparator<int[]>(){
                @Override
                public int compare(int[] o1, int[] o2){
                    return o1[0] - o2[0]; 
                }
            }); 
                
            int result = 1;
            int top = gradeRank[0][1];
            for(int k = 1; k < gradeRank.length; k++){
                if(top > gradeRank[k][1]){
                    result += 1;
                    top = gradeRank[k][1];
                }
            }
            System.out.println(result);
        }
    }
}


