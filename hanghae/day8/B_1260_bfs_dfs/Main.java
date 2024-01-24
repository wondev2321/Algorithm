package hanghae.day8.B_1260_bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main{
    static int[][] graph;
    static boolean[] visited;

    private static void dfs(int idx){
        

    }

    private static void bfs(int idx){

    }
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        

        for(int i = 0; i < N + 1; i++){
            visited[i] = false; 
            
            for(int j = 0; j <N + 1; j++){
                graph[i][j] = 0;
            }
        }
        
        for(int j = 0; j < M; j++){
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(a + " : " + b);
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(V);
        System.out.println();

        for(int i = 0; i < N + 1; i++){
            visited[i] = false; 
        }

    }

}